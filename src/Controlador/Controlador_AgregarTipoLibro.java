package Controlador;

import DAO.CRUDtipolibro1;
import Formatos.Mensajes;
import Modelo.TipoLibro;
import Vista_Jefe1.AgregarTipoLibro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador_AgregarTipoLibro implements ActionListener {

    AgregarTipoLibro vista;
    TipoLibro tli;
    CRUDtipolibro1 crudt;
    Controlador_Administrar_Tipo_Libro controladorAdministrarTipo;

    public Controlador_AgregarTipoLibro(AgregarTipoLibro AT, Controlador_Administrar_Tipo_Libro CATL) {
        vista = AT;
        controladorAdministrarTipo = CATL;
        vista.jbtnAgregarTipoLibro.addActionListener(this);
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        crudt = new CRUDtipolibro1();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (vista.jcbxDescuentoTpl.getSelectedIndex() == 0 && Double.parseDouble(vista.jtxtPorcentajeDescuentoTpl.getText()) <= 0) {
            Mensajes.M1("El descuento no puede ser negativo o cero.");
        } else if (vista.jcbxDescuentoTpl.getSelectedIndex() == 1 && Double.parseDouble(vista.jtxtPorcentajeDescuentoTpl.getText()) != 0) {
            vista.jtxtPorcentajeDescuentoTpl.setText("0");
        } else if (vista.jtxtNombreTipoLibro.getText().isEmpty()) {
            Mensajes.M1("Completen los campos");
        } else {
            if (e.getSource() == vista.jbtnAgregarTipoLibro) {
                tli = Formatos.FormatoTipodeLibro.LeerTipoDeLibro(vista);
                crudt = new CRUDtipolibro1();
                crudt.InsertarRegistroTipoLibro(tli);
                Formatos.FormatoTipodeLibro.LimpiarEntradas(vista);
                controladorAdministrarTipo.ActualizarFormulario();
            }
        }
    }
}
