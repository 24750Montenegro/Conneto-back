package com.uvg.conneto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.uvg.conneto.models.ODS;
import com.uvg.conneto.services.ODSService;

import java.util.ArrayList;

@RestController
@RequestMapping("/ods")
public class ODSController 
{
    @Autowired
    private ODSService odsService;

    @GetMapping()
    public ArrayList<ODS> obtenerODSs() 
    {
        return odsService.obtenerODSs();
    }

    @PostMapping()
    public ODS guardarODS(@RequestBody ODS ods) 
    {
        return this.odsService.guardarUsuario(ods);
    }    
}
