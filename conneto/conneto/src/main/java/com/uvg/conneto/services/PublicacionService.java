package com.uvg.conneto.services;
import org.springframework.stereotype.Service;

import com.uvg.conneto.models.Publicacion;
import com.uvg.conneto.repositories.PublicacionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PublicacionService 
{
    private final PublicacionRepository publicacionRepository;
    public void crearteComentario(Publicacion publicacion)
    {
        publicacionRepository.save(publicacion);
    }
}
