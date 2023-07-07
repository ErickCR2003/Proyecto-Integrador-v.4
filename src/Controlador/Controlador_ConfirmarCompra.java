package Controlador;

import DAO.CRUDdetalles;
import DAO.CRUDfacturas;
import DAO.CRUDlibros;
import DAO.CRUDlibroxdetalle;
import Formatos.Mensajes;
import Principal.Main;
import Vista1.ConfirmarCompra;
import Vista1.LOGIN;
import Vista_Empleado1.AdministrarDatos;
import Vista_Empleado1.BuscarLibros_Venta;
import Vista_Empleado1.PrecioDireccion;
import Vista_Empleado1.ReciboVista1;
import Vista_Empleado1.SeleccionarEmpresaOCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Controlador_ConfirmarCompra implements ActionListener {

    ConfirmarCompra vista;
    BuscarLibros_Venta vista2;
    SeleccionarEmpresaOCliente vista3;
    PrecioDireccion vista4;
    AdministrarDatos vista5;
    CRUDdetalles crudd;
    CRUDlibroxdetalle crudld;
    CRUDfacturas crudf;
    CRUDlibros crudl;
    LOGIN vista6;

    public Controlador_ConfirmarCompra(ConfirmarCompra CC, BuscarLibros_Venta BL, SeleccionarEmpresaOCliente SC, PrecioDireccion PD, AdministrarDatos AD, LOGIN LG) {
        vista = CC;
        vista2 = BL;
        vista3 = SC;
        vista4 = PD;
        vista5 = AD;
        vista6 = LG;
        crudd = new CRUDdetalles();
        crudld = new CRUDlibroxdetalle();
        crudf = new CRUDfacturas();
        crudl = new CRUDlibros();
        vista.jbtnCancelarCompra.addActionListener(this);
        vista.jbtnConfirmarCompra.addActionListener(this);
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        int fila = 0;
        DecimalFormat redondeado = new DecimalFormat("####.#");
        
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

            vista.jtxaBorradorRecibo.setText("***********************RECIBO***********************"
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
                vista.jtxaBorradorRecibo.append("\nTITULO: " + vista2.jtblTablaVenta.getValueAt(i, 1) + " CANTIDAD: "
                        + vista2.jtblTablaVenta.getValueAt(i, 7) + " PRECIO: " + vista2.jtblTablaVenta.getValueAt(i, 6)
                        + " TOTAL: " + vista2.jtblTablaVenta.getValueAt(i, 9));
            }
            vista.jtxaBorradorRecibo.append("\n******************************************************"
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

            vista.jtxaBorradorRecibo.setText("***********************RECIBO***********************"
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
                vista.jtxaBorradorRecibo.append("\nTITULO: " + vista2.jtblTablaVenta.getValueAt(i, 1) + " CANTIDAD: "
                        + vista2.jtblTablaVenta.getValueAt(i, 7) + " PRECIO: " + vista2.jtblTablaVenta.getValueAt(i, 6)
                        + " TOTAL: " + vista2.jtblTablaVenta.getValueAt(i, 9));
            }
            vista.jtxaBorradorRecibo.append("\n******************************************************"
                    + "\nMonto a pagar:   " + (acumulado + (acumulado * 0.18) + preciodelivery)
                    + "\nMonto a pagar redondeado:   " + redondeado.format(acumulado + (acumulado * 0.18) + preciodelivery));
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.jbtnCancelarCompra) {
            Main.VCC.dispose();
        }

        if (e.getSource() == vista.jbtnConfirmarCompra) {
            crudd = new CRUDdetalles();
            crudld = new CRUDlibroxdetalle();
            crudf = new CRUDfacturas();
            crudl = new CRUDlibros();

            double subtotal = 0;
            double descuento = 0;
            double acumulado = 0;
            for (int i = 0; i < vista2.jtblTablaVenta.getRowCount(); i++) {
                acumulado += Double.parseDouble(vista2.jtblTablaVenta.getValueAt(i, 9).toString());
                subtotal += Double.parseDouble(vista2.jtblTablaVenta.getValueAt(i, 6).toString()) * Integer.parseInt(vista2.jtblTablaVenta.getValueAt(i, 7).toString());
                descuento += Double.parseDouble(vista2.jtblTablaVenta.getValueAt(i, 6).toString()) * Integer.parseInt(vista2.jtblTablaVenta.getValueAt(i, 7).toString()) * (Double.parseDouble(vista2.jtblTablaVenta.getValueAt(i, 8).toString()) / 100);
            }

            double preciodelivery = 0;
            if (vista2.jcbxDelivery.getSelectedIndex() == 2) {
                preciodelivery = 0.0;
            } else {
                preciodelivery = Double.parseDouble(vista4.jtxtprecio.getText());
            }
            double montofinal = subtotal - descuento + preciodelivery + (acumulado * 0.18);
            
            DecimalFormat redondeado = new DecimalFormat("####.#");
            
            String xd = redondeado.format(montofinal);

            crudd.InsertarRegistroDetalles(subtotal, descuento, Double.parseDouble(xd), preciodelivery, vista2.jtxtDirección.getText(), acumulado * 0.18);

            int cantidad = crudd.ConsultarCantidadDeDetalles();
            for (int i = 0; i < vista2.jtblTablaVenta.getRowCount(); i++) {
                crudld.InsertarRegistroLibroxDetalles(Integer.parseInt(vista2.jtblTablaVenta.getValueAt(i, 0).toString()), cantidad);
                crudl.ActualizarRegistroLibrosPorIDVentas(Integer.parseInt(vista2.jtblTablaVenta.getValueAt(i, 0).toString()),Integer.parseInt(vista2.jtblTablaVenta.getValueAt(i, 7).toString()));
            }

            String fecha = DateTimeFormatter.ofPattern("yyyy-MM-dd")
                    .format(LocalDateTime.now());

            int idempleado = crudl.ConsultarIdEmpleadoPorUsuario(vista6.jtxtUsuario.getText());

            int fila = 0;
            int idcliente = 0;
            if (vista3.jtpnclientes.getSelectedIndex() == 0) {
                fila = vista3.jtblClientes.getSelectedRow();
                idcliente = Integer.parseInt(vista3.jtblClientes.getValueAt(fila, 0).toString());
            } else {
                fila = vista3.jtblEmpresas.getSelectedRow();
                idcliente = Integer.parseInt(vista3.jtblEmpresas.getValueAt(fila, 0).toString());
            }

            crudf.InsertarRegistroFacturas(LocalDate.parse(fecha), idempleado, cantidad, idcliente);

            this.vista.dispose();
            Main.VBLV.dispose();
            Main.VRV = new ReciboVista1();
            Main.CR = new Controlador_Recibo(Main.VRV,Main.VBLV,Main.VES,Main.VPD,Main.VAD,Main.VAD);
            vista5.jpanelContenedorMenuEmpleados.add(Main.VRV);

        }
    }

}
