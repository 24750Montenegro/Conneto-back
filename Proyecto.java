import java.util.List;

/**
 * @ Project : Proyecto de Semestre, Conneto
 * @author Julián Divas
 * Creacion 09.08.2024
 * Ultima modificacion 09.08.2024
 * @ File Name: Proyecto.java
 * 
 */

public class Proyecto {
    
    // Atributos de la clase
    private String nombre; // Se refiere al nombre con el cual se identifica el proyecto.
    private String descripcion; // una breve descripcion del proyecto a realizar
    private List<ODS> categoriaODS; // Una lista la cual contiene los ODS que aborda el proyecto a trabajar
    private List<Usuario> usuarios; // Una lista con los participantes del proyecto
    private List<Tarea> tareas; // Otra lista con las tareas a realizar en el proyecto para que este se lleve a cabo

    //Constructor 1: Método tradicional con parametros
    public Proyecto(String nombre, String descripcion, List<ODS> categoriaODS, List<Usuario> usuarios, List<Tarea> tareas){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoriaODS = categoriaODS;
        this.usuarios = usuarios;
        this.tareas = tareas;
    }

    //Constructor 2:  Metodo secundario sin parametros
    public Proyecto(){
        //Iniicializa un objeto proyecto, sin asignarle ningun valor a sus atributos.
    }

    //Set y get de nombre

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }

    //Sets y gets de descripcion

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public String getDescripcion(){
        return descripcion;
    }

    //Set y get de categoriaODS

    public void setCategoriaODS(List<ODS> categoriaODS){
        this.categoriaODS = categoriaODS;
    }

    public List<ODS> getCategoriaODS(){
        return categoriaODS;
    }

    //Set y get de usuarios

    public void setUsuarios(List<Usuario> usuarios){
        this.usuarios = usuarios;
    }

    public List<Usuario> getUsuarios(){
        return usuarios;
    }

    //Set y get de tareas

    public void setTareas(List<Tarea> tareas){
        this.tareas = tareas;
    }

    public List<Tarea> getTareas(){
        return tareas;
    }

    public void agregarCategoria(ODS ods)
    { categoriaODS.add(ods);}

    public void agregarUsuario(Usuario usuario)
    {usuarios.add(usuario);}

    public void agregarTarea(Tarea tarea)
    {tareas.add(tarea);}
}