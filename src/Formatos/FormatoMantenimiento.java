
package Formatos;

import Modelo.OrdenMantenimiento;
import Principal.Main;
import Vst.Herramienta.VstHerramientaMantenimiento;
import java.text.SimpleDateFormat;
import java.time.LocalDate;


public class FormatoMantenimiento {
    
    public static void LimpiarEntradasLN(VstHerramientaMantenimiento m) {
        
        m.jdtcFechaCreacion.setDateFormatString("");
        m.jdtcFechaCierre.setDateFormatString("");
        m.jtxtIDHerramienta.setText("");
        m.jtxtNombreHerramienta.setText("");
        m.jtxtDescProblema.setText("");
        m.jtxtDescReparacion.setText("");
        m.jcbxEstado.setSelectedIndex(0);
        m.jcbxTipo.setSelectedIndex(0);
        m.jtxtNombreEmp.setText("");
        m.jspnCostoReparacion.setValue(0);
        m.jtxtDescProblema.requestFocus();
        
    }
    
    public static OrdenMantenimiento LeerOrdenMantenimiento(VstHerramientaMantenimiento ve) {

        SimpleDateFormat ff = new SimpleDateFormat("yyyy-MM-dd");
        
        OrdenMantenimiento orM = new OrdenMantenimiento();
        
        orM.setFecCreacion(LocalDate.parse(ff.format(ve.jdtcFechaCreacion.getCalendar().getTime())));
        orM.setFecCierre(LocalDate.parse(ff.format(ve.jdtcFechaCierre.getCalendar().getTime())));
        orM.setEstado(ve.jcbxEstado.getSelectedItem().toString());
        orM.setProblema(ve.jtxtDescProblema.getText());
        orM.setReparacion(ve.jtxtDescProblema.getText());
        orM.setCostoReparacion(Double.parseDouble(ve.jspnCostoReparacion.getValue().toString()));
        orM.setId_herramienta(Integer.parseInt(ve.jtxtIDHerramienta.getText()));
        orM.setId_empleado(Main.UsrActual.getID());

        return orM;
    }
    
}
