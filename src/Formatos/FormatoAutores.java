package Formatos;

import Modelo.Autor;
import Vista_Jefe1.AgregarAutor;
import Vista_Jefe1.EditarAutor;

public class FormatoAutores {

    public static Autor LeerAutor(AgregarAutor f1) {
        Autor aut = new Autor();
        aut.setNombre(f1.jtxtNombreAutor.getText());
        aut.setDescuento(f1.jcbxDescuento.getSelectedItem().toString());
        aut.setPorcentajeDescuento(Double.parseDouble(f1.jtxtPorcentajeDescuento.getText()));
        return aut;
    }

    public static void LimpiarEntradas(AgregarAutor AU) {
        AU.jtxtNombreAutor.setText("");
        AU.jcbxDescuento.setSelectedIndex(0);
        AU.jtxtPorcentajeDescuento.setText("");
    }

    public static Autor EditarAutor(EditarAutor EA) {
        Autor aut = new Autor();
        aut.setNombre(EA.jtxtEditarNombreAutor.getText());
        aut.setEstado(EA.jcbxEstadoAutor.getSelectedItem().toString());
        aut.setDescuento(EA.jcbxDescuento.getSelectedItem().toString());
        aut.setPorcentajeDescuento(Double.parseDouble(EA.jtxtPorcentajeDescuento.getText()));
        return aut;
    }
}
