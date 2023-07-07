package Controlador;

import DAO.CRUDautores;
import Formatos.FormatoAutores;
import Formatos.Mensajes;
import Modelo.Autor;
import Vista_Jefe1.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador_Agregar_Autor implements ActionListener {

    AgregarAutor vista;
    CRUDautores cruda;
    Autor aut;
    Controlador_Administrar_Autores controladorAdmAutores;
    Administrar_Autores vista2;

    public Controlador_Agregar_Autor(AgregarAutor JAE, Controlador_Administrar_Autores CAA) {
        vista = JAE;
        controladorAdmAutores = CAA;
        vista2 = controladorAdmAutores.vistaAutores;
        vista.jbtnAgregarAutor.addActionListener(this);
        cruda = new CRUDautores();
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (vista.jcbxDescuento.getSelectedIndex() == 0 && Double.parseDouble(vista.jtxtPorcentajeDescuento.getText()) <= 0) {
            Mensajes.M1("El descuento no puede ser negativo o cero.");
        } else if (vista.jcbxDescuento.getSelectedIndex() == 1 && (Double.parseDouble(vista.jtxtPorcentajeDescuento.getText()) != 0 || vista.jtxtPorcentajeDescuento.getText().isEmpty())) {
            vista.jtxtPorcentajeDescuento.setText("0");
        } else if (vista.jtxtNombreAutor.getText().isEmpty()) {
            Mensajes.M1("Completen los campos");
        } else {
            if (e.getSource() == vista.jbtnAgregarAutor) {
                aut = FormatoAutores.LeerAutor(vista);
                cruda = new CRUDautores();
                cruda.InsertarRegistroAutor(aut);
                Formatos.FormatoAutores.LimpiarEntradas(vista);
                controladorAdmAutores.ActualizarFormulario();
            }
        }
    }
}
