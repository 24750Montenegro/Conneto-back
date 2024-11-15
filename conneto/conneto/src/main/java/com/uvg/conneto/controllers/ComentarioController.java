// ComentarioController.java
package com.uvg.conneto.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uvg.conneto.models.Comentario;
import com.uvg.conneto.services.ComentarioService;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/guardarComentario")
    public ResponseEntity<String> guardarComentario(@RequestBody Comentario comentario) {
        comentarioService.createComentario(comentario);
        return ResponseEntity.ok("Comentario guardado exitosamente");
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/{publicacionId}")
    public ResponseEntity<List<Map<String, Object>>> obtenerComentariosPorPublicacion(
            @PathVariable Long publicacionId) {
        // Llama al servicio para obtener todos los comentarios sin limitarlos
        List<Map<String, Object>> comentarios = comentarioService.obtenerComentariosPorPublicacion(publicacionId);
        return ResponseEntity.ok(comentarios);
    }
}