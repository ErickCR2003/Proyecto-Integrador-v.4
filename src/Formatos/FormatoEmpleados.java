package Formatos;

import Modelo.Empleado;
import Vst.Empleado.VstEmpleado;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class FormatoEmpleados {
    
    public static Empleado LeerEmpleado(VstEmpleado f1){
        Empleado emp = new Empleado();
        SimpleDateFormat ff = new SimpleDateFormat("yyyy-MM-dd");
        emp.setUsuario(f1.txtUsuario.getText());
        emp.setNombre(f1.jtxtNombres.getText());
        emp.setApellido(f1.txtApellidos.getText());
        emp.setDni(f1.txtDNI.getText());
        emp.setTelefono(f1.txtNumeroCelular.getText());
        emp.setEmail(f1.txtCorreo.getText());
        emp.setContraseña(String.valueOf(f1.txtContraseña.getPassword()));
        emp.setTipo(f1.cmbTipoEmpleado.getSelectedItem().toString());
        emp.setGenero(f1.cmbGenero.getSelectedItem().toString());
        emp.setActivo(f1.chkActivo.isSelected()); 
        emp.setFecNacimiento(LocalDate.parse(ff.format(f1.txtFechaNacimiento.getCalendar().getTime())));
        return emp;
    }
    
     public static void LimpiarEntradas(VstEmpleado AE){
        AE.jtxtNombres.setText("");
        AE.txtApellidos.setText("");
        AE.txtDNI.setText("");
        AE.txtNumeroCelular.setText("");
        AE.txtCorreo.setText("");
        AE.txtContraseña.setText("");
        AE.txtConfirmarContraseña.setText("");
        AE.cmbTipoEmpleado.setSelectedIndex(0);
        AE.cmbGenero.setSelectedIndex(0);
        AE.txtFechaNacimiento.setDateFormatString("");
        AE.chkActivo.setSelected(false);
        AE.jtxtNombres.requestFocus();
    }
    
     public static Empleado EditarEmpleado(VstEmpleado f1){
        Empleado emp = new Empleado();
        SimpleDateFormat ff = new SimpleDateFormat("yyyy-MM-dd");
        emp.setUsuario(f1.txtUsuario.getText());
        emp.setNombre(f1.jtxtNombres.getText());
        emp.setApellido(f1.txtApellidos.getText());
        emp.setDni(f1.txtDNI.getText());
        emp.setTelefono(f1.txtNumeroCelular.getText());
        emp.setEmail(f1.txtCorreo.getText());
        emp.setContraseña(String.valueOf(f1.txtContraseña.getPassword()));
        emp.setTipo(f1.cmbTipoEmpleado.getSelectedItem().toString());
        emp.setActivo(f1.chkActivo.isSelected());
        emp.setGenero(f1.cmbGenero.getSelectedItem().toString());
        emp.setFecNacimiento(LocalDate.parse(ff.format(f1.txtFechaNacimiento.getCalendar().getTime())));
        return emp;
    }
    
}
