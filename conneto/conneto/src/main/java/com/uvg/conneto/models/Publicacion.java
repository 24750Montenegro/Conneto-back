//Se define donde se guardará el archivo
package com.uvg.conneto.models;
//Se importan los recursos necesarios
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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

/**
 * Clase que representa una publicación en el sistema.
 * 
 * Cada publicación puede tener contenido textual, una imagen asociada, un autor, categorías ODS, 
 * una lista de usuarios que han dado "like" y una lista de comentarios.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Publicacion {

    /**
     * Identificador único de la publicación.
     * Generado automáticamente mediante {@code GenerationType.IDENTITY}.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Contenido textual de la publicación.
     */
    @Basic
    private String contenido;

    /**
     * URL de la imagen asociada a la publicación.
     */
    @Basic
    private String imagenURL;

    /**
     * Autor de la publicación.
     * Relación de muchos a uno con la entidad {@link Usuario}.
     * Se ignoran las propiedades recursivas de publicaciones al serializar.
     */
    @ManyToOne
    @JsonIgnoreProperties("publicaciones")
    @JoinColumn(name = "autor_id")
    private Usuario autor;

    /**
     * Categorías ODS asociadas a la publicación.
     * Relación de muchos a muchos con la entidad {@link ODS}, cargada con una estrategia EAGER.
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "publicacion_ods",
        joinColumns = @JoinColumn(name = "publicacion_id"),
        inverseJoinColumns = @JoinColumn(name = "ods_id")
    )
    private List<ODS> categoriaODS;

    /**
     * Lista de usuarios que han dado "like" a la publicación.
     * Relación de muchos a muchos con la entidad {@link Usuario}.
     * Se ignoran las propiedades recursivas específicas relacionadas con "likes" y otras publicaciones.
     */
    @ManyToMany
    @JsonIgnoreProperties(value = {"publicaciones", "likes", "publicacionesQueLeGustan"})
    @JoinTable(
        name = "publicacion_likes",
        joinColumns = @JoinColumn(name = "publicacion_id"),
        inverseJoinColumns = @JoinColumn(name = "usuario_id")
    )
    private List<Usuario> likes;

    /**
     * Lista de comentarios asociados a la publicación.
     * Relación de uno a muchos con la entidad {@link Comentario}.
     * Los comentarios se eliminan automáticamente en cascada cuando se elimina la publicación.
     */
    @OneToMany(mappedBy = "publicacion", cascade = CascadeType.ALL)
    private List<Comentario> comentarios;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> categorias;
  

}

    // /**
    //  * Constructor para crear una nueva publicación.
    //  * 
    //  * @param contenido El contenido de la publicación.
    //  * @param autor El autor de la publicación.
    //  */
    // public Publicación(String contenido, Usuario autor)
    // {
    //     this.contenido = contenido;
    //     this.autor = autor;
    // }

    //     /**
    //  * Agrega una categoría ODS a la lista de categorías asociadas a la publicación.
    //  * 
    //  * @param ods La categoría ODS a agregar.
    //  */
    // public void agregarCategoriaODS(ODS ods)
    // {
    //     this.categoriaODS.add(ods);
    // }

    // /**
    //  * Agrega un like de un usuario a la publicación.
    //  * 
    //  * @param usuario El usuario que dio like.
    //  */
    // public void agregarLike(Usuario usuario) 
    // {
    //     this.likes.add(usuario);
    // }

    // /**
    //  * Agrega un comentario a la publicación.
    //  * 
    //  * @param comentario El comentario a agregar.
    //  */
    // public void agregarComentario(Comentario comentario) 
    // {
    //     this.comentarios.add(comentario);
    // }

    // /**
    //  * Obtiene el contenido de la publicación.
    //  * 
    //  * @return El contenido de la publicación.
    //  */
    // public String getContenido() 
    // {
    //     return contenido;
    // }

    // /**
    //  * Establece el contenido de la publicación.
    //  * 
    //  * @param contenido El contenido a establecer.
    //  */
    // public void setContenido(String contenido) 
    // {
    //     this.contenido = contenido;
    // }

    // /**
    //  * Obtiene el autor de la publicación.
    //  * 
    //  * @return El autor de la publicación.
    //  */
    // public Usuario getAutor() 
    // {
    //     return autor;
    // }

    // /**
    //  * Establece el autor de la publicación.
    //  * 
    //  * @param autor El autor a establecer.
    //  */
    // public void setAutor(Usuario autor) 
    // {
    //     this.autor = autor;
    // }

    // /**
    //  * Obtiene la lista de categorías ODS asociadas a la publicación.
    //  * 
    //  * @return La lista de categorías ODS.
    //  */
    // public List<ODS> getCategoriaODS() 
    // {
    //     return categoriaODS;
    // }

    // /**
    //  * Establece la lista de categorías ODS asociadas a la publicación.
    //  * 
    //  * @param categoriaODS La lista de categorías ODS a establecer.
    //  */
    // public void setCategoriaODS(List<ODS> categoriaODS) 
    // {
    //     this.categoriaODS = categoriaODS;
    // }

    // /**
    //  * Obtiene la lista de likes de la publicación.
    //  * 
    //  * @return La lista de likes.
    //  */
    // public List<Usuario> getLikes() 
    // {
    //     return likes;
    // }

    // /**
    //  * Establece la lista de likes de la publicación.
    //  * 
    //  * @param likes La lista de likes a establecer.
    //  */
    // public void setLikes(List<Usuario> likes) 
    // {
    //     this.likes = likes;
    // }

    // /**
    //  * Obtiene la lista de comentarios de la publicación.
    //  * 
    //  * @return La lista de comentarios.
    //  */
    // public List<Comentario> getComentarios() 
    // {
    //     return comentarios;
    // }

    // /**
    //  * Establece la lista de comentarios de la publicación.
    //  * 
    //  * @param comentarios La lista de comentarios a establecer.
    //  */
    // public void setComentarios(List<Comentario> comentarios) 
    // {
    //     this.comentarios = comentarios;
    // }

