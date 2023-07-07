package Controlador;

import DAO.CRUDempleados;
import Formatos.Mensajes;
import Modelo.Empleado;
import Principal.Main;
import Vista1.LOGIN;
import Vista_Empleado1.AdministrarDatos;
import Vista_Jefe1.AdministrarSuprema;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;

public class Controlador_Login implements ActionListener {

    LOGIN vista;
    CRUDempleados crude;

    public Controlador_Login(LOGIN lg) {

        vista = lg;
        crude = new CRUDempleados();
        vista.jbtnIniciarSesion.addActionListener(this);
        vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.jbtnIniciarSesion) {
            String busqueda = crude.ConsultarUsuario(vista.jtxtUsuario.getText(), vista.jpswContraseña.getText());
            String nombreUsuario = crude.ConsultarNombreusuario(vista.jtxtUsuario.getText());
            String contraseñaUsuario = crude.ConsultarContraseñaDelUsuario(vista.jpswContraseña.getText());
            LocalDate fechaactual = LocalDate.now();
            LocalTime horaactual = LocalTime.now();

            if (crude.ConsultarNumeroIntentos(vista.jtxtUsuario.getText()) == 0) {
                LocalDate fecha = LocalDate.parse(crude.ConsultarFechaSuspencion(vista.jtxtUsuario.getText()));
                LocalTime hora = LocalTime.parse(crude.ConsultarHoraSuspendida(vista.jtxtUsuario.getText()));
                if (fecha.compareTo(fechaactual) <= 0 && hora.compareTo(horaactual) <= 0) {
                    crude.ActualizarIntentosA3(vista.jtxtUsuario.getText());
                }
            }
            if (busqueda.equals("Usuario Encontrado ADMINISTRADOR ACTIVO")) {
                LocalDate fecha = LocalDate.parse(crude.ConsultarFechaSuspencion(vista.jtxtUsuario.getText()));
                LocalTime hora = LocalTime.parse(crude.ConsultarHoraSuspendida(vista.jtxtUsuario.getText()));
                if (crude.ConsultarNumeroIntentos(vista.jtxtUsuario.getText()) <= 0) {
                    Mensajes.M1("Su cuenta fue suspendido hasta FECHA:" + fecha
                            + " HORA: " + hora);
                } else {
                    crude.ActualizarIntentosA3(vista.jtxtUsuario.getText());
                    Main.VAS = new AdministrarSuprema();
                    Main.CAS = new Controlador_Administrar_V_Jefe(Main.VAS);
                    Main.VL.dispose();
                }

            } else if (busqueda.equals("Usuario Encontrado EMPLEADO ACTIVO")) {
                LocalDate fecha = LocalDate.parse(crude.ConsultarFechaSuspencion(vista.jtxtUsuario.getText()));
                LocalTime hora = LocalTime.parse(crude.ConsultarHoraSuspendida(vista.jtxtUsuario.getText()));
                if (crude.ConsultarNumeroIntentos(vista.jtxtUsuario.getText()) <= 0) {
                    Mensajes.M1("Su cuenta fue suspendido hasta FECHA:" + fecha
                            + " HORA: " + hora);
                } else {
                    crude.ActualizarIntentosA3(vista.jtxtUsuario.getText());
                    Main.VAD = new AdministrarDatos();
                    Main.CVE = new Controlador_Administrar_V_Empleado(Main.VAD);
                    Main.VL.dispose();
                }
            } else if (crude.ConsultarNumeroIntentos(vista.jtxtUsuario.getText()) == 0) {
                LocalDate fecha = LocalDate.parse(crude.ConsultarFechaSuspencion(vista.jtxtUsuario.getText()));
                LocalTime hora = LocalTime.parse(crude.ConsultarHoraSuspendida(vista.jtxtUsuario.getText()));
                Mensajes.M1("Su cuenta fue suspendido hasta FECHA:" + fecha
                        + " HORA: " + hora);

            } else if (nombreUsuario.equals("Usuario Encontrado")) {
                if (contraseñaUsuario.equals("No encontrado")) {
                    crude.ActualizarIntentos(vista.jtxtUsuario.getText());
                    if (crude.ConsultarNumeroIntentos(vista.jtxtUsuario.getText()) > 0) {
                        Mensajes.M1("Le quedan " + crude.ConsultarNumeroIntentos(vista.jtxtUsuario.getText()) + " intento(s)");
                    } else {
                        crude.ActualizarfechaSuspendida(vista.jtxtUsuario.getText());
                        crude.ActualizarHoraSuspendida(vista.jtxtUsuario.getText());
                        Mensajes.M1("Su cuenta sera suspendido hasta FECHA: "
                                + crude.ConsultarFechaSuspencion(vista.jtxtUsuario.getText()) + " HORA: "
                                + crude.ConsultarHoraSuspendida(vista.jtxtUsuario.getText()));
                    }
                }
            } else {
                Mensajes.M1("Usuario y Contraseña no encontrados");
            }
        }
    }
}
