package Controlador;

import DAO.CRUDeditoriales;
import Formatos.FormatoEditoriales;
import Formatos.Mensajes;
import Modelo.Editorial;
import Vista_Jefe1.AgregarEditorial;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador_Agregar_Editorial implements ActionListener {

    AgregarEditorial vista;
    Editorial edi;
    CRUDeditoriales crude;
    Controlador_Administrar_Editorial controladorAdmEditorial;

    public Controlador_Agregar_Editorial(AgregarEditorial AEDIT, Controlador_Administrar_Editorial CAED) {

        vista = AEDIT;
        vista.jbtnAgregarEditorial.addActionListener(this);
        controladorAdmEditorial = CAED;
        crude = new CRUDeditoriales();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (vista.jcbxDescuento.getSelectedIndex()==0 && Double.parseDouble(vista.jtxtPorcentajeDescuento.getText())<=0){
            Mensajes.M1("El descuento no puede ser negativo o cero.");
        } else if (vista.jcbxDescuento.getSelectedIndex()==1 && Double.parseDouble(vista.jtxtPorcentajeDescuento.getText())!=0){
            vista.jtxtPorcentajeDescuento.setText("0");
        } else if (vista.jtxtNombreEditorial.getText().isEmpty()) {
            Mensajes.M1("Complete el campo de nombre.");
        } else {
            if (e.getSource() == vista.jbtnAgregarEditorial) {
                edi = FormatoEditoriales.LeerEditorial(vista);
                crude = new CRUDeditoriales();
                crude.InsertarRegistroEdi(edi);
                FormatoEditoriales.LimpiarEntradas(vista);
                controladorAdmEditorial.ActualizarFormulario();
            }
        }
    }
}
