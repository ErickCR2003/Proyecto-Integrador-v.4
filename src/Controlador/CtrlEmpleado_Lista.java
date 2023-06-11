package Controlador;

import Vst.Empleado.VstEmpleado_Lista;
import DAO.CRUDempleados;
import Formatos.Mensajes;
import Modelo.Empleado;
import Vst.Empleado.VstEmpleado;
import Vst.Empleado.VstEmpleado_Editar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrlEmpleado_Lista implements ActionListener {

    VstEmpleado_Lista VEmp;
    CRUDempleados crude;
    Empleado emp;
    
    public static Vst.Empleado.VstEmpleado VEmpleado_Editar;
    public static CtrlEmpleado_Editar CEmpleado_Editar;
    
    public static Vst.Empleado.VstEmpleado VEmpleado_Nvo;
    public static CtrlEmpleado_Nvo CEmpleado_Nvo;

    
    public CtrlEmpleado_Lista(VstEmpleado_Lista XVEmp) {

        VEmp = XVEmp;
        VEmp.jbtnAgregarUsuario.addActionListener(this);
        VEmp.jbtnBuscarUsuario.addActionListener(this);      
        VEmp.jbtnEditarUsuario.addActionListener(this);
        
        crude = new CRUDempleados();
        crude.MostrarEmpleadosEnTabla(VEmp.jtblDatos_Usuarios, VEmp.jlblRegistros_Usuarios);
        XVEmp.setVisible(true);
    }

    public void ActualizarFormulario() {
        crude = new CRUDempleados();
        crude.MostrarEmpleadosEnTabla(VEmp.jtblDatos_Usuarios, VEmp.jlblRegistros_Usuarios);
        VEmp.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        //actualizar lista de empleados
//         if (e.getSource() == VEmp.btnActualizar) {
//           ActualizarFormulario();
//        }

        if (e.getSource() == VEmp.jbtnEditarUsuario) {
            if (VEmp.jtxtBuscarPorDni.getText().length() == 0) {
                Mensajes.M1("El campo esta vacio");

            } else {
                String dni = VEmp.jtxtBuscarPorDni.getText();
                emp = crude.ConsultarRegistroEmp(dni);
                if (emp == null) {
                    Mensajes.M1("El DNI " + dni + " no existe en la tabla Empleados.");
                } else {
                    VEmpleado_Editar = new VstEmpleado();
                    CEmpleado_Editar = new CtrlEmpleado_Editar(VEmpleado_Editar, this);
                }
            }
        }

        if (e.getSource() == VEmp.jbtnAgregarUsuario) {
            VEmpleado_Nvo = new VstEmpleado();
            CEmpleado_Nvo = new CtrlEmpleado_Nvo(VEmpleado_Nvo, this);
        }

        if (e.getSource() == VEmp.jbtnBuscarUsuario) {
            if (VEmp.jtxtBuscarPorDni.getText().length() == 0) {
                Mensajes.M1("El campo esta vacio");

            } else {
                String dni = VEmp.jtxtBuscarPorDni.getText();
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
                            +   "<br>Fecha Nacimiento:   " + emp.getFecNacimiento()
                            +   "<br>Tipo:               " + emp.getTipo()
                            +   "<br>Genero:             " + emp.getGenero()
                            +   "<br>Activo:             " + emp.getActivo()
                            +   "<br>DNI:                " + emp.getDni());
                    
                }
            }
        }
    }

}
