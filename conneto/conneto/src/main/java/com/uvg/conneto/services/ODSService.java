package com.uvg.conneto.services;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.uvg.conneto.models.ODS;
import com.uvg.conneto.repositories.ODSRepository;

import lombok.RequiredArgsConstructor;

/**
 * Servicio para gestionar la lógica de negocio relacionada con los Objetivos de Desarrollo Sostenible (ODS).
 * 
 * Proporciona métodos para crear, leer, actualizar y eliminar ODS, interactuando con el repositorio {@link ODSRepository}.
 */
@Service
@RequiredArgsConstructor
public class ODSService {

    /**
     * Repositorio para interactuar con la base de datos de ODS.
     * Inyectado automáticamente mediante el uso de {@code @RequiredArgsConstructor}.
     */
    private final ODSRepository odsRepository;

    /**
     * Crea un nuevo ODS y lo guarda en la base de datos.
     * 
     * @param ods Objeto {@link ODS} que se desea guardar.
     */
    public void crearODS(ODS ods) {
        odsRepository.save(ods);
    }

    /**
     * Busca un ODS por su ID.
     * 
     * @param id Identificador único del ODS.
     * @return Un {@link Optional} que contiene el ODS encontrado, o vacío si no se encuentra.
     */
    public Optional<ODS> obtenerODSPorId(Long id) {
        return odsRepository.findById(id);
    }

    /**
     * Obtiene una lista de todos los ODS almacenados en la base de datos.
     * 
     * @return Una lista de objetos {@link ODS}.
     */
    public List<ODS> obtenerTodasODS() {
        return odsRepository.findAll();
    }

    /**
     * Actualiza un ODS existente en la base de datos.
     * 
     * @param id            Identificador único del ODS a actualizar.
     * @param odsActualizado Objeto {@link ODS} con los datos actualizados.
     */
    public void actualizarODS(Long id, ODS odsActualizado) {
        Optional<ODS> odsExistente = odsRepository.findById(id);
        if (odsExistente.isPresent()) {
            ODS ods = odsExistente.get();
            ods.setNombre(odsActualizado.getNombre());
            ods.setDescripcion(odsActualizado.getDescripcion());
            odsRepository.save(ods);
        }
    }

    /**
     * Elimina un ODS de la base de datos por su ID.
     * 
     * @param id Identificador único del ODS que se desea eliminar.
     */
    public void eliminarODS(Long id) {
        odsRepository.deleteById(id);
    }
}