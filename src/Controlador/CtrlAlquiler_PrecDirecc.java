package Controlador;

import Formatos.Mensajes;
import Principal.Main;
import Vst.Alquiler.VstAlquiler_Confirmar;
import Vst.Alquiler.VstAlquiler;
import Vst.Alquiler.VstAlquiler_PrecDirec;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrlAlquiler_PrecDirecc implements ActionListener {

    VstAlquiler_PrecDirec VAql_PD;
    VstAlquiler VAql_E;

    public static VstAlquiler_Confirmar VAlq_Conf;
    public static CtrlAlquiler_Confirmar CAql_Conf;

    public CtrlAlquiler_PrecDirecc(VstAlquiler_PrecDirec XVAlqPD, VstAlquiler XVAlqE) {
        VAql_PD = XVAlqPD;
        VAql_E = XVAlqE;

        VAql_PD.jlblDireccion.setText("DIRECCION: " + VAql_E.jtxtDirecciónObra.getText());
        VAql_PD.jbtnCancelar.addActionListener(this);
        VAql_PD.jbtnConfirmar.addActionListener(this);
        VAql_PD.jtxtprecio.setText("0.0");
        VAql_PD.setVisible(true);
        VAql_PD.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == VAql_PD.jbtnCancelar) {
            VAql_PD.dispose();
        }

//        if (e.getSource() == VAql_PD.jbtnConfirmar) {
//            if (Double.parseDouble(VAql_PD.jtxtprecio.getText()) <= 0) {
//                Mensajes.M1("EL PRECIO TIENE QUE SER MAYOR A 0");
//            } else {
//                VAlq_Conf = new VstAlquiler_Confirmar();
//                CAql_Conf = new CtrlAlquiler_Confirmar(VAlq_Conf, VAql_PD, VAql_E);
//                VAql_PD.dispose();
//            }
//        }
    }

}
