package Controlador;

import DAO.*;
import Formatos.*;
import Modelo.Libro;
import Vista1.AgregarLibroNuevo;
import Vista1.LOGIN;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador_AgregarLibroNuevo implements ActionListener {

    AgregarLibroNuevo vista;
    CRUDautores cruda;
    CRUDeditoriales crude;
    CRUDlibros crudl;
    CRUDtipolibro1 crudt;
    Controlador_AdministrarLibros controladorAL;
    Libro libro;
    LOGIN login;

    public Controlador_AgregarLibroNuevo(AgregarLibroNuevo ALN, Controlador_AdministrarLibros CAL, LOGIN LG) {
        
        login = LG;
        controladorAL = CAL;
        vista = ALN;
        crude = new CRUDeditoriales();
        cruda = new CRUDautores();
        crudl = new CRUDlibros();
        crudt = new CRUDtipolibro1();
        vista.jbtnAgregarLibroNuevo.addActionListener(this);
        vista.jbtnLimpiarLibroNuevo.addActionListener(this);
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);

        for (String autores : cruda.RegistrarAutoresComboBox()) {
            vista.jcbxAutoresLibroNuevo.addItem(autores);
        }

        for (String editoriales : crude.RegistrarEditorialesComboBox()) {
            vista.jcbxEditorialesLibroNuevo.addItem(editoriales);
        }
        
        for (String editoriales : crudt.RegistrarTipoLibroComboBox()) {
            vista.jcbxTipoLN.addItem(editoriales);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.jbtnAgregarLibroNuevo) {
            if (vista.jcbxAutoresLibroNuevo.getSelectedItem() == null
                    || vista.jcbxEditorialesLibroNuevo.getSelectedItem() == null
                    || vista.jtxtPrecioLibroNuevo.getText() == null
                    || vista.jtxtStockLibroNuevo.getText() == null
                    || vista.jcbxTipoLN.getSelectedItem() == null
                    || vista.jtxtNumpagLN.getText() == null
                    || vista.jtxtTituloLibroNuevo.getText() == null) {
                Mensajes.M1("Complete todos los campos");
            } else if (Double.parseDouble(vista.jtxtPrecioLibroNuevo.getText()) < 0) {
                Mensajes.M1("El precio no puede ser negativo");
            } else if (Integer.parseInt(vista.jtxtStockLibroNuevo.getText()) < 0) {
                Mensajes.M1("El stock no puede ser negativo");
            } else if (Integer.parseInt(vista.jtxtNumpagLN.getText()) < 0) {
                Mensajes.M1("El número de páginas no puede ser negativo");
            } else {
                libro = Formatos.FormatoLibros.LeerLibroLN(vista, login);
                crudl = new CRUDlibros();
                crudl.InsertarRegistroLibro(libro);
                Formatos.FormatoLibros.LimpiarEntradasLN(vista);
                controladorAL.ActualizarTablaLibros();
            }
        }

        if (e.getSource() == vista.jbtnLimpiarLibroNuevo) {
            Formatos.FormatoLibros.LimpiarEntradasLN(vista);
        }
    }
}
