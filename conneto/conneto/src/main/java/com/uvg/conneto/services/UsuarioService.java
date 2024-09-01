package com.uvg.conneto.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uvg.conneto.models.Usuario;
import com.uvg.conneto.repositories.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    public ArrayList<Usuario> obtenerUsuarios(){
        return (ArrayList<Usuario>) usuarioRepository.findAll();
    }

    public Usuario guardarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

        public Usuario registrarUsuario(Usuario usuario) {
        // Verificar si el usuario ya existe
        if (usuarioRepository.findByEmail(usuario.getEmail()) != null) {
            throw new IllegalArgumentException("El email ya está registrado");
        }
        // Guardar el usuario en la base de datos
        return usuarioRepository.save(usuario);
    }

    public Usuario autenticarUsuario(String email, String contrasena) {
        // Buscar el usuario por email
        Usuario usuario = usuarioRepository.findByEmail(email);
        if (usuario == null || !usuario.getContrasena().equals(contrasena)) {
            throw new IllegalArgumentException("Credenciales incorrectas");
        }
        return usuario;
    }
    
}
