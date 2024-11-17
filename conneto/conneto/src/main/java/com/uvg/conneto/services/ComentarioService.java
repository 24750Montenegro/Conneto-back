// ComentarioService.java
package com.uvg.conneto.services;
import org.springframework.stereotype.Service;
import com.uvg.conneto.models.Comentario;
import com.uvg.conneto.repositories.ComentarioRepository;
import lombok.RequiredArgsConstructor;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ComentarioService {

    private final ComentarioRepository comentarioRepository;

    //Crear un comentario
    public void createComentario(Comentario comentario) {
        comentarioRepository.save(comentario);
    }

    //Obtener los comentarios
    public List<Map<String, Object>> obtenerComentariosPorPublicacion(Long publicacionId) {
        // Llama al repositorio sin paginación
        List<Comentario> comentarios = comentarioRepository.findByPublicacionId(publicacionId);
    
        // Transforma la lista de comentarios a un mapa
        return comentarios.stream().map(comentario -> {
            Map<String, Object> comentarioMap = new HashMap<>();
            comentarioMap.put("id", comentario.getId());
            comentarioMap.put("username", comentario.getAutor().getNombre());
            comentarioMap.put("text", comentario.getContenido());
            comentarioMap.put("avatar", comentario.getAutor().getAvatar());
            return comentarioMap;
        }).collect(Collectors.toList());
    }
}
