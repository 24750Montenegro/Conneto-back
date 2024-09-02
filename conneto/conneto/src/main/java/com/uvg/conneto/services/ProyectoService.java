package com.uvg.conneto.services;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uvg.conneto.models.Proyecto;
import com.uvg.conneto.repositories.ProyectoRepository;

@Service
public class ProyectoService {

    @Autowired
    ProyectoRepository proyectoRepository;

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
}