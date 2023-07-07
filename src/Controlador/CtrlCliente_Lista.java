
package Controlador;

import DAO.CRUDclientes;
import Formatos.Mensajes;
import Modelo.Cliente;
import Vst.Cliente.VstCliente_Lista;
import Vst.Cliente.VstCliente_Nvo;
import Vst.Cliente.VstCliente_Editar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrlCliente_Lista implements ActionListener{

    
    VstCliente_Lista vista;
    CRUDclientes crude;
    Cliente cli;
    
    public static Vst.Cliente.VstCliente_Nvo VCliente_Nvo;
    public static CtrlCliente_Nvo CCliente_Nvo;

    public static Vst.Cliente.VstCliente_Editar VCliente_Editar;
    public static CtrlCliente_Editar CCliente_Editar;
    
    
    public CtrlCliente_Lista(VstCliente_Lista ARCE) {
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
   
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vista.jbtnAgregarCliente){
            VCliente_Nvo = new VstCliente_Nvo();
            CCliente_Nvo =new CtrlCliente_Nvo(VCliente_Nvo, this);
        }        
       
        if (e.getSource() == vista.jbtnEditarRegistroCliente) {
            if (vista.jtxtBuscarClientePorDNI.getText().length() == 0) {
                Mensajes.M1("El campo esta vacio");

            } else {
                String dni = vista.jtxtBuscarClientePorDNI.getText();
                crude = new CRUDclientes();
                cli = crude.ConsultarRegistroClientes(dni);
                if (cli == null) {
                    Mensajes.M1("El DNI " + dni + " no existe en la tabla Cliente.");
                } else {

                    VCliente_Editar = new VstCliente_Editar();
                    CCliente_Editar = new CtrlCliente_Editar(VCliente_Editar, this);
                }
            }
        }        
       
        
     if (e.getSource() == vista.jbtnBuscarCliente) {
            if (vista.jtxtBuscarClientePorDNI.getText().length() == 0) {
                Mensajes.M1("El campo esta vacio");

            } else {
                String dni = vista.jtxtBuscarClientePorDNI.getText();
                crude = new CRUDclientes();
                cli = crude.ConsultarRegistroClientes(dni);
                if (cli == null) {
                    Mensajes.M1("El DNI " + dni + " no existe en la tabla Cliente.");
                } else {
                    Mensajes.M1("Nombre Completo:                " + cli.getNombrecompleto()
                            +   "<br>Telefono:            " + cli.getTelefono()
                            +   "<br>Direccion:          " + cli.getDireccion()
                            +   "<br>Fecha Nacimiento:           " + cli.getFecNacimiento()
                            +   "<br>Tipo de Identificacion:             " + cli.getRucDni()
                            +   "<br>Numero de Identificacion:   " + cli.getNumeroIdentificacion());
                }
            }
        }   
    }
}
