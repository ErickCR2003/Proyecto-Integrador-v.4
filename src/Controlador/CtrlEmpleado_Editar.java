package Controlador;

import DAO.CRUDempleados;
import Formatos.FormatoEmpleados;
import Formatos.Mensajes;
import Modelo.Empleado;
import Vst.Empleado.VstEmpleado;
import Vst.Empleado.VstEmpleado_Lista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrlEmpleado_Editar implements ActionListener {

    VstEmpleado vista;  
    CRUDempleados crude;
    Empleado emp;
    CtrlEmpleado_Lista controladorAdmEmpleados;
    VstEmpleado_Lista vista2;

    public CtrlEmpleado_Editar(VstEmpleado XVEmp, CtrlEmpleado_Lista XCEmp_lista) {
        controladorAdmEmpleados = XCEmp_lista;
        vista2 = controladorAdmEmpleados.VEmp;
        vista = XVEmp;
        vista.btnGuardar.addActionListener(this);
        crude = new CRUDempleados();
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        
        String dni = vista2.jtxtBuscarPorDni.getText();
        emp = crude.ConsultarRegistroEmp(dni);
        
        vista.txtCorreo.setText(emp.getEmail());
        vista.jtxtNombres.setText(emp.getNombre());
        vista.txtApellidos.setText(emp.getApellido());
        vista.txtNumeroCelular.setText(emp.getTelefono());
        vista.txtContraseña.setText(emp.getContraseña());
        vista.txtConfirmarContraseña.setText(emp.getContraseña());
        vista.cmbGenero.setSelectedItem(emp.getGenero());
        vista.txtFechaNacimiento.setDate(java.sql.Date.valueOf(emp.getFecNacimiento()));
        vista.txtDNI.setText(emp.getDni());
        vista.chkActivo.setSelected(emp.getActivo());
        vista.cmbTipoEmpleado.setSelectedItem(emp.getTipo());
        vista.txtUsuario.setText(emp.getUsuario());
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnGuardar) {
            if (vista.txtContraseña.getText().equals(vista.txtConfirmarContraseña.getText())) {
                String dni = vista2.jtxtBuscarPorDni.getText();
                emp = FormatoEmpleados.EditarEmpleado(vista);
                crude.ActualizarRegistroEmp(dni, emp);
                controladorAdmEmpleados.ActualizarFormulario();
                vista.dispose();
            } else {
                Mensajes.M1("Las contraseñas no coinciden");
            }

        }
    }

}
