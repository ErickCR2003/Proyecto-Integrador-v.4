package Controlador;

import DAO.CRUDtipolibro1;
import Formatos.Mensajes;
import Modelo.TipoLibro;
import Vista_Jefe1.Administrar_Tipo_Libro;
import Vista_Jefe1.EditarTipoLibro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador_EditarTipoLibro implements ActionListener {

    EditarTipoLibro vista;
    Administrar_Tipo_Libro vista2;
    TipoLibro tip;
    CRUDtipolibro1 crudt;
    Controlador_Administrar_Tipo_Libro controladorTipoLibro;

    public Controlador_EditarTipoLibro(EditarTipoLibro ET, Controlador_Administrar_Tipo_Libro ADT) {
        vista = ET;
        controladorTipoLibro = ADT;
        vista2 = controladorTipoLibro.vistaTipoLibro;
        vista.jbtnActualizarTipoLibro.addActionListener(this);
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        crudt = new CRUDtipolibro1();

        int id = Integer.parseInt(vista2.jtxtBuscarPorCodigoTipoLibro.getText());
        tip = crudt.ConsultarRegistroTipoLibro(id);

        vista.jtxtEditarTipoLibro.setText(tip.getNombreTipo());
        vista.jcbxEstadoTipoLibro.setSelectedItem(tip.getEstado());
        vista.jcbxDescuentoEditar.setSelectedIndex(tip.getDescuento());
        vista.jtxtPorcentajeDescuentoEditar.setText(tip.getPorcentajeDescuento().toString());
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (vista.jcbxDescuentoEditar.getSelectedIndex() == 0 && Double.parseDouble(vista.jtxtPorcentajeDescuentoEditar.getText()) <= 0) {
            Mensajes.M1("El descuento no puede ser negativo o cero.");
        } else if (vista.jcbxDescuentoEditar.getSelectedIndex() == 1 && Double.parseDouble(vista.jtxtPorcentajeDescuentoEditar.getText()) != 0) {
            vista.jtxtPorcentajeDescuentoEditar.setText("0");
        } else if (vista.jtxtEditarTipoLibro.getText().isEmpty()) {
            Mensajes.M1("Complete el campo de nombre.");
        } else {
            if (e.getSource() == vista.jbtnActualizarTipoLibro) {
                tip = Formatos.FormatoTipodeLibro.EditarTipoLibro(vista);
                crudt = new CRUDtipolibro1();
                crudt.ActualizarRegistroTipoLibro(Integer.parseInt(vista2.jtxtBuscarPorCodigoTipoLibro.getText()), tip);
                controladorTipoLibro.ActualizarFormulario();
            }
        }
    }
}
