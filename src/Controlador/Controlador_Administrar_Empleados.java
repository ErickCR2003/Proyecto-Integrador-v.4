package Controlador;

import DAO.CRUDempleados;
import Formatos.Mensajes;
import Modelo.Empleado;
import Principal.Main;
import Vista1.AñadirEmpleados;
import Vista1.EditarEmpleados;
import Vista_Jefe1.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador_Administrar_Empleados implements ActionListener {

    Administrar_Empleados vistaEmpleados;
    CRUDempleados crude;
    Empleado emp;

    public Controlador_Administrar_Empleados(Administrar_Empleados ADE) {

        vistaEmpleados = ADE;
        vistaEmpleados.jbtnEditarUsuario.addActionListener(this);
        vistaEmpleados.jbtnAgregarUsuario.addActionListener(this);
        vistaEmpleados.jbtnBuscarUsuario.addActionListener(this);

        crude = new CRUDempleados();
        crude.MostrarEmpleadosEnTabla(vistaEmpleados.jtblDatos_Usuarios, vistaEmpleados.jlblRegistros_Usuarios);
        ADE.setVisible(true);
    }

    public void ActualizarFormulario() {
        crude = new CRUDempleados();
        crude.MostrarEmpleadosEnTabla(vistaEmpleados.jtblDatos_Usuarios, vistaEmpleados.jlblRegistros_Usuarios);
        vistaEmpleados.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaEmpleados.jbtnEditarUsuario) {
            if (vistaEmpleados.jtxtBuscarPorDni.getText().length() == 0) {
                Mensajes.M1("El campo esta vacio");

            } else {
                String dni = vistaEmpleados.jtxtBuscarPorDni.getText();
                crude = new CRUDempleados();
                emp = crude.ConsultarRegistroEmp(dni);
                if (emp == null) {
                    Mensajes.M1("El DNI " + dni + " no existe en la tabla Empleados.");
                } else {

                    Main.VEE = new EditarEmpleados();
                    Main.CEE = new Controlador_EditarEmpleados(Main.VEE, this);
                }
            }
        }

        if (e.getSource() == vistaEmpleados.jbtnAgregarUsuario) {
            Main.VAEM = new AñadirEmpleados();
            Main.CAEM = new Controlador_AgregarEmpleado(Main.VAEM, this);
        }

        if (e.getSource() == vistaEmpleados.jbtnBuscarUsuario) {
            if (vistaEmpleados.jtxtBuscarPorDni.getText().length() == 0) {
                Mensajes.M1("El campo esta vacio");

            } else {
                String dni = vistaEmpleados.jtxtBuscarPorDni.getText();
                crude = new CRUDempleados();
                emp = crude.ConsultarRegistroEmp(dni);
                if (emp == null) {
                    Mensajes.M1("El DNI " + dni + " no existe en la tabla Empleados.");
                } else {
                    Mensajes.M1("Usuario:                " + emp.getUsuario()
                            +   "<br>Nombres:            " + emp.getNombre()
                            +   "<br>Apellidos:          " + emp.getApellido()
                            +   "<br>Telefono:           " + emp.getTelefono()
                            +   "<br>Correo:             " + emp.getEmail()
                            +   "<br>Fecha Nacimiento:   " + emp.getFnacimiento()
                            +   "<br>Tipo:               " + emp.getTipo()
                            +   "<br>Genero:             " + emp.getGenero()
                            +   "<br>Estado:             " + emp.getEstado()
                            +   "<br>DNI:                " + emp.getDni());
                    
                }
            }
        }
    }

}
