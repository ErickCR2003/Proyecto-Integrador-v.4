package Modelo;

import Formatos.FormatoTipos;

public class TipoHerramienta {
    private int ID;
    private String nombreTipo;
    private String descripcion;

    public TipoHerramienta() {
    }

    public int getID()                          {return ID;}
    public void setID(int ID)                   {this.ID = ID;}
    public String getNombreTipo() { return nombreTipo;}
    public void setNombreTipo(String nombreTipo) {this.nombreTipo = nombreTipo;}
    public String getDescripcion()              {return descripcion;}
    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}
           
    public Object[] RegistroTipoHerramienta(int num){             
        FormatoTipos formatoEdi = new Formatos.FormatoTipos();        
        Object[] fila = {ID,nombreTipo, descripcion};
        return fila;
    }
    
}
