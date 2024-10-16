package com.uvg.conneto.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uvg.conneto.models.ODS;
import com.uvg.conneto.services.ODSService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/ods")
@RequiredArgsConstructor
public class ODSController 
{
    @Autowired
    private final ODSService odsService;

    // Crear ODS
    @PostMapping("/crear")
    public ResponseEntity<ODS> crearODS(@RequestBody ODS ods) 
    {
        odsService.crearODS(ods);
        return ResponseEntity.ok(ods);
    }

    // Obtener ODS por ID
    @GetMapping("/{id}")
    public ResponseEntity<ODS> obtenerODS(@PathVariable Long id) 
    {
        Optional<ODS> ods = odsService.obtenerODSPorId(id);
        return ods.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Obtener todas las ODS
    @GetMapping("/todas")
    public ResponseEntity<List<ODS>> obtenerTodasODS() 
    {
        return ResponseEntity.ok(odsService.obtenerTodasODS());
    }

    // Actualizar ODS
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<ODS> actualizarODS(@PathVariable Long id, @RequestBody ODS odsActualizado) 
    {
        odsService.actualizarODS(id, odsActualizado);
        return ResponseEntity.ok(odsActualizado);
    }

    // Eliminar ODS
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarODS(@PathVariable Long id) 
    {
        odsService.eliminarODS(id);
        return ResponseEntity.noContent().build();
    }   
}
