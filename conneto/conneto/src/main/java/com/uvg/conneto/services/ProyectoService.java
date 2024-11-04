package com.uvg.conneto.services;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uvg.conneto.models.ODS;
import com.uvg.conneto.models.Proyecto;
import com.uvg.conneto.models.Tarea;
import com.uvg.conneto.models.Usuario;
import com.uvg.conneto.repositories.ODSRepository;
import com.uvg.conneto.repositories.ProyectoRepository;
import com.uvg.conneto.repositories.TareaRepository;
import com.uvg.conneto.repositories.UsuarioRepository;

@Service
public class ProyectoService {

    @Autowired
    ProyectoRepository proyectoRepository;
    ODSRepository odsRepository;
    UsuarioRepository usuarioRepository;
    TareaRepository tareaRepository;

    public ArrayList<Proyecto> obtenerProyectos() {
        return (ArrayList<Proyecto>) proyectoRepository.findAll();
    }

    public Proyecto guardarProyecto(Proyecto proyecto) {
        return proyectoRepository.save(proyecto);
    }

    public Proyecto actualizarProyecto(Long id, Proyecto proyecto) {
        Proyecto proyectoExistente = proyectoRepository.findById(id).orElse(null);
        if (proyectoExistente != null) {
            proyectoExistente.setNombre(proyecto.getNombre());
            proyectoExistente.setDescripcion(proyecto.getDescripcion());
            proyectoExistente.setCategoriaODS(proyecto.getCategoriaODS());
            proyectoExistente.setUsuarios(proyecto.getUsuarios());
            proyectoExistente.setTareas(proyecto.getTareas());
            return proyectoRepository.save(proyectoExistente);
        } else {
            throw new IllegalArgumentException("El proyecto no existe");
        }
    }

    public void eliminarProyecto(Long id) {
        proyectoRepository.deleteById(id);
    }

    public Proyecto obtenerProyectoPorId(Long id) {
        return proyectoRepository.findById(id).orElse(null);
    }

    public Proyecto agregarODSaProyecto(Long proyectoId, Long odsId) {
        Proyecto proyecto = proyectoRepository.findById(proyectoId).orElseThrow(() -> 
            new IllegalArgumentException("No se encontró el proyecto"));
        ODS nuevoODS = odsRepository.findById(odsId).orElseThrow(() -> 
            new IllegalArgumentException("No fue posible encontrar el ODS"));
        proyecto.getCategoriaODS().add(nuevoODS);
        return proyectoRepository.save(proyecto);
    }

    public Proyecto nuevoUsuario(Long proyectoId, Long usuarioId){
        Proyecto proyecto = proyectoRepository.findById(proyectoId)
            .orElseThrow(() -> new IllegalArgumentException("No se encontró el proyecto"));
        Usuario nuevoUsuario = usuarioRepository.findById(usuarioId)
            .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
        proyecto.getUsuarios().add(nuevoUsuario);
        return proyectoRepository.save(proyecto);
    }

    public Tarea agregarTareaProyecto(Long proyectoId, Tarea nuevaTarea){
        Proyecto proyecto = proyectoRepository.findById(proyectoId)
            .orElseThrow(() -> new IllegalArgumentException("No fue posible encontrar el proyecto"));
        nuevaTarea.setProyecto(proyecto);
        return tareaRepository.save(nuevaTarea);
    }
}