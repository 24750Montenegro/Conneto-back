package com.uvg.conneto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uvg.conneto.models.ODS;

/**
 * Repositorio para gestionar operaciones de acceso a datos relacionadas con los Objetivos de Desarrollo Sostenible (ODS).
 * 
 * Esta interfaz extiende {@link JpaRepository}, lo que proporciona métodos CRUD estándar 
 * y funcionalidades avanzadas de JPA para la entidad {@link ODS}.
 */
@Repository
public interface ODSRepository extends JpaRepository<ODS, Long> {

    /**
     * Busca un ODS por su identificador único.
     * 
     * @param id Identificador único del ODS que se desea buscar.
     * @return El objeto {@link ODS} correspondiente al identificador proporcionado, o {@code null} si no se encuentra.
     */
    ODS findById(long id);
}
