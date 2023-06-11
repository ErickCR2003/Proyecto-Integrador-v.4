package Formatos;

import Modelo.TipoHerramienta;
import Vst.Tipo.VstTipo_Nvo;
import Vst.Tipo.VstTipo_Editar;

public class FormatoTipos {

    public static TipoHerramienta FormatoTipos(VstTipo_Editar EE) {
        TipoHerramienta edi = new TipoHerramienta();
        edi.setNombreTipo(EE.txtDescripcion.getText());
        edi.setDescripcion(EE.txtDescripcion.getText());
        return edi;
    }

    public static TipoHerramienta LeerEditorial(VstTipo_Nvo f1) {
        TipoHerramienta edi = new TipoHerramienta();
        edi.setNombreTipo(f1.txtNombre.getText());
        edi.setDescripcion(f1.txtDescripcion.getText());
       
        return edi;
    }
    
     public static TipoHerramienta EditarTipos(VstTipo_Editar f1) {
        TipoHerramienta edi = new TipoHerramienta();
        edi.setNombreTipo(f1.txtNombre.getText());
        edi.setDescripcion(f1.txtDescripcion.getText());
        return edi;
    }

    public static void LimpiarEntradas(VstTipo_Nvo AED) {
        AED.txtDescripcion.setText("");
        AED.txtNombre.setText("");
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
