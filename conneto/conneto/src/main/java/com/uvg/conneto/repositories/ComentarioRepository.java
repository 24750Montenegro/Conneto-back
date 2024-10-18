package com.uvg.conneto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uvg.conneto.models.Comentario;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long>
{
    Comentario findById(long id);
}
