/**
 * @ Project : Proyecto de Semestre, Conneto
 * @author Luis Girón y Julián Divas
 * Creacion 10.08.2024
 * Ultima modificacion 16.08.2024
 * @ File Name: Tarea.java
 * 
 */
import java.util.ArrayList;
import java.util.List;

public class TareaCRUD {
    private List<Tarea> tareas = new ArrayList<>();

    //Crea una nueva tarea
    public void addTarea(Tarea tarea) {
        tareas.add(tarea);
    }

    //Brinda una nueva tarea basándose en el nombre
    public Tarea getTarea(String nombre) {
        for (Tarea tarea : tareas) {
            if (tarea.getNombre().equalsIgnoreCase(nombre)) {
                return tarea;
            }
        }
        return null; //En caso de no encontrar la tarea devuelve un valor null
    }

    //Actualiza los datos de una tarea para una tarea existente
    public boolean updateTarea(String nombre, Tarea tareaActualizada) {
        for (int i = 0; i < tareas.size(); i++) {
            Tarea tarea = tareas.get(i);
            if (tarea.getNombre().equalsIgnoreCase(nombre)) {
                tareas.set(i, tareaActualizada);
                return true; //El proceso se realizó exitosamente
            }
        }
        return false;}
        //No ha sido posible encontrar la tarea

    // Borra una tarea basándose en el nombre de esta
    public boolean deleteTarea(String nombre) {
        return tareas.removeIf(tarea -> tarea.getNombre().equalsIgnoreCase(nombre));
    }

    //Devuelve todas las tareas
    public List<Tarea> getAllTareas() {
        return tareas;
    }

    // Devuelve todas las tareas de un usuario específico
    public List<Tarea> getTareasPorUsuario(Usuario usuario) {
        List<Tarea> tareasPorUsuario = new ArrayList<>();
        for (Tarea tarea : tareas) {
            if (tarea.getAsignado().equals(usuario)) {
                tareasPorUsuario.add(tarea);
            }
        }
        return tareasPorUsuario;
    }

    //Marca una taraa completada, las busca en base a su nombre
    public boolean completarTarea(String nombre) {
        Tarea tarea = getTarea(nombre);
        if (tarea != null) {
            tarea.setCompletada(true);
            return true; // La tarea se completó
        }
        return false; // No se encontró la tarea
    }
}

