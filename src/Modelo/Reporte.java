/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author julis
 */
public class Reporte {
    private int codAlquiler;
    private Date fechaCreacion;
    private int diasAlquiler;
    private Date fechaSalida;
    private Date fechaRetorno;  
    private String nombreCliente;
    private Double importeTotal;
    private String estado;

    public int getCodAlquiler() {
        return codAlquiler;
    }

    public void setCodAlquiler(int codAlquiler) {
        this.codAlquiler = codAlquiler;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }   

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public Double getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(Double importeTotal) {
        this.importeTotal = importeTotal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public Object [] RegistroReporte(int num){
        Object[] fila = {codAlquiler,fechaCreacion,diasAlquiler,fechaSalida,fechaRetorno,nombreCliente,importeTotal,estado};
        return fila;
    } 

    public int getDiasAlquiler() {
        return diasAlquiler;
    }

    public void setDiasAlquiler(int diasAlquiler) {
        this.diasAlquiler = diasAlquiler;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Date getFechaRetorno() {
        return fechaRetorno;
    }

    public void setFechaRetorno(Date fechaRetorno) {
        this.fechaRetorno = fechaRetorno;
    }
    
    
    
}
