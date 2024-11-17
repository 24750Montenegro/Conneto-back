package com.uvg.conneto.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uvg.conneto.models.Tarea;
import com.uvg.conneto.repositories.TareaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TareaService {
    @Autowired
    TareaRepository tareaRepository;

        // Método para obtener tareas por ID de proyecto
    public List<Tarea> obtenerTareasPorProyecto(Long proyectoId) {
            return tareaRepository.findByProyectoId(proyectoId);
    }

    public ArrayList<Tarea> obtenerTareas(){
        return (ArrayList<Tarea>) tareaRepository.findAll();
    }

    public Tarea guardarTarea(Tarea tarea){
        return tareaRepository.save(tarea);
    }

    //eliminar tarea por id
    public void eliminarTareaPorId(Long tareaId) {
        if (tareaRepository.existsById(tareaId)) {
            tareaRepository.deleteById(tareaId);
        } else {
            throw new EntityNotFoundException("La tarea con ID " + tareaId + " no existe.");
        }
    }

        public Tarea registrarTarea(Tarea tarea) {
        // Verificar si la tarea ya existe
        if (tareaRepository.findById(tarea.getId()) != null) {
            throw new IllegalArgumentException("La tarea ya está registrado");
        }
        // Guardar la tarea en la base de datos
        return tareaRepository.save(tarea);
    }
    
    public Tarea actualizarEstadoTarea(Long id, boolean completada) {
        // Buscar la tarea por su ID
        Tarea tarea = tareaRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Tarea no encontrada con el ID: " + id));
    
        // Actualizar el estado de completada
        tarea.setCompletada(completada);
    
        // Guardar la tarea actualizada en la base de datos
        return tareaRepository.save(tarea);
    }    


        // Método para alternar el estado de la tarea
    public Tarea alternarEstadoTarea(Long tareaId) {
        Optional<Tarea> tareaOptional = tareaRepository.findById(tareaId);
        
        if (tareaOptional.isPresent()) {
            Tarea tarea = tareaOptional.get();
            tarea.setCompletada(!tarea.getCompletada()); // Alternar estado
            return tareaRepository.save(tarea); // Guardar cambios
        } else {
            throw new EntityNotFoundException("La tarea con ID " + tareaId + " no existe.");
        }
    }
}