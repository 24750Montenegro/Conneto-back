package com.uvg.conneto.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uvg.conneto.models.Publicacion;
import com.uvg.conneto.repositories.PublicacionRepository;

@Service
public class PublicacionService {
    @Autowired
    PublicacionRepository publicacionRepository;

    public ArrayList<Publicacion> obtenerPublicaciones(){
        return (ArrayList<Publicacion>) publicacionRepository.findAll();
    }

    public Publicacion guardarPublicacion(Publicacion publicacion){
        return publicacionRepository.save(publicacion);
    }

    public Publicacion registrarPublicacion(Publicacion publicacion){
        // Verificar si el codigo de la publicacion ya existe
        if (publicacionRepository.findById(publicacion.getId()) != null) {
            throw new IllegalArgumentException("Este codigo ya esta registrado. Eso no deveria de pasar");
        }
        // Guardar el usuario en la base de datos
        return publicacionRepository.save(publicacion);   
    }

    
}
