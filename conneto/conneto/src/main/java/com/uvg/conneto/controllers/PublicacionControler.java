package com.uvg.conneto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.uvg.conneto.services.PublicacionService;
import com.uvg.conneto.models.Publicacion;

import java.util.ArrayList;

@RestController
@RequestMapping("/publicacion")
public class PublicacionControler {

    @Autowired
    private PublicacionService publicacionService;

    @GetMapping()
    public ArrayList<Publicacion> obtenerPublicaciones(){
        return publicacionService.obtenerPublicaciones();
    }

    @PostMapping()
    public Publicacion guardarPublicacion(@RequestBody Publicacion publicacion){
        return this.publicacionService.guardarPublicacion(publicacion);
    }
    
}
