package Modelo;

public class DetallesAlquiler {

    private int ID;
    private double imp_montofinal;
    
    private int idAlquiler;
    private Alquiler alquiler;
    
    private int idHerramienta;
    private Herramienta herramienta;
    
    public DetallesAlquiler() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getIdAlquiler() {
        return idAlquiler;
    }

    public void setIdAlquiler(int idAlquiler) {
        this.idAlquiler = idAlquiler;
    }

    public int getIdHerramienta() {
        return idHerramienta;
    }

    public void setIdHerramienta(int idHerramienta) {
        this.idHerramienta = idHerramienta;
    }

    public double getImp_montofinal() {
        return imp_montofinal;
    }

    public void setImp_montofinal(double imp_montofinal) {
        this.imp_montofinal = imp_montofinal;
    }

    public Alquiler getAlquiler() {
        return alquiler;
    }

    public void setAlquiler(Alquiler alquiler) {
        this.alquiler = alquiler;
    }

    public Herramienta getHerramienta() {
        return herramienta;
    }

    public void setHerramienta(Herramienta herramienta) {
        this.herramienta = herramienta;
    }
    
    //    public Object [] RegistroDetallesAlquiler(int num){
//        Object[] fila = {ID,nombrecompleto,telefono,direccion,fecNacimiento,rucDni,numeroIdentificacion};
//        return fila;
//    }
    
}
