package com.uvg.conneto.models;
/**
 * @ Project : Proyecto de Semestre, Conneto
 * @author Luis Girón
 * Creacion 10.08.2024
 * Ultima modificacion 01.09.2024
 * @ File Name: Tarea.java
 * 
 */


import javax.persistence.*;

@Entity
@Table(name = "tarea")
public class Tarea {

    // Atributos
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id; 

    private String nombre; // Se refiere al nombre con el cual se identifica la tarea.
    private String descripcion; // una breve descripcion de la tarea a realizar
    private Usuario asignado; // El usuario que está asignado para realizar la tarea
    private boolean completada; // Un verificador si la tarea esta completa o no

    //Constructor 1: Método tradicional con parametros
    public Tarea(String nombre, String descripcion, Usuario asignado){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.asignado = asignado;
        this.completada = false; // La tarea inicia como no completada
    }

    //Constructor 2: Metodo secundario sin parametros
    public Tarea() {
        //Iniicializa un objeto tarea, sin asignarle ningun valor a sus atributos.
    }

    //Set y get de nombre

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }

    //Set y get de descripcion

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

    //Set y get de completada

    public void setCompletada(boolean completada){
        this.completada = completada;
    }

    public boolean getCompletada(){
        return completada;
    }
	
    // Método para marcar la tarea como completada
	public void completarTarea(){
		this.completada = true;
	}
}