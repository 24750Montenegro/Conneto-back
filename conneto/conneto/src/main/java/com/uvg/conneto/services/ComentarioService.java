package com.uvg.conneto.services;
import org.springframework.stereotype.Service;

import com.uvg.conneto.models.Comentario;
import com.uvg.conneto.repositories.ComentarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ComentarioService {

    private final ComentarioRepository comentarioRepository;
    public void createComentario(Comentario comentario){
        comentarioRepository.save(comentario);
    }
    
}
