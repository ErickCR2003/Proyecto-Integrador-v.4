package Controlador;

import DAO.CRUDAlquiler;
import DAO.CRUDtipos;
//import DAO.CRUDAlquiler;
import DAO.CRUDherramientas;
import Formatos.Mensajes;
import Modelo.Alquiler;
import Modelo.Herramienta;
import Vst.Alquiler.VstAlquiler_Confirmar;
import Vst.Alquiler.VstAlquiler;
//import Vst.Herramienta.VstHerramienta_Cantidad;
import Vst.Alquiler.VstAlquiler_PrecDirec;
import Vst.Cliente.VstCliente_Seleccionar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;

public class CtrlAlquiler_Devolver implements ActionListener {

    VstAlquiler vista;
    CRUDherramientas crudh;
    CRUDtipos crude;
    CRUDAlquiler cruda;
    Herramienta her;
    Alquiler alq;
    int idHerramientaEnTabla = 0;

    public static Vst.Cliente.VstCliente_Seleccionar VCliente_Selec;
    public static CtrlCliente_Seleccionar CCliente_Selec;

    public static VstAlquiler_PrecDirec VAlq_PrecDir;
    public static CtrlAlquiler_PrecDirecc CAlq_PrecDir;

    public static VstAlquiler_Confirmar VAlq_Confirmar;
    public static CtrlAlquiler_Confirmar CtrlAlq_Confirmar;

    public CtrlAlquiler_Devolver(VstAlquiler LV) {

        vista = LV;
        crudh = new CRUDherramientas();
        crude = new CRUDtipos();
        cruda = new CRUDAlquiler();
        her = new Herramienta();
        vista.jbtnBuscarHerramienta.addActionListener(this);
        vista.btnActualizaTipos.addActionListener(this);
        vista.jbtnAgregarCliente.addActionListener(this);
        vista.jbtnEliminarCampos.addActionListener(this);
        vista.jbtnCancelarCom.addActionListener(this);
        vista.jbtnConfirmarAlquiler.addActionListener(this);
        vista.btnFinalizar.addActionListener(this);
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);

        int cantidad = cruda.ConsultarCantidadDeFacturas() + 1;
        vista.jtxtNumAlquiler.setText("N° " + cantidad);

        for (String tipos : crude.RegistrarTiposComboBox()) {
            vista.jcbxTipo.addItem(tipos);
        }

        vista.jtblBusquedaHerramientasAlquiler.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblBusquedaHerramientasAlquilerMouseClicked(evt);
            }
        });

    }

    private void jtblBusquedaHerramientasAlquilerMouseClicked(java.awt.event.MouseEvent evt) {
        //indice de la fila
        int fila = vista.jtblBusquedaHerramientasAlquiler.getSelectedRow();
        //obtengo el valor del ID que está en la columna 0 de la fila
        idHerramientaEnTabla = (int) vista.jtblBusquedaHerramientasAlquiler.getValueAt(fila, 0);

        boolean rpta = false;

        for (int i = 0; i < vista.jtblTablaVenta.getRowCount(); i++) {
            if (idHerramientaEnTabla == Integer.parseInt(vista.jtblTablaVenta.getValueAt(i, 0).toString())) {
                rpta = true;
            }
        }

        if (rpta) {
            Mensajes.M1("Ya existe esta herramienta en el alquiler.");
        } else {
            Mensajes.M3("Agregar al Alquiler", "¿Deseas agregar este producto al alquiler?");
            DefaultTableModel modelo = (DefaultTableModel) vista.jtblTablaVenta.getModel();
            her = crudh.ConsultarRegistroHerramienta(idHerramientaEnTabla);
            modelo.addRow(her.RegistroHerramientasCarrito(her));
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
        if (e.getSource() == vista.btnFinalizar) {
            
            
            
            
            
            
        }

       
      

     

      
    }        
}
