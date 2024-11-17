package com.uvg.conneto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.uvg.conneto.services.TareaService;

import jakarta.persistence.EntityNotFoundException;

import com.uvg.conneto.models.Tarea;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tarea")
public class TareaController {

    @Autowired
    private TareaService tareaService;


    @GetMapping()
    public ArrayList<Tarea> obtenerTareas() {
        return tareaService.obtenerTareas();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/proyecto/{proyectoId}")
    public ResponseEntity<List<Tarea>> obtenerTareasPorProyecto(@PathVariable Long proyectoId) {
        List<Tarea> tareas = tareaService.obtenerTareasPorProyecto(proyectoId);
        if (tareas.isEmpty()) {
            return ResponseEntity.noContent().build(); // Retorna 204 si no hay tareas
        }
        return ResponseEntity.ok(tareas);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/agregar")
    public Tarea guardarTarea(@RequestBody Tarea tarea) {
        return this.tareaService.guardarTarea(tarea);
    }

    //actualizar estado por nombre
    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/actualizarEstado")
    public Tarea actualizarEstadoTarea(@RequestParam("nombre") String nombre, @RequestParam("completada") boolean completada) {
        return tareaService.actualizarEstadoTareaPorNombre(nombre, completada);
    }

    //actualizar estado por id
    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/{tareaId}/alternar-estado")
    public ResponseEntity<Tarea> alternarEstadoTarea(@PathVariable Long tareaId) {
        try {
            Tarea tareaActualizada = tareaService.alternarEstadoTarea(tareaId);
            return ResponseEntity.ok(tareaActualizada); // Retornar tarea actualizada
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build(); // Retornar 404 si no existe
        }
    }

        // Endpoint para eliminar una tarea por ID
    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/delete/{tareaId}")
    public ResponseEntity<Void> eliminarTarea(@PathVariable Long tareaId) {
        try {
            tareaService.eliminarTareaPorId(tareaId);
            return ResponseEntity.noContent().build(); // Retorna 204 No Content si se elimina exitosamente
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build(); // Retorna 404 si no existe
        }
    }

}