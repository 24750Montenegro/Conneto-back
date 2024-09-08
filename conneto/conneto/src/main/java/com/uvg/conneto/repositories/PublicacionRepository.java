package com.uvg.conneto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uvg.conneto.models.Publicación;

@Repository
public interface PublicacionRepository extends JpaRepository<Publicación, Long>{
    Publicación findById(long id);
}
