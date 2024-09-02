package com.uvg.conneto.repositories;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.uvg.conneto.models.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
        Usuario findByEmail(String email);

}

