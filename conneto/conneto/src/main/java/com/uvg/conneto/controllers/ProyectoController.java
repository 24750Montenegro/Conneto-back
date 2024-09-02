package com.uvg.conneto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.uvg.conneto.services.UsuarioService;

import java.util.ArrayList;

@RestController
@RequestMapping("/Proyecto")
public class ProyectoController {

    @Autowired
    private ProyectoService proyectoService;

    @GetMapping()
    public ArrayList<Proyecto> obtenerProyectos() {
        return proyectoService.obtenerProyectos();
    }

    @PostMapping()
    public Proyecto guardarProyecto(@RequestBody Proyecto proyecto) {
        return this.proyectoService.guardarProyecto(proyecto);
    }
}