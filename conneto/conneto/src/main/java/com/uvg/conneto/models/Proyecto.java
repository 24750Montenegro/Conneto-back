package com.uvg.conneto.models;
import java.util.ArrayList;
import java.util.List;

/**
 * @ Project : Proyecto de Semestre, Conneto
 * @author Julián Divas
 * Creacion 09.08.2024
 * @modifier Marcelo Detlefsen
 * Ultima modificacion 25.08.2024
 * @ File Name: Proyecto.java
 */

public class Proyecto {
    
    // Atributos de la clase
    private String nombre; // Se refiere al nombre con el cual se identifica el proyecto.
    private String descripcion; // una breve descripcion del proyecto a realizar
    private List<ODS> categoriaODS; // Una lista la cual contiene los ODS que aborda el proyecto a trabajar
    private List<Usuario> usuarios; // Una lista con los participantes del proyecto
    private List<Tarea> tareas; // Otra lista con las tareas a realizar en el proyecto para que este se lleve a cabo

    //Constructor 1: Método tradicional con parametros
    public Proyecto(String nombre, String descripcion, List<ODS> categoriaODS, List<Usuario> usuarios, List<Tarea> tareas){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoriaODS = categoriaODS;
        this.usuarios = usuarios;
        this.tareas = tareas;
    }

    //Constructor 2:  Metodo secundario sin parametros
    public Proyecto()
    {
        this.categoriaODS = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.tareas = new ArrayList<>();
    }

    // Método para agregar una categoría ODS
    public void agregarCategoriaODS(ODS ods)
    {
        if (this.categoriaODS == null) 
        {
            this.categoriaODS = new ArrayList<>();
        }
        this.categoriaODS.add(ods);
    }

    //Set y get de nombre

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }

    //Sets y gets de descripcion

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public String getDescripcion(){
        return descripcion;
    }

    //Set y get de categoriaODS

    public void setCategoriaODS(List<ODS> categoriaODS){
        this.categoriaODS = categoriaODS;
    }

    public List<ODS> getCategoriaODS(){
        return categoriaODS;
    }

    //Set y get de usuarios

    public void setUsuarios(List<Usuario> usuarios){
        this.usuarios = usuarios;
    }

    public List<Usuario> getUsuarios(){
        return usuarios;
    }

    //Set y get de tareas

    public void setTareas(List<Tarea> tareas){
        this.tareas = tareas;
    }

    public List<Tarea> getTareas(){
        return tareas;
    }

    // Método para agregar una categoría ODS de forma específica
public void agregarCategoria(String nombreODS) 
{
    ODS ods = switch (nombreODS) 
    {
        case "Fin de la pobreza" -> new ODS("Fin de la pobreza", "Acabar con la pobreza en todas sus formas y en todo el mundo.");
        case "Hambre cero" -> new ODS("Hambre cero", "Poner fin al hambre, lograr la seguridad alimentaria, mejorar la nutrición y promover la agricultura sostenible.");
        case "Salud y bienestar" -> new ODS("Salud y bienestar", "Garantizar una vida sana y promover el bienestar para todos en todas las edades.");
        case "Educación de calidad" -> new ODS("Educación de calidad", "Garantizar una educación inclusiva, equitativa y de calidad y promover oportunidades de aprendizaje durante toda la vida para todos.");
        case "Igualdad de género" -> new ODS("Igualdad de género", "Lograr la igualdad de género y empoderar a todas las mujeres y niñas.");
        case "Agua limpia y saneamiento" -> new ODS("Agua limpia y saneamiento", "Garantizar la disponibilidad de agua y su gestión sostenible y el saneamiento para todos.");
        case "Energía asequible y no contaminante" -> new ODS("Energía asequible y no contaminante", "Garantizar el acceso a una energía asequible, segura, sostenible y moderna para todos.");
        case "Trabajo decente y crecimiento económico" -> new ODS("Trabajo decente y crecimiento económico", "Promover el crecimiento económico sostenido, inclusivo y sostenible, el empleo pleno y productivo y el trabajo decente para todos.");
        case "Industria, innovación e infraestructura" -> new ODS("Industria, innovación e infraestructura", "Construir infraestructuras resilientes, promover la industrialización inclusiva y sostenible y fomentar la innovación.");
        case "Reducción de las desigualdades" -> new ODS("Reducción de las desigualdades", "Reducir la desigualdad en y entre los países.");
        case "Ciudades y comunidades sostenibles" -> new ODS("Ciudades y comunidades sostenibles", "Lograr que las ciudades y los asentamientos humanos sean inclusivos, seguros, resilientes y sostenibles.");
        case "Producción y consumo responsables" -> new ODS("Producción y consumo responsables", "Garantizar modalidades de consumo y producción sostenibles.");
        case "Acción por el clima" -> new ODS("Acción por el clima", "Adoptar medidas urgentes para combatir el cambio climático y sus efectos.");
        case "Vida submarina" -> new ODS("Vida submarina", "Conservar y utilizar de manera sostenible los océanos, los mares y los recursos marinos para el desarrollo sostenible.");
        case "Vida de ecosistemas terrestres" -> new ODS("Vida de ecosistemas terrestres", "Gestionar sosteniblemente los bosques, luchar contra la desertificación, detener e invertir la degradación de las tierras y detener la pérdida de biodiversidad.");
        case "Paz, justicia e instituciones sólidas" -> new ODS("Paz, justicia e instituciones sólidas", "Promover sociedades pacíficas e inclusivas para el desarrollo sostenible, facilitar el acceso a la justicia para todos y crear instituciones eficaces, responsables e inclusivas a todos los niveles.");
        case "Alianzas para lograr los objetivos" -> new ODS("Alianzas para lograr los objetivos", "Fortalecer los medios de ejecución y revitalizar la alianza mundial para el desarrollo sostenible.");
        default -> null;
    };

    if (ods != null) 
    {
        agregarCategoriaODS(ods);
    }

    else 
    {
        System.out.println("ODS no reconocida.");
    }
}


    public void agregarUsuario() //Recibirá como parametro un objeto usuario.
    {
        //el cual se añadirá a la lista usuarios del proyecto
    }

    public void agregarTarea() //Recibira como parametro un objeto tarea
    {
        //Dicho objeto será agregado a la lista de tareas del proyecto.
    }
}