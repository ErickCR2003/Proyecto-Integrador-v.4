
package Modelo;
import Formatos.FormatoTipodeLibro;

public class TipoLibro {
    private int idlibro;
    private String nombreTipo;
    private String estado;
    private int descuento;
    private Double porcentajeDescuento;

    public TipoLibro() {
    }

    public int getIdlibro() { return idlibro;}
    public void setIdlibro(int idlibro) {this.idlibro = idlibro;}
    public String getNombreTipo() {return nombreTipo;}
    public void setNombreTipo(String nombreTipo) {this.nombreTipo = nombreTipo;}
    public String getEstado() {return estado;}
    public void setEstado(String estado) {this.estado = estado;}
    public int getDescuento() { return descuento;}
    public void setDescuento(int descuento) {this.descuento = descuento;}
    public Double getPorcentajeDescuento() {return porcentajeDescuento;}
    public void setPorcentajeDescuento(Double porcentajeDescuento) {this.porcentajeDescuento = porcentajeDescuento;}
    
     public Object[] RegistroTipoLibro(int num){
        
        FormatoTipodeLibro formatoTpl = new Formatos.FormatoTipodeLibro();
        String desc = formatoTpl.DeIntAString(descuento);
         
        Object[] fila = {idlibro,nombreTipo,estado, desc, porcentajeDescuento};
        return fila;
    }
}
