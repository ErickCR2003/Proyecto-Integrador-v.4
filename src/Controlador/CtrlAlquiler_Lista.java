package Controlador;

import DAO.*;
import Formatos.Mensajes;
import Modelo.Alquiler;
import Vst.Alquiler.VstAlquiler;
import Vst.Alquiler.VstAlquiler_Lista;
import Vst.Herramienta.VstHerramienta_Lista;
import Vst.Herramienta.VstHerramienta;
import Vst.Herramienta.VstHerramienta_Editar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrlAlquiler_Lista implements ActionListener {

    Alquiler alq;
    CRUDAlquiler cruda;
    CRUDtipos crudt;
    VstAlquiler_Lista VstAlq_Lst;
    int idHerramientaEnTabla = 0;

    public static Vst.Alquiler.VstAlquiler VAql;
    public static CtrlAlquiler_Nuevo CAlq_Nvo;

    //public static Vst.Herramienta.VstHerramienta_Editar VHerr_Editar; //se usa la misma VstAlq_Lst de nuevo
    public static CtrlAlquiler_Editar CAlq_Editar;

    public CtrlAlquiler_Lista(VstAlquiler_Lista XVAlq) {
        VstAlq_Lst = XVAlq;
        VstAlq_Lst.setVisible(true);
        crudt = new CRUDtipos();
        VstAlq_Lst.btnAlquiler_Nvo.addActionListener(this);
        VstAlq_Lst.jbtnEditarHerramienta.addActionListener(this);
        VstAlq_Lst.btnAlquiler_Buscar.addActionListener(this);
        VstAlq_Lst.btnAlquiler_Devolucion.addActionListener(this);
        VstAlq_Lst.jbtnReiniciar.addActionListener(this);

        CargarTablaAlquileres();

        VstAlq_Lst.tblAlquileres.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblTablaDeHerramientasMouseClicked(evt);
            }
        });
    }

    private void CargarTablaAlquileres() {
        cruda = new CRUDAlquiler();
        cruda.Alquiler_Lista(VstAlq_Lst.tblAlquileres, VstAlq_Lst.lblAlquiler_Nro);
        VstAlq_Lst.setVisible(true);
    }

    private void jtblTablaDeHerramientasMouseClicked(java.awt.event.MouseEvent evt) {
        //indice de la fila
        int indiceDeFila = VstAlq_Lst.tblAlquileres.getSelectedRow();
        //obtengo el valor del ID que está en la columna 0 de la fila
        idHerramientaEnTabla = (int) VstAlq_Lst.tblAlquileres.getValueAt(indiceDeFila, 0);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // REGISTRAR DEVOLUCION  ---------------------------------------------------------------------------------
        if (e.getSource() == VstAlq_Lst.btnAlquiler_Devolucion) {
//            alq = cruda.ConsultarRegistroHerramienta(idHerramientaEnTabla);
//            if (alq == null) {
//                Mensajes.M1("El ID " + idHerramientaEnTabla + " no existe en la tabla Herramienta.");
//            } else {
//                Mensajes.M1("ID Herramienta:           " + alq.getID()
//                        + "<br>Nombre:         " + alq.getNombre()
//                        + "<br>Nro.Serie:      " + alq.getNroSerie()
//                        + "<br>Precio:         " + alq.getImp_PrecioAlquiler());
//            }
        }
        //------------------------------------------------------------------------------------------------------
        
        
        // ACTUALIZAR LISTA -------------------------------------------------------------------------------------
        if (e.getSource() == VstAlq_Lst.jbtnReiniciar) {
            CargarTablaAlquileres();
        }
        //------------------------------------------------------------------------------------------------------

        
        // NUEVO ALQUILER ---------------------------------------------------------------------------------------
        if (e.getSource() == VstAlq_Lst.btnAlquiler_Nvo) {
            VAql = new VstAlquiler();
            CAlq_Nvo = new CtrlAlquiler_Nuevo(VAql);
            CargarTablaAlquileres();
        }
        //------------------------------------------------------------------------------------------------------
        
                    

        // BUSCAR ------------------------------------------------------------------------------------------------
        if (e.getSource() == VstAlq_Lst.btnAlquiler_Buscar) {
            if (VstAlq_Lst.cmbEstadoAlquiler.getSelectedItem().toString() == "-") {
                Mensajes.M1("Ningun tipo seleccionado.");
            } else {
                String tipo = VstAlq_Lst.cmbEstadoAlquiler.getSelectedItem().toString();
                //cruda.MostrarHerramientasEnTablaSegunElTipo(VstAlq_Lst.tblAlquileres, VstAlq_Lst.lblAlquiler_Nro, tipo);
            }
        }
        //--------------------------------------------------------------------------------------------------------
    }
}
