package Controlador;

import DAO.CRUDeditoriales;
import Formatos.Mensajes;
import Modelo.Editorial;
import Vista_Jefe1.Administrar_Editorial;
import Vista_Jefe1.EditarEditorial;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador_Editar_Editorial implements ActionListener {

    EditarEditorial vista;
    Administrar_Editorial vista2;
    CRUDeditoriales crude;
    Editorial edi;
    Controlador_Administrar_Editorial controladorAdministrarEditorial;

    public Controlador_Editar_Editorial(EditarEditorial EEDIT, Controlador_Administrar_Editorial CAE) {
        controladorAdministrarEditorial = CAE;
        vista2 = controladorAdministrarEditorial.vistaEditorial;
        vista = EEDIT;
        crude = new CRUDeditoriales();
        vista.jbtnActualizarEditorial.addActionListener(this);
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);

        int id = Integer.parseInt(vista2.jtxtBuscarPorIDEditorial.getText());
        edi = crude.ConsultarRegistroEditorial(id);

        vista.jtxtEditarNombreEditorial.setText(edi.getNombre());
        vista.jcbxEstadoEditorial.setSelectedItem(edi.getEstado());
        vista.jcbxDescuentoEditar.setSelectedIndex(edi.getDescuento());
        vista.jtxtPorcentajeDescuentoEditar.setText(edi.getPorcentajeDescuento().toString());

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (vista.jcbxDescuentoEditar.getSelectedIndex() == 0 && Double.parseDouble(vista.jtxtPorcentajeDescuentoEditar.getText()) <= 0) {
            Mensajes.M1("El descuento no puede ser negativo o cero.");
        } else if (vista.jcbxDescuentoEditar.getSelectedIndex() == 1 && Double.parseDouble(vista.jtxtPorcentajeDescuentoEditar.getText()) != 0) {
            vista.jtxtPorcentajeDescuentoEditar.setText("0");
        } else if (vista.jtxtEditarNombreEditorial.getText().isEmpty()) {
            Mensajes.M1("Complete el campo de nombre.");
        } else {
            if (e.getSource() == vista.jbtnActualizarEditorial) {
                edi = Formatos.FormatoEditoriales.EditarEditorial(vista);
                crude = new CRUDeditoriales();
                crude.ActualizarRegistroEditorial(Integer.parseInt(vista2.jtxtBuscarPorIDEditorial.getText()), edi);
                controladorAdministrarEditorial.ActualizarFormulario();
            }
        }

    }
}
