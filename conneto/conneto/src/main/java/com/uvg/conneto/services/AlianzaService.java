package com.uvg.conneto.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.uvg.conneto.models.Alianza;
import com.uvg.conneto.models.Usuario;
import com.uvg.conneto.repositories.AlianzaRepository;
import com.uvg.conneto.repositories.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AlianzaService {   
    private final AlianzaRepository AlianzaRepository;
    private final AlianzaRepository alianzaRepository;
    private final UsuarioRepository usuarioRepository;
    //metodo para crear alianza
    public void createAlianza(Alianza alianza){
        AlianzaRepository.save(alianza);
    }

    //metodo para conseguir el  ArrayList de todas las alianzas
    public ArrayList<Alianza> obtenerAlianzas(){
        return (ArrayList<Alianza>) AlianzaRepository.findAll();
    }

    //metodo par aconseguir una alianza en especifico
    public Alianza obtenerAlianzaPorId(Long id) {
        return AlianzaRepository.findById(id).orElse(null);
    }

    //agregar a un usuario a una alianza
    public boolean unirUsuarioAAlianza(Long alianzaId, Long usuarioId) {
        Optional<Alianza> alianzaOpt = alianzaRepository.findById(alianzaId);
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(usuarioId);
        if (alianzaOpt.isPresent() && usuarioOpt.isPresent()) {
            Alianza alianza = alianzaOpt.get();
            Usuario usuario = usuarioOpt.get();
            if (!alianza.getUsuarios().contains(usuario)) {
                alianza.getUsuarios().add(usuario);
                alianzaRepository.save(alianza);
            }
            return true;
        }
        return false;
    }

    //elimina a un usuario de una alianza
    public boolean eliminarUsuarioDeAlianza(Long alianzaId, Long usuarioId) {
        Optional<Alianza> alianzaOpt = alianzaRepository.findById(alianzaId);
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(usuarioId);
        if (alianzaOpt.isPresent() && usuarioOpt.isPresent()) {
            Alianza alianza = alianzaOpt.get();
            Usuario usuario = usuarioOpt.get();
            if (alianza.getUsuarios().contains(usuario)) {
                alianza.getUsuarios().remove(usuario);
                alianzaRepository.save(alianza);
            }
            return true;
        }
        return false;
    }

}
