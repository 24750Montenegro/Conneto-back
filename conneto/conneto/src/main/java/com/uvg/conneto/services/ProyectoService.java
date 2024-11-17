//Se indica donde se guarda el ProyectoService
package com.uvg.conneto.services;

//Se importan los recursos necesarios
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uvg.conneto.models.Alianza;
import com.uvg.conneto.models.ODS;
import com.uvg.conneto.models.Proyecto;
import com.uvg.conneto.models.Tarea;
import com.uvg.conneto.models.Usuario;
import com.uvg.conneto.repositories.AlianzaRepository;
import com.uvg.conneto.repositories.ODSRepository;
import com.uvg.conneto.repositories.ProyectoRepository;
import com.uvg.conneto.repositories.TareaRepository;
import com.uvg.conneto.repositories.UsuarioRepository;

/**
 * Servicio para manejar las operaciones relacionadas con los proyectos.
 */
//Indica que es un service
@Service
public class ProyectoService {

    //Inyección de dependencias
    @Autowired
    ProyectoRepository proyectoRepository;
    ODSRepository odsRepository;
    UsuarioRepository usuarioRepository;
    TareaRepository tareaRepository;

    /**
     * Obtiene todos los proyectos encontrados en la base de datos.
     * 
     * @return Una lista de todos los proyectos.
     */
    public ArrayList<Proyecto> obtenerProyectos() {
        return (ArrayList<Proyecto>) proyectoRepository.findAll();
    }

    /**
     * Guarda un nuevo proyecto en la base de datos.
     * 
     * @param proyecto El proyecto a guardar.
     * @return El proyecto guardado.
     */
    public Proyecto guardarProyecto(Proyecto proyecto) {
        return proyectoRepository.save(proyecto);
    }

    /**
     * Actualiza los datos de un proyecto existente.
     * 
     * @param id El ID del proyecto a actualizar.
     * @param proyecto Los nuevos datos del proyecto.
     * @return El proyecto actualizado.
     * @throws IllegalArgumentException si el proyecto no existe.
     */
    public Proyecto actualizarProyecto(Long id, Proyecto proyecto) {
        //Se busca el proyecto a actualizar por su id.
        Proyecto proyectoExistente = proyectoRepository.findById(id).orElse(null);
        //Si se encuentra el proyecto
        if (proyectoExistente != null) {
            //Se actualizan los atributos correspondientes
            proyectoExistente.setNombre(proyecto.getNombre());
            proyectoExistente.setDescripcion(proyecto.getDescripcion());
            proyectoExistente.setCategoriaODS(proyecto.getCategoriaODS());
            proyectoExistente.setUsuarios(proyecto.getUsuarios());
            proyectoExistente.setTareas(proyecto.getTareas());
            //Devuelve el proyecto actualizado
            return proyectoRepository.save(proyectoExistente);
        } else {
            //Excepcion en caso de no encontrar el proyecto
            throw new IllegalArgumentException("El proyecto no existe");
        }
    }

    /**
     * Elimina un proyecto de la base de datos.
     * 
     * @param id El ID del proyecto a eliminar.
     */
    public void eliminarProyecto(Long id) {
        //Busca el proyecto por su ID y lo elimina
        proyectoRepository.deleteById(id);
    }

    /**
     * Obtiene un proyecto por su ID.
     * 
     * @param id El ID del proyecto a obtener.
     * @return El proyecto encontrado, o null si no existe.
     */
    public Proyecto obtenerProyectoPorId(Long id) {
        //Busca el proyecto en base a su id
        return proyectoRepository.findById(id).orElse(null);
    }

    /**
     * Agrega un ODS a un proyecto existente.
     * 
     * @param proyectoId El ID del proyecto.
     * @param odsId      El ID del ODS a agregar.
     * @return El proyecto con el ODS agregado.
     * @throws IllegalArgumentException si el proyecto o el ODS no existen.
     */
    public Proyecto agregarODSaProyecto(Long proyectoId, Long odsId) {
        //Enceuntra el proyecto en base a su ID
        Proyecto proyecto = proyectoRepository.findById(proyectoId)
        //Si no lo encuentra lanza una excepcion
                .orElseThrow(() -> new IllegalArgumentException("No se encontró el proyecto"));
        //Encuentra el ODS en base a su ID
        ODS nuevoODS = odsRepository.findById(odsId)
        //Si no lo enceuntra lanza una excepción
                .orElseThrow(() -> new IllegalArgumentException("No fue posible encontrar el ODS"));
        //Añade el ODS al proyecto
        proyecto.getCategoriaODS().add(nuevoODS);
        //Guarda el proyecto
        return proyectoRepository.save(proyecto);
    }

    /**
     * Agrega un usuario a la lista de participantes de un proyecto.
     * 
     * @param proyectoId El ID del proyecto.
     * @param usuarioId  El ID del usuario a agregar.
     * @return El proyecto con el usuario agregado.
     * @throws IllegalArgumentException si el proyecto o el usuario no existen.
     */
    public Proyecto nuevoUsuario(Long proyectoId, Long usuarioId) {
        //Busca el proyecto por su ID
        Proyecto proyecto = proyectoRepository.findById(proyectoId)
        //Si no lo encuentra lanza ua excepcion
                .orElseThrow(() -> new IllegalArgumentException("No se encontró el proyecto"));
        //busca el usuario por su id
        Usuario nuevoUsuario = usuarioRepository.findById(usuarioId)
        //Si no lo encuentra lanza una exceppcion
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
        //Añade el usuario a los usuarios del proyecto
        proyecto.getUsuarios().add(nuevoUsuario);
        //Guarda elproyecto
        return proyectoRepository.save(proyecto);
    }

    /**
     * Agrega una nueva tarea a un proyecto existente.
     * 
     * @param proyectoId El ID del proyecto al que se le va a agregar la tarea.
     * @param nuevaTarea La tarea a agregar.
     * @return La tarea agregada al proyecto.
     * @throws IllegalArgumentException si el proyecto no existe.
     */
    public Tarea agregarTareaProyecto(Long proyectoId, Tarea nuevaTarea) {
        //Busca el proyecto por su ID
        Proyecto proyecto = proyectoRepository.findById(proyectoId)
                .orElseThrow(() -> new IllegalArgumentException("No fue posible encontrar el proyecto"));
        //Asigna la tarea en el nuevo proyecto
        nuevaTarea.setProyecto(proyecto);
        //guarda la tarea
        return tareaRepository.save(nuevaTarea);
    }

    //Guarda el proyecto en una alianza
    @Autowired
    private AlianzaRepository AlianzaRepository;

    /**
     * Asocia un proyecto a una alianza y lo guarda en la base de datos.
     * 
     * @param alianzaId El ID de la alianza a la cual se asociará el proyecto.
     * @param proyecto  El proyecto a asociar con la alianza.
     * @return El proyecto guardado con la asociación a la alianza.
     * @throws IllegalArgumentException si la alianza no existe.
     */
    public Proyecto guardarProyectoEnAlianza(Long alianzaId, Proyecto proyecto) {
        //busca la alianza por id
        Alianza alianza = AlianzaRepository.findById(alianzaId)
        //Sino, lanza una excepcion
            .orElseThrow(() -> new IllegalArgumentException("Alianza no encontrada"));
    
            //Añade el proyeccto a la alianza
        proyecto.setAlianza(alianza);
        //Guarda el proyecto
        return proyectoRepository.save(proyecto);
    }
}
