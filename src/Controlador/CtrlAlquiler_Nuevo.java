package Controlador;

import DAO.CRUDAlquiler;
import DAO.CRUDtipos;
//import DAO.CRUDAlquiler;
import DAO.CRUDherramientas;
import Formatos.Mensajes;
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
import javax.swing.table.TableRowSorter;

public class CtrlAlquiler_Nuevo implements ActionListener {
    
    VstAlquiler vista;    
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

    
    //CONSTRUCTOR
    public CtrlAlquiler_Nuevo(VstAlquiler LV) {

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
        vista.btnActualizaTipos.addActionListener(this);
        vista.btnActualizaTipos.addActionListener(this);
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);

        int cantidad = cruda.ConsultarCantidadDeFacturas() + 1;
        vista.jtxtNumAlquiler.setText("N° " + cantidad);

       CargarTipos();

        vista.jtblBusquedaHerramientasAlquiler.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblBusquedaHerramientasAlquilerMouseClicked(evt);
            }
        });
    }
    
    
    // METODOS
    
    
    // método privado para actualizar el combo de tipos de herramientas --------------------------------------
    private void CargarTipos(){
        for (String tipos : crude.RegistrarTiposComboBox()) {
            vista.jcbxTipo.addItem(tipos);
        }
    }
    //--------------------------------------------------------------------------------------------------------
    
    
    // agregar herramienta de la lista al alquiler al hacer clic sobre la fila -------------------------------------------------
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
    //---------------------------------------------------------------------------------------------------------------------------
    
    
    // Manejador de botones ====================================================================================================================
    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        
        // Filtrar tabla de herramientas --------------------------------------------------------------------------------------
        if (e.getSource() == vista.jbtnBuscarHerramienta) {

            String marca ="";
            String tipoH = "";

            if (!vista.jtxtMarcaHerramienta.getText().isEmpty()) {                         
                 marca = vista.jtxtMarcaHerramienta.getText();}
            
            if (vista.jcbxTipo.getSelectedIndex() != 0) {
             tipoH = vista.jcbxTipo.getSelectedItem().toString();}
            
            crudh.MostrarHerramientasEnTablaAlquiler(vista.jtblBusquedaHerramientasAlquiler, tipoH, marca);
        }
        //---------------------------------------------------------------------------------------------------------------------

        
        // Actualizar tipo de herramientas --------------------------------------------------------------------------------------
        if (e.getSource() == vista.btnActualizaTipos) {            
            vista.jcbxTipo.removeAllItems();
            CargarTipos();
        }
        //---------------------------------------------------------------------------------------------------------------------
                
                        
        
        
        if (e.getSource() == vista.jbtnlimpiar) {
            Formatos.FormatoAlquiler.LimpiarEntradas(vista);
        }

        if (e.getSource() == vista.jbtnEliminarCampos) {
            int fila = vista.jtblTablaVenta.getSelectedRow();
            if (fila < 0) {
                Mensajes.M1("Por favor seleccionar una herramienta a eliminar del alquiler");
            } else {
                String nombreH = vista.jtblTablaVenta.getValueAt(fila, 2).toString();
                int rpta = Mensajes.M3("Confirmacion de eliminacion", "¿Esta seguro de eliminar la herramienta \"" + nombreH + "\" del alquiler?");
                if (rpta == 0) {
                    DefaultTableModel modelo = (DefaultTableModel) vista.jtblTablaVenta.getModel();
                    modelo.removeRow(fila);
                    double acumulado = 0;
                    int CantidadFilas = vista.jtblTablaVenta.getRowCount();
                    for (int i = 0; i < CantidadFilas; i++) {
                        acumulado += Double.parseDouble(vista.jtblTablaVenta.getValueAt(i, 8).toString());;
                    }
                }
            }
        }

        if (e.getSource() == vista.jbtnAgregarCliente) {
            VCliente_Selec = new VstCliente_Seleccionar();
            CCliente_Selec = new CtrlCliente_Seleccionar(VCliente_Selec, vista);
        }

        if (e.getSource() == vista.jbtnCancelarCom) {
            int rpta = Mensajes.M3("Cancelacion de alquiler", "¿Está seguro que desea cancelar el alquiler?");
            if (rpta == 0) {
                Formatos.FormatoAlquiler.LimpiarEntradasTabla(vista);
                DefaultTableModel modelo = (DefaultTableModel) vista.jtblTablaVenta.getModel();
                int cantidad = vista.jtblTablaVenta.getRowCount();
                for (int i = 0; i < cantidad; i++) {
                    modelo.removeRow(0);
                }
            }
        }

        if (e.getSource() == vista.jbtnConfirmarAlquiler) {
            if (vista.jtxtClienteCom.getText().isEmpty()) {
                Mensajes.M1("Debe seleccionar un cliente para el alquiler.");
            } else if (vista.jtxtDirecciónObra.getText().isEmpty()) {
                Mensajes.M1("La direccion no puede ser vacia.");
            } else if (vista.jcbxTraslado.getSelectedIndex() == 0) {
                Mensajes.M1("Debe seleccionar una opcion de traslado.");
            } else if (vista.jcbxTraslado.getSelectedIndex() == 2 && Double.parseDouble(vista.jspnPrecioTraslado.getValue().toString()) > 0) {
                Mensajes.M1("El precio no debe ser mayor a cero.");
            } else if (vista.jcbxTraslado.getSelectedIndex() == 1 && Double.parseDouble(vista.jspnPrecioTraslado.getValue().toString()) <= 0) {
                Mensajes.M1("El precio no debe ser menor o igual a cero.");
            } else if (Integer.parseInt(vista.jspnDiasdeAlquiler.getValue().toString()) <= 0) {
                Mensajes.M1("Los dias de alquiler no pueden ser menor o igual que cero.");
            } else if (vista.jtblTablaVenta.getRowCount() < 1) {
                Mensajes.M1("El alquiler debe tener como mínimo una herramienta.");
            } else {
//                if (vista.jcbxTraslado.getSelectedIndex() == 1) {
//                    VAlq_PrecDir = new VstAlquiler_PrecDirec();
//                    CAlq_PrecDir = new CtrlAlquiler_PrecDirecc(VAlq_PrecDir, vista);
//                } else {
                VAlq_Confirmar = new VstAlquiler_Confirmar();
                CtrlAlq_Confirmar = new CtrlAlquiler_Confirmar(VAlq_Confirmar, vista, VCliente_Selec);
            }
        }
    }        
}
