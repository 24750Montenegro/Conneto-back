package com.uvg.conneto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.uvg.conneto.services.AlianzaService;
import com.uvg.conneto.services.ComentarioService;
import com.uvg.conneto.models.Alianza;
import com.uvg.conneto.models.Comentario;

import java.util.ArrayList;


@RestController
@RequestMapping("/alianza")
public class ComentarioController {
    @Autowired
    private ComentarioService ComentarioService;


    @PostMapping()
    public void guardarComentario(@RequestBody Comentario comentario){
        ComentarioService.createComentario(comentario);
    }
}
