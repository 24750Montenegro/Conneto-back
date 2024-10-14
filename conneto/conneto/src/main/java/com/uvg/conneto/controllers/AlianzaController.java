package com.uvg.conneto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.uvg.conneto.services.AlianzaService;
import com.uvg.conneto.models.Alianza;

import java.util.ArrayList;

@RestController
@RequestMapping("/alianza")
public class AlianzaController {

    @Autowired
    private AlianzaService AlianzaService;

    @GetMapping()
    public ArrayList<Alianza> obtenerAlianzas(){
        return AlianzaService.obtenerAlianzas();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("guardarAlianza")
    public void guardarAlianza(@RequestBody Alianza alianza){
        AlianzaService.createAlianza(alianza);
    }
    
}