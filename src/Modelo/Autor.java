
package Modelo;

public class Autor {
    private int idautor;
    private String nombre;
    private String estado;
    private String descuento;
    private double porcentajeDescuento;

    public Autor() {
    }

    public int getIdautor()              {   return idautor; }
    public void setIdautor(int idautor)  {   this.idautor = idautor; }
    public String getNombre()            { return nombre;  }
    public void setNombre(String nombre) {  this.nombre = nombre;   }
    public String getEstado()            { return estado;  }
    public void setEstado(String estado) {  this.estado = estado;   }

    public String getDescuento() {
        return descuento;
    }

    public void setDescuento(String descuento) {
        this.descuento = descuento;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }
    
    
    public Object [] RegistroAutores(int num){
        Object[] fila = {idautor,nombre,estado,descuento,porcentajeDescuento};
        return fila;
    }
}
