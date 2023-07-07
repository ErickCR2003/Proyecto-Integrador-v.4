package Controlador;

import DAO.CRUDclientes;
import DAO.CRUDfacturas;
import Formatos.Mensajes;
import Modelo.Cliente;
import Vista_Empleado1.Admin_Historial_Facturas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador_Administrar_Factura_Cliente implements ActionListener{

    Admin_Historial_Facturas vista;
    CRUDclientes crudc;
    CRUDfacturas crudf;
    Cliente cli;

    public Controlador_Administrar_Factura_Cliente(Admin_Historial_Facturas AC) {
        
        vista = AC;
        vista.setVisible(true);
        vista.jbtnBuscarClienteDNI.addActionListener(this);
        vista.jbtnBuscarClienteRUC.addActionListener(this);
        crudf = new CRUDfacturas();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vista.jbtnBuscarClienteDNI){
            if (vista.jtxtBuscarClienteDNI.getText().length() == 0) {
                Mensajes.M1("El campo esta vacio");
            } else {
                String dni = vista.jtxtBuscarClienteDNI.getText();
                crudc = new CRUDclientes();
                cli = crudc.ConsultarRegistroClientes(dni);
                if (cli == null) {
                    Mensajes.M1("El DNI " + dni + " no existe en la tabla Clientes.");
                } else {
                    crudf = new CRUDfacturas();
                    crudc = new CRUDclientes();
                    dni = vista.jtxtBuscarClienteDNI.getText();
                    crudf.MostrarFacturasClienteDNI(vista.jtblHistorial_Libros_Cliente, dni);
                    vista.jtxaDatosCliente.setText("**************************************"
                            + "\nNombre:  " + cli.getNombrecompleto()
                            + "\nTelefono:  " + cli.getTelefono()
                            + "\nDireccion:  " + cli.getDireccion()
                            + "\nTipo Identificacion:  " + cli.getTipoIdentificacion()
                            + "\nN° Identificacion:  " + cli.getNumeroIdentificacion()
                            + "\nFecha Nacimiento:  " + cli.getFnacimiento());
                }
            }
        }
        
        if(e.getSource() == vista.jbtnBuscarClienteRUC){
            if (vista.jtxtBuscarEmpresaRUC.getText().length() == 0) {
                Mensajes.M1("El campo esta vacio");
            } else {
                String ruc = vista.jtxtBuscarEmpresaRUC.getText();
                crudc = new CRUDclientes();
                cli = crudc.ConsultarRegistroClientesEmpresa(ruc);
                if (cli == null) {
                    Mensajes.M1("El DNI " + ruc + " no existe en la tabla Clientes.");
                } else {
                    crudf = new CRUDfacturas();
                    crudc = new CRUDclientes();
                    ruc = vista.jtxtBuscarEmpresaRUC.getText();
                    crudf.MostrarFacturasEmpresaRUC(vista.jtblHistorial_Libros_Cliente_Empresa, ruc);
                    vista.jtxaDatosEmpresa.setText("**************************************"
                            + "\nNombre:  " + cli.getNombrecompleto()
                            + "\nTelefono:  " + cli.getTelefono()
                            + "\nDireccion:  " + cli.getDireccion()
                            + "\nTipo Identificacion:  " + cli.getTipoIdentificacion()
                            + "\nN° Identificacion:  " + cli.getNumeroIdentificacion()
                            + "\nFecha Creacion:  " + cli.getFnacimiento());
                }
            }
        }
    }
}