package Controlador;

import DAO.CRUDclientes;
import Formatos.Mensajes;
import Principal.Main;
import Vst.Alquiler.VstAlquiler;
import Vst.Cliente.VstCliente_Seleccionar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.plaf.synth.Region;

public class CtrlCliente_Seleccionar implements ActionListener {

    VstCliente_Seleccionar vista;
    CRUDclientes crudc;
    VstAlquiler vista2;

    public CtrlCliente_Seleccionar(VstCliente_Seleccionar SE, VstAlquiler BL) {
        vista = SE;
        vista2 = BL;
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        vista.jbtnConfirmarCliente.addActionListener(this);
        crudc = new CRUDclientes();
        crudc.MostrarPersonasEnTabla(vista.jtblClientes);
        crudc.MostrarEmpresasEnTabla(vista.jtblEmpresas);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.jbtnConfirmarCliente) {
            String nombre = null;
            if (vista.jtpnclientes.getSelectedIndex() == 0) {
                if (vista.jtblClientes.getSelectedRow() < 0) {
                    Mensajes.M1("Por favor seleccione un cliente");
                } else {
                    int fila = vista.jtblClientes.getSelectedRow();
                    nombre = vista.jtblClientes.getValueAt(fila, 1).toString();
                }
            } else {
                if (vista.jtblEmpresas.getSelectedRow() < 0) {
                    Mensajes.M1("Por favor seleccione un cliente");
                } else {
                    int fila = vista.jtblEmpresas.getSelectedRow();
                    nombre = vista.jtblEmpresas.getValueAt(fila, 1).toString();
                }
            }
            vista2.jtxtClienteCom.setText(nombre);
            vista.dispose();
        }
    }

}
