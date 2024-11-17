// Definimos el paquete donde se encuentra la clase Proyecto
package com.uvg.conneto.models;
//Se importa list para hace uso de listas
import java.util.List;
// Se importan las anotaciones de JPA necesarias para la configuración de la entidad y las relaciones en la base de datos
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Genera getters correspondientes y demás métodos como toString
@Data
//Genera un constructor con todos los parametros
@AllArgsConstructor
//Genera un constructor sin parametros
@NoArgsConstructor
//Se define a la clase como una entidad para la persistencia de datos
@Entity
//Se crea la clase proyecto
public class Proyecto {
    
    // Atributos de la clase

    //Se define Id como la clave primaria de la entidad
    @Id 
    //Hace que el Id sea autogenerado en la base de datos
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    //Atributo privado id
    private Long id; 

    @Basic
    private String nombre; // Se refiere al nombre con el cual se identifica el proyecto.
    private String descripcion; // una breve descripcion del proyecto a realizar

    //Multiplicidad varios a uno, cada proyecto tiene un autor y un autor varios proyectos
    @ManyToOne
    @JoinColumn(name = "usuario_id") // Llave foránea que relaciona el proyecto con un usuario
    //Atributo usuario correspondiente a su autor
    private Usuario autor;
    
    //Se refiere a la multiplicidad de muchos a muchos
    @ManyToMany
    @JoinTable(
        // Nombre de la tabla intermedia para la relación muchos a muchos(name = "proyecto_id"),
        name = "proyecto_ods",
        // Llave foránea que hace referencia a Proyecto
        joinColumns = @JoinColumn(name = "proyecto_id"),
        // Llave foránea que hace referencia a ODS
        inverseJoinColumns = @JoinColumn(name = "ods_id")
    )
    private List<ODS> categoriaODS; // Una lista la cual contiene los ODS que aborda el proyecto a trabajar

    @ManyToMany
    @JoinTable(
        // Nombre de la tabla intermedia para la relación muchos a muchos
        name = "proyecto_usuario",
        // Nombre de la tabla intermedia para la relación muchos a muchos
        joinColumns = @JoinColumn(name = "proyecto_id"),
        // Llave foránea que hace referencia a Usuario
        inverseJoinColumns = @JoinColumn(name = "usuario_id")
    )
    private List<Usuario> usuarios; // Una lista con los participantes del proyecto

    //Relacion one to many, un proyecto puede tener varias tareas.
    //cascade indica que las operaciones en Proyecto también se aplicarán a sus tareas
    @OneToMany(mappedBy = "proyecto", cascade = CascadeType.ALL)
    private List<Tarea> tareas; // Otra lista con las tareas a realizar en el proyecto para que este se lleve a cabo


    // Relación ManyToOne entre Proyecto y Alianza, donde un proyecto puede estar asociado a una alianza específica
    @ManyToOne
    // 'JoinColumn' especifica la llave foránea 'alianza_id' para la relación en la tabla de proyecto
    @JoinColumn(name = "alianza_id")
    private Alianza alianza; //Id de la alianza a la cual esta ligada


    public Proyecto orElseThrow(Object object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'orElseThrow'");
    }

    
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