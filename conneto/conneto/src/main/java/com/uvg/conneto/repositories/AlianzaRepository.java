package com.uvg.conneto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uvg.conneto.models.Alianza;


@Repository
public interface AlianzaRepository extends JpaRepository<Alianza, Long>
{
    Alianza findById(long id);
}