package com.uvg.conneto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUserById(@PathVariable Long id) {
        return usuarioService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
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

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/update/{userId}")
    public Usuario updateUser(@PathVariable Long userId, @RequestBody Usuario usuario) {
        return usuarioService.updateUser(userId, usuario);
    }

}
