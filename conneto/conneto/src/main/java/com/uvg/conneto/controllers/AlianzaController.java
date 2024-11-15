package com.uvg.conneto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;

import com.uvg.conneto.services.AlianzaService;
import com.uvg.conneto.models.Alianza;

import java.util.List;

@RestController
@RequestMapping("/alianza")
public class AlianzaController {

    @Autowired
    private AlianzaService alianzaService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/{id}")
    public ResponseEntity<Alianza> obtenerAlianzaPorId(@PathVariable Long id) {
        Alianza alianza = alianzaService.obtenerAlianzaPorId(id);
        if (alianza != null) {
            return ResponseEntity.ok(alianza);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Autowired
    private AlianzaService AlianzaService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping()
    public ResponseEntity<List<Alianza>> obtenerAlianzas() {
        List<Alianza> alianzas = AlianzaService.obtenerAlianzas();
        return ResponseEntity.ok(alianzas);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("guardarAlianza")
    public void guardarAlianza(@RequestBody Alianza alianza) {
        AlianzaService.createAlianza(alianza);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/{alianzaId}/unirse/{usuarioId}")
    public ResponseEntity<Void> unirseAlianza(@PathVariable Long alianzaId, @PathVariable Long usuarioId) {
        if (alianzaService.unirUsuarioAAlianza(alianzaId, usuarioId)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/{alianzaId}/salir/{usuarioId}")
    public ResponseEntity<Void> salirDeAlianza(@PathVariable Long alianzaId, @PathVariable Long usuarioId) {
        if (alianzaService.eliminarUsuarioDeAlianza(alianzaId, usuarioId)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}