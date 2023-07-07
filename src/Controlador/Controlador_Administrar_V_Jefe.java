package Controlador;

import Formatos.Mensajes;
import static Principal.Main.*;
import Vista_Jefe1.*;
import Principal.Main;
import Vista_Jefe1.AdministrarSuprema;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controlador_Administrar_V_Jefe implements ActionListener {

    AdministrarSuprema vistaAdminSuprema;

    public Controlador_Administrar_V_Jefe(AdministrarSuprema ADS) {

        vistaAdminSuprema = ADS;

        vistaAdminSuprema.jbtnAdministrarEmpleados.addActionListener(this);
        vistaAdminSuprema.jbtnAdministrarAutores.addActionListener(this);
        vistaAdminSuprema.jbtnAdministrarEditoriales.addActionListener(this);
        vistaAdminSuprema.jbtnAdministrarTipoDeLibro.addActionListener(this);
        vistaAdminSuprema.jbtnAdministrarReporte.addActionListener(this);
        vistaAdminSuprema.jbtnCerrarSesion.addActionListener(this);

        Main.VAE = new Administrar_Empleados();
        Main.CAE = new Controlador_Administrar_Empleados(Main.VAE);

        Main.VAU = new Vista_Jefe1.Administrar_Autores();
        Main.CAU = new Controlador.Controlador_Administrar_Autores(VAU);

        Main.VADE = new Vista_Jefe1.Administrar_Editorial();
        Main.CADE = new Controlador.Controlador_Administrar_Editorial(VADE);

        Main.VATL = new Vista_Jefe1.Administrar_Tipo_Libro();
        Main.CATL = new Controlador.Controlador_Administrar_Tipo_Libro(VATL);

        Main.VAR = new Vista_Jefe1.Administrar_Reporte();
        Main.CAR = new Controlador.Controlador_Administrar_Reporte(VAR);

        vistaAdminSuprema.jdesktoppnlContenedor.add(Main.VAE);
        ADS.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaAdminSuprema.jbtnAdministrarEmpleados) {
            if (Main.VAU.isVisible()) {
                try {
                    Main.VAU.setClosed(true);
                    VAE = new Vista_Jefe1.Administrar_Empleados();
                    CAE = new Controlador.Controlador_Administrar_Empleados(VAE);
                    vistaAdminSuprema.jdesktoppnlContenedor.add(Main.VAE);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(Controlador_Administrar_V_Jefe.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if (Main.VADE.isVisible()) {
                try {
                    Main.VADE.setClosed(true);
                    VAE = new Vista_Jefe1.Administrar_Empleados();
                    CAE = new Controlador.Controlador_Administrar_Empleados(VAE);
                    vistaAdminSuprema.jdesktoppnlContenedor.add(Main.VAE);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(Controlador_Administrar_V_Jefe.class.getName()).log(Level.SEVERE, null, ex);
                }

            }else if (Main.VAR.isVisible()) {
                try {
                    Main.VAR.setClosed(true);
                    VAE = new Vista_Jefe1.Administrar_Empleados();
                    CAE = new Controlador.Controlador_Administrar_Empleados(VAE);
                    vistaAdminSuprema.jdesktoppnlContenedor.add(Main.VAE);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(Controlador_Administrar_V_Jefe.class.getName()).log(Level.SEVERE, null, ex);
                }

            }else if (Main.VATL.isVisible()) {
                try {
                    Main.VATL.setClosed(true);
                    VAE = new Vista_Jefe1.Administrar_Empleados();
                    CAE = new Controlador.Controlador_Administrar_Empleados(VAE);
                    vistaAdminSuprema.jdesktoppnlContenedor.add(Main.VAE);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(Controlador_Administrar_V_Jefe.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }

        if (e.getSource() == vistaAdminSuprema.jbtnAdministrarAutores) {
            if (Main.VAE.isVisible()) {
                try {
                    Main.VAE.setClosed(true);
                    VAU = new Vista_Jefe1.Administrar_Autores();
                    CAU = new Controlador.Controlador_Administrar_Autores(VAU);
                    vistaAdminSuprema.jdesktoppnlContenedor.add(Main.VAU);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(Controlador_Administrar_V_Jefe.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else if (Main.VADE.isVisible()) {
                try {
                    Main.VADE.setClosed(true);
                    VAU = new Vista_Jefe1.Administrar_Autores();
                    CAU = new Controlador.Controlador_Administrar_Autores(VAU);
                    vistaAdminSuprema.jdesktoppnlContenedor.add(Main.VAU);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(Controlador_Administrar_V_Jefe.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else if (Main.VAR.isVisible()) {
                try {
                    Main.VAR.setClosed(true);
                    VAU = new Vista_Jefe1.Administrar_Autores();
                    CAU = new Controlador.Controlador_Administrar_Autores(VAU);
                    vistaAdminSuprema.jdesktoppnlContenedor.add(Main.VAU);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(Controlador_Administrar_V_Jefe.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else if (Main.VATL.isVisible()) {
                try {
                    Main.VATL.setClosed(true);
                    VAU = new Vista_Jefe1.Administrar_Autores();
                    CAU = new Controlador.Controlador_Administrar_Autores(VAU);
                    vistaAdminSuprema.jdesktoppnlContenedor.add(Main.VAU);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(Controlador_Administrar_V_Jefe.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if (e.getSource() == vistaAdminSuprema.jbtnAdministrarEditoriales) {
            if (Main.VAE.isVisible()) {
                try {
                    Main.VAE.setClosed(true);
                    VADE = new Vista_Jefe1.Administrar_Editorial();
                    CADE = new Controlador.Controlador_Administrar_Editorial(VADE);
                    vistaAdminSuprema.jdesktoppnlContenedor.add(Main.VADE);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(Controlador_Administrar_V_Jefe.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else if (Main.VAU.isVisible()) {
                try {
                    Main.VAU.setClosed(true);
                    VADE = new Vista_Jefe1.Administrar_Editorial();
                    CADE = new Controlador.Controlador_Administrar_Editorial(VADE);
                    vistaAdminSuprema.jdesktoppnlContenedor.add(Main.VADE);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(Controlador_Administrar_V_Jefe.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else if (Main.VAR.isVisible()) {
                try {
                    Main.VAR.setClosed(true);
                    VADE = new Vista_Jefe1.Administrar_Editorial();
                    CADE = new Controlador.Controlador_Administrar_Editorial(VADE);
                    vistaAdminSuprema.jdesktoppnlContenedor.add(Main.VADE);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(Controlador_Administrar_V_Jefe.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else if (Main.VATL.isVisible()) {
                try {
                    Main.VATL.setClosed(true);
                    VADE = new Vista_Jefe1.Administrar_Editorial();
                    CADE = new Controlador.Controlador_Administrar_Editorial(VADE);
                    vistaAdminSuprema.jdesktoppnlContenedor.add(Main.VADE);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(Controlador_Administrar_V_Jefe.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
        if (e.getSource() == vistaAdminSuprema.jbtnAdministrarTipoDeLibro) {
            if (Main.VAE.isVisible()) {
                try {
                    Main.VAE.setClosed(true);
                    VATL = new Vista_Jefe1.Administrar_Tipo_Libro();
                    CATL = new Controlador.Controlador_Administrar_Tipo_Libro(VATL);
                    vistaAdminSuprema.jdesktoppnlContenedor.add(Main.VATL);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(Controlador_Administrar_V_Jefe.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else if (Main.VAU.isVisible()) {
                try {
                    Main.VAU.setClosed(true);
                    VATL = new Vista_Jefe1.Administrar_Tipo_Libro();
                    CATL = new Controlador.Controlador_Administrar_Tipo_Libro(VATL);
                    vistaAdminSuprema.jdesktoppnlContenedor.add(Main.VATL);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(Controlador_Administrar_V_Jefe.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else if (Main.VADE.isVisible()) {
                try {
                    Main.VADE.setClosed(true);
                    VATL = new Vista_Jefe1.Administrar_Tipo_Libro();
                    CATL = new Controlador.Controlador_Administrar_Tipo_Libro(VATL);
                    vistaAdminSuprema.jdesktoppnlContenedor.add(Main.VATL);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(Controlador_Administrar_V_Jefe.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else if (Main.VAR.isVisible()) {
                try {
                    Main.VAR.setClosed(true);
                    VATL = new Vista_Jefe1.Administrar_Tipo_Libro();
                    CATL = new Controlador.Controlador_Administrar_Tipo_Libro(VATL);
                    vistaAdminSuprema.jdesktoppnlContenedor.add(Main.VATL);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(Controlador_Administrar_V_Jefe.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }

        if (e.getSource() == vistaAdminSuprema.jbtnAdministrarReporte) {
            if (Main.VAE.isVisible()) {
                try {
                    Main.VAE.setClosed(true);
                    VAR = new Vista_Jefe1.Administrar_Reporte();
                    CAR = new Controlador.Controlador_Administrar_Reporte(VAR);
                    vistaAdminSuprema.jdesktoppnlContenedor.add(Main.VAR);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(Controlador_Administrar_V_Jefe.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else if (Main.VAU.isVisible()) {
                try {
                    Main.VAU.setClosed(true);
                    VAR = new Vista_Jefe1.Administrar_Reporte();
                    CAR = new Controlador.Controlador_Administrar_Reporte(VAR);
                    vistaAdminSuprema.jdesktoppnlContenedor.add(Main.VAR);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(Controlador_Administrar_V_Jefe.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else if (Main.VADE.isVisible()) {
                try {
                    Main.VADE.setClosed(true);
                    VAR = new Vista_Jefe1.Administrar_Reporte();
                    CAR = new Controlador.Controlador_Administrar_Reporte(VAR);
                    vistaAdminSuprema.jdesktoppnlContenedor.add(Main.VAR);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(Controlador_Administrar_V_Jefe.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else if (Main.VATL.isVisible()) {
                try {
                    Main.VATL.setClosed(true);
                    VAR = new Vista_Jefe1.Administrar_Reporte();
                    CAR = new Controlador.Controlador_Administrar_Reporte(VAR);
                    vistaAdminSuprema.jdesktoppnlContenedor.add(Main.VAR);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(Controlador_Administrar_V_Jefe.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if (e.getSource() == vistaAdminSuprema.jbtnCerrarSesion) {
            int respuesta = Mensajes.M3("Confirmar!!!!", "¿Confirmas que deseas cerrar sesión?"); // si la respuesta es OK representa 0
            if (respuesta == 0) {
                Main.VAS.dispose();
                VL = new Vista1.LOGIN();
                CL = new Controlador_Login(VL);
            }
        }
    }
}
