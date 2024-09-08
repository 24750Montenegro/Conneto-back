package com.uvg.conneto.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uvg.conneto.models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository <Usuario, Long> {
        Usuario findByEmail(String email);

}

