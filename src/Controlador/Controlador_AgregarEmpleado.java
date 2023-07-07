package Controlador;

import DAO.CRUDempleados;
import Formatos.FormatoEmpleados;
import Formatos.Mensajes;
import Modelo.Empleado;
import Vista1.AñadirEmpleados;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador_AgregarEmpleado implements ActionListener{
    
    Empleado emp;
    AñadirEmpleados vista;
    CRUDempleados crude;
    Controlador_Administrar_Empleados controladorAdmEmpleados;
    public Controlador_AgregarEmpleado(AñadirEmpleados AE, Controlador_Administrar_Empleados CAE ) {
        vista = AE;
        vista.jbtnRegistrar.addActionListener(this);
        controladorAdmEmpleados = CAE;
        crude = new CRUDempleados();
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vista.jbtnRegistrar) {
            if(vista.jpswIngresarContraseña.getText().isEmpty() ||vista.jtxtNombres.getText().isEmpty() || vista.jtxtApellidos.getText().isEmpty() || vista.jtxtCorreo.getText().isEmpty() || 
                    vista.jtxtDNI.getText().isEmpty() || vista.jtxtNumeroCelular.getText().isEmpty() || vista.jdtcFechaNacimiento.getDate() == null 
                    ){
                Mensajes.M1("Completar los campos faltantes");
                
            }else if (!vista.jpswIngresarContraseña.getText().equals(vista.jpswConfirmarContraseña.getText())) {
                Mensajes.M1("Las contraseñas no coinciden");
            } else {
                emp = FormatoEmpleados.LeerEmpleado(vista);
                crude = new CRUDempleados();
                crude.InsertarRegistroEmp(emp);
                FormatoEmpleados.LimpiarEntradas(vista);
                controladorAdmEmpleados.ActualizarFormulario();

            }
        }
    }
    
}
