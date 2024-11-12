package com.uvg.conneto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uvg.conneto.models.Comentario;
import com.uvg.conneto.services.ComentarioService;


@RestController
@RequestMapping("/alianza")
public class ComentarioController {
    @Autowired
    private ComentarioService ComentarioService;


    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("guardarCOmentario")
    public void guardarComentario(@RequestBody Comentario comentario){
        ComentarioService.createComentario(comentario);
    }
}
