package Controlador;

import DAO.CRUDclientes;
import Formatos.Mensajes;
import Principal.Main;
import Vista_Empleado1.BuscarLibros_Venta;
import Vista_Empleado1.SeleccionarEmpresaOCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.plaf.synth.Region;

public class Controlador_SeleccionarCliente implements ActionListener{

    SeleccionarEmpresaOCliente vista;
    CRUDclientes crudc;
    BuscarLibros_Venta vista2;
    public Controlador_SeleccionarCliente(SeleccionarEmpresaOCliente SE, BuscarLibros_Venta BL) {
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
       if(e.getSource() == vista.jbtnConfirmarCliente){
           String nombre = null;
           String direccion = null;
               if(vista.jtpnclientes.getSelectedIndex() == 0){
                   if(vista.jtblClientes.getSelectedRow() < 0){
                       Mensajes.M1("Por favor seleccione un cliente");
                   } else {
                   int fila = vista.jtblClientes.getSelectedRow();
                   nombre = vista.jtblClientes.getValueAt(fila, 1).toString();
                   direccion = vista.jtblClientes.getValueAt(fila, 2).toString();
                   Main.VES.dispose();
                   }
               } else {
                   if(vista.jtblEmpresas.getSelectedRow() < 0) {
                       Mensajes.M1("Por favor seleccione un cliente");
                   } else {
                   int fila = vista.jtblEmpresas.getSelectedRow();
                   nombre = vista.jtblEmpresas.getValueAt(fila, 1).toString();
                   direccion = vista.jtblEmpresas.getValueAt(fila, 2).toString();
                   Main.VES.dispose();
                   }
               }
           vista2.jtxtClienteCom.setText(nombre);
           vista2.jtxtDirección.setText(direccion);
           
       }
    }
    
}
