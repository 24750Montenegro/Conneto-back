package com.uvg.conneto.services;
import org.springframework.stereotype.Service;

import com.uvg.conneto.models.Comentario;
import com.uvg.conneto.models.ODS;
import com.uvg.conneto.models.Publicacion;
import com.uvg.conneto.models.Usuario;
import com.uvg.conneto.repositories.PublicacionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PublicacionService 
{
    private final PublicacionRepository publicacionRepository;
    public void crearPublicacion(Publicacion publicacion)
    {
        publicacionRepository.save(publicacion);
    }

    public void agregarCategoriaODS(Publicacion publicacion, ODS ods) 
    {
        publicacion.getCategoriaODS().add(ods);
        publicacionRepository.save(publicacion);
    }

    public void agregarLike(Publicacion publicacion, Usuario usuario) 
    {
        publicacion.getLikes().add(usuario);
        publicacionRepository.save(publicacion);
    }

    public void agregarComentario(Publicacion publicacion, Comentario comentario) 
    {
        publicacion.getComentarios().add(comentario);
        publicacionRepository.save(publicacion);
    }
}
