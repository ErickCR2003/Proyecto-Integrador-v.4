
package Controlador;

import DAO.CRUDclientes;
import DAO.CRUDempleados;
import Formatos.Mensajes;
import Modelo.Cliente;
import Principal.Main;
import Vista1.EditarEmpleados;
import Vista_Empleado1.Admin_RegistroClientesYEmpresas;
import Vista_Empleado1.AñadirRegistroClientes;
import Vista_Empleado1.AñadirRegistroEmpresas;
import Vista_Empleado1.EditarRegistroClientes;
import Vista_Empleado1.EditarRegistroEmpresas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador_AdministrarRegistroClientesEmpresa implements ActionListener{

    
    Admin_RegistroClientesYEmpresas vista;
    CRUDclientes crude;
    Cliente cli;
    public Controlador_AdministrarRegistroClientesEmpresa(Admin_RegistroClientesYEmpresas ARCE) {
        vista=ARCE;
        crude = new CRUDclientes();
        vista.jbtnAgregarCliente.addActionListener(this);
        vista.jbtnBuscarCliente.addActionListener(this);
        vista.jbtnBuscarClienteEmpresa.addActionListener(this);
        vista.jbtnEditarRegistroCliente.addActionListener(this);
        vista.jbtnAgregarRegistroEmpresa.addActionListener(this);
        vista.jbtnEditarRegistroEmpresa.addActionListener(this);
        crude.MostrarClientesEnTabla(vista.jtblRegistroClientes, vista.jlblRegistros_Clientes);
        crude.MostrarEmpresasEnTabla(vista.jtblRegistroEmpresa, vista.jlblRegistros_Empresas);
        ARCE.setVisible(true);
        
    }
    
    public void ActualizarFormulario(){
        crude = new CRUDclientes();
        crude.MostrarClientesEnTabla(vista.jtblRegistroClientes, vista.jlblRegistros_Clientes);
        vista.setVisible(true);
        
    }
    
     public void ActualizarForm(){
        crude = new CRUDclientes();
        crude.MostrarClientesEnTabla(vista.jtblRegistroClientes, vista.jlblRegistros_Clientes);
       
        
    }
    
    public void ActualizarFormularioEmpresa(){
        crude = new CRUDclientes();
        crude.MostrarEmpresasEnTabla(vista.jtblRegistroEmpresa, vista.jlblRegistros_Empresas);
        vista.setVisible(true);
        
    }
    
     public void ActuEmpresa(){
        crude = new CRUDclientes();
        crude.MostrarEmpresasEnTabla(vista.jtblRegistroEmpresa, vista.jlblRegistros_Empresas);
        
        
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vista.jbtnAgregarCliente){
            Main.AÑRC=new AñadirRegistroClientes();
            Main.CARC=new Controlador_AgregarRegistroClientes(Main.AÑRC,this);
        }
        
        if(e.getSource() == vista.jbtnAgregarRegistroEmpresa){
            Main.AREM=new AñadirRegistroEmpresas();
            Main.CAEMP=new Controlador_AgregarEmpresa(Main.AREM,this);
        }
        if (e.getSource() == vista.jbtnEditarRegistroCliente) {
            if (vista.jtxtBuscarClientePorDNI.getText().length() == 0) {
                Mensajes.M1("El campo esta vacio");

            } else {
                String dni = vista.jtxtBuscarClientePorDNI.getText();
                crude = new CRUDclientes();
                cli = crude.ConsultarRegistroClientes(dni);
                if (cli == null) {
                    Mensajes.M1("El DNI " + dni + " no existe en la tabla Empleados.");
                } else {

                    Main.ERCL=new EditarRegistroClientes();
                    Main.CEDCL=new Controlador_EditarCliente(Main.ERCL, this);
                }
            }
        }
         if (e.getSource() == vista.jbtnEditarRegistroEmpresa) {
            if (vista.jtxtBuscarClienteEmpresaPorRuc.getText().length() == 0) {
                Mensajes.M1("El campo esta vacio");

            } else {
                String ruc = vista.jtxtBuscarClienteEmpresaPorRuc.getText();
                crude = new CRUDclientes();
                cli = crude.ConsultarRegistroClientesEmpresa(ruc);
                if (cli == null) {
                    Mensajes.M1("El RUC " + ruc + " no existe en la tabla Empleados.");
                } else {

                    Main.EREMPRE=new EditarRegistroEmpresas();
                    Main.CEEMPR=new Controlador_EditarEmpresa(Main.EREMPRE, this);
                }
            }
        }
        
     if (e.getSource() == vista.jbtnBuscarCliente) {
            if (vista.jtxtBuscarClientePorDNI.getText().length() == 0) {
                Mensajes.M1("El campo esta vacio");

            } else {
                String dni = vista.jtxtBuscarClientePorDNI.getText().toString();
                crude = new CRUDclientes();
                cli = crude.ConsultarRegistroClientes(dni);
                if (cli == null) {
                    Mensajes.M1("El DNI " + dni + " no existe en la tabla Empleados.");
                } else {
                    Mensajes.M1("Nombre Completo:                " + cli.getNombrecompleto()
                            +   "<br>Telefono:            " + cli.getTelefono()
                            +   "<br>Direccion:          " + cli.getDireccion()
                            +   "<br>Fecha Nacimiento:           " + cli.getFnacimiento()
                            +   "<br>Tipo de Identificacion:             " + cli.getTipoIdentificacion()
                            +   "<br>Numero de Identificacion:   " + cli.getNumeroIdentificacion());
                           
                    
                }
            }
        }
     
      if (e.getSource() == vista.jbtnBuscarClienteEmpresa) {
            if (vista.jtxtBuscarClienteEmpresaPorRuc.getText().length() == 0) {
                Mensajes.M1("El campo esta vacio");

            } else {
                String ruc = vista.jtxtBuscarClienteEmpresaPorRuc.getText();
                crude = new CRUDclientes();
                cli = crude.ConsultarRegistroClientesEmpresa(ruc);
                if (cli == null) {
                    Mensajes.M1("El RUC " + ruc + " no existe en la tabla Empleados.");
                } else {
                    Mensajes.M1("Nombre Completo:                " + cli.getNombrecompleto()
                            +   "<br>Telefono:            " + cli.getTelefono()
                            +   "<br>Direccion:          " + cli.getDireccion()
                            +   "<br>Fecha Nacimiento:           " + cli.getFnacimiento()
                            +   "<br>Tipo de Identificacion:             " + cli.getTipoIdentificacion()
                            +   "<br>Numero de Identificacion:   " + cli.getNumeroIdentificacion());
                           
                    
                }
            }
        }         
        
        
    }
    
}
