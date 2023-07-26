package Modelo;

import java.time.LocalDate;

public class OrdenMantenimiento {
    
    private int ID;
    private LocalDate fecCreacion;
    private LocalDate fecCierre;
    private String estado;
    private String problema;
    private String reparacion;
    private double costoReparacion;
    
    private int id_herramienta;
    private Herramienta her;
    
    private int id_empleado;
    private Empleado emp;

    public OrdenMantenimiento() {
    }

    public OrdenMantenimiento(LocalDate fecCreacion, LocalDate fecCierre, String estado, String problema, String reparacion, double costoReparacion, int id_herramienta, Herramienta her, int id_empleado, Empleado emp) {
        this.fecCreacion = fecCreacion;
        this.fecCierre = fecCierre;
        this.estado = estado;
        this.problema = problema;
        this.reparacion = reparacion;
        this.costoReparacion = costoReparacion;
        this.id_herramienta = id_herramienta;
        this.her = her;
        this.id_empleado = id_empleado;
        this.emp = emp;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public LocalDate getFecCreacion() {
        return fecCreacion;
    }

    public void setFecCreacion(LocalDate fecCreacion) {
        this.fecCreacion = fecCreacion;
    }

    public LocalDate getFecCierre() {
        return fecCierre;
    }

    public void setFecCierre(LocalDate fecCierre) {
        this.fecCierre = fecCierre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    public String getReparacion() {
        return reparacion;
    }

    public void setReparacion(String reparacion) {
        this.reparacion = reparacion;
    }

    public double getCostoReparacion() {
        return costoReparacion;
    }

    public void setCostoReparacion(double costoReparacion) {
        this.costoReparacion = costoReparacion;
    }

    public int getId_herramienta() {
        return id_herramienta;
    }

    public void setId_herramienta(int id_herramienta) {
        this.id_herramienta = id_herramienta;
    }

    public Herramienta getHer() {
        return her;
    }

    public void setHer(Herramienta her) {
        this.her = her;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public Empleado getEmp() {
        return emp;
    }

    public void setEmp(Empleado emp) {
        this.emp = emp;
    }
    
    public Object [] RegistroOrdenesMantenimiento(int num){
        Object[] fila = {ID, fecCreacion, fecCierre, estado, costoReparacion, her.getNombre(), emp.getUsuario()};
        return fila;
    }

}