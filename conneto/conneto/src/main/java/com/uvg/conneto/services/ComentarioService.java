// ComentarioService.java
package com.uvg.conneto.services;

import org.springframework.stereotype.Service;
import com.uvg.conneto.models.Comentario;
import com.uvg.conneto.repositories.ComentarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import java.util.stream.Collectors;
import java.util.Map;
import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class ComentarioService {

    private final ComentarioRepository comentarioRepository;

    public void createComentario(Comentario comentario) {
        comentarioRepository.save(comentario);
    }

    public List<Map<String, Object>> obtenerComentariosPorPublicacion(Long publicacionId, int cantidad) {
    List<Comentario> comentarios = comentarioRepository.findByPublicacionId(publicacionId, PageRequest.of(0, cantidad));

    return comentarios.stream().map(comentario -> {
        Map<String, Object> comentarioMap = new HashMap<>();
        comentarioMap.put("id", comentario.getId());
        comentarioMap.put("username", comentario.getAutor().getNombre()); // Ajusta al nombre del autor
        comentarioMap.put("text", comentario.getContenido()); // Ajusta al contenido del comentario
        return comentarioMap;
    }).collect(Collectors.toList());
}
}
