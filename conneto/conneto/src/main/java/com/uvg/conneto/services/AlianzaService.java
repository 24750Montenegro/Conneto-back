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
    public void createAlianza(Alianza alianza){
        AlianzaRepository.save(alianza);
    }

    public ArrayList<Alianza> obtenerAlianzas(){
        return (ArrayList<Alianza>) AlianzaRepository.findAll();
    }

    public Alianza obtenerAlianzaPorId(Long id) {
        return AlianzaRepository.findById(id).orElse(null);
    }

    private final AlianzaRepository alianzaRepository;
    private final UsuarioRepository usuarioRepository;

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
