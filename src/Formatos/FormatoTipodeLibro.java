package Formatos;

import Modelo.TipoLibro;
import Vista_Jefe1.AgregarTipoLibro;
import Vista_Jefe1.EditarTipoLibro;

public class FormatoTipodeLibro {

    public static TipoLibro EditarTipoLibro(EditarTipoLibro EE) {
        TipoLibro tipo = new TipoLibro();
        tipo.setNombreTipo(EE.jtxtEditarTipoLibro.getText());
        tipo.setEstado(EE.jcbxEstadoTipoLibro.getSelectedItem().toString());
        tipo.setDescuento(EE.jcbxDescuentoEditar.getSelectedIndex());
        tipo.setPorcentajeDescuento(Double.parseDouble(EE.jtxtPorcentajeDescuentoEditar.getText()));
        return tipo;
    }

    public static TipoLibro LeerTipoDeLibro(AgregarTipoLibro f1) {
        TipoLibro tipo = new TipoLibro();
        tipo.setNombreTipo(f1.jtxtNombreTipoLibro.getText());
        tipo.setDescuento(f1.jcbxDescuentoTpl.getSelectedIndex());
        tipo.setPorcentajeDescuento(Double.parseDouble(f1.jtxtPorcentajeDescuentoTpl.getText()));
        return tipo;
    }

    public static void LimpiarEntradas(AgregarTipoLibro AED) {
        AED.jtxtNombreTipoLibro.setText("");
        AED.jcbxDescuentoTpl.setSelectedIndex(0);
        AED.jtxtPorcentajeDescuentoTpl.setText("");
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
