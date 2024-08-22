/**
 * @ Project : Proyecto de Semestre, Conneto
 * @author Marcelo Detlefsen
 * Creacion 09.08.2024
 * Ultima modificacion 09.08.2024
 * @ File Name: ODS.java
 */

public class ODS
{
    private String nombre;
    private String descripcion;

    /**
     * Constructor para crear una nueva instancia de ODS.
    * 
    * @param nombre El nombre del ODS.
    * @param descripcion La descripción del ODS.
    */
    public ODS(String nombre, String descripcion) 
    {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    /**
     * Obtiene el nombre del ODS.
    * 
    * @return El nombre del ODS.
    */
    public String getNombre() 
    {
        return nombre;
    }

    /**
     * Establece el nombre del ODS.
    * 
    * @param nombre El nombre a establecer.
    */
    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }

    /**
     * Obtiene la descripción del ODS.
    * 
    * @return La descripción del ODS.
    */
    public String getDescripcion() 
    {
        return descripcion;
    }

    /**
     * Establece la descripción del ODS.
    * 
    * @param descripcion La descripción a establecer.
    */
    public void setDescripcion(String descripcion) 
    {
        this.descripcion = descripcion;
    }
}
