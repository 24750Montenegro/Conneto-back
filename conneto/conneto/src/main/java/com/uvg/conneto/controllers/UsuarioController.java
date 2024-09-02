package com.uvg.conneto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.uvg.conneto.services.UsuarioService;
import com.uvg.conneto.models.Usuario;

import java.util.ArrayList;

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

        @PostMapping("/signup")
    public Usuario signUp(@RequestBody Usuario usuario) {
        return usuarioService.registrarUsuario(usuario);
    }

    @PostMapping("/login")
    public Usuario login(@RequestParam String email, @RequestParam String contrasena) {
        return usuarioService.autenticarUsuario(email, contrasena);
    }
}
