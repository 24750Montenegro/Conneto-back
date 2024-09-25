package com.uvg.conneto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uvg.conneto.models.ODS;


@Repository
public interface ODSRepository extends JpaRepository<ODS, Long>
{
    ODS findById(long id);
}
