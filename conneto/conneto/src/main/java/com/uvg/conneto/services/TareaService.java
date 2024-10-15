package com.uvg.conneto.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uvg.conneto.models.Tarea;
import com.uvg.conneto.repositories.TareaRepository;

@Service
public class TareaService {
    @Autowired
    TareaRepository tareaRepository;

    public ArrayList<Tarea> obtenerTareas(){
        return (ArrayList<Tarea>) tareaRepository.findAll();
    }

    public Tarea guardarTarea(Tarea tarea){
        return tareaRepository.save(tarea);
    }

        public Tarea registrarTarea(Tarea tarea) {
        // Verificar si la tarea ya existe
        if (tareaRepository.findByNombre(tarea.getNombre()) != null) {
            throw new IllegalArgumentException("La tarea ya está registrado");
        }
        // Guardar la tarea en la base de datos
        return tareaRepository.save(tarea);
    }
    
    public Tarea actualizarEstadoTareaPorNombre(String nombre, boolean completada) {
        // Buscar la tarea por su nombre
        Tarea tarea = tareaRepository.findByNombre(nombre);
        
        if (tarea == null) {
            throw new IllegalArgumentException("Tarea no encontrada con el nombre: " + nombre);
        }
    
        // Actualizar el estado de completada
        tarea.setCompletada(completada);
    
        // Guardar la tarea actualizada en la base de datos
        return tareaRepository.save(tarea);
    }    
}