package Controlador;

import DAO.CRUDtipos;
import Formatos.Mensajes;
import Modelo.TipoHerramienta;
import Vst.Tipo.VstTipo_Lista;
import Vst.Tipo.VstTipo_Editar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrlTipo_Editar implements ActionListener {

    VstTipo_Editar vista;
    VstTipo_Lista vista2;
    CRUDtipos crude;
    TipoHerramienta edi;
    //VstTipo_Editar CTipoE;

    public CtrlTipo_Editar(VstTipo_Editar XVTipo, VstTipo_Lista VCTipoL) {
        //CTipoE = XVTipo;
        vista2 = VCTipoL;
        vista = XVTipo;
        crude = new CRUDtipos();
        vista.jbtnActualizarEditorial.addActionListener(this);
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);

        int id = Integer.parseInt(vista2.jtxtBuscarPorID.getText());
        edi = crude.ConsultarRegistroTipo(id);
        
        vista.txtNombre.setText(edi.getNombreTipo());
        vista.txtDescripcion.setText(edi.getDescripcion());
  
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (vista.txtNombre.getText().isEmpty()){
             Mensajes.M1("Complete el campo de nombre.");
        } else if (vista.txtDescripcion.getText().isEmpty()) {
            Mensajes.M1("Complete el campo de la descripción");
        } else {
            if (e.getSource() == vista.jbtnActualizarEditorial) {
                edi = Formatos.FormatoTipos.EditarTipos(vista);
                crude = new CRUDtipos();
                crude.ActualizarRegistroTipo(Integer.parseInt(vista2.jtxtBuscarPorID.getText()), edi);                
            }
        }

    }
}
