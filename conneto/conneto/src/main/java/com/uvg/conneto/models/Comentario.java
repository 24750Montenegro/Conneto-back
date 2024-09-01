package com.uvg.conneto.models;
//  @ Proyecto Fase 2
//  @ File Name : Comentario.java
//  @ Date : 10/08/2024
//  @ Author : Alejandro Manuel Jerez Melgar 24678
//

import javax.persistence.*;

@Entity
@Table(name = "comentario")
public class Comentario {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private Usuario autor;
    private String contenido;

    //Constructor 1: 
    /**
     * 
     * @param autor Usuario
     * @param contenido String
     */
    public Comentario(Usuario autor, String contenido){
        this.autor=autor;
        this.contenido=contenido;
    }

    /**
     * 
     * @return autor
     */
    public Usuario getAutor() {
        return autor;
    }
    /**
     * 
     * @param autor
     */
    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    /**
     * 
     * @return contenido
     */
    public String getContenido() {
        return contenido;
    }
    /**
     * 
     * @param contenido
     */
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}