/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.CRUDclientes;
import Formatos.FormatoClientes;
import Formatos.Mensajes;
import Modelo.Cliente;
import Vst.Cliente.VstCliente_Editar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vst.Cliente.VstCliente_Lista;

/**
 *
 * @author User
 */
public class CtrlCliente_Editar implements ActionListener {

    VstCliente_Editar vista;
    VstCliente_Lista vista2;
    CRUDclientes crude;
    Cliente cli;
    CtrlCliente_Lista controladorAdminClienYEmpre;

    public CtrlCliente_Editar(VstCliente_Editar ERC, CtrlCliente_Lista CRCYE) {
        controladorAdminClienYEmpre = CRCYE;
        vista = ERC;
        vista2 = controladorAdminClienYEmpre.vista;
        vista.jbtnActualizar.addActionListener(this);
        crude = new CRUDclientes();
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);

        String dni = vista2.jtxtBuscarClientePorDNI.getText();
        cli = crude.ConsultarRegistroClientes(dni);

        vista.jtxtEditarNombreCompleto.setText(cli.getNombrecompleto());
        vista.jcbxEditarDniORuc.setSelectedItem(cli.getRucDni());
        vista.jdtcEditarFechaNacimiento.setDate(java.sql.Date.valueOf(cli.getFecNacimiento()));
        vista.jtxtEditarDireccion.setText(cli.getDireccion());
        vista.jtxtEditarNumerodeIdentificacion.setText(cli.getNumeroIdentificacion());
        vista.jtxtEditarTelefono.setText(cli.getTelefono());

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.jbtnActualizar) {
            String dni = vista2.jtxtBuscarClientePorDNI.getText();
            crude = new CRUDclientes();
            cli = FormatoClientes.EditarCliente(vista);
            crude.ActualizarRegistroEmp(dni, cli);
            controladorAdminClienYEmpre.ActualizarFormulario();
        } else {
            Mensajes.M1("Incorrecto");
        }
    }

}
