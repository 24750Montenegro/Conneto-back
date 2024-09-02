package com.uvg.conneto.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.uvg.conneto.models.ODS;

public class ODSRepostitory 
{
    
}

@Repository
public interface ODSRepository extends CrudRepository<ODS, Long>
{
    ODS findById(long id);
}
