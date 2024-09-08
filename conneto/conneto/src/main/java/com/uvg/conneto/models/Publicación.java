package com.uvg.conneto.models;
import java.util.List;
import java.util.Set;

/**
 * @ Project : Proyecto de Semestre, Conneto
 * @author Marcelo Detlefsen
 * Creacion 09.08.2024
 * Ultima modificacion 09.08.2024
 * @ File Name: Publicación.java
 */


 import jakarta.persistence.*;
 import lombok.AllArgsConstructor;
 import lombok.Data;
 import lombok.NoArgsConstructor;
 
 @Data
 @AllArgsConstructor
 @NoArgsConstructor
 @Entity
public class Publicación 
{
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id; 

    @Basic
    private String contenido;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Usuario autor;

    @ManyToMany
    @JoinTable(
        name = "publicacion_ods",
        joinColumns = @JoinColumn(name = "publicacion_id"),
        inverseJoinColumns = @JoinColumn(name = "ods_id")
    )
    private List<ODS> categoriaODS;

    @ManyToMany
    @JoinTable(
        name = "publicacion_likes",
        joinColumns = @JoinColumn(name = "publicacion_id"),
        inverseJoinColumns = @JoinColumn(name = "usuario_id")
    )
    private Set<Usuario> likes;

    @OneToMany(mappedBy = "publicacion", cascade = CascadeType.ALL)
    private List<Comentario> comentarios;

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
}
