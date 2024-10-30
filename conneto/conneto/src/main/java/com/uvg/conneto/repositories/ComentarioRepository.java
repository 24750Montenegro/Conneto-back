// ComentarioRepository.java
package com.uvg.conneto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.uvg.conneto.models.Comentario;
import java.util.List;
import org.springframework.data.domain.Pageable;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
    List<Comentario> findByPublicacionId(Long publicacionId, Pageable pageable);
}
