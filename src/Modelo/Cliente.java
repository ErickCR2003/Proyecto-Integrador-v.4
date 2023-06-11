
package Modelo;

import java.time.LocalDate;

public class Cliente {
    private int ID;
    private String nombrecompleto;
    private String rucDni;
    private String numeroIdentificacion;
    private String telefono;
    private String direccion;
    private LocalDate fecNacimiento;

    public Cliente() {
    }

    public int getID() {return ID;}
    public void setID(int ID) {this.ID = ID;}
    public String getNombrecompleto() { return nombrecompleto;}
    public void setNombrecompleto(String nombrecompleto) {this.nombrecompleto = nombrecompleto; }
    public String getRucDni() {return rucDni;}
    public void setRucDni(String tipoIdentificacion) {this.rucDni = tipoIdentificacion;}
    public String getNumeroIdentificacion() { return numeroIdentificacion; }
    public void setNumeroIdentificacion(String numeroIdentificacion) {this.numeroIdentificacion = numeroIdentificacion;}
    public String getTelefono() {return telefono;}
    public void setTelefono(String telefono) {this.telefono = telefono;}
    public String getDireccion() {return direccion;}
    public void setDireccion(String direccion) {this.direccion = direccion;}
    public LocalDate getFecNacimiento() {return fecNacimiento;}
    public void setFecNacimiento(LocalDate fnacimiento) { this.fecNacimiento = fnacimiento;}
    
    public Object [] RegistroClientes(int num){
        Object[] fila = {ID,nombrecompleto,telefono,direccion,fecNacimiento,rucDni,numeroIdentificacion};
        return fila;
    }
    
    public Object [] RegistroPersonasYEmpresasTabla(){
        Object[] fila = {ID,nombrecompleto,direccion,numeroIdentificacion};
        return fila;
    }
}
