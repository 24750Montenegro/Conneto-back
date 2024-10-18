package com.uvg.conneto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import com.uvg.conneto.models.Proyecto;
import com.uvg.conneto.models.Tarea;
import com.uvg.conneto.services.ProyectoService;
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

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/crearProyecto")
    public Proyecto guardarProyecto(@RequestBody Proyecto proyecto) {
        return this.proyectoService.guardarProyecto(proyecto);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping ("/{proyectoId}/ods/{odsId}")
    public Proyecto agregarODSaProyecto(@PathVariable Long proyectoId, @PathVariable Long odsId) {
        return proyectoService.agregarODSaProyecto(proyectoId, odsId);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping ("/{proyectoId}/usuario/{usuarioId}")
    public Proyecto agregarUsuario(@PathVariable Long proyectoId, @PathVariable Long odsId){
        return proyectoService.nuevoUsuario(proyectoId, odsId);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/{proyectoId}/tarea/{tareaId}")
    public Tarea agregarTareaProyecto(@PathVariable Long proyectoId, @RequestBody Tarea nuevaTarea){
        return proyectoService.agregarTareaProyecto(proyectoId, nuevaTarea);
    }
}
