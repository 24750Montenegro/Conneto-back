package com.uvg.conneto.models;
/**
 * @ Project : Proyecto de Semestre, Conneto
 * @author Luis Girón
 * Creacion 10.08.2024
 * Ultima modificacion 01.09.2024
 * @ File Name: Tarea.java
 * 
 */


 import jakarta.persistence.*;
 import lombok.AllArgsConstructor;
 import lombok.Data;
 import lombok.NoArgsConstructor;
 
 @Data
 @AllArgsConstructor
 @NoArgsConstructor
 @Entity
public class Tarea {

    // Atributos
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id; 

    @Basic
    private String nombre; // Se refiere al nombre con el cual se identifica la tarea.
    private String descripcion; // una breve descripcion de la tarea a realizar
    private boolean completada; // Un verificador si la tarea esta completa o no


    @ManyToOne
    @JoinColumn(name = "asignado_id")
    private Usuario asignado; // El usuario que está asignado para realizar la tarea
    
    @ManyToOne
    @JoinColumn(name = "proyecto_id")
    private Proyecto proyecto;

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