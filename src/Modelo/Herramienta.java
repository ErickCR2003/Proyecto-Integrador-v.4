package Modelo;

import java.time.LocalDate;

public class Herramienta {
    private int ID;
    private String nroSerie;    
    private String nombre;
    private double imp_ValorReferencial;
    private int anioFabricacion;    
    private String descripcion;
    private double peso;
    private double imp_PrecioAlquiler;
    private LocalDate fecAdquisicion;    
    private int nroAlquileres;
    private String estado;  
    
    private int idTipo;
    private TipoHerramienta Tipo;
    
    public Herramienta() {
    }
    
//Getter y Setters ---------------------------------------------------------------------------------
    public int getID()                          {return ID;}
    public void setID(int ID)                   {this.ID = ID;}
    public String getNroSerie()                 {return nroSerie;}
    public void setNroSerie(String nroSerie)    {this.nroSerie = nroSerie;}
    public String getNombre()                   {return nombre;}
    public void setNombre(String nombre)        {this.nombre = nombre;}
    public int getIdTipo()                      {return idTipo;}
    public void setIdTipo(int idTipo)           {this.idTipo = idTipo;}
    public TipoHerramienta getTipo()                       {return Tipo;}
    public void setTipo(TipoHerramienta Tipo)              {this.Tipo = Tipo;}
    public double getImp_ValorReferencial() {return imp_ValorReferencial;}
    public void setImp_ValorReferencial(double imp_ValorReferencial) {this.imp_ValorReferencial = imp_ValorReferencial;}
    public int getAnioFabricacion() {return anioFabricacion;}
    public void setAnioFabricacion(int anioFabricacion) {this.anioFabricacion = anioFabricacion;}
    public String getDescripcion()              {return descripcion;}
    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}
    public double getPeso() {return peso;}
    public void setPeso(double peso)            {this.peso = peso;}
    public double getImp_PrecioAlquiler() {return imp_PrecioAlquiler;}
    public void setImp_PrecioAlquiler(double imp_PrecioAlquiler) {this.imp_PrecioAlquiler = imp_PrecioAlquiler;}
    public LocalDate getFecAdquisicion()        {return fecAdquisicion;}
    public void setFecAdquisicion(LocalDate fecAdquisicion) {this.fecAdquisicion = fecAdquisicion;}
    public int getNroAlquileres()               {return nroAlquileres;}
    public void setNroAlquileres(int nroAlquileres) {this.nroAlquileres = nroAlquileres;}
    public String getEstado()                   {return estado;}
    public void setEstado(String estado)        {this.estado = estado;}    
    
    
    
    //Listados ----------------------------------------------------------------------   
    
       public Object [] RegistroHerramientas(int num){
        Object[] fila = {ID, nroSerie, nombre, Tipo.getNombreTipo(), imp_ValorReferencial, anioFabricacion, peso,imp_PrecioAlquiler, nroAlquileres,  estado};
        return fila;
    }
    
    public Object [] RegistroHerramientaAlquiler(int num){
        Object[] fila = {ID, nroSerie, nombre, Tipo.getNombreTipo(), imp_ValorReferencial, peso,imp_PrecioAlquiler, nroAlquileres};
        return fila;
    }
    
    public Object [] RegistroHerramientasCarrito(Herramienta her){
        Object[] fila = {her.ID, her.nroSerie, her.nombre, her.Tipo.getNombreTipo(), her.imp_ValorReferencial, her.peso,her.imp_PrecioAlquiler, her.nroAlquileres};
        return fila;
    } 
}
