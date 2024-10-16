package com.uvg.conneto.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
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

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/publicaciones")
@RequiredArgsConstructor
public class PublicacionController 
{
    private final PublicacionService publicacionService;

    // Crear Publicación
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
    @GetMapping("/todas")
    public ResponseEntity<List<Publicacion>> obtenerTodasPublicaciones() 
    {
        return ResponseEntity.ok(publicacionService.obtenerTodasPublicaciones());
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

    // Agregar un "like" a una Publicación
    @PutMapping("/{id}/like")
    public ResponseEntity<Void> agregarLike(@PathVariable Long id, @RequestBody Usuario usuario) 
    {
        Optional<Publicacion> publicacion = publicacionService.obtenerPublicacionPorId(id);
        if (publicacion.isPresent()) 
        {
            publicacionService.agregarLike(publicacion.get(), usuario);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
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
