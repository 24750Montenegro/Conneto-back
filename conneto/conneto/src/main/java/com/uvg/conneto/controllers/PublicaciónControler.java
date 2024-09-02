package com.uvg.conneto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.uvg.conneto.models.Publicación;
import com.uvg.conneto.services.PublicaciónService;

import java.util.ArrayList;

@RestController
@RequestMapping("/publicacion")
public class PublicaciónControler 
{
    @Autowired
    private PublicaciónService publicacionService;

    @GetMapping()
    public ArrayList<Publicación> obtenerPublicaciónes() 
    {
        return publicacionService.obtenerPublicaciónes();
    }

    @PostMapping()
    public Publicación guardarPublicación(@RequestBody Publicación publicación) 
    {
        return this.publicacionService.guardarUsuario(publicación);
    }    
}