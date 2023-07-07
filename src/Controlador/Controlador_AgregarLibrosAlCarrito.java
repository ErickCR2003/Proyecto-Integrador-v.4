package Controlador;

import Formatos.Mensajes;
import Modelo.Libro;
import Vista_Empleado1.BuscarLibros_Venta;
import Vista_Empleado1.CantidadDeLibros;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class Controlador_AgregarLibrosAlCarrito implements ActionListener {

    CantidadDeLibros vista;
    BuscarLibros_Venta vista2;

    public Controlador_AgregarLibrosAlCarrito(CantidadDeLibros CL, String titulo, BuscarLibros_Venta VL) {
        vista = CL;
        vista2 = VL;
        vista.jbtnAgregar.addActionListener(this);
        vista.jbtnCancelar.addActionListener(this);
        vista.jlblTitulo.setText("TITULO DEL LIBRO: \"" + titulo + "\"");
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.jbtnCancelar) {
            this.vista.dispose();
        }

        if (e.getSource() == vista.jbtnAgregar) {
            int fila = vista2.jtblTablaLibros1.getSelectedRow();
            if (Integer.parseInt(vista.jspnCantidad.getValue().toString()) <= 0) {
                Mensajes.M1("POR FAVOR INGRESAR UN VALOR MAYOR A 0");
            } else if (Integer.parseInt(vista.jspnCantidad.getValue().toString()) > Integer.parseInt(vista2.jtblTablaLibros1.getValueAt(fila, 7).toString())) {
                Mensajes.M1("NO PUEDE AGREGAR UNA CANTIDAD MAYOR AL STOCK");
            } else {

                boolean resultado = false;
                int cont = 0;
                for (int i = 0; i < vista2.jtblTablaVenta.getRowCount(); i++) {
                    if (Integer.parseInt(vista2.jtblTablaLibros1.getValueAt(fila, 0).toString()) == Integer.parseInt(vista2.jtblTablaVenta.getValueAt(i, 0).toString())) {
                        resultado = true;
                        cont = i;
                    }
                }

                if (resultado == true) {
                    
                    double descuento = Double.parseDouble(vista2.jtblTablaLibros1.getValueAt(cont, 8).toString());
                    double precio = Double.parseDouble(vista2.jtblTablaLibros1.getValueAt(cont, 5).toString());
                    int suma = Integer.parseInt(vista.jspnCantidad.getValue().toString()) + Integer.parseInt(vista2.jtblTablaVenta.getValueAt(cont, 7).toString());
                    double total = (precio * suma) - ((precio * suma) * descuento / 100);
                    if(suma > Integer.parseInt(vista2.jtblTablaLibros1.getValueAt(fila, 7).toString())){
                        Mensajes.M1("SOBREPASAS EL LIMITE DEL STOCK");
                    } else {
                    vista2.jtblTablaVenta.setValueAt(suma, cont, 7);
                    vista2.jtblTablaVenta.setValueAt(total, cont, 9);
                    double acumulado = 0;
                    for (int i = 0; i < vista2.jtblTablaVenta.getRowCount(); i++) {
                        acumulado += Double.parseDouble(vista2.jtblTablaVenta.getValueAt(i, 9).toString());;
                    }

                    vista2.jtxtCostoTotal.setText("S/. " + acumulado);
                    
                    this.vista.dispose();
                    }
                    
                } else {

                    DefaultTableModel modelo = (DefaultTableModel) vista2.jtblTablaVenta.getModel();

                    int id = Integer.parseInt(vista2.jtblTablaLibros1.getValueAt(fila, 0).toString());
                    String titulo = vista2.jtblTablaLibros1.getValueAt(fila, 1).toString();
                    String autor = vista2.jtblTablaLibros1.getValueAt(fila, 2).toString();
                    String editorial = vista2.jtblTablaLibros1.getValueAt(fila, 3).toString();
                    String tipo = vista2.jtblTablaLibros1.getValueAt(fila, 4).toString();
                    double precio = Double.parseDouble(vista2.jtblTablaLibros1.getValueAt(fila, 5).toString());
                    String numpagina = vista2.jtblTablaLibros1.getValueAt(fila, 6).toString();
                    double descuento = Double.parseDouble(vista2.jtblTablaLibros1.getValueAt(fila, 8).toString());
                    Libro lib = new Libro();
                    double total = (precio * Integer.parseInt(vista.jspnCantidad.getValue().toString())) - ((precio * Integer.parseInt(vista.jspnCantidad.getValue().toString())) * descuento / 100);
                    modelo.addRow(lib.RegistroLibrosCarrito(id, titulo, autor, editorial, tipo, numpagina, precio, Integer.parseInt(vista.jspnCantidad.getValue().toString()), descuento, total));

                    int CantidadFilas = vista2.jtblTablaVenta.getRowCount();

                    double acumulado = 0;
                    for (int i = 0; i < CantidadFilas; i++) {
                        acumulado += Double.parseDouble(vista2.jtblTablaVenta.getValueAt(i, 9).toString());;
                    }

                    vista2.jtxtCostoTotal.setText("S/. " + acumulado);
                    this.vista.dispose();
                }
            }
        }
    }

}
