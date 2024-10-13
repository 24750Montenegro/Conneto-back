package com.uvg.conneto.models;
//  @ Proyecto Fase 2
//  @ File Name : Comentario.java
//  @ Date : 10/08/2024
//  @ Author : Alejandro Manuel Jerez Melgar 24678
//


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comentario {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String contenido;


       // Relación muchos a uno con Publicacion
       @ManyToOne
       @JoinColumn(name = "publicacion_id")
       private Publicacion publicacion;
   
       // Relación muchos a uno con Usuario (autor)
       @ManyToOne
       @JoinColumn(name = "autor_id")
       private Usuario autor;

    // //Constructor 1: 
    // /**
    //  * 
    //  * @param autor Usuario
    //  * @param contenido String
    //  */
    // public Comentario(Usuario autor, String contenido){
    //     this.autor=autor;
    //     this.contenido=contenido;
    // }

    // /**
    //  * 
    //  * @return autor
    //  */
    // public Usuario getAutor() {
    //     return autor;
    // }
    // /**
    //  * 
    //  * @param autor
    //  */
    // public void setAutor(Usuario autor) {
    //     this.autor = autor;
    // }

    // /**
    //  * 
    //  * @return contenido
    //  */
    // public String getContenido() {
    //     return contenido;
    // }
    // /**
    //  * 
    //  * @param contenido
    //  */
    // public void setContenido(String contenido) {
    //     this.contenido = contenido;
    // }
}