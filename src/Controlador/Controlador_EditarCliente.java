/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.CRUDclientes;
import Formatos.FormatoClientes;
import Formatos.Mensajes;
import Modelo.Cliente;
import Vista_Empleado1.EditarRegistroClientes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista_Empleado1.Admin_RegistroClientesYEmpresas;
/**
 *
 * @author User
 */
public class Controlador_EditarCliente  implements ActionListener {
    
    EditarRegistroClientes vista;
    Admin_RegistroClientesYEmpresas vista2;
    CRUDclientes crude;
    Cliente cli;
    Controlador_AdministrarRegistroClientesEmpresa controladorAdminClienYEmpre;
    
    
    
    public Controlador_EditarCliente(EditarRegistroClientes ERC, Controlador_AdministrarRegistroClientesEmpresa CRCYE) {
    controladorAdminClienYEmpre=CRCYE;
    vista=ERC;
    vista2=controladorAdminClienYEmpre.vista;
    vista.jbtnActualizar.addActionListener(this);
    crude = new CRUDclientes();
    vista.setVisible(true);
    vista.setLocationRelativeTo(null);
    
    String dni=vista2.jtxtBuscarClientePorDNI.getText();
    cli = crude.ConsultarRegistroClientes(dni);
    
    vista.jtxtEditarNombreCompleto.setText(cli.getNombrecompleto());
    vista.jcbxEditarDniORuc.setSelectedItem(cli.getTipoIdentificacion());
    vista.jdtcEditarFechaNacimiento.setDate(java.sql.Date.valueOf(cli.getFnacimiento()));
    vista.jtxtEditarDireccion.setText(cli.getDireccion());
    vista.jtxtEditarNumerodeIdentificacion.setText(cli.getNumeroIdentificacion());
    vista.jtxtEditarTelefono.setText(cli.getTelefono());
    
    }
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== vista.jbtnActualizar){
            String dni=vista2.jtxtBuscarClientePorDNI.getText();
            crude=new CRUDclientes();
            cli=FormatoClientes.EditarCliente(vista);
            crude.ActualizarRegistroEmp(dni, cli);
            controladorAdminClienYEmpre.ActualizarFormulario();
            controladorAdminClienYEmpre.ActuEmpresa();
        }else{
            Mensajes.M1("Incorrecto");
        }
    }
    
}
