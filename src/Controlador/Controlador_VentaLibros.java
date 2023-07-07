package Controlador;

import DAO.CRUDautores;
import DAO.CRUDeditoriales;
import DAO.CRUDfacturas;
import DAO.CRUDlibros;
import DAO.CRUDtipolibro1;
import Formatos.Mensajes;
import Principal.Main;
import Vista1.ConfirmarCompra;
import Vista_Empleado1.BuscarLibros_Venta;
import Vista_Empleado1.CantidadDeLibros;
import Vista_Empleado1.PrecioDireccion;
import Vista_Empleado1.SeleccionarEmpresaOCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class Controlador_VentaLibros implements ActionListener {

    BuscarLibros_Venta vista;
    CRUDlibros crudl;
    CRUDautores cruda;
    CRUDeditoriales crude;
    CRUDtipolibro1 crudt;
    CRUDfacturas crudf;

    public Controlador_VentaLibros(BuscarLibros_Venta LV) {
        vista = LV;
        crudl = new CRUDlibros();
        cruda = new CRUDautores();
        crude = new CRUDeditoriales();
        crudt = new CRUDtipolibro1();
        crudf = new CRUDfacturas();
        vista.jbtnBuscarLibro1.addActionListener(this);
        vista.jbtnlimpiar.addActionListener(this);
        vista.jbtnAgregarClient.addActionListener(this);
        vista.jbtnEliminarCampos.addActionListener(this);
        vista.jbtnCancelarCom.addActionListener(this);
        vista.jbtnConfirmarCom.addActionListener(this);
        vista.setVisible(true);

        vista.jtxtCostoTotal.setText("S/. 0.0");
        int cantidad = crudf.ConsultarCantidadDeFacturas() + 1;
        vista.jtxtNumBoleta.setText("N° " + cantidad);

        for (String autores : cruda.RegistrarAutoresComboBox()) {
            vista.jcbxAutor.addItem(autores);
        }

        for (String editoriales : crude.RegistrarEditorialesComboBox()) {
            vista.jcbxeditorial.addItem(editoriales);
        }

        for (String editoriales : crudt.RegistrarTipoLibroComboBox()) {
            vista.jcbxtipolibro.addItem(editoriales);
        }

        vista.jtblTablaLibros1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblTablaLibros1MouseClicked(evt);
            }
        });

    }

    //METODO PARA SELECCIONAR EL LIBRO A AGREGAR EN EL CARRITO (AGREGAR LIBRO AL CARRITO (TABLA))
    private void jtblTablaLibros1MouseClicked(java.awt.event.MouseEvent evt) {
        int fila = vista.jtblTablaLibros1.getSelectedRow();
        String titulo = vista.jtblTablaLibros1.getValueAt(fila, 1).toString();

        Main.VCDL = new CantidadDeLibros();
        Main.CALC = new Controlador_AgregarLibrosAlCarrito(Main.VCDL, titulo, this.vista);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.jbtnBuscarLibro1) {
            if (Integer.parseInt(vista.jspnCodigoLibro.getValue().toString()) == 0 && vista.jcbxAutor.getSelectedIndex() == 0
                    && vista.jtxtTituloLibro.getText().isEmpty() && vista.jcbxeditorial.getSelectedIndex() == 0 && vista.jcbxtipolibro.getSelectedIndex() == 0) {
                crudl.MostrarLibrosPorTituloEnTabla(vista.jtblTablaLibros1, null);
                Mensajes.M1("Complete los datos para la busqueda de libros");
            } else if (vista.jcbxAutor.getSelectedIndex() == 0
                    && vista.jtxtTituloLibro.getText().isEmpty() && vista.jcbxeditorial.getSelectedIndex() == 0 && vista.jcbxtipolibro.getSelectedIndex() == 0) {
                if (Integer.parseInt(vista.jspnCodigoLibro.getValue().toString()) < 0) {
                    Mensajes.M1("El codigo no puede ser negativo");
                } else {
                    crudl = new CRUDlibros();
                    crudl.MostrarLibrosPorCodigoEnTabla(vista.jtblTablaLibros1, Integer.parseInt(vista.jspnCodigoLibro.getValue().toString()));
                    if (crudl.ConsultarRegistroLibro(Integer.parseInt(vista.jspnCodigoLibro.getValue().toString())) == null) {
                        Mensajes.M1("El codigo " + (vista.jspnCodigoLibro.getValue().toString()) + " no existe en la base de datos");
                    }

                }

            } else if (vista.jcbxAutor.getSelectedIndex() > 0) {
                cruda = new CRUDautores();
                int id = cruda.ConsultarIdAutorPorNombre(vista.jcbxAutor.getSelectedItem().toString());
                crudl = new CRUDlibros();
                crudl.MostrarLibrosPorAutorEnTabla(vista.jtblTablaLibros1, id);

            } else if (!vista.jtxtTituloLibro.getText().isEmpty()) {
                crudl = new CRUDlibros();
                crudl.MostrarLibrosPorTituloEnTabla(vista.jtblTablaLibros1, vista.jtxtTituloLibro.getText());
                if (crudl.ConsultarRegistroLibroPortituloLibro(vista.jtxtTituloLibro.getText()) == null) {
                    Mensajes.M1("No existe el titulo \"" + vista.jtxtTituloLibro.getText() + "\" en la base de datos");
                }
            } else if (vista.jcbxeditorial.getSelectedIndex() > 0) {
                crude = new CRUDeditoriales();
                int id = crude.ConsultarIdEditorialPorNombre(vista.jcbxeditorial.getSelectedItem().toString());
                crudl = new CRUDlibros();
                crudl.MostrarLibrosPorIdEditorialEnTabla(vista.jtblTablaLibros1, id);
            } else if (vista.jcbxtipolibro.getSelectedIndex() > 0) {
                crudt = new CRUDtipolibro1();
                int id = crudt.ConsultarIdTipoLibroPorNombre(vista.jcbxtipolibro.getSelectedItem().toString());
                crudl = new CRUDlibros();
                crudl.MostrarLibrosPorIdTipolibroEnTabla(vista.jtblTablaLibros1, id);

            }
        }

        if (e.getSource() == vista.jbtnlimpiar) {
            Formatos.FormatoVenta.LimpiarEntradas(vista);
            crudl.MostrarLibrosPorTituloEnTabla(vista.jtblTablaLibros1, null);
        }

        if (e.getSource() == vista.jbtnAgregarClient) {
            Main.VES = new SeleccionarEmpresaOCliente();
            Main.CSC = new Controlador_SeleccionarCliente(Main.VES, Main.VBLV);
        }

        if (e.getSource() == vista.jbtnEliminarCampos) {
            int fila = vista.jtblTablaVenta.getSelectedRow();
            if (fila < 0) {
                Mensajes.M1("Por favor seleccionar un libro del carrito a eliminar");
            } else {
                String titulo = vista.jtblTablaVenta.getValueAt(fila, 1).toString();
                int rpta = Mensajes.M3("CONFIRMACION DE ELIMINACION", "¿Esta seguro de eliminar el libro \"" + titulo + "\" del carrito de compra?");

                if (rpta == 0) {
                    DefaultTableModel modelo = (DefaultTableModel) vista.jtblTablaVenta.getModel();
                    modelo.removeRow(fila);
                    double acumulado = 0;
                    int CantidadFilas = vista.jtblTablaVenta.getRowCount();
                    for (int i = 0; i < CantidadFilas; i++) {
                        acumulado += Double.parseDouble(vista.jtblTablaVenta.getValueAt(i, 8).toString());;
                    }
                    vista.jtxtCostoTotal.setText("S/. " + acumulado);
                }
            }

        }

        if (e.getSource() == vista.jbtnCancelarCom) {
            int respuesta = Mensajes.M3("CONFIRMACION PARA CANCELAR VENTA", "¿ESTA SEGURO QUE DESEA CANCELAR LA VENTA?,SE BORRARA TODO SU PROGRESO");
            if (respuesta == 0) {
                Formatos.FormatoVenta.LimpiarEntradas(vista);
                crudl.MostrarLibrosPorTituloEnTabla(vista.jtblTablaLibros1, null);
                DefaultTableModel modelo = (DefaultTableModel) vista.jtblTablaVenta.getModel();
                int cantidad = vista.jtblTablaVenta.getRowCount();

                for (int i = 0; i < cantidad; i++) {

                    modelo.removeRow(0);

                }
                vista.jtxtCostoTotal.setText("S/. 0.0");
                vista.jtxtClienteCom.setText("");
                vista.jtxtDirección.setText("");
                vista.jcbxDelivery.setSelectedIndex(0);

            }
        }

        if (e.getSource() == vista.jbtnConfirmarCom) {
            if (vista.jtxtClienteCom.getText().isEmpty()) {
                Mensajes.M1("DEBE SELECCIONAR UN CLIENTE PARA CONFIRMAR LA COMPRA");
            } else if (vista.jtxtDirección.getText().isEmpty()) {
                Mensajes.M1("LA DIRECCION NO PUEDE ESTAR VACIA");
            } else if (vista.jcbxDelivery.getSelectedIndex() == 0) {
                Mensajes.M1("DEBE SELECCIONAR UNA OPCION PARA EL DELIVERY");
            } else if (vista.jtblTablaVenta.getRowCount() < 1) {
                Mensajes.M1("EL CARRITO DEBE TENER COMO MINIMO 1 LIBRO");
            } else {

                if (vista.jcbxDelivery.getSelectedIndex() == 1) {
                    Main.VPD = new PrecioDireccion();
                    Main.CPD = new Controlador_PrecioDireccion(Main.VPD, this.vista);
                } else {
                    Main.VCC = new ConfirmarCompra();
                    Main.CCC = new Controlador_ConfirmarCompra(Main.VCC,Main.VBLV,Main.VES,Main.VPD,Main.VAD,Main.VL);
                }
            }
        }
    }
}
