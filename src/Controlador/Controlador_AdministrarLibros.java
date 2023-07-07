package Controlador;

import DAO.CRUDlibros;
import Formatos.Mensajes;
import Modelo.Libro;
import Principal.Main;
import Vista_Empleado1.Admin_Libros;
import Vista1.AgregarLibroExis;
import Vista1.AgregarLibroNuevo;
import Vista1.EditarLibros;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador_AdministrarLibros implements ActionListener {

    Libro libro;
    CRUDlibros crudl;
    Admin_Libros vista;

    public Controlador_AdministrarLibros(Admin_Libros AL) {

        vista = AL;
        vista.setVisible(true);
        vista.jbtnAñadirLibroExistente.addActionListener(this);
        vista.jbtnAñadirLibroNuevo.addActionListener(this);
        vista.jbtnEditarLibro.addActionListener(this);
        vista.jbtnBuscarLibro.addActionListener(this);

        crudl = new CRUDlibros();
        crudl.MostrarLibrosEnTabla(vista.jtblTablaDeLibros, vista.jlblRegistros_Libros);
        vista.setVisible(true);
    }

    public void ActualizarTablaLibros() {
        crudl = new CRUDlibros();
        crudl.MostrarLibrosEnTabla(vista.jtblTablaDeLibros, vista.jlblRegistros_Libros);
        vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.jbtnAñadirLibroExistente) {
            Main.VEAL = new AgregarLibroExis();
            Main.CALE = new Controlador_Agregar_LibroExistente(Main.VEAL, this, Main.VL);
        }

        if (e.getSource() == vista.jbtnAñadirLibroNuevo) {
            Main.ALN = new AgregarLibroNuevo();
            Main.CLN = new Controlador_AgregarLibroNuevo(Main.ALN, this, Main.VL);
        }

        if (e.getSource() == vista.jbtnEditarLibro) {
            if (vista.jspnConsultarPorIdLibro.getValue().toString().length() == 0) {
                Mensajes.M1("El campo esta vacio");
            } else {
                int id = Integer.parseInt(vista.jspnConsultarPorIdLibro.getValue().toString());
                crudl = new CRUDlibros();
                libro = crudl.ConsultarRegistroLibro(id);
                if (libro == null) {
                    Mensajes.M1("El ID " + id + " no existe en la tabla Libros.");
                } else {
                    int idempleadologin = crudl.ConsultarIdEmpleadoPorUsuario(Main.VL.jtxtUsuario.getText());
                    int idempleadolibro = crudl.ConsultarIdempleadoporIdLibro(Integer.parseInt(Main.VAL.jspnConsultarPorIdLibro.getValue().toString()));
                    if (idempleadologin == idempleadolibro) {
                        Main.EL = new EditarLibros();
                        Main.CEL = new Controlador_EditarLibro(Main.EL, this,Main.VAL);
                    } else {
                        Mensajes.M1("No tienes permisos para editar este libro");
                    }
                }
            }
        }

        if (e.getSource() == vista.jbtnBuscarLibro) {
            if (vista.jspnConsultarPorIdLibro.getValue().toString().length() == 0) {
                Mensajes.M1("El campo esta vacio");
            } else {
                int id = Integer.parseInt(vista.jspnConsultarPorIdLibro.getValue().toString());
                crudl = new CRUDlibros();
                libro = crudl.ConsultarRegistroLibro(id);
                if (libro == null) {
                    Mensajes.M1("El ID " + id + " no existe en la tabla Libros.");
                } else {
                    Mensajes.M1("ID Libro:           " + libro.getIdlibro()
                            + "<br>Titulo:         " + libro.getTitulo()
                            + "<br>Autor:          " + libro.getAutor().getNombre()
                            + "<br>Editorial:      " + libro.getEditorial().getNombre()
                            + "<br>Precio:         " + libro.getPrecio()
                            + "<br>Stock:          " + libro.getStock()
                            + "<br>N° Paginas:     " + libro.getNumpagina()
                            + "<br>ID Empleado:    " + libro.getIdempleado());
                }
            }
        }
    }
}
