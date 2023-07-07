package Controlador;

import Formatos.Mensajes;
import Principal.Main;
import Vista_Empleado1.Admin_Historial_Facturas;
import Vista_Empleado1.Admin_Libros;
import Vista_Empleado1.Admin_RegistroClientesYEmpresas;
import Vista_Empleado1.AdministrarDatos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controlador_Administrar_V_Empleado implements ActionListener {

    AdministrarDatos vista;

    public Controlador_Administrar_V_Empleado(AdministrarDatos AD) {
        vista = AD;
        vista.jbtnAdmClientes.addActionListener(this);
        vista.jbtnAdmLibros1.addActionListener(this);
        vista.jbtnVentaLibros.addActionListener(this);
        vista.jbtnCerrarSesion.addActionListener(this);
        vista.jbtnRegistroClientesEmpresa.addActionListener(this);
        Main.VL.dispose();
        
        Main.VAL = new Admin_Libros();
        Main.CAL = new Controlador_AdministrarLibros(Main.VAL);
        
        Main.VBLV = new Vista_Empleado1.BuscarLibros_Venta();
        Main.CVL = new Controlador_VentaLibros(Main.VBLV);
                    
        Main.VRCEM = new Admin_RegistroClientesYEmpresas();
        Main.CACEM = new Controlador_AdministrarRegistroClientesEmpresa(Main.VRCEM);
                    
        Main.VAC = new Admin_Historial_Facturas();
        Main.CAC = new Controlador_Administrar_Factura_Cliente(Main.VAC);
        vista.jpanelContenedorMenuEmpleados.add(Main.VAC);
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.jbtnAdmLibros1) {
            if (Main.VAC.isVisible()) {
                try {
                    Main.VAC.setClosed(true);
                    Main.VAL = new Admin_Libros();
                    Main.CAL = new Controlador_AdministrarLibros(Main.VAL);
                    vista.jpanelContenedorMenuEmpleados.add(Main.VAL);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(Controlador_Administrar_V_Empleado.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (Main.VBLV.isVisible()) {
                try {
                    Main.VBLV.setClosed(true);
                    Main.VAL = new Admin_Libros();
                    Main.CAL = new Controlador_AdministrarLibros(Main.VAL);
                    vista.jpanelContenedorMenuEmpleados.add(Main.VAL);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(Controlador_Administrar_V_Empleado.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (Main.VRCEM.isVisible()) {

                try {
                    Main.VRCEM.setClosed(true);
                    Main.VAL = new Admin_Libros();
                    Main.CAL = new Controlador_AdministrarLibros(Main.VAL);
                    vista.jpanelContenedorMenuEmpleados.add(Main.VAL);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(Controlador_Administrar_V_Empleado.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if (e.getSource() == vista.jbtnVentaLibros) {
            if (Main.VAC.isVisible()) {
                try {
                    Main.VAC.setClosed(true);
                    Main.VBLV = new Vista_Empleado1.BuscarLibros_Venta();
                    Main.CVL = new Controlador_VentaLibros(Main.VBLV);
                    vista.jpanelContenedorMenuEmpleados.add(Main.VBLV);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(Controlador_Administrar_V_Empleado.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (Main.VAL.isVisible()) {
                try {
                    Main.VAL.setClosed(true);
                    Main.VBLV = new Vista_Empleado1.BuscarLibros_Venta();
                    Main.CVL = new Controlador_VentaLibros(Main.VBLV);
                    vista.jpanelContenedorMenuEmpleados.add(Main.VBLV);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(Controlador_Administrar_V_Empleado.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else if (Main.VRCEM.isVisible()) {
                try {
                    Main.VRCEM.setClosed(true);
                    Main.VBLV = new Vista_Empleado1.BuscarLibros_Venta();
                    Main.CVL = new Controlador_VentaLibros(Main.VBLV);
                    vista.jpanelContenedorMenuEmpleados.add(Main.VBLV);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(Controlador_Administrar_V_Empleado.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
        if (e.getSource() == vista.jbtnAdmClientes) {
            if (Main.VAL.isVisible()) {
                try {
                    Main.VAL.setClosed(true);
                    Main.VAC = new Admin_Historial_Facturas();
                    Main.CAC = new Controlador_Administrar_Factura_Cliente(Main.VAC);
                    vista.jpanelContenedorMenuEmpleados.add(Main.VAC);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(Controlador_Administrar_V_Empleado.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (Main.VBLV.isVisible()) {
                try {
                    Main.VBLV.setClosed(true);
                    Main.VAC = new Admin_Historial_Facturas();
                    Main.CAC = new Controlador_Administrar_Factura_Cliente(Main.VAC);
                    vista.jpanelContenedorMenuEmpleados.add(Main.VAC);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(Controlador_Administrar_V_Empleado.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (Main.VRCEM.isVisible()) {
                try {
                    Main.VRCEM.setClosed(true);
                    Main.VAC = new Admin_Historial_Facturas();
                    Main.CAC = new Controlador_Administrar_Factura_Cliente(Main.VAC);
                    vista.jpanelContenedorMenuEmpleados.add(Main.VAC);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(Controlador_Administrar_V_Empleado.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if (e.getSource() == vista.jbtnCerrarSesion) {
            int respuesta = Mensajes.M3("Confirmar!!!!", "¿Confirmas que deseas cerrar sesión?"); // si la respuesta es OK representa 0
            if (respuesta == 0) {
                Main.VAD.dispose();
                Main.VL = new Vista1.LOGIN();
                Main.CL = new Controlador_Login(Main.VL);
            }
        }

        if (e.getSource() == vista.jbtnRegistroClientesEmpresa) {
            if (Main.VAC.isVisible()) {
                try {
                    Main.VAC.setClosed(true);
                    Main.VRCEM = new Admin_RegistroClientesYEmpresas();
                    Main.CACEM = new Controlador_AdministrarRegistroClientesEmpresa(Main.VRCEM);
                    vista.jpanelContenedorMenuEmpleados.add(Main.VRCEM);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(Controlador_Administrar_V_Empleado.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (Main.VAL.isVisible()) {
                try {
                    Main.VAL.setClosed(true);
                    Main.VRCEM = new Admin_RegistroClientesYEmpresas();
                    Main.CACEM = new Controlador_AdministrarRegistroClientesEmpresa(Main.VRCEM);
                    vista.jpanelContenedorMenuEmpleados.add(Main.VRCEM);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(Controlador_Administrar_V_Empleado.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (Main.VBLV.isVisible()) {
                try {
                    Main.VBLV.setClosed(true);
                    Main.VRCEM = new Admin_RegistroClientesYEmpresas();
                    Main.CACEM = new Controlador_AdministrarRegistroClientesEmpresa(Main.VRCEM);
                    vista.jpanelContenedorMenuEmpleados.add(Main.VRCEM);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(Controlador_Administrar_V_Empleado.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
