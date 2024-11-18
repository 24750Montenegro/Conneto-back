//Se indica donde se guarda el ProyectoRepository
package com.uvg.conneto.repositories;

//Se importan los recursos necesarios
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.uvg.conneto.models.Proyecto;

/**
 * ProyectoRepository es una interfaz que extiende {@link CrudRepository} para proporcionar operaciones
 * CRUD (crear, leer, actualizar y eliminar) en entidades {@link Proyecto}.
 * @Repository indica que esta interfaz es un componente de repositorio de Spring,
 * lo que permite que sea detectada automáticamente y manejada por el contenedor de Spring.
 */
@Repository
public interface ProyectoRepository extends CrudRepository<Proyecto, Long> {

    /**
     * Busca y devuelve un proyecto basado en su nombre.
     *
     * @param nombre el nombre del proyecto a buscar
     * @return el proyecto con el nombre especificado, o {@code null} si no se encuentra ninguno.
     */
    Proyecto findByNombre(String nombre);
}
