package Modelo;

import java.time.LocalDate;

public class Alquiler {

    private int ID;
    private LocalDate fecHoraCreacion;
    private int diasAlquiler;
    private LocalDate fecHoraSalida;
    private LocalDate fecHoraRetorno;
    private double imp_Alquiler;
    private double imp_Garantia;
    private double imp_Traslado;
    private double imp_Total;
    private String estado;
    private boolean conTraslado;
    private String direccionEntrega;
    private String SerieFacBol;
    private int NroFacBol;
    private String serieCorrFacBol;
    
    private int idEmpleado;
    private Empleado empleado;
    
    private Cliente cliente;
    private int idCliente;

    public Alquiler() {
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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

    public int getDiasAlquiler() {
        return diasAlquiler;
    }

    public void setDiasAlquiler(int diasAlquiler) {
        this.diasAlquiler = diasAlquiler;
    }

    public LocalDate getFecHoraSalida() {
        return fecHoraSalida;
    }

    public void setFecHoraSalida(LocalDate fecHoraSalida) {
        this.fecHoraSalida = fecHoraSalida;
    }

    public LocalDate getFecHoraRetorno() {
        return fecHoraRetorno;
    }

    public void setFecHoraRetorno(LocalDate fecHoraRetorno) {
        this.fecHoraRetorno = fecHoraRetorno;
    }

    public double getImp_Total() {
        return imp_Total;
    }

    public void setImp_Total(double imp_Total) {
        this.imp_Total = imp_Total;
    }

    public double getImp_Garantia() {
        return imp_Garantia;
    }

    public void setImp_Garantia(double imp_Garantia) {
        this.imp_Garantia = imp_Garantia;
    }

    public double getImp_Traslado() {
        return imp_Traslado;
    }

    public void setImp_Traslado(double imp_Traslado) {
        this.imp_Traslado = imp_Traslado;
    }
    
    public double getImp_Alquiler() {
        return imp_Alquiler;
    }

    public void setImp_Alquiler(double imp_Alquiler) {
        this.imp_Alquiler = imp_Alquiler;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean isConTraslado() {
        return conTraslado;
    }

    public void setConTraslado(boolean conTraslado) {
        this.conTraslado = conTraslado;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public String getSerieFacBol() {
        return SerieFacBol;
    }

    public void setSerieFacBol(String SerieFacBol) {
        this.SerieFacBol = SerieFacBol;
    }

    public int getNroFacBol() {
        return NroFacBol;
    }

    public void setNroFacBol(int NroFacBol) {
        this.NroFacBol = NroFacBol;
    }

    public String getSerieCorrFacBol() {
        return serieCorrFacBol;
    }

    public void setSerieCorrFacBol(String serieCorrFacBol) {
        this.serieCorrFacBol = serieCorrFacBol;
    }

//    public Object [] RegistroAlquiler(){
//        Object[] fila = {ID,  };
//        return fila;
//    }
}
