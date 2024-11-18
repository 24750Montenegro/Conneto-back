//Se indica donde se guarda la TareaService
package com.uvg.conneto.services;

//Se importan los recursos necesarios
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uvg.conneto.models.Tarea;
import com.uvg.conneto.repositories.TareaRepository;
import jakarta.persistence.EntityNotFoundException;

/**
 * Servicio para manejar las operaciones relacionadas con las tareas.
 */
//Indica que es un service
@Service
public class TareaService {

    //Inyección de dependencias
    @Autowired
    TareaRepository tareaRepository;

    /**
     * Obtiene todas las tareas encontradas en la base de datos relacionadas a un proyecto.
     * 
     * @return Una lista de todas las tareas.
     */
        // Método para obtener tareas por ID de proyecto
    public List<Tarea> obtenerTareasPorProyecto(Long proyectoId) {
            return tareaRepository.findByProyectoId(proyectoId);
    }

    /**
     * Obtiene todas las tareas encontradas en la base de datos.
     * 
     * @return Una lista de todas las tareas.
     */
    public ArrayList<Tarea> obtenerTareas(){
        return (ArrayList<Tarea>) tareaRepository.findAll();
    }

    /**
     * Guarda una nueva tarea en la base de datos.
     * 
     * @param tarea La tarea a guardar.
     * @return La tarea guardada.
     */
    public Tarea guardarTarea(Tarea tarea){
        return tareaRepository.save(tarea);
    }

    /**
     * Elimina una tarea de la base de datos.
     * 
     * @param id El ID de la tarea a eliminar.
     */
    //eliminar tarea por id
    public void eliminarTareaPorId(Long tareaId) {
        //Busca la tarea por su ID y la elimina
        if (tareaRepository.existsById(tareaId)) {
            tareaRepository.deleteById(tareaId);
        } else {
            throw new EntityNotFoundException("La tarea con ID " + tareaId + " no existe.");
        }
    }

    /**
     * Guarda una nueva tarea en la base de datos.
     * 
     * @param tarea La tarea a guardar.
     * @return La tarea guardada.
     */
        public Tarea registrarTarea(Tarea tarea) {
        // Verificar si la tarea ya existe
        if (tareaRepository.findById(tarea.getId()) != null) {
            throw new IllegalArgumentException("La tarea ya está registrado");
        }
        // Guardar la tarea en la base de datos
        return tareaRepository.save(tarea);
    }

    /**
     * Actualiza los datos de una tarea existente.
     * 
     * @param id El ID de la tarea a actualizar.
     * @param completada El dato de si la tarea esta completada.
     * @return La tarea actualizada.
     * @throws IllegalArgumentException si la tarea no existe.
     */
    public Tarea actualizarEstadoTarea(Long id, boolean completada) {
        //Se busca la tarea a actualizar por su id.
        // Buscar la tarea por su ID
        Tarea tarea = tareaRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Tarea no encontrada con el ID: " + id));

            //Se actualiza el atributo correspondiente
        // Actualizar el estado de completada
        tarea.setCompletada(completada);

        //Devuelve la tarea actualizada
        // Guardar la tarea actualizada en la base de datos
        return tareaRepository.save(tarea);
    }    

    /**
     * Actualiza los datos de una tarea existente.
     * 
     * @param id El ID de la tarea a actualizar.
     * @return La tarea actualizada.
     */
        // Método para alternar el estado de la tarea
    public Tarea alternarEstadoTarea(Long tareaId) {
        //Se busca la tarea a actualizar por su id.
        Optional<Tarea> tareaOptional = tareaRepository.findById(tareaId);
        
        //Se actualiza el atributo correspondiente
        if (tareaOptional.isPresent()) {
            Tarea tarea = tareaOptional.get();
            tarea.setCompletada(!tarea.getCompletada()); // Alternar estado
            //Devuelve la tarea actualizada
            return tareaRepository.save(tarea); // Guardar cambios
        } else {
            throw new EntityNotFoundException("La tarea con ID " + tareaId + " no existe.");
        }
    }
}