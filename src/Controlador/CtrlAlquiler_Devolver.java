package Controlador;

import DAO.CRUDAlquiler;
import DAO.CRUDMovimiento;
import Modelo.Alquiler;
import Modelo.Movimiento;
import Vst.Alquiler.VstAlquiler_Confirmar;
import Vst.Alquiler.VstAlquiler_Devolver;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class CtrlAlquiler_Devolver implements ActionListener {

    VstAlquiler_Devolver vista;
    Alquiler alq;     
    CRUDAlquiler cruda; 

    public static VstAlquiler_Confirmar VAlq_Confirmar;
    public static CtrlAlquiler_Confirmar CtrlAlq_Confirmar;

    public CtrlAlquiler_Devolver(VstAlquiler_Devolver LV) {

        
        vista = LV;       
        cruda = new CRUDAlquiler();  
               
        
        //-- Asociar eventos de la vista al controlador                         
        vista.btnGuardar.addActionListener(this);
        vista.btnCancelar.addActionListener(this);        
        
        //mostrar
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
    }
    
    public void CargarAlquiler(Alquiler XAql){
        alq   = XAql;
    
        vista.txtNomCli.setText(alq.getCliente().getNombrecompleto());
        vista.txtNumBoleta.setText(alq.getSerieCorrFacBol());        
        vista.txtImp_Transp.setText(String.valueOf(alq.getImp_Traslado()));        
        vista.txtImp_Alq.setText(String.valueOf(alq.getImp_Alquiler()));
        vista.txtImp_Garant.setText(String.valueOf(alq.getImp_Garantia()));
        vista.txtIdAlquiler.setText(String.valueOf(alq.getID()));
        vista.txtFecRetiro.setDate(java.sql.Date.valueOf(alq.getFecHoraSalida()));
        vista.txtFecDevol.setDate(java.sql.Date.valueOf(LocalDate.now()));        
    }
   

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == vista.btnGuardar) {
         
            //marcar alquiler como devuelto
            var cruda = new CRUDAlquiler();
            cruda.Alquiler_Devolver(alq.getID());
         
            //movimiento de salida por devolucion de garantía
            //garantía
            if (Double.parseDouble(vista.txtImpDevol.getValue().toString()) > 0) {
                CRUDMovimiento crudg = new CRUDMovimiento();
                Movimiento movG = new Movimiento();
                movG.setIdAlquiler(alq.getID());
                movG.setConcepto("Garantia");
                movG.setIdEmpleado(alq.getIdEmpleado());
                movG.setTipoEfectivoElectronico("Efectivo");
                movG.setAnulado(false);
                movG.setMonto(Double.parseDouble(vista.txtImpDevol.getValue().toString()));
                movG.setTipoIngresoSalida("Salida");
                crudg.Movimiento_Insertar(movG);    
            } 
        }        
        
        if (e.getSource() == vista.btnCancelar) {
            vista.dispose();
        }
        
    }        
}
