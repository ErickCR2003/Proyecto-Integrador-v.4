/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.CRUDreportes;
import Vst.Reporte.VstReportes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author julis
 */
public class CtrlReporte implements ActionListener{    
     VstReportes vista;
     CRUDreportes crud;
    
      public CtrlReporte(VstReportes v_reporte) {
        vista = v_reporte; 
        crud = new CRUDreportes();   
        vista.btn_reporte2.addActionListener(this);
        vista.btn_reporte3.addActionListener(this);
        vista.btn_reportePorFecha.addActionListener(this);       
      
        vista.setVisible(true);  
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vista.btn_reportePorFecha){
            if(vista.fecha_desde.getDate() != null && vista.fecha_hasta.getDate() !=null ){
            crud.MostrarHerramientasAlquiladasPorFecha(vista.tabla_reporteAlquiler, vista.fecha_desde,
                 vista.fecha_hasta, vista.totalRecaudado,vista.total_hAlquiladas);  
            }else{
                JOptionPane.showMessageDialog(null, "No ha ingresado las fechas de busqueda", "INGRESE LAS FECHAS", JOptionPane.INFORMATION_MESSAGE);
            }
                
        }
        
        if(e.getSource() == vista.btn_reporte2){    
            if(vista.fecha_desde1.getDate() != null && vista.fecha_hasta1.getDate() !=null ){
            DefaultTableModel model = (DefaultTableModel) vista.tabla_reporteOtros.getModel();
            model.setRowCount(0);       
            crud.Mostrar10HerramientasAlquiladas(vista.tabla_reporteOtros,vista.fecha_desde1,
                     vista.fecha_hasta1,vista.jLabel_descripcion); 
            }else{
                JOptionPane.showMessageDialog(null, "No ha ingresado las fechas de busqueda", "INGRESE LAS FECHAS", JOptionPane.INFORMATION_MESSAGE);
            }      
        }
        
        if(e.getSource() == vista.btn_reporte3){
            System.out.println("vista.fecha_desde1 "+vista.fecha_desde1 );
            
              if(vista.fecha_desde1.getDate() != null && vista.fecha_hasta1.getDate() !=null ){
                  DefaultTableModel model = (DefaultTableModel) vista.tabla_reporteOtros.getModel();
        model.setRowCount(0);
         crud.MostrarHerramientasNuncaSeAlquilo(vista.tabla_reporteOtros,vista.fecha_desde1,
                 vista.fecha_hasta1,vista.jLabel_descripcion);   
              }else{
              JOptionPane.showMessageDialog(null, "No ha ingresado las fechas de busqueda", "INGRESE LAS FECHAS", JOptionPane.INFORMATION_MESSAGE);
              }
              
        }       
    }   
    
}
