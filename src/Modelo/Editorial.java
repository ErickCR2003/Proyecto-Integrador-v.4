package Modelo;

import Formatos.FormatoEditoriales;

public class Editorial {
    private int ideditorial;
    private String nombre;
    private String estado;
    private int descuento;
    private Double porcentajeDescuento;

    public Editorial() {
    }

    public int getIdeditorial()                 {   return ideditorial; }
    public void setIdeditorial(int ideditorial) {   this.ideditorial = ideditorial; }
    public String getNombre()                   { return nombre;  }
    public void setNombre(String nombre)        {  this.nombre = nombre;   }
    public String getEstado()                   { return estado;  }
    public void setEstado(String estado)        {  this.estado = estado;   }
    public int getDescuento() {return descuento;}
    public void setDescuento(int descuento) {this.descuento = descuento;}
    public Double getPorcentajeDescuento()      {return porcentajeDescuento;}
    public void setPorcentajeDescuento(Double porcentajeDescuento) {this.porcentajeDescuento = porcentajeDescuento;}

        
    public Object[] RegistroEditoriales(int num){
             
        FormatoEditoriales formatoEdi = new Formatos.FormatoEditoriales();
        String desc = formatoEdi.DeIntAString(descuento);
        
        Object[] fila = {ideditorial,nombre,estado, desc, porcentajeDescuento};
        return fila;
    }
    
}
