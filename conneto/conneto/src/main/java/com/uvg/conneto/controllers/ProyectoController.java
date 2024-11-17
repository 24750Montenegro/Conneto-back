//Se indica donde se guarda el proyectocontroller
package com.uvg.conneto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import com.uvg.conneto.models.Proyecto;
import com.uvg.conneto.models.Tarea;
import com.uvg.conneto.services.ProyectoService;
import java.util.ArrayList;

/**
 * Controlador REST para manejar las operaciones relacionadas con la entidad.
 * Proporciona puntos de acceso para realizar operaciones CRUD y otras funcionalidades
 * adicionales como agregar tareas y asociar proyectos a alianzas.
 */
@RestController
//Define la URL base para todas las rutas del controlador
@RequestMapping("/Proyecto")
public class ProyectoController {

    //Inyección de dependencias
    @Autowired
    private ProyectoService proyectoService;

    /**
     * Obtiene una lista de todos los proyectos.
     *
     * @return lista de todos los proyectos existentes en la base de datos.
     */
    //Permite que el metodo sea accesible desde esa URL
    @CrossOrigin(origins = "http://localhost:3000")
    //Solicitud que representa un HTTP get, es como un get basico de java
    @GetMapping("/obtenerProyectos")
    public ArrayList<Proyecto> obtenerProyectos() {
        // Se llama a la función definida en el service
        return this.proyectoService.obtenerProyectos();
    }

    /**
     * Crea y guarda un nuevo proyecto en la base de datos.
     *
     * @param proyecto objeto {@link Proyecto} a guardar.
     * @return el proyecto guardado.
     */
    //Permite que el metodo sea accesible desde esa URL
    @CrossOrigin(origins = "http://localhost:3000")
    //Solicitud que representa un HTTP post, es como un set basico de java que envia informacion
    @PostMapping("/crearProyecto")
    public Proyecto guardarProyecto(@RequestBody Proyecto proyecto) {
        // Se llama a la función definida en el service
        return this.proyectoService.guardarProyecto(proyecto);
    }

    /**
     * Agrega un ODS a un proyecto existente.
     *
     * @param proyectoId ID del proyecto al que se desea agregar el ODS.
     * @param odsId ID del ODS a agregar.
     * @return el proyecto actualizado con el nuevo ODS.
     */
    //Permite que el metodo sea accesible desde esa URL
    @CrossOrigin(origins = "http://localhost:3000")
    //Solicitud que representa un HTTP post, es como un set basico de java que envia informacion
    @PostMapping("/{proyectoId}/ods/{odsId}")
    public Proyecto agregarODSaProyecto(@PathVariable Long proyectoId, @PathVariable Long odsId) {
        // Se llama a la función definida en el service
        return proyectoService.agregarODSaProyecto(proyectoId, odsId);
    }

    /**
     * Agrega un usuario a un proyecto existente.
     *
     * @param proyectoId ID del proyecto al que se desea agregar el usuario.
     * @param usuarioId ID del usuario a agregar.
     * @return el proyecto actualizado con el nuevo usuario.
     */
    //Permite que el metodo sea accesible desde esa URL
    @CrossOrigin(origins = "http://localhost:3000")
    //Solicitud que representa un HTTP post, es como un set basico de java que envia informacion
    @PostMapping("/{proyectoId}/usuario/{usuarioId}")
    public Proyecto agregarUsuario(@PathVariable Long proyectoId, @PathVariable Long usuarioId) {
        // Se llama a la función definida en el service
        return proyectoService.nuevoUsuario(proyectoId, usuarioId);
    }

    /**
     * Agrega una nueva tarea a un proyecto.
     *
     * @param proyectoId ID del proyecto al que se desea agregar la tarea.
     * @param nuevaTarea objeto {@link Tarea} que representa la nueva tarea a agregar.
     * @return la tarea guardada en el proyecto.
     */
    //Permite que el metodo sea accesible desde esa URL
    @CrossOrigin(origins = "http://localhost:3000")
    //Solicitud que representa un HTTP post, es como un set basico de java que envia informacion
    @PostMapping("/{proyectoId}/tarea/{tareaId}")
    public Tarea agregarTareaProyecto(@PathVariable Long proyectoId, @RequestBody Tarea nuevaTarea) {
        // Se llama a la función definida en el service
        return proyectoService.agregarTareaProyecto(proyectoId, nuevaTarea);
    }

    /**
     * Actualiza un proyecto existente con los datos proporcionados.
     *
     * @param id ID del proyecto a actualizar.
     * @param proyecto objeto {@link Proyecto} con los nuevos datos.
     * @return el proyecto actualizado.
     */
    //Permite que el metodo sea accesible desde esa URL
    @CrossOrigin(origins = "http://localhost:3000")
    //Tipo de solicitud que actualiza inforomacion
    @PutMapping("/actualizarProyecto")
    public Proyecto actualizarProyecto(@PathVariable Long id, @RequestBody Proyecto proyecto) {
        // Se llama a la función definida en el service
        return proyectoService.actualizarProyecto(id, proyecto);
    }

    /**
     * Elimina un proyecto de la base de datos.
     *
     * @param id ID del proyecto a eliminar.
     */
    //Permite que el metodo sea accesible desde esa URL
    @CrossOrigin(origins = "http://localhost:3000")
    //Tipo de solicitud que elimina informacion
    @DeleteMapping("/eliminarproyecto")
    public void eliminarProyecto(@PathVariable Long id) {
        //Utiliza un metodo para borrar el proyecto por su ID
        proyectoService.eliminarProyecto(id);
    }

    /**
     * Obtiene un proyecto por su ID.
     *
     * @param id ID del proyecto a obtener.
     * @return el proyecto correspondiente al ID proporcionado, o null si no se encuentra.
     */
    //Permite que el metodo sea accesible desde esa URL
    @CrossOrigin(origins = "http://localhost:3000")
    //Solicitud que representa un HTTP get, es como un get basico de java
    @GetMapping("/obtenerProyecto")
    public Proyecto obtenerProyectoporID(@PathVariable Long id) {
        // Se llama a la función definida en el service
        return proyectoService.obtenerProyectoPorId(id);
    }

    /**
     * Crea y guarda un nuevo proyecto en una alianza específica.
     *
     * @param alianzaId ID de la alianza en la que se desea guardar el proyecto.
     * @param proyecto objeto que representa el proyecto a crear.
     * @return el proyecto guardado en la alianza especificada.
     */
    //Permite que el metodo sea accesible desde esa URL
    @CrossOrigin(origins = "http://localhost:3000")
    //Solicitud que representa un HTTP post, es como un set basico de java que envia informacion
    @PostMapping("/{alianzaId}/crearProyecto")
    public Proyecto crearProyectoEnAlianza(
            @PathVariable Long alianzaId,
            @RequestBody Proyecto proyecto) {
        //Llama la metodo creado en el proyecto service
        return proyectoService.guardarProyectoEnAlianza(alianzaId, proyecto);
    }
}