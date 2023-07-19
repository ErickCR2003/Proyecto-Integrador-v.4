package Controlador;

import DAO.CRUDAlquiler;
import DAO.CRUDtipos;
import Modelo.Alquiler;
//import DAO.CRUDAlquiler;
import DAO.CRUDherramientas;
import Formatos.Mensajes;
import Modelo.Herramienta;
import Vst.Alquiler.VstAlquiler_Confirmar;
import Vst.Alquiler.VstAlquiler_Devolver;
//import Vst.Herramienta.VstHerramienta_Cantidad;
import Vst.Alquiler.VstAlquiler_PrecDirec;
import Vst.Cliente.VstCliente_Seleccionar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;

public class CtrlAlquiler_Devolver implements ActionListener {

    VstAlquiler_Devolver vista;
    Alquiler alq;
    CRUDherramientas crudh;
    CRUDtipos crude;
    CRUDAlquiler cruda;
    Herramienta her;
    int idHerramientaEnTabla = 0;

    public static Vst.Cliente.VstCliente_Seleccionar VCliente_Selec;
    public static CtrlCliente_Seleccionar CCliente_Selec;

    public static VstAlquiler_PrecDirec VAlq_PrecDir;
    public static CtrlAlquiler_PrecDirecc CAlq_PrecDir;

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
        vista.txtImp_Alq.setText(String.valueOf(alq.getImp_Total()));
        vista.txtImp_Garant.setText(String.valueOf(alq.getImp_Garantia()));
//        vista.txtFecRetiro.setText(alq.getFecHoraSalida());
//        vista.txtFecRetiro.setDate(java.sql.Date.valueOf(alq.getFecHoraSalida()));

    }
   

    @Override
    public void actionPerformed(ActionEvent e) {


//        if (e.getSource() == vista.jbtnEliminarCampos) {
//            int fila = vista.tblTablaVenta.getSelectedRow();
//            if (fila < 0) {
//                Mensajes.M1("Por favor seleccionar una herramienta a eliminar del alquiler");
//            } else {
//                String nombreH = vista.tblTablaVenta.getValueAt(fila, 2).toString();
//                int rpta = Mensajes.M3("Confirmacion de eliminacion", "¿Esta seguro de eliminar la herramienta \"" + nombreH + "\" del alquiler?");
//                if (rpta == 0) {
//                    DefaultTableModel modelo = (DefaultTableModel) vista.tblTablaVenta.getModel();
//                    modelo.removeRow(fila);
//                    double acumulado = 0;
//                    int CantidadFilas = vista.tblTablaVenta.getRowCount();
//                    for (int i = 0; i < CantidadFilas; i++) {
//                        acumulado += Double.parseDouble(vista.tblTablaVenta.getValueAt(i, 8).toString());;
//                    }
//                }
//            }
//        }
      
      
    }        
}
