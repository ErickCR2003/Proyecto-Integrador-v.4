/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.CRUDmantenimiento;
import Formatos.Mensajes;
import Modelo.OrdenMantenimiento;
import Vst.Mantenimiento.VstMantenimiento_Lista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrlMantenimiento_Lista implements ActionListener {

    VstMantenimiento_Lista vista_Lst;
    CRUDmantenimiento crudm;
    int idOrdenEnTabla = 0;
    OrdenMantenimiento orM;

    public CtrlMantenimiento_Lista(VstMantenimiento_Lista AL) {

        vista_Lst = AL;
        vista_Lst.setVisible(true);
        crudm = new CRUDmantenimiento();
        crudm = new CRUDmantenimiento();
        vista_Lst.jbtnInfoOrden.addActionListener(this);
        crudm.MostrarOrdenesEnTabla(vista_Lst.jtblTablaDeMantenimientos, vista_Lst.jlblNumeroDeOrdenes);
        
        vista_Lst.jtblTablaDeMantenimientos.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblTablaDeHerramientasMouseClicked(evt);
            }
        });
    }
    
    public void ActualizarTablaHerramientas() {
        crudm = new CRUDmantenimiento();
        crudm.MostrarOrdenesEnTabla(vista_Lst.jtblTablaDeMantenimientos, vista_Lst.jlblNumeroDeOrdenes);
        vista_Lst.setVisible(true);
    }

    private void jtblTablaDeHerramientasMouseClicked(java.awt.event.MouseEvent evt) {
        //indice de la fila
        int indiceDeFila = vista_Lst.jtblTablaDeMantenimientos.getSelectedRow();
        //obtengo el valor del ID que está en la columna 0 de la fila
        idOrdenEnTabla = (int) vista_Lst.jtblTablaDeMantenimientos.getValueAt(indiceDeFila, 0);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == vista_Lst.jbtnInfoOrden) {
            orM = crudm.ConsultarRegistroMantenimiento(idOrdenEnTabla);
            if (orM == null) {
                Mensajes.M1("El ID " + idOrdenEnTabla + " no existe en la tabla Herramienta.");
            } else {
                Mensajes.M1("ID Orden:           " + orM.getID()
                        + "<br>Herramienta:         " + orM.getHer().getNombre()
                        + "<br>Empleado:         " + orM.getEmp().getNombre()
                        + "<br>Problema:      " + orM.getProblema()
                        + "<br>Reparacion:         " + orM.getReparacion());
            }
        }
    }

}
