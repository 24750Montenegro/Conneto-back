package com.uvg.conneto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uvg.conneto.models.Publicacion;

@Repository
public interface PublicacionRepository extends JpaRepository<Publicacion, Long>{
    Publicacion findById(long id);
}
