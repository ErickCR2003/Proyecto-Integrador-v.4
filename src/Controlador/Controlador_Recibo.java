package Controlador;

import DAO.CRUDfacturas;
import DAO.CRUDlibroxdetalle;
import Modelo.Factura;
import Modelo.Libro;
import Modelo.LibrosxDetalle;
import Principal.Main;
import Vista_Empleado1.AdministrarDatos;
import Vista_Empleado1.BuscarLibros_Venta;
import Vista_Empleado1.PrecioDireccion;
import Vista_Empleado1.ReciboVista1;
import Vista_Empleado1.SeleccionarEmpresaOCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Controlador_Recibo implements ActionListener {
    
    List <Libro> libroLista = new ArrayList();
    ReciboVista1 vista;
    BuscarLibros_Venta vista2;
    SeleccionarEmpresaOCliente vista3;
    PrecioDireccion vista4;
    AdministrarDatos vista5;
    AdministrarDatos vistaprincipal;
    CRUDfacturas crudf;
    CRUDlibroxdetalle crudlxd;

    public Controlador_Recibo(ReciboVista1 RV, BuscarLibros_Venta BL, SeleccionarEmpresaOCliente SC, PrecioDireccion PD, AdministrarDatos AD, AdministrarDatos ADS) {
        vista = RV;
        vista2 = BL;
        vista3 = SC;
        vista4 = PD;
        vista5 = AD;
        vistaprincipal = ADS;
        vista.setVisible(true);
        vista.jbtnRegresarABuscarLibro.addActionListener(this);
        vista.jbtnImprimir.addActionListener(this);
        DecimalFormat redondeado = new DecimalFormat("####.#");
        
        int fila = 0;

        double preciodelivery = 0;

        if (vista2.jcbxDelivery.getSelectedIndex() == 2) {
            preciodelivery = 0.0;
        } else {
            preciodelivery = Double.parseDouble(vista4.jtxtprecio.getText());
        }

        String dateTime = DateTimeFormatter.ofPattern("MMM dd yyyy, hh:mm:ss a")
                .format(LocalDateTime.now());
        if (vista3.jtpnclientes.getSelectedIndex() == 0) {
            fila = vista3.jtblClientes.getSelectedRow();

            double acumulado = 0;
            double descuento = 0;
            double subtotal = 0;
            for (int i = 0; i < vista2.jtblTablaVenta.getRowCount(); i++) {
                acumulado += Double.parseDouble(vista2.jtblTablaVenta.getValueAt(i, 9).toString());
                descuento += Double.parseDouble(vista2.jtblTablaVenta.getValueAt(i, 6).toString()) * Integer.parseInt(vista2.jtblTablaVenta.getValueAt(i, 7).toString()) * (Double.parseDouble(vista2.jtblTablaVenta.getValueAt(i, 8).toString()) / 100);
                subtotal += Double.parseDouble(vista2.jtblTablaVenta.getValueAt(i, 6).toString()) * Integer.parseInt(vista2.jtblTablaVenta.getValueAt(i, 7).toString());
            }

            vista.jtxaRecibo.setText("***********************RECIBO***********************"
                    + "\nRUC:                    " + "204141185428"
                    + "\nRecibo N°:              " + vista2.jtxtNumBoleta.getText()
                    + "\nFecha y Hora:           " + dateTime
                    + "\nComprador:              " + vista2.jtxtClienteCom.getText()
                    + "\nDNI del comprador:      " + vista3.jtblClientes.getValueAt(fila, 3).toString()
                    + "\nDirección:              " + vista2.jtxtDirección.getText()
                    + "\nDelivery:               " + vista2.jcbxDelivery.getSelectedItem().toString()
                    + "\nDescuento total:        " + descuento
                    + "\nCosto Delivery:         " + preciodelivery
                    + "\nIGV:                    " + acumulado * 0.18
                    + "\n***********************DETALLES***********************");
            for (int i = 0; i < vista2.jtblTablaVenta.getRowCount(); i++) {
                Libro lib = new Libro();
                lib.setIdlibro((int) vista2.jtblTablaVenta.getValueAt(i, 0));
                lib.setTitulo((String) vista2.jtblTablaVenta.getValueAt(i, 1));
                lib.setCantidad((int) vista2.jtblTablaVenta.getValueAt(i, 7));
                lib.setPrecio((double) vista2.jtblTablaVenta.getValueAt(i, 6));
                libroLista.add(lib);
                vista.jtxaRecibo.append("\nTITULO: " + vista2.jtblTablaVenta.getValueAt(i, 1) + "\nCANTIDAD: "
                        + vista2.jtblTablaVenta.getValueAt(i, 7) + " PRECIO: " + vista2.jtblTablaVenta.getValueAt(i, 6)
                        + " TOTAL: " + vista2.jtblTablaVenta.getValueAt(i, 9));
            }
            vista.jtxaRecibo.append("\n******************************************************"
                    + "\nMonto a pagar:   " + (acumulado + (acumulado * 0.18) + preciodelivery)
                    + "\nMonto a pagar redondeado:   " + redondeado.format(acumulado + (acumulado * 0.18) + preciodelivery));

        } else {
            fila = vista3.jtblEmpresas.getSelectedRow();

            double acumulado = 0;
            double descuento = 0;
            double subtotal = 0;
            for (int i = 0; i < vista2.jtblTablaVenta.getRowCount(); i++) {
                acumulado += Double.parseDouble(vista2.jtblTablaVenta.getValueAt(i, 9).toString());
                descuento += Double.parseDouble(vista2.jtblTablaVenta.getValueAt(i, 6).toString()) * Integer.parseInt(vista2.jtblTablaVenta.getValueAt(i, 7).toString()) * (Double.parseDouble(vista2.jtblTablaVenta.getValueAt(i, 8).toString()) / 100);
                subtotal += Double.parseDouble(vista2.jtblTablaVenta.getValueAt(i, 6).toString()) * Integer.parseInt(vista2.jtblTablaVenta.getValueAt(i, 7).toString());

            }

            vista.jtxaRecibo.setText("***********************RECIBO***********************"
                    + "\nRUC:                    " + "204141185428"
                    + "\nRecibo N°:              " + vista2.jtxtNumBoleta.getText()
                    + "\nFecha y Hora:           " + dateTime
                    + "\nComprador:              " + vista2.jtxtClienteCom.getText()
                    + "\nRUC del comprador:      " + vista3.jtblEmpresas.getValueAt(fila, 3).toString()
                    + "\nDirección:              " + vista2.jtxtDirección.getText()
                    + "\nDelivery:               " + vista2.jcbxDelivery.getSelectedItem().toString()
                    + "\nDescuento total:        " + descuento
                    + "\nCosto Delivery:         " + preciodelivery
                    + "\nIGV:                    " + acumulado * 0.18
                    + "\n***********************DETALLES***********************");
            
            for (int i = 0; i < vista2.jtblTablaVenta.getRowCount(); i++) {
                Libro lib = new Libro();
                lib.setIdlibro((int) vista2.jtblTablaVenta.getValueAt(i, 0));
                lib.setTitulo((String) vista2.jtblTablaVenta.getValueAt(i, 1));
                lib.setCantidad((int) vista2.jtblTablaVenta.getValueAt(i, 7));
                lib.setPrecio((double) vista2.jtblTablaVenta.getValueAt(i, 6));
                libroLista.add(lib);
                vista.jtxaRecibo.append("\nTITULO: " + vista2.jtblTablaVenta.getValueAt(i, 1) + "\nCANTIDAD: "
                        + vista2.jtblTablaVenta.getValueAt(i, 7) + " PRECIO: " + vista2.jtblTablaVenta.getValueAt(i, 6)
                        + " TOTAL: " + vista2.jtblTablaVenta.getValueAt(i, 9));
            }
            
            vista.jtxaRecibo.append("\n******************************************************"
                    + "\nMonto a pagar:   " + (acumulado + (acumulado * 0.18) + preciodelivery)
                    + "\nMonto a pagar redondeado:   " + redondeado.format(acumulado + (acumulado * 0.18) + preciodelivery));
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.jbtnRegresarABuscarLibro) {
            this.vista.dispose();
            Main.VBLV = new Vista_Empleado1.BuscarLibros_Venta();
            Main.CVL = new Controlador_VentaLibros(Main.VBLV);
            vistaprincipal.jpanelContenedorMenuEmpleados.add(Main.VBLV);
        }
        if (e.getSource() == vista.jbtnImprimir) {
            String hora = DateTimeFormatter.ofPattern("hh:mm:ss a").format(LocalTime.now());
            crudf = new CRUDfacturas();
            Factura infoFact = crudf.UltimoRegistroFactura();
            crudlxd = new CRUDlibroxdetalle();
            int cantProductos = crudlxd.ConsultarCantidadporID(infoFact.getIddetalles());
            String fecha = DateTimeFormatter.ofPattern("yyyy MMM dd").format(infoFact.getFecha());
            crudf.ImprimirPDF(infoFact.getIdfactura(), fecha, infoFact.getCliente().getNumeroIdentificacion(), infoFact.getCliente().getNombrecompleto(), hora, infoFact.getEmpleado().getUsuario(), infoFact.getDetalles().getDescuento(), cantProductos, infoFact.getDetalles().getSubtotal(), infoFact.getDetalles().getIgv(), infoFact.getDetalles().getMontofinal(), libroLista);
        }
    }
}
