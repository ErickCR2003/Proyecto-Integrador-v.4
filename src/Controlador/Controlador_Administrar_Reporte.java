
package Controlador;

import DAO.CRUDfacturas;
import Formatos.Mensajes;
import Vista_Jefe1.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Action;


public class Controlador_Administrar_Reporte implements ActionListener{

    Administrar_Reporte vistaReporte;
    CRUDfacturas crudf;

    public Controlador_Administrar_Reporte(Administrar_Reporte VADR) {
        
        vistaReporte = VADR;
        vistaReporte.setVisible(true);
        vistaReporte.jbtnBuscarReporteFechaRango.addActionListener(this);
        vistaReporte.jbtnBuscarReporteFechaEspecifica.addActionListener(this);
        crudf = new CRUDfacturas();
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vistaReporte.jbtnBuscarReporteFechaRango){
            if( vistaReporte.jdtcFechaInicio.getDate() == null || vistaReporte.jdtcFechaFin.getDate() == null){
                Mensajes.M1("Rellene los campos");
            } else if (vistaReporte.jdtcFechaInicio.getDate().compareTo(vistaReporte.jdtcFechaFin.getDate()) <= 0){
            //el dia de fin no puede ser menor al dia de inicio
                crudf = new CRUDfacturas();
                SimpleDateFormat ff = new SimpleDateFormat("yyyy-MM-dd");
                String fechaInicio = ff.format(vistaReporte.jdtcFechaInicio.getCalendar().getTime());
                String fechaFin = ff.format(vistaReporte.jdtcFechaFin.getCalendar().getTime());
                crudf.MostrarFacturasPorFechaRango(vistaReporte.jtblTablaReporteRango, fechaInicio, fechaFin);
                crudf.ConsultarTotalGanadoEnRango(fechaInicio, fechaFin, vistaReporte.jlblTotalGanadoRango);
            } else {
                Mensajes.M1("La fecha de inicio no puede ser mayor a la fecha de fin");
            }
        }
        
        if(e.getSource() == vistaReporte.jbtnBuscarReporteFechaEspecifica){
            if (vistaReporte.jdtcFechaEspecificada.getDate() == null) {
                Mensajes.M1("El campo esta vacio");
            } else {
                crudf = new CRUDfacturas();
                SimpleDateFormat ff = new SimpleDateFormat("yyyy-MM-dd");
                String fechaEspecifica = ff.format(vistaReporte.jdtcFechaEspecificada.getCalendar().getTime());
                crudf.MostrarFacturasPorFechaEspecifica(vistaReporte.jtblTablaReporteFechaEspecificada, fechaEspecifica);
                crudf.ConsultarTotalGanadoEnElDia(fechaEspecifica, vistaReporte.jlblTotalGanadoDia);
            }
        }
       
    }
}
