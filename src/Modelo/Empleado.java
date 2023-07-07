package Modelo;

import java.time.*;

public class Empleado {
    private int ID;
    private String usuario;
    private String contraseña;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private LocalDate fecNacimiento;
    private String tipo;
    private String genero;
    private String dni;
    private boolean activo;
    
    public Empleado() {
    }   
    
    public int getID()                                  {return ID;}
    public void setID(int ID)                           {this.ID = ID;}
    public LocalDate getFecNacimiento()                 {return fecNacimiento;}
    public void setFecNacimiento(LocalDate fecNacimiento) {this.fecNacimiento = fecNacimiento;}
    public int getIdEmpleado()                          {return ID;}
    public void setIdEmpleado(int idEmpleado)           {this.ID = idEmpleado;}
    public String getUsuario()                          {return usuario;}
    public void setUsuario(String usuario)              {this.usuario = usuario;}
    public String getContraseña()                       {return contraseña;}
    public void setContraseña(String contraseña)        {this.contraseña = contraseña;}
    public String getNombre()                           {return nombre;}
    public void setNombre(String nombre)                {this.nombre = nombre;}
    public String getApellido()                         {return apellido;}
    public void setApellido(String apellido)            {this.apellido = apellido;}
    public String getTelefono()                         {return telefono;}   
    public void setTelefono(String telefono)            {this.telefono = telefono;}
    public String getEmail()                            {return email;}
    public void setEmail(String email)                  {this.email = email;}
    public String getTipo()                             {return tipo;}
    public void setTipo(String tipo)                    {this.tipo = tipo;}
    public String getGenero()                           {return genero;}
    public void setGenero(String genero)                {this.genero = genero;}
    public String getDni()                              {return dni;}
    public void setDni(String dni)                      {this.dni = dni;}
    public boolean getActivo()                          {return activo;}
    public void setActivo(boolean activo)               {this.activo = activo;}
  
    
    public Object [] RegistroEmpleados(int num){
        Object[] fila = {ID,usuario,nombre,apellido,telefono,email,dni,fecNacimiento,tipo,genero,activo};
        return fila;
    }  
}
