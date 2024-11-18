//Indica donde almacenar el repository
package com.uvg.conneto.repositories;

//importa los recursos necesarios
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uvg.conneto.models.Publicacion;

/**
 * Repositorio para gestionar operaciones de acceso a datos relacionadas con las Publicaciones.
 * 
 * Esta interfaz extiende {@link JpaRepository}, lo que proporciona métodos CRUD estándar 
 * y funcionalidades avanzadas de JPA para la entidad {@link Publicacion}.
 */
@Repository
public interface PublicacionRepository extends JpaRepository<Publicacion, Long>
{
    /**
     * Busca una publicación por su identificador único.
     *
     * @param id el identificador único de la publicación
     * @return la publicación correspondiente al identificador proporcionado, o {@code null} si no se encuentra
     */
    Publicacion findById(long id);
}