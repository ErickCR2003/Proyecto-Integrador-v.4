package Controlador;

import Vst.Tipo.VstTipo_Lista;
import Vst.Tipo.VstTipo_Nvo;
import Vst.Tipo.VstTipo_Editar;
import DAO.CRUDtipos;
import Formatos.*;
import Modelo.TipoHerramienta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrlTipo_Lista implements ActionListener {

    VstTipo_Lista VTipoL;
    TipoHerramienta edi;
    CRUDtipos crude;
    
    public static Vst.Tipo.VstTipo_Nvo VTipo_Nvo;
    public static Controlador.CtrlTipo_Nvo CTipo_Nvo;

    public static Vst.Tipo.VstTipo_Editar VTipo_Editar;
    public static Controlador.CtrlTipo_Editar CTipo_Editar;

    public CtrlTipo_Lista(VstTipo_Lista XVstTipo) {

        VTipoL = XVstTipo;
        crude = new CRUDtipos();
        VTipoL.jbtnAgregarTipo.addActionListener(this);
        VTipoL.jbtnEditarTipo.addActionListener(this);
        VTipoL.jbtnBuscarTipo.addActionListener(this);
        crude = new CRUDtipos();
        crude.MostrarTipoEnTabla(VTipoL.jtblDatos, VTipoL.jlblRegistros);
        VTipoL.setVisible(true);
    }

    public void ActualizarFormulario() {
        crude = new CRUDtipos();
        crude.MostrarTipoEnTabla(VTipoL.jtblDatos, VTipoL.jlblRegistros);
        VTipoL.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        //Nuevo tipo ----------------------------------------------------------------
        if (e.getSource() == VTipoL.jbtnAgregarTipo) {
            VTipo_Nvo = new VstTipo_Nvo();
            CTipo_Nvo = new CtrlTipo_Nvo(VTipo_Nvo, this);
        }
        
        //Editar tipo ---------------------------------------------------------------
        if (e.getSource() == VTipoL.jbtnEditarTipo) {
            if (VTipoL.jtxtBuscarPorID.getText().length() == 0) {
                Mensajes.M1("El campo esta vacio");
            } else {
                int id = Integer.parseInt(VTipoL.jtxtBuscarPorID.getText());
                crude = new CRUDtipos();
                edi = crude.ConsultarRegistroTipo(id);
                if (edi == null) {
                    Mensajes.M1("El ID " + id + " no existe en la tabla Editoriales.");
                } else {
                    VTipo_Editar = new VstTipo_Editar();
                    CTipo_Editar = new CtrlTipo_Editar(VTipo_Editar, VTipoL);
                }
            }
        }
        
        //Buscar tipo ----------------------------------------------------------------
        if (e.getSource() == VTipoL.jbtnBuscarTipo) {
            if (VTipoL.jtxtBuscarPorID.getText().length() == 0) {
                Mensajes.M1("El campo esta vacio");
            } else {
                int id = Integer.parseInt(VTipoL.jtxtBuscarPorID.getText());
                crude = new CRUDtipos();
                edi = crude.ConsultarRegistroTipo(id);
                FormatoTipos formatoTp = new FormatoTipos();
                if (edi == null) {
                    Mensajes.M1("El ID " + id + " no existe en la tabla Editoriales.");
                } else {
                    Mensajes.M1("ID:                        " + edi.getID()
                            + "<br>Nombres:               " + edi.getNombreTipo()
                            + "<br>Descripcion:                " + edi.getDescripcion());
                }
            }
        }
    }

}
