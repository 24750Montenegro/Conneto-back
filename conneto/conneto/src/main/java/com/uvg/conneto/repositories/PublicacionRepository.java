package com.uvg.conneto.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.uvg.conneto.models.Publicacion;

@Repository
public interface PublicacionRepository extends CrudRepository<Publicacion, Long>{
    Publicacion findById(long id);
}
