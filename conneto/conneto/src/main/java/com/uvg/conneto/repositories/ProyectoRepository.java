package com.uvg.conneto.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.uvg.conneto.models.Proyecto;

@Repository
public interface ProyectoRepository extends CrudRepository<Proyecto, Long> {
    Proyecto findByNombre(String nombre);
}