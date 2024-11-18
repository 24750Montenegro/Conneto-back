package com.uvg.conneto.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uvg.conneto.models.Comentario;
import com.uvg.conneto.models.ODS;
import com.uvg.conneto.models.Publicacion;
import com.uvg.conneto.models.Usuario;
import com.uvg.conneto.services.PublicacionService;
import com.uvg.conneto.services.UsuarioService;

import lombok.RequiredArgsConstructor;

/**
 * Controlador REST para gestionar las publicaciones.
 * Define endpoints para crear, leer, actualizar, eliminar y gestionar interacciones como likes y comentarios.
 */
@RestController
@RequestMapping("/publicaciones")
@RequiredArgsConstructor
public class PublicacionController {

    // Servicio para gestionar publicaciones
    private final PublicacionService publicacionService;

    // Servicio para gestionar usuarios
    @Autowired
    private UsuarioService usuarioService;

    /**
     * Crear una nueva publicación.
     * 
     * @param publicacion Objeto de tipo {@link Publicacion} a crear.
     * @return La publicación creada con una respuesta HTTP 200.
     */
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/crear")
    public ResponseEntity<Publicacion> crearPublicacion(@RequestBody Publicacion publicacion) {
        publicacionService.crearPublicacion(publicacion);
        return ResponseEntity.ok(publicacion);
    }

    /**
     * Obtener una publicación por su ID.
     * 
     * @param id Identificador único de la publicación.
     * @return La publicación correspondiente si existe, o un error 404 si no se encuentra.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Publicacion> obtenerPublicacion(@PathVariable Long id) {
        Optional<Publicacion> publicacion = publicacionService.obtenerPublicacionPorId(id);
        return publicacion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Obtener todas las publicaciones.
     * 
     * @return Lista de todas las publicaciones con una respuesta HTTP 200.
     */
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/todas")
    public ResponseEntity<List<Publicacion>> obtenerTodasPublicaciones() {
        return ResponseEntity.ok(publicacionService.obtenerTodasPublicaciones());
    }

    /**
     * Actualiza una publicación existente.
     * 
     * @param id La ID de la publicación que se desea actualizar.
     * @param publicacionActualizada El objeto con los nuevos datos para la publicación.
     * @return Respuesta HTTP con el código de estado 200 (OK) y la publicación actualizada.
     */
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Publicacion> actualizarPublicacion(@PathVariable Long id, @RequestBody Publicacion publicacionActualizada) {
        publicacionService.actualizarPublicacion(id, publicacionActualizada);
        return ResponseEntity.ok(publicacionActualizada);
    }

    /**
     * Eliminar una publicación por su ID.
     * 
     * @param id Identificador único de la publicación.
     * @return Respuesta HTTP 204 si la eliminación es exitosa.
     */
    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarPublicacion(@PathVariable Long id) {
        publicacionService.eliminarPublicacion(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Agregar una categoría ODS a una publicación.
     * 
     * @param id Identificador único de la publicación.
     * @param ods Objeto ODS a asociar con la publicación.
     * @return Respuesta HTTP 200 si la operación es exitosa, o 404 si la publicación no existe.
     */
    @PutMapping("/{id}/categoriaODS")
    public ResponseEntity<Void> agregarCategoriaODS(@PathVariable Long id, @RequestBody ODS ods) {
        Optional<Publicacion> publicacion = publicacionService.obtenerPublicacionPorId(id);
        if (publicacion.isPresent()) {
            publicacionService.agregarCategoriaODS(publicacion.get(), ods);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Agregar un "like" a una publicación por parte de un usuario.
     * 
     * @param publicacionId ID de la publicación.
     * @param usuarioId ID del usuario.
     * @return Respuesta indicando éxito o errores según el caso.
     */
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/{publicacionId}/like/{usuarioId}")
    public ResponseEntity<String> agregarLike(@PathVariable Long publicacionId, @PathVariable Long usuarioId) {
        Optional<Publicacion> publicacionOpt = publicacionService.obtenerPublicacionPorId(publicacionId);
        Optional<Usuario> usuarioOpt = usuarioService.getUserById(usuarioId);

        if (publicacionOpt.isPresent() && usuarioOpt.isPresent()) {
            Publicacion publicacion = publicacionOpt.get();
            Usuario usuario = usuarioOpt.get();

            if (!publicacion.getLikes().contains(usuario)) {
                publicacion.getLikes().add(usuario);
                publicacionService.crearPublicacion(publicacion);
                return ResponseEntity.ok("Like agregado");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ya has dado like a esta publicación");
            }
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Publicación o Usuario no encontrado");
    }

    /**
     * Eliminar un "like" de una publicación.
     * 
     * @param publicacionId ID de la publicación.
     * @param usuarioId ID del usuario.
     * @return Respuesta indicando éxito o errores según el caso.
     */
    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/{publicacionId}/like/{usuarioId}")
    public ResponseEntity<String> eliminarLike(@PathVariable Long publicacionId, @PathVariable Long usuarioId) {
        Optional<Publicacion> publicacionOpt = publicacionService.obtenerPublicacionPorId(publicacionId);
        Optional<Usuario> usuarioOpt = usuarioService.getUserById(usuarioId);

        if (publicacionOpt.isPresent() && usuarioOpt.isPresent()) {
            Publicacion publicacion = publicacionOpt.get();
            Usuario usuario = usuarioOpt.get();

            if (publicacion.getLikes().contains(usuario)) {
                publicacion.getLikes().remove(usuario);
                publicacionService.crearPublicacion(publicacion);
                return ResponseEntity.ok("Like eliminado");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No has dado like a esta publicación");
            }
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Publicación o Usuario no encontrado");
    }

    /**
     * Obtener todos los "likes" de una publicación.
     * 
     * @param publicacionId ID de la publicación.
     * @return Lista de usuarios que han dado "like" y la cantidad total de likes.
     */
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/{publicacionId}/likes")
    public ResponseEntity<Map<String, Object>> obtenerLikes(@PathVariable Long publicacionId) {
        Optional<Publicacion> publicacionOpt = publicacionService.obtenerPublicacionPorId(publicacionId);

        if (publicacionOpt.isPresent()) {
            Publicacion publicacion = publicacionOpt.get();

            List<Map<String, Object>> likes = publicacion.getLikes().stream()
                .map(usuario -> {
                    Map<String, Object> userMap = new HashMap<>();
                    userMap.put("id", usuario.getId());
                    userMap.put("nombre", usuario.getNombre());
                    userMap.put("email", usuario.getEmail());
                    return userMap;
                })
                .collect(Collectors.toList());

            Map<String, Object> response = new HashMap<>();
            response.put("likes", likes);
            response.put("cantidadLikes", likes.size());
            return ResponseEntity.ok(response);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "Publicación no encontrada"));
    }

    /**
     * Agregar un comentario a una publicación.
     * 
     * @param id ID de la publicación.
     * @param comentario Comentario a agregar.
     * @return Respuesta HTTP 200 si es exitoso, o 404 si la publicación no existe.
     */
    @PutMapping("/{id}/comentario")
    public ResponseEntity<Void> agregarComentario(@PathVariable Long id, @RequestBody Comentario comentario) {
        Optional<Publicacion> publicacion = publicacionService.obtenerPublicacionPorId(id);
        if (publicacion.isPresent()) {
            publicacionService.agregarComentario(publicacion.get(), comentario);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}