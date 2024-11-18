// Definimos el paquete donde se encuentra la clase Tarea
package com.uvg.conneto.models;
/**
 * @ Project : Proyecto de Semestre, Conneto
 * @author Luis Girón
 * Creacion 10.08.2024
 * Ultima modificacion 01.09.2024
 * @ File Name: Tarea.java
 * 
 */
 import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
 // Se importan las anotaciones de JPA necesarias para la configuración de la entidad y las relaciones en la base de datos
 import jakarta.persistence.*;
 import lombok.AllArgsConstructor;
 import lombok.Data;
 import lombok.NoArgsConstructor;
 
 //Genera getters correspondientes y demás métodos como toString
 @Data
 //Genera un constructor con todos los parametros
 @AllArgsConstructor
 //Genera un constructor sin parametros
 @NoArgsConstructor
 //Se define a la clase como una entidad para la persistencia de datos
 @Entity
 //Se crea la clase tarea
public class Tarea {

    // Atributos de la clase
    //Se define Id como la clave primaria de la entidad
    // Atributos
    @Id 
    //Hace que el Id sea autogenerado en la base de datos
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    //Atributo privado id
    private Long id; 

    @Basic
    private String nombre; // Se refiere al nombre con el cual se identifica la tarea.
    private String descripcion; // una breve descripcion de la tarea a realizar
    private boolean completada; // Un verificador si la tarea esta completa o no

    //Multiplicidad varios a uno, cada tarea tiene un usuario y un usuario varias tareas
    @ManyToOne
    @JsonIgnoreProperties(value = {"publicacionesQueLeGustan", "publicaciones", "likes"})
    @JoinColumn(name = "asignado_id") // Llave foránea que relaciona la tarea con un usuario
    private Usuario asignado; // El usuario que está asignado para realizar la tarea

    //Multiplicidad varios a uno, cada tarea tiene un proyecto y un proyecto varias tareas
    @ManyToOne
    @JsonIgnoreProperties(value= {"autor", "usuarios","tareas", "alianza"})
    @JoinColumn(name = "proyecto_id") // Llave foránea que relaciona la tarea con un proyecto
    private Proyecto proyecto; // El proyecto en el que se encuentra la tarea

    //Constructor 1: Método tradicional con parametros
    public Tarea(String nombre, String descripcion, Usuario asignado, boolean completada){
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.asignado = asignado;
	this.completada = completada;
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

    //Set y Get de completada

    public void setCompletada(boolean completada){
        this.completada = completada;
    }

    public boolean getCompletada(){
    return completada;
    }
	
	public void completarTarea(){
	// Se completara la tarea
    this.completada = true;
	}
}