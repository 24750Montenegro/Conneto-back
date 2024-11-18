//Se indica donde se guarda el tareacontroller
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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import com.uvg.conneto.services.TareaService;
import jakarta.persistence.EntityNotFoundException;
import com.uvg.conneto.models.Tarea;
import java.util.ArrayList;
import java.util.List;
/**
 * Controlador REST para manejar las operaciones relacionadas con la entidad.
 * Proporciona puntos de acceso para realizar operaciones CRUD y otras funcionalidades
 * adicionales como obtener tareas por proyecto.
 */
@RestController
//Define la URL base para todas las rutas del controlador
@RequestMapping("/tarea")
public class TareaController {
    //Inyección de dependencias
    @Autowired
    private TareaService tareaService;
    /**
     * Obtiene una lista de todas las tareas.
     *
     * @return lista de todas las tareas existentes en la base de datos.
     */
    @GetMapping()
    public ArrayList<Tarea> obtenerTareas() {
        // Se llama a la función definida en el service
        return tareaService.obtenerTareas();
    }
    /**
     * Obtiene una lista de todas las tareas de un proyecto.
     *
     * @return lista de todas las tareas existentes en la base de datos relacionadas a un proyecto.
     */
    //Permite que el metodo sea accesible desde esa URL
    @CrossOrigin(origins = "http://localhost:3000")
    //Solicitud que representa un HTTP get, es como un get basico de java
    @GetMapping("/proyecto/{proyectoId}")
    public ResponseEntity<List<Tarea>> obtenerTareasPorProyecto(@PathVariable Long proyectoId) {
        // Se llama a la función definida en el service
        List<Tarea> tareas = tareaService.obtenerTareasPorProyecto(proyectoId);
        if (tareas.isEmpty()) {
            return ResponseEntity.noContent().build(); // Retorna 204 si no hay tareas
        }
        return ResponseEntity.ok(tareas);
    }

    /**
     * Crea y guarda una nueva tarea en la base de datos.
     *
     * @param tarea objeto {@link Tarea} a guardar.
     * @return la tarea guardada.
     */
    //Permite que el metodo sea accesible desde esa URL
    @CrossOrigin(origins = "http://localhost:3000")
    //Solicitud que representa un HTTP post, es como un set basico de java que envia informacion
    @PostMapping("/agregar")
    public Tarea guardarTarea(@RequestBody Tarea tarea) {
        // Se llama a la función definida en el service
        return this.tareaService.guardarTarea(tarea);
    }

    /**
     * Actualiza una tarea existente con los datos proporcionados.
     *
     * @param id ID de la tarea a actualizar.
     * @param tarea objeto {@link Tarea} con los nuevos datos.
     * @return la tarea actualizada.
     */
    //Permite que el metodo sea accesible desde esa URL
    //actualizar estado por id
    @CrossOrigin(origins = "http://localhost:3000")
    //Tipo de solicitud que actualiza inforomacion
    @PutMapping("/{tareaId}/alternar-estado")
    public ResponseEntity<Tarea> alternarEstadoTarea(@PathVariable Long tareaId) {
        // Se llama a la función definida en el service
        try {
            Tarea tareaActualizada = tareaService.alternarEstadoTarea(tareaId);
            return ResponseEntity.ok(tareaActualizada); // Retornar tarea actualizada
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build(); // Retornar 404 si no existe
        }
    }

    /**
     * Elimina una tarea de la base de datos.
     *
     * @param id ID de la tarea a eliminar.
     */
    //Permite que el metodo sea accesible desde esa URL
        // Endpoint para eliminar una tarea por ID
    @CrossOrigin(origins = "http://localhost:3000")
    //Tipo de solicitud que elimina informacion
    @DeleteMapping("/delete/{tareaId}")
    public ResponseEntity<Void> eliminarTarea(@PathVariable Long tareaId) {
        //Utiliza un metodo para borrar la tarea por su ID
        try {
            tareaService.eliminarTareaPorId(tareaId);
            return ResponseEntity.noContent().build(); // Retorna 204 No Content si se elimina exitosamente
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build(); // Retorna 404 si no existe
        }
    }
}