package Modelo;

public class HerramientaxDetalle {
    private int idlibrosxdetalle;
    private int idlibro;
    private int iddetalles;
    
    private Herramienta libro;
    private Detalles detalle;

    public HerramientaxDetalle() {
    }

    public int getIdlibrosxdetalle() {  return idlibrosxdetalle;}
    public void setIdlibrosxdetalle(int idlibrosxdetalle) {this.idlibrosxdetalle = idlibrosxdetalle;}
    public int getIdlibro() {return idlibro;}
    public void setIdlibro(int idlibro) {this.idlibro = idlibro;}
    public int getIddetalles() {return iddetalles;}
    public void setIddetalles(int iddetalles) {this.iddetalles = iddetalles;}
    public Herramienta getLibro() {return libro;}
    public void setLibro(Herramienta libro) {this.libro = libro;}
    public Detalles getDetalle() {return detalle;}
    public void setDetalle(Detalles detalle) {this.detalle = detalle;}
   
}
