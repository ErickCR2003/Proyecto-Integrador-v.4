package Modelo;

import java.time.LocalDate;

public class Pago {

    private int ID;
    private LocalDate fecHoraCreacion;
    private double impTotal;
    private String formaDePago;
    private String nroTransaccion;
    
    private int idAlquiler;
    private Alquiler alquiler;

    public Pago() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public LocalDate getFecHoraCreacion() {
        return fecHoraCreacion;
    }

    public void setFecHoraCreacion(LocalDate fecHoraCreacion) {
        this.fecHoraCreacion = fecHoraCreacion;
    }

    public int getIdAlquiler() {
        return idAlquiler;
    }

    public void setIdAlquiler(int idAlquiler) {
        this.idAlquiler = idAlquiler;
    }

    public double getImpTotal() {
        return impTotal;
    }

    public void setImpTotal(double impTotal) {
        this.impTotal = impTotal;
    }

    public String getFormaDePago() {
        return formaDePago;
    }

    public void setFormaDePago(String formaDePago) {
        this.formaDePago = formaDePago;
    }

    public String getNroTransaccion() {
        return nroTransaccion;
    }

    public void setNroTransaccion(String nroTransaccion) {
        this.nroTransaccion = nroTransaccion;
    }

    public Alquiler getAlquiler() {
        return alquiler;
    }

    public void setAlquiler(Alquiler alquiler) {
        this.alquiler = alquiler;
    }

}
