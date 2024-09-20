package com.uvg.conneto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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
    private AlianzaService alianzaService;

    @GetMapping()
    public ArrayList<Alianza> obtenerAlianzas(){
        return alianzaService.obtenerAlianzas();
    }

    @PostMapping()
    public Alianza guardarAlianza(@RequestBody Alianza alianza){
        return this.alianzaService.guardarAlianza(alianza);
    }
    
}