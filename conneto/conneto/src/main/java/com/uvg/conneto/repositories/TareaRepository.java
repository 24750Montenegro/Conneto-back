package com.uvg.conneto.repositories;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.uvg.conneto.models.Tarea;

@Repository
public interface TareaRepository extends CrudRepository<Tarea, Long> {
        Tarea findByNombre(String nombre);

}