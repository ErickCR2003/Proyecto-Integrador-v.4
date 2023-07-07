/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.CRUDclientes;
import Formatos.FormatoClientes;
import Formatos.Mensajes;
import Modelo.Cliente;
import Vista_Empleado1.Admin_RegistroClientesYEmpresas;
import Vista_Empleado1.EditarRegistroEmpresas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author User
 */
public class Controlador_EditarEmpresa implements ActionListener {
    EditarRegistroEmpresas vista;
    Admin_RegistroClientesYEmpresas vista2;
    CRUDclientes crude;
    Cliente cli;
    Controlador_AdministrarRegistroClientesEmpresa controladorAdminClienYEmpre;

    public Controlador_EditarEmpresa(EditarRegistroEmpresas ED, Controlador_AdministrarRegistroClientesEmpresa CARE) {
        controladorAdminClienYEmpre=CARE;
        vista=ED;
        vista2=controladorAdminClienYEmpre.vista;
        vista.jbtnActualizar.addActionListener(this);
        crude = new CRUDclientes();
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        
        String ruc=vista2.jtxtBuscarClienteEmpresaPorRuc.getText();
        cli = crude.ConsultarRegistroClientesEmpresa(ruc);
    
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
            String ruc=vista2.jtxtBuscarClienteEmpresaPorRuc.getText();
            crude=new CRUDclientes();
            cli=FormatoClientes.EditarEmpresa(vista);
            crude.ActualizarRegistroEmpresa(ruc, cli);
            controladorAdminClienYEmpre.ActualizarFormularioEmpresa();
            controladorAdminClienYEmpre.ActualizarForm();
            
            
        }else{
           Mensajes.M1("Incorrecto"); 
        }
    }
    
}
