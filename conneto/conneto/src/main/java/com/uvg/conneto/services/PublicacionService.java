package com.uvg.conneto.services;
import java.util.List;
import java.util.Optional;

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

    // Crear Publicación
    public void crearPublicacion(Publicacion publicacion) 
    {
        publicacionRepository.save(publicacion);
    }

    // Leer Publicación por ID
    public Optional<Publicacion> obtenerPublicacionPorId(Long id) 
    {
        return publicacionRepository.findById(id);
    }

    // Leer todas las Publicaciones
    public List<Publicacion> obtenerTodasPublicaciones() 
    {
        return publicacionRepository.findAll();
    }

    // Actualizar Publicación
    public void actualizarPublicacion(Long id, Publicacion publicacionActualizada) 
    {
        Optional<Publicacion> publicacionExistente = publicacionRepository.findById(id);
        if (publicacionExistente.isPresent()) {

            Publicacion publicacion = publicacionExistente.get();
            publicacion.setContenido(publicacionActualizada.getContenido());
            publicacion.setCategoriaODS(publicacionActualizada.getCategoriaODS());
            publicacion.setImagenURL(publicacionActualizada.getImagenURL());
            publicacion.setLikes(publicacionActualizada.getLikes());
            publicacion.setComentarios(publicacionActualizada.getComentarios());
            publicacionRepository.save(publicacion);
        }
    }

    // Eliminar Publicación por ID
    public void eliminarPublicacion(Long id) 
    {
        publicacionRepository.deleteById(id);
    }

    // Agregar una categoría ODS a la Publicación
    public void agregarCategoriaODS(Publicacion publicacion, ODS ods) 
    {
        publicacion.getCategoriaODS().add(ods);
        publicacionRepository.save(publicacion);
    }

    // Agregar un "like" a la Publicación
    public void agregarLike(Publicacion publicacion, Usuario usuario) 
    {
        publicacion.getLikes().add(usuario);
        publicacionRepository.save(publicacion);
    }

    // Agregar un comentario a la Publicación
    public void agregarComentario(Publicacion publicacion, Comentario comentario) 
    {
        publicacion.getComentarios().add(comentario);
        publicacionRepository.save(publicacion);
    }
}
