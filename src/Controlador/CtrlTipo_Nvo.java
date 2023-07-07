package Controlador;

import DAO.CRUDtipos;
import Formatos.FormatoTipos;
import Formatos.Mensajes;
import Modelo.TipoHerramienta;
import Vst.Tipo.VstTipo_Nvo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrlTipo_Nvo implements ActionListener {

    VstTipo_Nvo vista;
    TipoHerramienta edi;
    CRUDtipos crude;
    CtrlTipo_Lista controladorAdmEditorial;

    public CtrlTipo_Nvo(VstTipo_Nvo XVTipoN, CtrlTipo_Lista XCTipoL) {

        vista = XVTipoN;
        vista.jbtnAgregarEditorial.addActionListener(this);
        controladorAdmEditorial = XCTipoL;
        crude = new CRUDtipos();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
      
        if (vista.txtNombre.getText().isEmpty()) {
            Mensajes.M1("Complete el campo del nombre");
        } else if (vista.txtDescripcion.getText().isEmpty()) {
            Mensajes.M1("Complete el campo de la descripción.");
        } else {
            if (e.getSource() == vista.jbtnAgregarEditorial) {
                edi = FormatoTipos.LeerEditorial(vista);
                crude = new CRUDtipos();
                crude.InsertarRegistroTipo(edi);
                FormatoTipos.LimpiarEntradas(vista);
                controladorAdmEditorial.ActualizarFormulario();
            }
        }
    }
}
