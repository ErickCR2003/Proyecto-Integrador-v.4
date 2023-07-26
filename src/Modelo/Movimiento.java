
package Modelo;

import java.time.LocalDate;

public class Movimiento {
    private int ID;
    private int idAlquiler;
    private int idEmpleado;
    private LocalDate fecEjecucion;
    private String tipoIngresoSalida;
    private String concepto; //INGRESO: alquiler, transporte, garantía. SALIDA: garantía, banco.
    private String tipoEfectivoElectronico;
    private double monto;

    
    public Movimiento(){
    }
    
    public Movimiento(int ID, int idAlquiler, int idEmpleado, LocalDate fecEjecucion, String tipoIngresoSalida, String concepto, String tipoEfectivoElectronico, double monto, String observ, boolean anulado) {
        this.ID = ID;
        this.idAlquiler = idAlquiler;
        this.idEmpleado = idEmpleado;
        this.fecEjecucion = fecEjecucion;
        this.tipoIngresoSalida = tipoIngresoSalida;
        this.concepto = concepto;
        this.tipoEfectivoElectronico = tipoEfectivoElectronico;
        this.monto = monto;
        this.observ = observ;
        this.anulado = anulado;
    }
    private String observ;
    private boolean anulado;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getIdAlquiler() {
        return idAlquiler;
    }

    public void setIdAlquiler(int idPago) {
        this.idAlquiler = idPago;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public LocalDate getFecEjecucion() {
        return fecEjecucion;
    }

    public void setFecEjecucion(LocalDate fecEjecucion) {
        this.fecEjecucion = fecEjecucion;
    }

    public String getTipoIngresoSalida() {
        return tipoIngresoSalida;
    }

    public void setTipoIngresoSalida(String tipoIngresoSalida) {
        this.tipoIngresoSalida = tipoIngresoSalida;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getTipoEfectivoElectronico() {
        return tipoEfectivoElectronico;
    }

    public void setTipoEfectivoElectronico(String tipoEfectivoElectronico) {
        this.tipoEfectivoElectronico = tipoEfectivoElectronico;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getObserv() {
        return observ;
    }

    public void setObserv(String observ) {
        this.observ = observ;
    }

    public boolean isAnulado() {
        return anulado;
    }

    public void setAnulado(boolean anulado) {
        this.anulado = anulado;
    }
}
