package com.uvg.conneto.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uvg.conneto.models.Alianza;
import com.uvg.conneto.repositories.AlianzaRepository;

@Service
public class AlianzaService {
    @Autowired
    AlianzaRepository alianzaRepository;

    public ArrayList<Alianza> obtenerAlianzas(){
        return (ArrayList<Alianza>) alianzaRepository.findAll();
    }

    public Alianza guardarAlianza(Alianza alianza){
        return alianzaRepository.save(alianza);
    }

    public Alianza registrarAlianza(Alianza alianza){
        // Verificar si el codigo de la alizanza ya existe
        if (alianzaRepository.findById(alianza.getId()) != null) {
            throw new IllegalArgumentException("Este codigo ya esta registrado. Eso no deveria de pasar");
        }
        // Guardar el usuario en la base de datos
        return alianzaRepository.save(alianza);   
    }
}
