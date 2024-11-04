package com.uvg.conneto.services;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.uvg.conneto.models.ODS;
import com.uvg.conneto.repositories.ODSRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ODSService 
{
    //Crear ODS
    private final ODSRepository odsRepository;
    public void crearODS(ODS ods)
    {
        odsRepository.save(ods);
    }

    // Leer ODS por ID
    public Optional<ODS> obtenerODSPorId(Long id) 
    {
        return odsRepository.findById(id);
    }

    // Leer todas las ODS
    public List<ODS> obtenerTodasODS() 
    {
        return odsRepository.findAll();
    }

    //Actualizar ODS
    public void actualizarODS(Long id, ODS odsActualizado) 
    {
        Optional<ODS> odsExistente = odsRepository.findById(id);
        if (odsExistente.isPresent()) {
            ODS ods = odsExistente.get();
            ods.setNombre(odsActualizado.getNombre());
            ods.setDescripcion(odsActualizado.getDescripcion());
            odsRepository.save(ods);
        }
    }

    //Eliminar ODS
    public void eliminarODS(Long id) 
    {
        odsRepository.deleteById(id);
    }
}
