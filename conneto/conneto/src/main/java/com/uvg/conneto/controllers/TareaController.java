package com.uvg.conneto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.uvg.conneto.services.TareaService;
import com.uvg.conneto.models.Tarea;

import java.util.ArrayList;

@RestController
@RequestMapping("/tarea")
public class TareaController {

    @Autowired
    private TareaService tareaService;

    @GetMapping()
    public ArrayList<Tarea> obtenerTareas() {
        return tareaService.obtenerTareas();
    }

    @PostMapping()
    public Tarea guardarTarea(@RequestBody Tarea tarea) {
        return this.tareaService.guardarTarea(tarea);
    }

    @PutMapping("/completar")
    public Tarea completarTarea(@RequestParam("id") Long id) {
        return tareaService.actualizarEstadoTarea(id, true);
    }

}