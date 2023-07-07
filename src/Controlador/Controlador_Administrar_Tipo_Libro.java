package Controlador;

import DAO.CRUDtipolibro1;
import Formatos.*;
import Modelo.TipoLibro;
import Principal.Main;
import Vista_Jefe1.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador_Administrar_Tipo_Libro implements ActionListener {

    Administrar_Tipo_Libro vistaTipoLibro;
    CRUDtipolibro1 crudt;
    TipoLibro tip;

    public Controlador_Administrar_Tipo_Libro(Administrar_Tipo_Libro VATL) {

        vistaTipoLibro = VATL;
        vistaTipoLibro.jbtnAgregarTipoLibro.addActionListener(this);
        vistaTipoLibro.jbtnEditarTipoLibro.addActionListener(this);
        vistaTipoLibro.jbtnBuscarTipoLibro.addActionListener(this);
        crudt = new CRUDtipolibro1();
        crudt.MostrarTipoLibroEnTabla(vistaTipoLibro.jtblDatos_Tipo_Libro, vistaTipoLibro.jlblRegistros_Tipo_Libro);
        VATL.setVisible(true);
    }
    
    public void ActualizarFormulario(){
         crudt=new CRUDtipolibro1();
        crudt.MostrarTipoLibroEnTabla(vistaTipoLibro.jtblDatos_Tipo_Libro,vistaTipoLibro.jlblRegistros_Tipo_Libro);
        vistaTipoLibro.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaTipoLibro.jbtnAgregarTipoLibro) {
            Main.VJA = new AgregarTipoLibro();
            Main.CAT = new Controlador_AgregarTipoLibro(Main.VJA,this);
        }
        if (e.getSource() == vistaTipoLibro.jbtnEditarTipoLibro) {
            if (vistaTipoLibro.jtxtBuscarPorCodigoTipoLibro.getText().length() == 0) {
                Mensajes.M1("El campo esta vacio");
            } else {
                int id = Integer.parseInt(vistaTipoLibro.jtxtBuscarPorCodigoTipoLibro.getText());
                crudt = new CRUDtipolibro1();
                tip = crudt.ConsultarRegistroTipoLibro(id);
                if (tip == null) {
                    Mensajes.M1("El ID " + id + " no existe en la tabla TipoLibro.");
                } else {
                    Main.VJE = new EditarTipoLibro();
                    Main.CET = new Controlador_EditarTipoLibro(Main.VJE, this);

                }
            }
            
        }
        if (e.getSource() == vistaTipoLibro.jbtnBuscarTipoLibro) {
            if (vistaTipoLibro.jtxtBuscarPorCodigoTipoLibro.getText().length() == 0) {
                Mensajes.M1("El campo esta vacio");
            } else {
                int id = Integer.parseInt(vistaTipoLibro.jtxtBuscarPorCodigoTipoLibro.getText());
                crudt = new CRUDtipolibro1();
                tip = crudt.ConsultarRegistroTipoLibro(id);
                FormatoTipodeLibro formatoTpl = new FormatoTipodeLibro();
                String descMessage = formatoTpl.DeIntAString(tip.getDescuento());
                if (tip == null) {
                    Mensajes.M1("El ID " + id + " no existe en la tabla TipoLibro.");
                } else {
                    Mensajes.M1("ID:                     " + tip.getIdlibro()
                            +   "<br>Nombres:            " + tip.getNombreTipo()
                            +   "<br>Estado:             " + tip.getEstado()
                            +   "<br>Descuento:             " + descMessage
                            +   "<br>Porcentaje Descuento:  " + tip.getPorcentajeDescuento());
                }
            }
        }
    }
}
