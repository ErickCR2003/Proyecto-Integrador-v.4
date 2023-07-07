package Formatos;

import Modelo.Editorial;
import Vista_Jefe1.AgregarEditorial;
import Vista_Jefe1.EditarEditorial;

public class FormatoEditoriales {

    public static Editorial EditarEditorial(EditarEditorial EE) {
        Editorial edi = new Editorial();
        edi.setNombre(EE.jtxtEditarNombreEditorial.getText());
        edi.setEstado(EE.jcbxEstadoEditorial.getSelectedItem().toString());
        edi.setDescuento(EE.jcbxDescuentoEditar.getSelectedIndex());
        edi.setPorcentajeDescuento(Double.parseDouble(EE.jtxtPorcentajeDescuentoEditar.getText()));
        return edi;
    }

    public static Editorial LeerEditorial(AgregarEditorial f1) {
        Editorial edi = new Editorial();
        edi.setNombre(f1.jtxtNombreEditorial.getText());
        edi.setDescuento(f1.jcbxDescuento.getSelectedIndex());
        edi.setPorcentajeDescuento(Double.parseDouble(f1.jtxtPorcentajeDescuento.getText()));
        return edi;
    }

    public static void LimpiarEntradas(AgregarEditorial AED) {
        AED.jtxtNombreEditorial.setText("");
        AED.jcbxDescuento.setSelectedIndex(0);
        AED.jtxtPorcentajeDescuento.setText("");
    }

    public static String DeIntAString(int num) {
        String valorString = null;
        if (num == 0) {
            valorString = "VERDADERO";
        } else {
            valorString = "FALSO";
        }
        return valorString;
    }

}
