/**
 * @ Project : Proyecto de Semestre, Conneto
 * @author Julián Divas y Luis Angel Giron
 * Creacion 09.08.2024
 * Ultima modificacion 09.08.2024
 * @ File Name: ProyectoCRUD.java
 * 
 */
import java.util.ArrayList;
import java.util.List;

public class ProyectoCRUD {
        private List<Proyecto> proyectos = new ArrayList<>();

        //Crea un nuevo proyecto
        public void addProyecto(Proyecto proyecto) {
            proyectos.add(proyecto);
        }

        //Obtiene un proyecto de acuerdo a su nombre
        public Proyecto getProyecto(String nombre) {
            for (Proyecto proyecto : proyectos) {
                if (proyecto.getNombre().equals(nombre)) {
                    return proyecto;
                }
            }
            return null; // En caso de no encontrarlo devuelve un nulo.
        }

        //Actualiza los datos de un proyecto existente
        public boolean updateProyecto(String nombre, Proyecto proyectoActualizado) {
            for (int i = 0; i < proyectos.size(); i++) {
                Proyecto proyecto = proyectos.get(i);
                if (proyecto.getNombre().equals(nombre)) {
                    proyectos.set(i, proyectoActualizado);
                    return true; //La actualizacion se realizo correctamente
                }
            }
            return false;///No fue posible encontrar el proyecto.
        }

        //Elimina un proyecto buscando su nombre.
        public boolean deleteProyecto(String nombre) {
            return proyectos.removeIf(proyecto -> proyecto.getNombre().equals(nombre));
        }

        // Muestra todos los proyectos existentes.
        public List<Proyecto> getAllProyectos() {
            return proyectos;
        }
    }