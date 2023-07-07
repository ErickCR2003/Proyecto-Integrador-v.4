package Controlador;

import DAO.CRUDautores;
import DAO.CRUDeditoriales;
import DAO.CRUDlibros;
import DAO.CRUDtipolibro1;
import Formatos.FormatoLibros;
import Formatos.Mensajes;
import Modelo.Libro;
import Vista1.AgregarLibroExis;
import Vista1.LOGIN;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador_Agregar_LibroExistente implements ActionListener {

    CRUDautores cruda;
    CRUDeditoriales crude;
    CRUDlibros crudl;
    AgregarLibroExis vista;
    CRUDtipolibro1 crudt;
    Controlador_AdministrarLibros controladorAL;
    LOGIN LG;
    Libro libro;

    public Controlador_Agregar_LibroExistente(AgregarLibroExis ALE, Controlador_AdministrarLibros CAL, LOGIN LG) {
        
        controladorAL = CAL;
        vista = ALE;
        crude = new CRUDeditoriales();
        cruda = new CRUDautores();
        crudl = new CRUDlibros();
        crudt = new CRUDtipolibro1();
        vista.jbtnAgregarLibroExistente.addActionListener(this);
        vista.jbtnBuscarLibroExistente.addActionListener(this);
        vista.jbtnLimpiarLibroExistente.addActionListener(this);
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);

        for (String autores : cruda.RegistrarAutoresComboBox()) {
            vista.jcbxAutorLibroExistente.addItem(autores);
        }
        

        for (String editoriales : crude.RegistrarEditorialesComboBox()) {
            vista.jcbxEditorialLibroExistente.addItem(editoriales);
        }
        
        for (String editoriales : crudt.RegistrarTipoLibroComboBox()) {
            vista.jcbxTipoLE.addItem(editoriales);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.jbtnBuscarLibroExistente) {
            if (Integer.parseInt(vista.jspncodigolibro.getValue().toString()) <= 0) {
                Mensajes.M1("INGRESAR UN CODIGO MAYOR A 0");
            } else {
                int id = Integer.parseInt(vista.jspncodigolibro.getValue().toString());
                crudl = new CRUDlibros();
                libro = crudl.ConsultarRegistroLibro(id);
                if (libro == null) {
                    Mensajes.M1("El ID " + id + " no existe en la tabla Libros.");
                } else {
                    vista.jtxtTituloLibroExistente.setText(libro.getTitulo());
                    vista.jcbxAutorLibroExistente.setSelectedIndex(libro.getIdautor() - 1);
                    vista.jcbxEditorialLibroExistente.setSelectedIndex(libro.getIdeditorial() - 1);
                    vista.jcbxTipoLE.setSelectedIndex(libro.getIdtipolibro() - 1);
                    vista.jtxtNumpagLE.setText(""+libro.getNumpagina());
                }
            }
        }
        
        if (e.getSource() == vista.jbtnAgregarLibroExistente) {
            //aqui
            if (Integer.parseInt(vista.jspncodigolibro.getValue().toString()) <= 0) {
                Mensajes.M1("INGRESAR UN CODIGO MAYOR A 0");
            } else if(Integer.parseInt(vista.jspncantidadlibro.getValue().toString()) <= 0){
                Mensajes.M1("LA CANTIDAD DE LIBROS A AGREGAR DEBE SER MAYOR A 0");
            } else {
                crudl = new CRUDlibros(); //aqui
                crudl.ActualizarRegistroLibrosExistentes(Integer.parseInt(vista.jspncodigolibro.getValue().toString()), Integer.parseInt(vista.jspncantidadlibro.getValue().toString()));
                controladorAL.ActualizarTablaLibros();
            }
        }
        
        if (e.getSource() == vista.jbtnLimpiarLibroExistente) {
            Formatos.FormatoLibros.LimpiarEntradasLE(vista);
        }
    }

}
