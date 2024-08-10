//  @ Proyecto Fase 2
//  @ File Name : Alianza.java
//  @ Date : 10/08/2024
//  @ Author : Alejandro Manuel Jerez Melgar 24678
//

import java.util.List;
public class Alianza {
    //Atributos
    private List usuarios;
    private List proyectos;
    private String descripcion;

    /**
     * 
     * @param usuarios List
     * @param proyectos List
     * @param descripcion String
     */
    public Alianza(List usuarios, List proyectos, String descripcion){
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
    public List getProyectos() {
        return proyectos;
    }
    /**
     * 
     * @param proyectos
     */
    public void setProyectos(List proyectos) {
        this.proyectos = proyectos;
    }
    
    /**
     * 
     * @return usuarios
     */
    public List getUsuarios() {
        return usuarios;
    }
    /**
     * 
     * @param usuarios
     */
    public void setUsuarios(List usuarios) {
        this.usuarios = usuarios;
    }
}
