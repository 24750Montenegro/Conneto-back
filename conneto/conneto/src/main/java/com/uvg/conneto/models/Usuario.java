package com.uvg.conneto.models;
/**
 * @ Project : Proyecto de Semestre, Conneto
 * @author Juan Montenegro
 * Creacion 10.08.2024
 * Ultima modificacion 10.08.2024
 * @ File Name: Usuario.java
 * 
 */


import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

    //Atributos
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id; 

    
    private String nombre;
    private String email;
    private String contrasena;
    private String ubicacion;
    private List<String> habilidades;
    private List<Publicación> publicaciones;
    private List<Proyecto> proyectos;
    private List<ODS> interesesODS;
    private List<Alianza> alianzas;
    private List<Usuario> aliados;


    //Getters & setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public String getUbicacion() {
        return ubicacion;
    }
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    public List<String> getHabilidades() {
        return habilidades;
    }
    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }
    public List<Publicación> getPublicaciones() {
        return publicaciones;
    }
    public void setPublicaciones(List<Publicación> publicaciones) {
        this.publicaciones = publicaciones;
    }
    public List<Proyecto> getProyectos() {
        return proyectos;
    }
    public void setProyectos(List<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }
    public List<ODS> getInteresesODS() {
        return interesesODS;
    }
    public void setInteresesODS(List<ODS> interesesODS) {
        this.interesesODS = interesesODS;
    }
    public List<Alianza> getAlianzas() {
        return alianzas;
    }
    public void setAlianzas(List<Alianza> alianzas) {
        this.alianzas = alianzas;
    }
    public List<Usuario> getAliados() {
        return aliados;
    }
    public void setAliados(List<Usuario> aliados) {
        this.aliados = aliados;
    }


    //Constructores
    public Usuario() {
    }
    public Usuario(String nombre, String email, String contrasena, String ubicacion, List<String> habilidades,
            List<Publicación> publicaciones, List<Proyecto> proyectos, List<ODS> interesesODS, List<Alianza> alianzas,
            List<Usuario> aliados) {
        this.nombre = nombre;
        this.email = email;
        this.contrasena = contrasena;
        this.ubicacion = ubicacion;
        this.habilidades = habilidades;
        this.publicaciones = publicaciones;
        this.proyectos = proyectos;
        this.interesesODS = interesesODS;
        this.alianzas = alianzas;
        this.aliados = aliados;
    }

    

    

}
