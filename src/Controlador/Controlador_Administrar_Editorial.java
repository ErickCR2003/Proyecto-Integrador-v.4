package Controlador;

import DAO.CRUDeditoriales;
import Formatos.*;
import Modelo.Editorial;
import Principal.Main;
import Vista_Jefe1.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador_Administrar_Editorial implements ActionListener {

    Administrar_Editorial vistaEditorial;
    Editorial edi;
    CRUDeditoriales crude;

    public Controlador_Administrar_Editorial(Administrar_Editorial VADE) {

        vistaEditorial = VADE;
        crude = new CRUDeditoriales();
        vistaEditorial.jbtnAgregarEditorial.addActionListener(this);
        vistaEditorial.jbtnEditarEditorial.addActionListener(this);
        vistaEditorial.jbtnBuscarEditorial.addActionListener(this);
        crude = new CRUDeditoriales();
        crude.MostrarEditorialEnTabla(vistaEditorial.jtblDatosEditorial, vistaEditorial.jlblRegistros_Editorial);
        VADE.setVisible(true);
    }

    public void ActualizarFormulario() {
        crude = new CRUDeditoriales();
        crude.MostrarEditorialEnTabla(vistaEditorial.jtblDatosEditorial, vistaEditorial.jlblRegistros_Editorial);
        vistaEditorial.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaEditorial.jbtnAgregarEditorial) {
            Main.VJAE = new AgregarEditorial();
            Main.CCAE = new Controlador_Agregar_Editorial(Main.VJAE, this);
        }
        if (e.getSource() == vistaEditorial.jbtnEditarEditorial) {
            if (vistaEditorial.jtxtBuscarPorIDEditorial.getText().length() == 0) {
                Mensajes.M1("El campo esta vacio");
            } else {
                int id = Integer.parseInt(vistaEditorial.jtxtBuscarPorIDEditorial.getText());
                crude = new CRUDeditoriales();
                edi = crude.ConsultarRegistroEditorial(id);
                if (edi == null) {
                    Mensajes.M1("El ID " + id + " no existe en la tabla Editoriales.");
                } else {
                    Main.VJEE = new EditarEditorial();
                    Main.CCEE = new Controlador_Editar_Editorial(Main.VJEE, this);
                }
            }
        }
        if (e.getSource() == vistaEditorial.jbtnBuscarEditorial) {
            if (vistaEditorial.jtxtBuscarPorIDEditorial.getText().length() == 0) {
                Mensajes.M1("El campo esta vacio");
            } else {
                int id = Integer.parseInt(vistaEditorial.jtxtBuscarPorIDEditorial.getText());
                crude = new CRUDeditoriales();
                edi = crude.ConsultarRegistroEditorial(id);
                FormatoEditoriales formatoEditorial = new FormatoEditoriales();
                String descMessage = formatoEditorial.DeIntAString(edi.getDescuento());
                if (edi == null) {
                    Mensajes.M1("El ID " + id + " no existe en la tabla Editoriales.");
                } else {
                    Mensajes.M1("ID:                        " + edi.getIdeditorial()
                            + "<br>Nombres:               " + edi.getNombre()
                            + "<br>Estado:                " + edi.getEstado()
                            + "<br>Descuento:             " + descMessage
                            + "<br>Porcentaje Descuento:  " + edi.getPorcentajeDescuento());
                }
            }
        }
    }

}
