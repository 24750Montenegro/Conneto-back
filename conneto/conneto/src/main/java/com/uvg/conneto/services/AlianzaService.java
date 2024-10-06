package com.uvg.conneto.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uvg.conneto.models.Alianza;
import com.uvg.conneto.repositories.AlianzaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AlianzaService {
    private final AlianzaRepository AlianzaRepository;
    public void createAlianza(Alianza alianza){
        AlianzaRepository.save(alianza);
    }

    public ArrayList<Alianza> obtenerAlianzas(){
        return (ArrayList<Alianza>) AlianzaRepository.findAll();
    }

}
