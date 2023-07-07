package Controlador;

import DAO.*;
import Formatos.Mensajes;
import Modelo.Herramienta;
import Vst.Herramienta.VstHerramienta_Lista;
import Vst.Herramienta.VstHerramienta;
import Vst.Herramienta.VstHerramienta;
import Vst.Herramienta.VstHerramienta_Editar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrlHerramienta_Lista implements ActionListener {

    Herramienta her;
    CRUDherramientas crudh;
    CRUDtipos crudt;
    VstHerramienta_Lista vista_Lst;
    int idHerramientaEnTabla = 0;

    public static Vst.Herramienta.VstHerramienta VHerr_Nva;
    public static CtrlHerramienta_Nvo CHerr_Nva;

    public static Vst.Herramienta.VstHerramienta_Editar VHerr_Editar;
    public static CtrlHerramienta_Editar CHerr_Editar;

    public CtrlHerramienta_Lista(VstHerramienta_Lista AL) {
        vista_Lst = AL;
        vista_Lst.setVisible(true);
        crudt = new CRUDtipos();
        vista_Lst.jbtnAñadirHerramientaNueva.addActionListener(this);
        vista_Lst.jbtnEditarHerramienta.addActionListener(this);
        vista_Lst.jbtnBuscarHerramienta.addActionListener(this);
        vista_Lst.jbtnInformacionHerramienta.addActionListener(this);
        vista_Lst.jbtnReiniciar.addActionListener(this);

        crudh = new CRUDherramientas();
        crudh.MostrarHerramientasEnTabla(vista_Lst.jtblTablaDeHerramientas, vista_Lst.jlblNumeroDeHerramientas);
        vista_Lst.setVisible(true);

        for (String tipos : crudt.RegistrarTiposComboBox()) {
            vista_Lst.jcbxTipoHerramienta.addItem(tipos);
        }

        vista_Lst.jtblTablaDeHerramientas.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblTablaDeHerramientasMouseClicked(evt);
            }
        });
    }

    public void ActualizarTablaHerramientas() {
        crudh = new CRUDherramientas();
        crudh.MostrarHerramientasEnTabla(vista_Lst.jtblTablaDeHerramientas, vista_Lst.jlblNumeroDeHerramientas);
        vista_Lst.setVisible(true);
    }

    private void jtblTablaDeHerramientasMouseClicked(java.awt.event.MouseEvent evt) {
        //indice de la fila
        int indiceDeFila = vista_Lst.jtblTablaDeHerramientas.getSelectedRow();
        //obtengo el valor del ID que está en la columna 0 de la fila
        idHerramientaEnTabla = (int) vista_Lst.jtblTablaDeHerramientas.getValueAt(indiceDeFila, 0);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista_Lst.jbtnInformacionHerramienta) {
            her = crudh.ConsultarRegistroHerramienta(idHerramientaEnTabla);
            if (her == null) {
                Mensajes.M1("El ID " + idHerramientaEnTabla + " no existe en la tabla Herramienta.");
            } else {
                Mensajes.M1("ID Herramienta:           " + her.getID()
                        + "<br>Nombre:         " + her.getNombre()
                        + "<br>Nro.Serie:      " + her.getNroSerie()
                        + "<br>Precio:         " + her.getImp_PrecioAlquiler());
            }
        }
        
        if (e.getSource() == vista_Lst.jbtnReiniciar) {
            ActualizarTablaHerramientas();
        }

        if (e.getSource() == vista_Lst.jbtnAñadirHerramientaNueva) {
            VHerr_Nva = new VstHerramienta();
            CHerr_Nva = new CtrlHerramienta_Nvo(VHerr_Nva, this);
        }

        if (e.getSource() == vista_Lst.jbtnEditarHerramienta) {
            if (idHerramientaEnTabla == 0) {
                Mensajes.M1("Ninguna herramienta seleccionada.");
            } else {
                int id = idHerramientaEnTabla;
                her = crudh.ConsultarRegistroHerramienta(id);
                if (her == null) {
                    Mensajes.M1("El ID " + id + " no existe en la tabla Herramientas.");
                } else {
                    VHerr_Editar = new VstHerramienta_Editar();
                    CHerr_Editar = new CtrlHerramienta_Editar(VHerr_Editar, this);
                }
            }
        }

        // Cargar lista segun tipo -----------------------------------------------------------------------------------------------------------
        if (e.getSource() == vista_Lst.jbtnBuscarHerramienta) {            
            String tipo = "";                        
            if (vista_Lst.jcbxTipoHerramienta.getSelectedItem().toString() != "-") {
                tipo = vista_Lst.jcbxTipoHerramienta.getSelectedItem().toString();
            }            
            crudh.MostrarHerramientasEnTablaSegunElTipo(vista_Lst.jtblTablaDeHerramientas, vista_Lst.jlblNumeroDeHerramientas, tipo);
        }
        //-------------------------------------------------------------------------------------------------------------------------------------
        
                
        
    }
}
