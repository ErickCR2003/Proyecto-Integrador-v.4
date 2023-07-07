package Controlador;

import DAO.CRUDautores;
import DAO.CRUDeditoriales;
import DAO.CRUDlibros;
import DAO.CRUDtipolibro1;
import Formatos.FormatoLibros;
import Formatos.Mensajes;
import Modelo.Libro;
import Vista1.EditarLibros;
import Vista_Empleado1.Admin_Libros;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador_EditarLibro implements ActionListener {

    Admin_Libros vistaAdminLibros;
    EditarLibros vistaEditar;
    Libro libro;
    CRUDlibros crudl;
    Controlador_AdministrarLibros controlAL;
    CRUDautores cruda;
    CRUDeditoriales crude;
    CRUDtipolibro1 crudt;

    public Controlador_EditarLibro(EditarLibros EL, Controlador_AdministrarLibros CAL, Admin_Libros VAL) {
        
        vistaAdminLibros = VAL;
        controlAL = CAL;
        vistaEditar = EL;
        cruda = new CRUDautores();
        crude = new CRUDeditoriales();
        crudt = new CRUDtipolibro1();
        vistaEditar.jbtnActualizarLibro.addActionListener(this);
        vistaEditar.setVisible(true);
        vistaEditar.setLocationRelativeTo(null);

        for (String autores : cruda.RegistrarAutoresComboBox()) {
            vistaEditar.jcbxAutores_EditarLibros.addItem(autores);
        }

        for (String editoriales : crude.RegistrarEditorialesComboBox()) {
            vistaEditar.jcbxEditorial_EditarLibros.addItem(editoriales);
        }
        
        for (String editoriales : crudt.RegistrarTipoLibroComboBox()) {
            vistaEditar.jcbx_TipoDeLibro_Editar.addItem(editoriales);
        }

            crudl = new CRUDlibros();
            int id = Integer.parseInt(vistaAdminLibros.jspnConsultarPorIdLibro.getValue().toString());
            libro = crudl.ConsultarRegistroLibro(id);
            vistaEditar.jcbxAutores_EditarLibros.setSelectedIndex(libro.getIdautor() - 1);
            vistaEditar.jcbxEditorial_EditarLibros.setSelectedIndex(libro.getIdeditorial() - 1);
            vistaEditar.jcbx_TipoDeLibro_Editar.setSelectedIndex(libro.getIdtipolibro() -1);
            vistaEditar.jtxtPrecio_Editar.setText(String.valueOf(libro.getPrecio()));
            vistaEditar.jtxt_NdePaginas_Editar.setText(String.valueOf(libro.getNumpagina()));
            vistaEditar.jtxtStock_Editar.setText(String.valueOf(libro.getStock()));
            vistaEditar.jtxtTitulo_Editar.setText(libro.getTitulo());

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaEditar.jbtnActualizarLibro) {
            if (vistaEditar.jcbxAutores_EditarLibros.getSelectedIndex() == -1
                    || vistaEditar.jcbxEditorial_EditarLibros.getSelectedIndex() == -1
                    || vistaEditar.jtxtPrecio_Editar.getText() == null
                    || vistaEditar.jtxtStock_Editar.getText() == null
                    || vistaEditar.jtxtTitulo_Editar.getText() == null) {
                Mensajes.M1("Complete todos los campos");
            } else if (Double.parseDouble(vistaEditar.jtxtPrecio_Editar.getText()) < 0) {
                Mensajes.M1("El precio no puede ser negativo");
            } else if (Integer.parseInt(vistaEditar.jtxtStock_Editar.getText()) < 0) {
                Mensajes.M1("El stock no puede ser negativo");
            } else {
                libro = FormatoLibros.LeerEditarLibro(vistaEditar);
                crudl = new CRUDlibros();
                crudl.ActualizarRegistroLibros(Integer.parseInt(vistaAdminLibros.jspnConsultarPorIdLibro.getValue().toString()), libro);
                controlAL.ActualizarTablaLibros();
            }
        }
    }
}

