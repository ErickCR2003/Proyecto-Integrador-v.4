package Modelo;

import Formatos.FormatoTipos;

public class Tipo {
    private int ID;
    private String nombre;
    private String descripcion;

    public Tipo() {
    }

    public int getID()                          {return ID;}
    public void setID(int ID)                   {this.ID = ID;}
    public String getNombre()                   {return nombre;}
    public void setNombre(String nombre)        {this.nombre = nombre;}
    public String getDescripcion()              {return descripcion;}
    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}
   

        
    public Object[] RegistroEditoriales(int num){             
        FormatoTipos formatoEdi = new Formatos.FormatoTipos();        
        Object[] fila = {ID,nombre,nombre, descripcion,};
        return fila;
    }

  
    
}
