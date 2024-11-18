//Indica donde almacenar el repository
package com.uvg.conneto.repositories;

//importa los recursos necesarios
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uvg.conneto.models.Publicacion;

/**
 * Repositorio para acceder y realizar operaciones CRUD en la entidad Publicacion.
 * Extiende JpaRepository para obtener las funcionalidades básicas de persistencia.
 */
@Repository
public interface PublicacionRepository extends JpaRepository<Publicacion, Long> {

    /**
     * Encuentra una publicación por su ID.
     * 
     * @param id El ID de la publicación.
     * @return La publicación correspondiente al ID proporcionado.
     */
    Publicacion findById(long id);
}