package com.uvg.conneto.models;

//  @ Proyecto Fase 2
//  @ File Name : Alianza.java
//  @ Date : 10/08/2024
//  @ Author : Alejandro Manuel Jerez Melgar 24678

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "alianza")
public class Alianza {
    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @ManyToMany // Anotación para indicar la relación muchos a muchos con Usuarios
    private List<Usuario> usuarios;

    @ManyToMany // Anotación para indicar la relación muchos a muchos con Proyectos
    private List<Proyecto> proyectos;

    private String descripcion;

    /**
     * Constructor de la clase Alianza
     *
     * @param usuarios     List<Usuario> - Lista de usuarios asociados a la alianza
     * @param proyectos    List<Proyecto> - Lista de proyectos asociados a la alianza
     * @param descripcion  String - Descripción de la alianza
     */
    public Alianza(List<Usuario> usuarios, List<Proyecto> proyectos, String descripcion) {
        this.usuarios = usuarios;
        this.proyectos = proyectos;
        this.descripcion = descripcion;
    }

    /**
     * @return String - Descripción de la alianza
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion String - Descripción de la alianza
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return List<Proyecto> - Lista de proyectos asociados a la alianza
     */
    public List<Proyecto> getProyectos() {
        return proyectos;
    }

    /**
     * @param proyectos List<Proyecto> - Lista de proyectos asociados a la alianza
     */
    public void setProyectos(List<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }

    /**
     * @return List<Usuario> - Lista de usuarios asociados a la alianza
     */
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    /**
     * @param usuarios List<Usuario> - Lista de usuarios asociados a la alianza
     */
    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
