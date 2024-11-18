//Se indica donde se guarda la TareaRepository
package com.uvg.conneto.repositories;

//Se importan los recursos necesarios
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.uvg.conneto.models.Tarea;

/**
 * TareaRepository es una interfaz que extiende {@link CrudRepository} para proporcionar operaciones
 * CRUD (crear, leer, actualizar y eliminar) en entidades {@link Tarea}.
 * @Repository indica que esta interfaz es un componente de repositorio de Spring,
 * lo que permite que sea detectada automáticamente y manejada por el contenedor de Spring.
 */
@Repository
public interface TareaRepository extends JpaRepository<Tarea, Long> {
        /**
         * Busca y devuelve una tarea basada en su nombre y por el ID de un proyecto.
         *
         * @param nombre el nombre de la tarea a buscar
         * @param proyectoId el ID de un proyecto
         * @return la tarea con el nombre especificado, o {@code null} si no se encuentra ninguno.
         */
        Tarea findByNombre(String nombre);
        List<Tarea> findByProyectoId(Long proyectoId);
}