package com.uvg.conneto.models;

/**
 * @ Project : Proyecto de Semestre, Conneto
 * @author Marcelo Detlefsen
 * Creacion 09.08.2024
 * Ultima modificacion 01.09.2024
 * @ File Name: ODS.java
 */



 import jakarta.persistence.*;
 import lombok.AllArgsConstructor;
 import lombok.Data;
 import lombok.NoArgsConstructor;
 
 @Data
 @AllArgsConstructor
 @NoArgsConstructor
 @Entity
public class ODS
{
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id; 

    @Basic
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    // /**
    //  * Constructor para crear una nueva instancia de ODS.
    // * 
    // * @param nombre El nombre del ODS.
    // * @param descripcion La descripción del ODS.
    // */
    // public ODS(String nombre, String descripcion) 
    // {
    //     this.nombre = nombre;
    //     this.descripcion = descripcion;
    // }

    // /**
    //  * Obtiene el nombre del ODS.
    // * 
    // * @return El nombre del ODS.
    // */
    // public String getNombre() 
    // {
    //     return nombre;
    // }

    // /**
    //  * Establece el nombre del ODS.
    // * 
    // * @param nombre El nombre a establecer.
    // */
    // public void setNombre(String nombre) 
    // {
    //     this.nombre = nombre;
    // }

    // /**
    //  * Obtiene la descripción del ODS.
    // * 
    // * @return La descripción del ODS.
    // */
    // public String getDescripcion() 
    // {
    //     return descripcion;
    // }

    // /**
    //  * Establece la descripción del ODS.
    // * 
    // * @param descripcion La descripción a establecer.
    // */
    // public void setDescripcion(String descripcion) 
    // {
    //     this.descripcion = descripcion;
    // }
}
