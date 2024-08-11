/**
 * @ Project : Proyecto de Semestre, Conneto
 * @author Luis Girón
 * Creacion 10.08.2024
 * Ultima modificacion 10.08.2024
 * @ File Name: Tarea.java
 * 
 */
public class Tarea {

    // Atributos de la clase
    private String nombre; // Se refiere al nombre con el cual se identifica la tarea.
    private String descripcion; // una breve descripcion de la tarea a realizar
    private Usuario asignado; // El usuario que está asignado para realizar la tarea
    private boolean completada; // Un verificador si la tarea esta completa o no

    //Constructor 1: Método tradicional con parametros
    public Tarea(String nombre, String descripcion, Usuario asignado, boolean completada){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.asignado = asignado;
		this.completada = completada;
    }

    //Constructor 2:  Metodo secundario sin parametros
    public Tarea(){
        //Iniicializa un objeto tarea, sin asignarle ningun valor a sus atributos.
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

    //Set y get de asignado

    public void setAsignado(Usuario asignado){
        this.asignado = asignado;
    }

    public Usuario getAsignado(){
        return asignado;
    }

    //Set y get de usuarios

    public void setCompletada(boolean completada){
        this.completada = completada;
    }

    public boolean getCompletada(){
        return completada;
    }
	
	public void completarTarea(){
		// Se completara la tarea
	}
}