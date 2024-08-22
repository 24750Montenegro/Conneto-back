package com.uvg.conneto.models;
//  @ Proyecto Fase 2
//  @ File Name : Alianza.java
//  @ Date : 10/08/2024
//  @ Author : Alejandro Manuel Jerez Melgar 24678
//


import java.util.List;
public class Alianza {
    //Atributos
    private List<Usuario> usuarios;
    private List<Proyecto> proyectos;
    private String descripcion;

    /**
     * 
     * @param usuarios List
     * @param proyectos List
     * @param descripcion String
     */
    public Alianza(List<Usuario> usuarios, List<Proyecto> proyectos, String descripcion){
        this.usuarios=usuarios;
        this.proyectos=proyectos;
        this.descripcion=descripcion;
    }

    /**
     * 
     * @return descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }
    /**
     * 
     * @param descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    /**
     * 
     * @return proyectos
     */
    public List<Proyecto> getProyectos() {
        return proyectos;
    }
    /**
     * 
     * @param proyectos
     */
    public void setProyectos(List<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }
    
    /**
     * 
     * @return usuarios
     */
    public List<Usuario> getUsuarios() {
        return usuarios;
    }
    /**
     * 
     * @param usuarios
     */
    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
