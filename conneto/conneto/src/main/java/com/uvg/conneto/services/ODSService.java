package com.uvg.conneto.services;
import org.springframework.stereotype.Service;

import com.uvg.conneto.models.ODS;
import com.uvg.conneto.repositories.ODSRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ODSService 
{
    private final ODSRepository odsRepository;
    public void crearteComentario(ODS ods)
    {
        odsRepository.save(ods);
    }
}
