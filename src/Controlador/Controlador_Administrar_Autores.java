package Controlador;

import DAO.CRUDautores;
import Formatos.Mensajes;
import Modelo.Autor;
import Principal.Main;
import Vista_Jefe1.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador_Administrar_Autores implements ActionListener {

    Administrar_Autores vistaAutores;
    CRUDautores cruda;
    Autor aut;

    public Controlador_Administrar_Autores(Administrar_Autores VAU) {

        vistaAutores = VAU;
        cruda = new CRUDautores();
        vistaAutores.jbtnAgregarAutores.addActionListener(this);
        vistaAutores.jbtnEditarAutores.addActionListener(this);
        vistaAutores.jbtnBuscarAutores.addActionListener(this);
        VAU.setVisible(true);

        cruda.MostrarAutoresEnTabla(vistaAutores.jtblDatos_Autores, vistaAutores.jlblRegistros_Autores);

    }

    public void ActualizarFormulario() {
        cruda = new CRUDautores();
        cruda.MostrarAutoresEnTabla(vistaAutores.jtblDatos_Autores, vistaAutores.jlblRegistros_Autores);
        vistaAutores.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vistaAutores.jbtnAgregarAutores) {
            Main.VJAA = new AgregarAutor();
            Main.CCAA = new Controlador_Agregar_Autor(Main.VJAA, this);
        }
        if (e.getSource() == vistaAutores.jbtnEditarAutores) {
            if (vistaAutores.jtxtBuscarPorID_Autores.getText().length() == 0) {
                Mensajes.M1("El campo esta vacio");
            } else {
                int id = Integer.parseInt(vistaAutores.jtxtBuscarPorID_Autores.getText());
                cruda = new CRUDautores();
                aut = cruda.ConsultarRegistroAutor(id);
                if (aut == null) {
                    Mensajes.M1("El ID " + id + " no existe en la tabla Autores.");
                } else {
                    Main.VJEA = new EditarAutor();
                    Main.CCEA = new Controlador_Editar_Autor(Main.VJEA, this);
                }
            }
        }

        if (e.getSource() == vistaAutores.jbtnBuscarAutores) {
            if (vistaAutores.jtxtBuscarPorID_Autores.getText().length() == 0) {
                Mensajes.M1("El campo esta vacio");
            } else {
                int id = Integer.parseInt(vistaAutores.jtxtBuscarPorID_Autores.getText());
                cruda = new CRUDautores();
                aut = cruda.ConsultarRegistroAutor(id);

                if (aut == null) {
                    Mensajes.M1("El ID " + id + " no existe en la tabla Autores.");
                } else {
                    Mensajes.M1("ID:                     " + aut.getIdautor()
                            + "<br>Nombres:            " + aut.getNombre()
                            + "<br>Estado:             " + aut.getEstado()
                            + "<br>Descuento:             " + aut.getDescuento()
                            + "<br>Porcentaje Descuento:  " + aut.getPorcentajeDescuento());
                }
            }
        }
    }

}
