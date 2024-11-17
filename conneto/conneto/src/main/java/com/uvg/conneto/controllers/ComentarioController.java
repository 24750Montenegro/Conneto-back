// ComentarioController.java
package com.uvg.conneto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import com.uvg.conneto.services.ComentarioService;
import com.uvg.conneto.models.Comentario;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;

    //Guarda un comentario
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/guardarComentario")
    public ResponseEntity<String> guardarComentario(@RequestBody Comentario comentario) {
        comentarioService.createComentario(comentario);
        return ResponseEntity.ok("Comentario guardado exitosamente");
    }

    //Obtiene todos los comentarios
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/{publicacionId}")
    public ResponseEntity<List<Map<String, Object>>> obtenerComentariosPorPublicacion(
            @PathVariable Long publicacionId) {
        // Llama al servicio para obtener todos los comentarios sin limitarlos
        List<Map<String, Object>> comentarios = comentarioService.obtenerComentariosPorPublicacion(publicacionId);
        return ResponseEntity.ok(comentarios);
    }
}
