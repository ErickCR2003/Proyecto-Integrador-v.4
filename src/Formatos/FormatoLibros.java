package Formatos;

import Modelo.Libro;
import Vista1.*;
import DAO.CRUDlibros;

import Vista1.EditarLibros;

public class FormatoLibros {

    public static void LimpiarEntradasLN(AgregarLibroNuevo ALN) {
        ALN.jcbxAutoresLibroNuevo.setSelectedIndex(0);
        ALN.jcbxEditorialesLibroNuevo.setSelectedIndex(0);
        ALN.jtxtPrecioLibroNuevo.setText("");
        ALN.jtxtStockLibroNuevo.setText("");
        ALN.jtxtTituloLibroNuevo.setText("");
        ALN.jcbxAutoresLibroNuevo.requestFocus();
    }
    
    public static void LimpiarEntradasLE(AgregarLibroExis ALE) {
        ALE.jcbxAutorLibroExistente.setSelectedIndex(0);
        ALE.jcbxEditorialLibroExistente.setSelectedIndex(0);
        ALE.jtxtTituloLibroExistente.setText("");
        ALE.jspncantidadlibro.setValue(0);
        ALE.jspncodigolibro.setValue(0);
        ALE.jtxtTituloLibroExistente.requestFocus();
    }
    

    public static Libro LeerEditarLibro(EditarLibros EL) {

        Libro libro = new Libro();
        libro.setIdautor(EL.jcbxAutores_EditarLibros.getSelectedIndex()+1);
        libro.setIdeditorial(EL.jcbxEditorial_EditarLibros.getSelectedIndex()+1);
        libro.setTitulo(EL.jtxtTitulo_Editar.getText());
        libro.setIdtipolibro(EL.jcbx_TipoDeLibro_Editar.getSelectedIndex()+1);
        libro.setPrecio(Double.parseDouble(EL.jtxtPrecio_Editar.getText()));
        libro.setNumpagina(Integer.parseInt(EL.jtxt_NdePaginas_Editar.getText()));
        libro.setStock(Integer.parseInt(EL.jtxtStock_Editar.getText()));
        
        return libro;
    }
    
    public static Libro LeerLibroLN(AgregarLibroNuevo ALN, LOGIN LG){
        CRUDlibros crudl =  new CRUDlibros();
        int idemp = crudl.ConsultarIdEmpleadoPorUsuario(LG.jtxtUsuario.getText());
        
        Libro libro = new Libro();
        libro.setIdautor(ALN.jcbxAutoresLibroNuevo.getSelectedIndex()+1);
        libro.setIdeditorial(ALN.jcbxEditorialesLibroNuevo.getSelectedIndex()+1);
        libro.setTitulo(ALN.jtxtTituloLibroNuevo.getText());
        libro.setPrecio(Double.parseDouble(ALN.jtxtPrecioLibroNuevo.getText()));
        libro.setStock(Integer.parseInt(ALN.jtxtStockLibroNuevo.getText()));
        libro.setIdtipolibro(ALN.jcbxTipoLN.getSelectedIndex()+1);
        libro.setNumpagina(Integer.parseInt(ALN.jtxtNumpagLN.getText()));
        libro.setIdempleado(idemp);
        
        return libro;
    }
    
    public static Libro EditarLibroExistente(AgregarLibroExis ALE) {

        Libro libro = new Libro();
        libro.setIdautor(ALE.jcbxAutorLibroExistente.getSelectedIndex()+1);
        libro.setIdeditorial(ALE.jcbxEditorialLibroExistente.getSelectedIndex()+1);
        libro.setStock(Integer.parseInt(ALE.jspncantidadlibro.getValue().toString()));
        
        return libro;
    }
}
