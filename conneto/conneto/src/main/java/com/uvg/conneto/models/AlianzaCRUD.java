package com.uvg.conneto.models;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Project : Proyecto de Semestre, Conneto
 * @author Marcelo Detlefsen
 * Creacion 25.08.2024
 * Ultima modificacion 25.08.2024
 * @ File Name: Publicación.java
 */
public class AlianzaCRUD 
{
    // Lista para almacenar las alianzas
    private List<Alianza> alianzas;

    // Constructor
    public void CRUD_Alianza() 
    {
        this.alianzas = new ArrayList<>();
    }

    // Crear una nueva alianza
    public void crearAlianza(List<Usuario> usuarios, List<Proyecto> proyectos, String descripcion) 
    {
        Alianza nuevaAlianza = new Alianza(usuarios, proyectos, descripcion);
        alianzas.add(nuevaAlianza);
    }

    // Leer una alianza específica por índice
    public Alianza leerAlianza(int index) 
    {
        if (index >= 0 && index < alianzas.size()) 
        {
            return alianzas.get(index);
        }
        return null; // Retorna null si el índice no es válido
    }

    // Leer todas las alianzas
    public List<Alianza> leerTodasLasAlianzas() 
    {
        return new ArrayList<>(alianzas);
    }

    // Actualizar una alianza específica por índice
    public void actualizarAlianza(int index, List<Usuario> nuevosUsuarios, List<Proyecto> nuevosProyectos, String nuevaDescripcion)
    {
        if (index >= 0 && index < alianzas.size()) 
        {
            Alianza alianza = alianzas.get(index);
            alianza.setUsuarios(nuevosUsuarios);
            alianza.setProyectos(nuevosProyectos);
            alianza.setDescripcion(nuevaDescripcion);
        }
    }

    // Eliminar una alianza específica por índice
    public void eliminarAlianza(int index) 
    {
        if (index >= 0 && index < alianzas.size()) 
        {
            alianzas.remove(index);
        }
    }

    // Obtener la cantidad de alianzas
    public int cantidadDeAlianzas() 
    {
        return alianzas.size();
    }
}
