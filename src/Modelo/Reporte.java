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
    private int codHerramienta;
    private String nombreHerramienta;
    private Double precioAlquiler;
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

    public int getCodHerramienta() {
        return codHerramienta;
    }

    public void setCodHerramienta(int codHerramienta) {
        this.codHerramienta = codHerramienta;
    }

    public String getNombreHerramienta() {
        return nombreHerramienta;
    }

    public void setNombreHerramienta(String nombreHerramienta) {
        this.nombreHerramienta = nombreHerramienta;
    }

    public Double getPrecioAlquiler() {
        return precioAlquiler;
    }

    public void setPrecioAlquiler(Double precioAlquiler) {
        this.precioAlquiler = precioAlquiler;
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
        Object[] fila = {codAlquiler,fechaCreacion,codHerramienta,nombreHerramienta,precioAlquiler,nombreCliente,importeTotal,estado};
        return fila;
    } 
    
}
