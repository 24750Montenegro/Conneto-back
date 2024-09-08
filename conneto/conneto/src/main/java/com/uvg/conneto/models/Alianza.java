package com.uvg.conneto.models;

import java.util.List;

//  @ Proyecto Fase 2
//  @ File Name : Alianza.java
//  @ Date : 10/08/2024
//  @ Author : Alejandro Manuel Jerez Melgar 24678


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Alianza {
    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;

    @ManyToMany
    @JoinTable(
        name = "alianza_usuario",
        joinColumns = @JoinColumn(name = "alianza_id"),
        inverseJoinColumns = @JoinColumn(name = "usuario_id")
    )
    private List<Usuario> usuarios;

    @OneToMany(mappedBy = "alianza", cascade = CascadeType.ALL)
    private List<Proyecto> proyectos;
    

    // /**
    //  * Constructor de la clase Alianza
    //  *
    //  * @param usuarios     List<Usuario> - Lista de usuarios asociados a la alianza
    //  * @param proyectos    List<Proyecto> - Lista de proyectos asociados a la alianza
    //  * @param descripcion  String - Descripción de la alianza
    //  */
    // public Alianza(List<Usuario> usuarios, List<Proyecto> proyectos, String descripcion) {
    //     this.usuarios = usuarios;
    //     this.proyectos = proyectos;
    //     this.descripcion = descripcion;
    // }

    // /**
    //  * @return String - Descripción de la alianza
    //  */
    // public String getDescripcion() {
    //     return descripcion;
    // }

    // /**
    //  * @param descripcion String - Descripción de la alianza
    //  */
    // public void setDescripcion(String descripcion) {
    //     this.descripcion = descripcion;
    // }

    // /**
    //  * @return List<Proyecto> - Lista de proyectos asociados a la alianza
    //  */
    // public List<Proyecto> getProyectos() {
    //     return proyectos;
    // }

    // /**
    //  * @param proyectos List<Proyecto> - Lista de proyectos asociados a la alianza
    //  */
    // public void setProyectos(List<Proyecto> proyectos) {
    //     this.proyectos = proyectos;
    // }

    // /**
    //  * @return List<Usuario> - Lista de usuarios asociados a la alianza
    //  */
    // public List<Usuario> getUsuarios() {
    //     return usuarios;
    // }

    // /**
    //  * @param usuarios List<Usuario> - Lista de usuarios asociados a la alianza
    //  */
    // public void setUsuarios(List<Usuario> usuarios) {
    //     this.usuarios = usuarios;
    // }
}
