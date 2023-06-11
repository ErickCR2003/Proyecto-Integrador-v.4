package Controlador;

import DAO.*;
import Formatos.*;
import Modelo.Herramienta;
import Vst.Herramienta.VstHerramienta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrlHerramienta_Nvo implements ActionListener {

    VstHerramienta vista;
    CRUDtipos crude;
    CRUDherramientas crudl;
    CtrlHerramienta_Lista controladorAL;
    Herramienta her;

    public CtrlHerramienta_Nvo(VstHerramienta ALN, CtrlHerramienta_Lista CAL) {

        controladorAL = CAL;
        vista = ALN;
        crude = new CRUDtipos();
        crudl = new CRUDherramientas();
        vista.btnCancelar.addActionListener(this);
        vista.btnLimpiarDatos.addActionListener(this);
        vista.btnGuardar.addActionListener(this);
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);

        for (String editoriales : crude.RegistrarTiposComboBox()) {
            vista.cmbTipoHerramienta.addItem(editoriales);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnCancelar) {
            vista.dispose();
        }

        if (e.getSource() == vista.btnLimpiarDatos) {
            Formatos.FormatoHerramienta.LimpiarEntradasLN(vista);
        }

        if (e.getSource() == vista.btnGuardar) {
            if (vista.cmbTipoHerramienta.getSelectedItem() == null
                    || vista.txtNroSerie.getText() == null
                    || vista.txtNombre.getText() == null
                    || vista.txtDescrip.getText() == null
                    || vista.jcbxEstado.getSelectedItem() == null
                    || vista.txtPrecXdia.getText() == null
                    || vista.txtPeso.getText() == null
                    || vista.txtAnioFabrica.getText() == null
                    || vista.txtFecAdquisicion.getDate() == null
                    || vista.txtNroAlquileres.getText() == null
                    || vista.txtImpValorRef.getText() == null) {
                Mensajes.M1("Complete todos los campos");
            } else if (Double.parseDouble(vista.txtPrecXdia.getText()) < 0) {
                Mensajes.M1("El precio no puede ser negativo");
            } else {
                her = Formatos.FormatoHerramienta.LeerHerramienta(vista);
                crudl.InsertarRegistroHerramienta(her);
                Formatos.FormatoHerramienta.LimpiarEntradasLN(vista);
                controladorAL.ActualizarTablaHerramientas();
            }
        }

    }
}
