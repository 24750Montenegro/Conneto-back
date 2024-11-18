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
 * Controlador para gestionar las solicitudes HTTP relacionadas con la entidad Publicación.
 * Proporciona endpoints para crear, actualizar, obtener, eliminar publicaciones y gestionar interacciones con ellas,
 * como agregar comentarios y likes.
 */
@RestController
@RequestMapping("/publicaciones")
@RequiredArgsConstructor
public class PublicacionController {

    private final PublicacionService publicacionService;
    @Autowired
    private UsuarioService usuarioService;

    /**
     * Crea una nueva publicación.
     * 
     * @param publicacion El objeto Publicación que se desea crear.
     * @return Respuesta HTTP con el código de estado 200 (OK) y la publicación creada.
     */
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/crear")
    public ResponseEntity<Publicacion> crearPublicacion(@RequestBody Publicacion publicacion) {
        publicacionService.crearPublicacion(publicacion);
        return ResponseEntity.ok(publicacion);
    }

    /**
     * Obtiene una publicación por su ID.
     * 
     * @param id El ID de la publicación que se desea obtener.
     * @return Respuesta HTTP con la publicación encontrada o un error 404 si no se encuentra.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Publicacion> obtenerPublicacion(@PathVariable Long id) {
        Optional<Publicacion> publicacion = publicacionService.obtenerPublicacionPorId(id);
        return publicacion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Obtiene todas las publicaciones disponibles.
     * 
     * @return Respuesta HTTP con una lista de todas las publicaciones.
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
     * Elimina una publicación por su ID.
     * 
     * @param id El ID de la publicación que se desea eliminar.
     * @return Respuesta HTTP con el código de estado 204 (No Content) si la eliminación fue exitosa.
     */
    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarPublicacion(@PathVariable Long id) {
        publicacionService.eliminarPublicacion(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Agrega una categoría ODS a una publicación existente.
     * 
     * @param id El ID de la publicación a la que se le desea agregar la categoría ODS.
     * @param ods El objeto ODS que se desea agregar a la publicación.
     * @return Respuesta HTTP con el código de estado 200 (OK) si la categoría ODS fue agregada.
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
     * Agrega un "like" de un usuario a una publicación.
     * 
     * @param publicacionId El ID de la publicación a la que se le desea agregar el like.
     * @param usuarioId El ID del usuario que está dando el like.
     * @return Respuesta HTTP con un mensaje indicando si el like fue agregado o si ya fue dado previamente.
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
     * Elimina un "like" de un usuario a una publicación.
     * 
     * @param publicacionId El ID de la publicación de la que se desea eliminar el like.
     * @param usuarioId El ID del usuario cuyo like se desea eliminar.
     * @return Respuesta HTTP con un mensaje indicando si el like fue eliminado o si no existía.
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
     * Obtiene todos los "likes" de una publicación.
     * 
     * @param publicacionId El ID de la publicación para la cual se desean obtener los likes.
     * @return Respuesta HTTP con una lista de los usuarios que dieron like y la cantidad total de likes.
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
     * Agrega un comentario a una publicación.
     * 
     * @param id El ID de la publicación a la que se desea agregar el comentario.
     * @param comentario El objeto Comentario que se desea agregar a la publicación.
     * @return Respuesta HTTP con el código de estado 200 (OK) si el comentario fue agregado.
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
