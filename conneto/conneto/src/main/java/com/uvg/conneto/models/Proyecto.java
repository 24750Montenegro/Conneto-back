package com.uvg.conneto.models;
import java.util.List;

/**
 * @ Project : Proyecto de Semestre, Conneto
 * @author Julián Divas
 * Creacion 09.08.2024
 * Ultima modificacion 09.08.2024
 * @ File Name: Proyecto.java
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
public class Proyecto {
    
    // Atributos de la clase

    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id; 

    @Basic
    private String nombre; // Se refiere al nombre con el cual se identifica el proyecto.
    private String descripcion; // una breve descripcion del proyecto a realizar

    @ManyToOne
    @JoinColumn(name = "usuario_id") // Llave foránea que relaciona el proyecto con un usuario
    private Usuario autor;
    
    @ManyToMany
    @JoinTable(
        name = "proyecto_ods",
        joinColumns = @JoinColumn(name = "proyecto_id"),
        inverseJoinColumns = @JoinColumn(name = "ods_id")
    )
    private List<ODS> categoriaODS; // Una lista la cual contiene los ODS que aborda el proyecto a trabajar

    @ManyToMany
    @JoinTable(
        name = "proyecto_usuario",
        joinColumns = @JoinColumn(name = "proyecto_id"),
        inverseJoinColumns = @JoinColumn(name = "usuario_id")
    )
    private List<Usuario> usuarios; // Una lista con los participantes del proyecto

    @OneToMany(mappedBy = "proyecto", cascade = CascadeType.ALL)
    private List<Tarea> tareas; // Otra lista con las tareas a realizar en el proyecto para que este se lleve a cabo

    @ManyToOne
    @JoinColumn(name = "alianza_id")
    private Alianza alianza;

    // //Constructor 1: Método tradicional con parametros
    // public Proyecto(String nombre, String descripcion, List<ODS> categoriaODS, List<Usuario> usuarios, List<Tarea> tareas){
    //     this.nombre = nombre;
    //     this.descripcion = descripcion;
    //     this.categoriaODS = categoriaODS;
    //     this.usuarios = usuarios;
    //     this.tareas = tareas;
    // }

    // //Constructor 2:  Metodo secundario sin parametros
    // public Proyecto(){
    //     //Iniicializa un objeto proyecto, sin asignarle ningun valor a sus atributos.
    // }

    // //Set y get de nombre

    // public void setNombre(String nombre){
    //     this.nombre = nombre;
    // }

    // public String getNombre(){
    //     return nombre;
    // }

    // //Sets y gets de descripcion

    // public void setDescripcion(String descripcion){
    //     this.descripcion = descripcion;
    // }

    // public String getDescripcion(){
    //     return descripcion;
    // }

    // //Set y get de categoriaODS

    // public void setCategoriaODS(List<ODS> categoriaODS){
    //     this.categoriaODS = categoriaODS;
    // }

    // public List<ODS> getCategoriaODS(){
    //     return categoriaODS;
    // }

    // //Set y get de usuarios

    // public void setUsuarios(List<Usuario> usuarios){
    //     this.usuarios = usuarios;
    // }

    // public List<Usuario> getUsuarios(){
    //     return usuarios;
    // }

    // //Set y get de tareas

    // public void setTareas(List<Tarea> tareas){
    //     this.tareas = tareas;
    // }

    // public List<Tarea> getTareas(){
    //     return tareas;
    // }

    // public void agregarCategoria(
    //     // recibirá como parámetro un objeto ODS, para añadirlo y que este ligado a dicho ods
    // )
    // {//Se añadirá a la lista categoría}
    // }

    // public void agregarUsuario(
    //     //Recibirá como parametro un objeto usuario.
    // )
    // {//el cual se añadirá a la lista usuarios del proyecto
    // }

    // public void agregarTarea(
    //     //Recibira como parametro un objeto tarea
    // ){
    //     //Dicho objeto será agregado a la lista de tareas del proyecto.
    // }
}