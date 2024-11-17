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

/**
 * Controlador REST para gestionar las operaciones relacionadas con los Objetivos de Desarrollo Sostenible (ODS).
 * 
 * Proporciona endpoints para crear, leer, actualizar y eliminar ODS.
 * Los métodos utilizan {@link ResponseEntity} para retornar respuestas HTTP estándar.
 */
@RestController
@RequestMapping("/ods")
@RequiredArgsConstructor
public class ODSController {

    /**
     * Servicio encargado de la lógica de negocio relacionada con los ODS.
     * Inyectado automáticamente mediante {@link Autowired}.
     */
    @Autowired
    private final ODSService odsService;

    /**
     * Endpoint para crear un nuevo ODS.
     * 
     * @param ods Objeto {@link ODS} enviado en el cuerpo de la solicitud.
     * @return Un {@link ResponseEntity} con el ODS creado y un código HTTP 200 (OK).
     */
    @PostMapping("/crear")
    public ResponseEntity<ODS> crearODS(@RequestBody ODS ods) {
        odsService.crearODS(ods);
        return ResponseEntity.ok(ods);
    }

    /**
     * Endpoint para obtener un ODS por su ID.
     * 
     * @param id Identificador único del ODS.
     * @return Un {@link ResponseEntity} con el ODS encontrado y un código HTTP 200 (OK),
     * o un código HTTP 404 (Not Found) si no se encuentra.
     */
    @GetMapping("/{id}")
    public ResponseEntity<ODS> obtenerODS(@PathVariable Long id) {
        Optional<ODS> ods = odsService.obtenerODSPorId(id);
        return ods.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Endpoint para obtener una lista de todos los ODS disponibles.
     * 
     * @return Un {@link ResponseEntity} con la lista de todos los ODS y un código HTTP 200 (OK).
     */
    @GetMapping("/todas")
    public ResponseEntity<List<ODS>> obtenerTodasODS() {
        return ResponseEntity.ok(odsService.obtenerTodasODS());
    }

    /**
     * Endpoint para actualizar un ODS existente.
     * 
     * @param id            Identificador único del ODS a actualizar.
     * @param odsActualizado Objeto {@link ODS} con los datos actualizados.
     * @return Un {@link ResponseEntity} con el ODS actualizado y un código HTTP 200 (OK).
     */
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<ODS> actualizarODS(@PathVariable Long id, @RequestBody ODS odsActualizado) {
        odsService.actualizarODS(id, odsActualizado);
        return ResponseEntity.ok(odsActualizado);
    }

    /**
     * Endpoint para eliminar un ODS por su ID.
     * 
     * @param id Identificador único del ODS a eliminar.
     * @return Un {@link ResponseEntity} sin contenido (HTTP 204 No Content) si la operación es exitosa.
     */
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarODS(@PathVariable Long id) {
        odsService.eliminarODS(id);
        return ResponseEntity.noContent().build();
    }  
}
