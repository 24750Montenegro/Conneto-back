package com.uvg.conneto.services;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.uvg.conneto.models.Comentario;
import com.uvg.conneto.models.ODS;
import com.uvg.conneto.models.Publicacion;
import com.uvg.conneto.models.Usuario;
import com.uvg.conneto.repositories.ODSRepository;
import com.uvg.conneto.repositories.PublicacionRepository;

import lombok.RequiredArgsConstructor;

/**
 * Servicio para gestionar la lógica de negocio relacionada con las Publicaciones
 * 
 * Proporciona métodos para crear, leer, actualizar y eliminar ODS, interactuando con el repositorio {@link PublicacionRepository}.
 */
@Service
@RequiredArgsConstructor
public class PublicacionService {

    private final PublicacionRepository publicacionRepository;
    private final ODSRepository odsRepository;

    /**
     * Crea una nueva publicación y la guarda en la base de datos.
     * Si la publicación incluye categorías ODS, las busca y las asocia a la publicación.
     * 
     * @param publicacion la publicación a crear
     */
    public void crearPublicacion(Publicacion publicacion) {
        if (publicacion.getCategoriaODS() != null && !publicacion.getCategoriaODS().isEmpty()) {
            List<ODS> odsList = odsRepository.findAllById(
                publicacion.getCategoriaODS().stream().map(ODS::getId).collect(Collectors.toList())
            );
            publicacion.setCategoriaODS(odsList);
        }
        publicacionRepository.save(publicacion);
    }

    /**
     * Busca una publicación por su identificador único.
     * 
     * @param id el identificador único de la publicación
     * @return un {@link Optional} con la publicación encontrada o vacío si no existe
     */
    public Optional<Publicacion> obtenerPublicacionPorId(Long id) {
        return publicacionRepository.findById(id);
    }

    /**
     * Recupera todas las publicaciones almacenadas en la base de datos.
     * 
     * @return una lista de todas las publicaciones
     */
    public List<Publicacion> obtenerTodasPublicaciones() {
        return publicacionRepository.findAll();
    }

    /**
     * Actualiza una publicación existente con los datos proporcionados.
     * Si se especifican categorías ODS, actualiza su asociación.
     * 
     * @param id el identificador de la publicación a actualizar
     * @param publicacionActualizada la publicación con los nuevos datos
     */
    public void actualizarPublicacion(Long id, Publicacion publicacionActualizada) {
        Optional<Publicacion> publicacionOpt = publicacionRepository.findById(id);
        if (publicacionOpt.isPresent()) {
            Publicacion publicacion = publicacionOpt.get();
            publicacion.setContenido(publicacionActualizada.getContenido());
            publicacion.setImagenURL(publicacionActualizada.getImagenURL());

            if (publicacionActualizada.getCategoriaODS() != null) {
                List<ODS> odsList = odsRepository.findAllById(
                    publicacionActualizada.getCategoriaODS().stream().map(ODS::getId).collect(Collectors.toList())
                );
                publicacion.setCategoriaODS(odsList);
            }

            publicacionRepository.save(publicacion);
        }
    }

    /**
     * Elimina una publicación por su identificador único.
     * 
     * @param id el identificador de la publicación a eliminar
     */
    public void eliminarPublicacion(Long id) {
        publicacionRepository.deleteById(id);
    }

    /**
     * Agrega una categoría ODS a una publicación existente.
     * 
     * @param publicacion la publicación a la que se le agregará la categoría
     * @param ods la categoría ODS a agregar
     */
    public void agregarCategoriaODS(Publicacion publicacion, ODS ods) {
        publicacion.getCategoriaODS().add(ods);
        publicacionRepository.save(publicacion);
    }

    /**
     * Agrega un "like" a una publicación por parte de un usuario.
     * 
     * @param publicacion la publicación a la que se le agregará el "like"
     * @param usuario el usuario que da el "like"
     */
    public void agregarLike(Publicacion publicacion, Usuario usuario) {
        publicacion.getLikes().add(usuario);
        publicacionRepository.save(publicacion);
    }

    /**
     * Agrega un comentario a una publicación existente.
     * 
     * @param publicacion la publicación a la que se le agregará el comentario
     * @param comentario el comentario a agregar
     */
    public void agregarComentario(Publicacion publicacion, Comentario comentario) {
        publicacion.getComentarios().add(comentario);
        publicacionRepository.save(publicacion);
    }
}
