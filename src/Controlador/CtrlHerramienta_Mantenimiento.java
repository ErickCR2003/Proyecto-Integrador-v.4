package Controlador;

import DAO.CRUDherramientas;
import DAO.CRUDmantenimiento;
import DAO.CRUDtipos;
import Formatos.Mensajes;
import Modelo.Herramienta;
import Modelo.OrdenMantenimiento;
import Principal.Main;
import Vst.Herramienta.VstHerramientaMantenimiento;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrlHerramienta_Mantenimiento implements ActionListener {

    VstHerramientaMantenimiento vista;
    CRUDtipos crude;
    CRUDherramientas crudh;
    CtrlHerramienta_Lista controladorAL;
    Herramienta her;
    OrdenMantenimiento orMan;
    CRUDmantenimiento crudm;

    public CtrlHerramienta_Mantenimiento(VstHerramientaMantenimiento ALN, CtrlHerramienta_Lista CAL) {

        controladorAL = CAL;
        vista = ALN;
        crude = new CRUDtipos();
        crudh = new CRUDherramientas();
        crudm = new CRUDmantenimiento();
        vista.btnCancelar.addActionListener(this);
        vista.btnGuardar.addActionListener(this);
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);

        for (String editoriales : crude.RegistrarTiposComboBox()) {
            vista.jcbxTipo.addItem(editoriales);
        }

        her = crudh.ConsultarRegistroHerramienta(controladorAL.idHerramientaEnTabla);

        vista.jcbxTipo.setSelectedIndex(her.getIdTipo() - 1);
        vista.jtxtIDHerramienta.setText(String.valueOf(her.getID()));
        vista.jtxtNombreHerramienta.setText(her.getNombre());
        vista.jtxtNombreEmp.setText(Main.UsrActual.getNombre());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnCancelar) {
            vista.dispose();
        }

        if (e.getSource() == vista.btnGuardar) {
            if (vista.jcbxEstado.getSelectedItem() == null
                    || vista.jcbxTipo.getSelectedItem() == null
                    || vista.jtxtDescProblema.getText() == null
                    || vista.jtxtDescReparacion.getText() == null
                    || vista.jtxtIDHerramienta.getText() == null
                    || vista.jtxtNombreEmp.getText() == null
                    || vista.jtxtNombreHerramienta.getText() == null
                    || vista.jdtcFechaCierre.getDate() == null
                    || vista.jdtcFechaCreacion.getDate() == null
                    || vista.jspnCostoReparacion.getValue() == null) {
                Mensajes.M1("Complete todos los campos");
            } else if (Integer.parseInt(vista.jspnCostoReparacion.getValue().toString()) < 0) {
                Mensajes.M1("El costo no puede ser negativo");
            } else if (vista.jdtcFechaCreacion.getDate().compareTo(vista.jdtcFechaCierre.getDate()) > 0) {
                Mensajes.M1("La fecha de creacion no puede ser mayor a la fecha de cierre");
            } else {
                //actualizamos el registro de la herramienta
                her.setEstado("EN MANTENIMIENTO");
                crudh.ActualizarRegistroHerramienta(her.getID(), her);
                //Leemos el objeto OrdenMantenimiento
                orMan = Formatos.FormatoMantenimiento.LeerOrdenMantenimiento(vista);
                //insertamos el objeto en la BD
                crudm.InsertarRegistroOrdenMantenimiento(orMan);
                //limpiamos
                Formatos.FormatoMantenimiento.LimpiarEntradasLN(vista);
                //actualizamos la tabla
                vista.dispose();
                controladorAL.ActualizarTablaHerramientas();

            }
        }
    }

}
