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

@RestController
@RequestMapping("/publicaciones")
@RequiredArgsConstructor
public class PublicacionController 
{
    private final PublicacionService publicacionService;
    @Autowired
    private UsuarioService usuarioService;


    // Crear Publicación
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/crear")
    public ResponseEntity<Publicacion> crearPublicacion(@RequestBody Publicacion publicacion) 
    {
        publicacionService.crearPublicacion(publicacion);
        return ResponseEntity.ok(publicacion);
    }

    // Obtener Publicación por ID
    @GetMapping("/{id}")
    public ResponseEntity<Publicacion> obtenerPublicacion(@PathVariable Long id) 
    {
        Optional<Publicacion> publicacion = publicacionService.obtenerPublicacionPorId(id);
        return publicacion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Obtener todas las Publicaciones
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/todas")
    public ResponseEntity<List<Publicacion>> obtenerTodasPublicaciones() 
    {
        List<Publicacion> publicaciones = publicacionService.obtenerTodasPublicaciones();
        
        publicaciones.forEach(publicacion -> {
            publicacion.setCategoriaODS(publicacion.getCategoriaODS().stream()
                .map(ods -> new ODS(ods.getId(), ods.getNombre(), null, null))
                .collect(Collectors.toList()));
        });
        
        return ResponseEntity.ok(publicaciones);
    }

    // Actualizar Publicación
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Publicacion> actualizarPublicacion(@PathVariable Long id, @RequestBody Publicacion publicacionActualizada) 
    {
        publicacionService.actualizarPublicacion(id, publicacionActualizada);
        return ResponseEntity.ok(publicacionActualizada);
    }

    // Eliminar Publicación
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarPublicacion(@PathVariable Long id) 
    {
        publicacionService.eliminarPublicacion(id);
        return ResponseEntity.noContent().build();
    }

    // Agregar una categoría ODS a una Publicación
    @PutMapping("/{id}/categoriaODS")
    public ResponseEntity<Void> agregarCategoriaODS(@PathVariable Long id, @RequestBody ODS ods) 
    {
        Optional<Publicacion> publicacion = publicacionService.obtenerPublicacionPorId(id);
        if (publicacion.isPresent()) 
        {
            publicacionService.agregarCategoriaODS(publicacion.get(), ods);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
   

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/{publicacionId}/like/{usuarioId}")
    public ResponseEntity<String> agregarLike(@PathVariable Long publicacionId, @PathVariable Long usuarioId) {
        // Obtener la publicación y el usuario desde sus respectivos servicios
        Optional<Publicacion> publicacionOpt = publicacionService.obtenerPublicacionPorId(publicacionId);
        Optional<Usuario> usuarioOpt = usuarioService.getUserById(usuarioId);
    
        // Verificamos si ambas entidades están presentes
        if (publicacionOpt.isPresent() && usuarioOpt.isPresent()) {
            Publicacion publicacion = publicacionOpt.get();
            Usuario usuario = usuarioOpt.get();
    
            // Verificar si el usuario ya ha dado like a la publicación (para evitar duplicados)
            if (!publicacion.getLikes().contains(usuario)) {
                // Agregar el usuario a la lista de likes de la publicación
                publicacion.getLikes().add(usuario);
    
                // Guardamos la publicación actualizada en la base de datos
                publicacionService.crearPublicacion(publicacion);
                    return ResponseEntity.ok("Like agregado");
            } else {
                // Si ya dio like, respondemos indicando que no se puede duplicar
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ya has dado like a esta publicación");
            }
        }
    
        // En caso de que no se encuentren la publicación o el usuario
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Publicación o Usuario no encontrado");
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/{publicacionId}/like/{usuarioId}")
    public ResponseEntity<String> eliminarLike(@PathVariable Long publicacionId, @PathVariable Long usuarioId) {
        Optional<Publicacion> publicacionOpt = publicacionService.obtenerPublicacionPorId(publicacionId);
        Optional<Usuario> usuarioOpt = usuarioService.getUserById(usuarioId);

        // Verificamos si ambas entidades están presentes
        if (publicacionOpt.isPresent() && usuarioOpt.isPresent()) {
            Publicacion publicacion = publicacionOpt.get();
            Usuario usuario = usuarioOpt.get();

            // Verificar si el usuario ya ha dado like a la publicación
            if (publicacion.getLikes().contains(usuario)) {
                // Eliminar el usuario de la lista de likes de la publicación
                publicacion.getLikes().remove(usuario);

                // Guardamos la publicación actualizada en la base de datos
                publicacionService.crearPublicacion(publicacion);
                return ResponseEntity.ok("Like eliminado");
            } else {
                // Si el usuario no ha dado like, respondemos indicando que no se puede eliminar
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No has dado like a esta publicación");
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Publicación o Usuario no encontrado");
    }


    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/{publicacionId}/likes")
    public ResponseEntity<Map<String, Object>> obtenerLikes(@PathVariable Long publicacionId) {
        Optional<Publicacion> publicacionOpt = publicacionService.obtenerPublicacionPorId(publicacionId);

        // Verificar si la publicación existe
        if (publicacionOpt.isPresent()) {
            Publicacion publicacion = publicacionOpt.get();

            // Transformar cada usuario en un Map con solo los campos necesarios
            List<Map<String, Object>> likes = publicacion.getLikes().stream()
                .map(usuario -> {
                    Map<String, Object> userMap = new HashMap<>();
                    userMap.put("id", usuario.getId());
                    userMap.put("nombre", usuario.getNombre());
                    userMap.put("email", usuario.getEmail());
                    return userMap;
                })
                .collect(Collectors.toList());

            // Preparar la respuesta JSON con la lista de likes y la cantidad total
            Map<String, Object> response = new HashMap<>();
            response.put("likes", likes);
            response.put("cantidadLikes", likes.size());

            return ResponseEntity.ok(response);
        }

        // Si no se encuentra la publicación, retornamos un error 404
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "Publicación no encontrada"));
    }





    // Agregar un comentario a una Publicación
    @PutMapping("/{id}/comentario")
    public ResponseEntity<Void> agregarComentario(@PathVariable Long id, @RequestBody Comentario comentario) 
    {
        Optional<Publicacion> publicacion = publicacionService.obtenerPublicacionPorId(id);
        if (publicacion.isPresent()) 
        {
            publicacionService.agregarComentario(publicacion.get(), comentario);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
