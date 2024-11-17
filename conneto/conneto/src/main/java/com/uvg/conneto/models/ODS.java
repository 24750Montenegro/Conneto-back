package com.uvg.conneto.models;

/**
 * @ Project : Proyecto de Semestre, Conneto
 * @author Marcelo Detlefsen
 * Creacion 09.08.2024
 * Ultima modificacion 01.09.2024
 * @ File Name: ODS.java
 */

import java.util.List;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Representa un Objetivo de Desarrollo Sostenible (ODS) dentro del sistema.
 * 
 * Esta clase utiliza JPA para mapear sus atributos como una entidad en la base
 * de datos y Lombok para generar automáticamente métodos comunes como getters,
 * setters, constructores y otros.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ODS {

    /**
     * Identificador único del ODS. 
     * Es la clave primaria de la entidad en la base de datos.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre del ODS.
     * Representa el título o nombre principal asociado a este objetivo.
     */
    @Basic
    private String nombre;

    /**
     * Descripción del ODS.
     * Proporciona detalles adicionales sobre el objetivo.
     * Este atributo se almacena como una columna llamada "descripcion" en la base de datos.
     */
    @Column(name = "descripcion")
    private String descripcion;

    /**
     * Lista de publicaciones asociadas al ODS.
     * Representa una relación de muchos a muchos entre los ODS y las publicaciones.
     * 
     * <p>
     * Esta relación es bidireccional y está mapeada por el atributo 
     * {@code categoriaODS} en la entidad {@code Publicacion}.
     * </p>
     */
    @ManyToMany(mappedBy = "categoriaODS")
    private List<Publicacion> publicaciones;

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
