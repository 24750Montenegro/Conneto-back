package com.uvg.conneto.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.uvg.conneto.models.Publicación;

public class PublicaciónRepository 
{
    
}

@Repository
public interface PublicaciónRepository extends CrudRepository<Publicación, Long>
{
    Publicación findById(long id);
}
