package com.uvg.conneto.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uvg.conneto.models.Usuario;
import com.uvg.conneto.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping()
    public ArrayList<Usuario> obtenerUsuarios() {
        return usuarioService.obtenerUsuarios();
    }

    @PostMapping()
    public Usuario guardarUsuario(@RequestBody Usuario usuario) {
        return this.usuarioService.guardarUsuario(usuario);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/signup")
    public Usuario signUp(@RequestBody Usuario usuario) {
        return usuarioService.registrarUsuario(usuario);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/login")
    public Usuario login(@RequestParam String email, @RequestParam String contrasena) {
        return usuarioService.autenticarUsuario(email, contrasena);
    }
}
