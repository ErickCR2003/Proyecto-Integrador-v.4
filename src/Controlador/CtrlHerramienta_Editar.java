package Controlador;

import DAO.CRUDherramientas;
import DAO.CRUDtipos;
import Formatos.FormatoHerramienta;
import Formatos.Mensajes;
import Modelo.Herramienta;
import Vst.Herramienta.VstHerramienta_Editar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrlHerramienta_Editar implements ActionListener {

    VstHerramienta_Editar vista;
    CtrlHerramienta_Lista controladorAL;
    Herramienta her;
    CRUDtipos crudt;
    CRUDherramientas crudh;

    public CtrlHerramienta_Editar(VstHerramienta_Editar EL, CtrlHerramienta_Lista CAL) {

        controladorAL = CAL;
        vista = EL;
        crudt = new CRUDtipos();
        crudh = new CRUDherramientas();
        vista.btnGuardar.addActionListener(this);
        vista.btnCancelar.addActionListener(this);
        vista.btnLimpiarDatos.addActionListener(this);
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);

        for (String tipoH : crudt.RegistrarTiposComboBox()) {
            vista.cmbTipoHerramienta.addItem(tipoH);
        }

        her = crudh.ConsultarRegistroHerramienta(controladorAL.idHerramientaEnTabla);
        
        vista.cmbTipoHerramienta.setSelectedIndex(her.getIdTipo()-1);
        vista.txtNroSerie.setText(her.getNroSerie());
        vista.txtNombre.setText(her.getNombre());
        vista.txtDescrip.setText(her.getDescripcion());
        vista.jcbxEstado.setSelectedItem(her.getEstado());
        vista.txtPrecXdia.setText(String.valueOf(her.getImp_PrecioAlquiler()));
        vista.txtPeso.setText(String.valueOf( her.getPeso()));
        vista.txtAnioFabrica.setText(String.valueOf(her.getAnioFabricacion()));
        vista.txtFecAdquisicion.setDate(java.sql.Date.valueOf(her.getFecAdquisicion()));
        vista.txtNroAlquileres.setText(String.valueOf(her.getNroAlquileres()));
        vista.txtImpValorRef.setText(String.valueOf(her.getImp_ValorReferencial()));
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnCancelar) {
            vista.dispose();
        }

        if (e.getSource() == vista.btnLimpiarDatos) {
            Formatos.FormatoHerramienta.LimpiarEntradas(vista);
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
                crudh.ActualizarRegistroHerramienta(controladorAL.idHerramientaEnTabla, her);
                controladorAL.ActualizarTablaHerramientas();
                vista.dispose();
            }
        }
    }
}
