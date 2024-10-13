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
import java.util.Set;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Usuario {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id; 

    @Basic
    private String nombre;
    private String email;
    private String contrasena;
    private String ubicacion;

    @ManyToMany(mappedBy = "likes")
    private Set<Publicacion> publicacionesQueLeGustan;

    @ElementCollection
    private List<String> habilidades;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
    private List<Publicacion> publicaciones;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
    private List<Proyecto> proyectos;

    @ManyToMany
    @JoinTable(
        name = "usuario_ods",
        joinColumns = @JoinColumn(name = "usuario_id"),
        inverseJoinColumns = @JoinColumn(name = "ods_id")
    )
    private List<ODS> interesesODS;
    
    @ManyToMany
    @JoinTable(
        name = "usuario_aliado",
        joinColumns = @JoinColumn(name = "usuario_id"),
        inverseJoinColumns = @JoinColumn(name = "aliado_id")
    )
    private List<Usuario> aliados;
    
    @OneToMany(mappedBy = "usuarios", cascade = CascadeType.ALL)
    private List<Alianza> alianzas;

}
