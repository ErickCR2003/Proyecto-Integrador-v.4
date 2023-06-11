package Controlador;

import DAO.CRUDempleados;
import Formatos.FormatoEmpleados;
import Formatos.Mensajes;
import Modelo.Empleado;
import Vst.Empleado.VstEmpleado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrlEmpleado_Nvo implements ActionListener{
    
    Empleado emp;
    VstEmpleado vista;
    CRUDempleados crude;
    CtrlEmpleado_Lista controladorAdmEmpleados;
    
    public CtrlEmpleado_Nvo(VstEmpleado AE, CtrlEmpleado_Lista CAE ) {
        controladorAdmEmpleados = CAE;
        vista = AE;
        vista.btnGuardar.addActionListener(this);        
        crude = new CRUDempleados();
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vista.btnGuardar) {
            if(vista.txtUsuario.getText().isEmpty() || vista.txtContraseña.getText().isEmpty() ||vista.jtxtNombres.getText().isEmpty() || vista.txtApellidos.getText().isEmpty() || vista.txtCorreo.getText().isEmpty() || 
                    vista.txtDNI.getText().isEmpty() || vista.txtNumeroCelular.getText().isEmpty() || vista.txtFechaNacimiento.getDate() == null 
                    ){
                Mensajes.M1("Completar los campos faltantes");
                
            }else if (!vista.txtContraseña.getText().equals(vista.txtConfirmarContraseña.getText())) {
                Mensajes.M1("Las contraseñas no coinciden");
            } else {
                emp = FormatoEmpleados.LeerEmpleado(vista);
                crude = new CRUDempleados();
                crude.InsertarRegistroEmp(emp);
                FormatoEmpleados.LimpiarEntradas(vista);
                controladorAdmEmpleados.ActualizarFormulario();
                vista.dispose();
            }
        }
    }
    
}
