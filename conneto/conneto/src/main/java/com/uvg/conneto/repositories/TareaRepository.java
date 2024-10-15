package com.uvg.conneto.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uvg.conneto.models.Tarea;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Long> {
        Tarea findById(long id);

}