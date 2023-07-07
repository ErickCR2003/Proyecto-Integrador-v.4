package Controlador;

import DAO.CRUDautores;
import Formatos.FormatoAutores;
import Formatos.Mensajes;
import Modelo.Autor;
import Vista_Jefe1.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador_Editar_Autor implements ActionListener {

    EditarAutor vista;
    Administrar_Autores vista2;
    CRUDautores cruda;
    Autor aut;
    Controlador_Administrar_Autores controladorAdministrarAutores;

    public Controlador_Editar_Autor(EditarAutor JEA, Controlador_Administrar_Autores CAA) {
        vista = JEA;
        controladorAdministrarAutores = CAA;
        vista2 = controladorAdministrarAutores.vistaAutores;
        vista.jbtnActualizarAutor.addActionListener(this);
        cruda = new CRUDautores();
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);

        int id = Integer.parseInt(vista2.jtxtBuscarPorID_Autores.getText());
        aut = cruda.ConsultarRegistroAutor(id);

        vista.jtxtEditarNombreAutor.setText(aut.getNombre());
        vista.jcbxEstadoAutor.setSelectedItem(aut.getEstado());
        vista.jcbxDescuento.setSelectedItem(aut.getDescuento());
        vista.jtxtPorcentajeDescuento.setText(String.valueOf(aut.getPorcentajeDescuento()));

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (vista.jcbxDescuento.getSelectedIndex() == 0 && Double.parseDouble(vista.jtxtPorcentajeDescuento.getText()) <= 0) {
            Mensajes.M1("El descuento no puede ser negativo o cero.");
        } else if (vista.jcbxDescuento.getSelectedIndex() == 1 && Double.parseDouble(vista.jtxtPorcentajeDescuento.getText()) != 0) {
            vista.jtxtPorcentajeDescuento.setText("0");
        } else if (vista.jtxtEditarNombreAutor.getText().isEmpty()) {
            Mensajes.M1("Complete el campo de nombre.");
        } else {
            if (e.getSource() == vista.jbtnActualizarAutor) {
                aut = FormatoAutores.EditarAutor(vista);
                cruda = new CRUDautores();
                cruda.ActualizarRegistroAutor(Integer.parseInt(vista2.jtxtBuscarPorID_Autores.getText()), aut);
                controladorAdministrarAutores.ActualizarFormulario();
            }
        }
    }
}
