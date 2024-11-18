//Se define donde se guardara el service
package com.uvg.conneto.services;
//Se importan los recursos necesarios
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.uvg.conneto.models.Comentario;
import com.uvg.conneto.models.ODS;
import com.uvg.conneto.models.Publicacion;
import com.uvg.conneto.models.Usuario;
import com.uvg.conneto.repositories.ODSRepository;
import com.uvg.conneto.repositories.PublicacionRepository;
import lombok.RequiredArgsConstructor;

/**
 * Servicio para manejar la lógica de negocio relacionada con las publicaciones.
 * Ofrece métodos para crear, leer, actualizar, eliminar publicaciones y 
 * para añadir categorías ODS, "likes" y comentarios a una publicación.
 */
@Service
//Crea un constructor con paramtros
@RequiredArgsConstructor
public class PublicacionService {

    /** Repositorio de publicaciones utilizado para realizar operaciones CRUD */
    private final PublicacionRepository publicacionRepository;
    private final ODSRepository odsRepository;

    /**
     * Crea y guarda una nueva publicación.
     * @param publicacion La publicación a crear.
     */
    public void crearPublicacion(Publicacion publicacion) {
        publicacionRepository.save(publicacion);
    }

    /**
     * Obtiene una publicación por su ID.
     * @param id El ID de la publicación.
     * @return Un Optional que contiene la publicación si se encuentra; de lo contrario, vacío.
     */
    public Optional<Publicacion> obtenerPublicacionPorId(Long id) {
        return publicacionRepository.findById(id);
    }

    /**
     * Obtiene todas las publicaciones existentes.
     * @return Una lista de todas las publicaciones.
     */
    public List<Publicacion> obtenerTodasPublicaciones() {
        return publicacionRepository.findAll();
    }

    /**
     * Actualiza los datos de una publicación existente.
     * @param id El ID de la publicación a actualizar.
     * @param publicacionActualizada La publicación con los datos actualizados.
     */
    public void actualizarPublicacion(Long id, Publicacion publicacionActualizada) {
        Optional<Publicacion> publicacionExistente = publicacionRepository.findById(id);
        if (publicacionExistente.isPresent()) {
            Publicacion publicacion = publicacionExistente.get();
            publicacion.setContenido(publicacionActualizada.getContenido());
            publicacion.setImagenURL(publicacionActualizada.getImagenURL());

            if (publicacionActualizada.getCategoriaODS() != null) 
            {
                List<ODS> odsList = odsRepository.findAllById(
                    publicacionActualizada.getCategoriaODS().stream().map(ODS::getId).collect(Collectors.toList())
                );
                publicacion.setCategoriaODS(odsList);
            }

            publicacionRepository.save(publicacion);
        }
    }

    /**
     * Elimina una publicación por su ID.
     * @param id El ID de la publicación a eliminar.
     */
    public void eliminarPublicacion(Long id) {
        publicacionRepository.deleteById(id);
    }

    /**
     * Agrega una categoría ODS a una publicación.
     * @param publicacion La publicación a la que se añadirá la categoría ODS.
     * @param ods La categoría ODS a añadir.
     */
    public void agregarCategoriaODS(Publicacion publicacion, ODS ods) {
        publicacion.getCategoriaODS().add(ods);
        publicacionRepository.save(publicacion);
    }

    /**
     * Agrega un "like" de un usuario a una publicación.
     * @param publicacion La publicación a la que se añadirá el "like".
     * @param usuario El usuario que da "like" a la publicación.
     */
    public void agregarLike(Publicacion publicacion, Usuario usuario) {
        publicacion.getLikes().add(usuario);
        publicacionRepository.save(publicacion);
    }

    /**
     * Agrega un comentario a una publicación.
     * @param publicacion La publicación a la que se añadirá el comentario.
     * @param comentario El comentario a añadir.
     */
    public void agregarComentario(Publicacion publicacion, Comentario comentario) {
        publicacion.getComentarios().add(comentario);
        publicacionRepository.save(publicacion);
    }
}
