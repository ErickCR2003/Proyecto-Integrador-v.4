package Controlador;

import DAO.CRUDAlquiler;
import DAO.CRUDMovimiento;
import DAO.CRUDPago;
import DAO.CRUDdetallesAlquiler;
import DAO.CRUDherramientas;
import Modelo.Alquiler;
import Modelo.DetallesAlquiler;
import Modelo.Movimiento;
import Modelo.Pago;
import Principal.Main;
import Vst.Alquiler.VstAlquiler_Confirmar;
import Vst.Alquiler.VstAlquiler;
import Vst.Cliente.VstCliente_Seleccionar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CtrlAlquiler_Confirmar implements ActionListener {

    VstAlquiler_Confirmar VAlq_Conf;
    VstAlquiler VAlq_Ed;
    VstCliente_Seleccionar VCli_Sel;
    CRUDdetallesAlquiler crudda;
    CRUDherramientas crudh;
    CRUDAlquiler cruda;
    Alquiler alquiler;
    Pago pago;
    int idempleado = 0;
    int idcliente = 0;
    int diasAlquiler = 0;
    double precioTraslado = 0;
    double precioAlquiler = 0;
    double subtotal = 0; //(alquiler mas traslado) SIN igv
    double IGV = 0;
    double montofinal = 0; //(alquiler + garantía) con igv. mas garantía, sin igv
    double garantia = 0;
    String estado = "EN PROCESO";
    boolean conTraslado;
    String direccionEntrega = "";
    String serieFacBol = "";
    int nroFacBol = 0;
    String serieCorrFacBol = "";
    DecimalFormat redondeado = new DecimalFormat("#####.##");
    DateTimeFormatter formatDia = DateTimeFormatter.ofPattern("yyyy-MM-dd");   
    LocalDate fechaAlquiler;
    LocalDate fechaSalidaHerramienta;
    LocalDate fechaRetornoHerramienta;

    public CtrlAlquiler_Confirmar(VstAlquiler_Confirmar vistaConfirmar, VstAlquiler vistaAlquiler, VstCliente_Seleccionar vistaClienteSelec) {
        
        VAlq_Conf = vistaConfirmar;
        VAlq_Ed = vistaAlquiler;
        VCli_Sel = vistaClienteSelec;
        crudda = new CRUDdetallesAlquiler();
        crudh = new CRUDherramientas();
        cruda = new CRUDAlquiler();
        alquiler = new Alquiler();
        VAlq_Conf.jbtnCancelarCompra.addActionListener(this);
        VAlq_Conf.jbtnConfirmarCompra.addActionListener(this);
        VAlq_Conf.setVisible(true);
        VAlq_Conf.setLocationRelativeTo(null);

        diasAlquiler = Integer.parseInt( VAlq_Ed.jspnDiasdeAlquiler.getValue().toString());
        
        fechaAlquiler = LocalDate.now();
        fechaSalidaHerramienta = LocalDate.now();
        fechaRetornoHerramienta = LocalDate.now().plusDays(diasAlquiler);
        
        if (VAlq_Ed.jcbxTraslado.getSelectedIndex() == 2) {
            precioTraslado = 0;
        } else {
            precioTraslado = Double.parseDouble(VAlq_Ed.jspnPrecioTraslado.getValue().toString());
        }

        direccionEntrega = VAlq_Ed.jtxtDirecciónObra.getText();
        
        if(VAlq_Ed.jcbxTraslado.getSelectedIndex() == 2){
            conTraslado = false;
        } else {
            conTraslado = true;
        }


        if (VCli_Sel.jtpnclientes.getSelectedIndex() == 0) {
            int fila = VCli_Sel.jtblClientes.getSelectedRow();
            
            for (int i = 0; i < VAlq_Ed.jtblTablaVenta.getRowCount(); i++) {
                precioAlquiler += Double.parseDouble(VAlq_Ed.jtblTablaVenta.getValueAt(i, 6).toString()) * diasAlquiler;
            }            
            
            garantia = precioAlquiler * 0.15;
            IGV = (precioAlquiler + precioTraslado) * 0.18;
            montofinal = (precioAlquiler + precioTraslado + IGV +  garantia);
            idempleado = Main.UsrActual.getID();
            idcliente = (int) VCli_Sel.jtblClientes.getValueAt(fila, 0);      
            
            VAlq_Conf.jtxaBorradorRecibo.setText("********************** RECIBO **********************"
                    + "\n RUC:                    " + "204141185428"
                    + "\n Recibo N°:              " + VAlq_Ed.jtxtNumAlquiler.getText()
                    + "\n Fecha:                  " + fechaSalidaHerramienta.format(formatDia)
                    + "\n Comprador:              " + VAlq_Ed.jtxtClienteCom.getText()
                    + "\n DNI del comprador:      " + VCli_Sel.jtblClientes.getValueAt(fila, 3).toString()
                    + "\n Dirección:              " + direccionEntrega
                    + "\n Traslado:               " + VAlq_Ed.jcbxTraslado.getSelectedItem().toString()
                    + "\n Costo Alquiler:         " + precioAlquiler
                    + "\n Costo Traslado:         " + precioTraslado
                    + "\n Garantía (15% alq):     " + garantia
                    + "\n IGV (alq. + tras.):     " + Math.round(IGV*100.00)/100.00
                    + "\n********************** DETALLES ********************");
                       
            for (int i = 0; i < VAlq_Ed.jtblTablaVenta.getRowCount(); i++) {
                VAlq_Conf.jtxaBorradorRecibo.append("\n\tHerramienta Nro." + (i+1)
                                                    + "\n\t\tNombre: " + VAlq_Ed.jtblTablaVenta.getValueAt(i, 2)
                                                    + "\n\t\tPrecio: " + VAlq_Ed.jtblTablaVenta.getValueAt(i, 6)
                                                    + "\n\t\tDías a alquilar: " +  diasAlquiler
                                                    + "\n\t\tTotal: " + Double.parseDouble(VAlq_Ed.jtblTablaVenta.getValueAt(i, 6).toString())*diasAlquiler);
            }
                                
            VAlq_Conf.jtxaBorradorRecibo.append("\n****************************************************"
                                            + "\n Monto a pagar:   S/" + montofinal
                                            + "\n Monto a pagar redondeado:   S/." + redondeado.format(montofinal)
                                            + "\n Monto a Facturar (sin garantía):   S/." + redondeado.format(montofinal - garantia));

        } else {
            int fila = VCli_Sel.jtblEmpresas.getSelectedRow();
            
            for (int i = 0; i < VAlq_Ed.jtblTablaVenta.getRowCount(); i++) {
                precioAlquiler += Double.parseDouble(VAlq_Ed.jtblTablaVenta.getValueAt(i, 6).toString()) * diasAlquiler;
            }
            
            garantia = precioAlquiler * 0.15;
            IGV = (precioAlquiler + precioTraslado) * 0.18;         
            montofinal = (precioAlquiler + precioTraslado + IGV +  garantia);            
            idempleado = Main.UsrActual.getID();
            idcliente = (int) VCli_Sel.jtblClientes.getValueAt(fila, 0);      
            
            VAlq_Conf.jtxaBorradorRecibo.setText("********************** RECIBO **********************"
                    + "\n RUC:                    " + "204141185428"
                    + "\n Recibo N°:              " + VAlq_Ed.jtxtNumAlquiler.getText()
                    + "\n Fecha:                  " + fechaSalidaHerramienta.format(formatDia)
                    + "\n Comprador:              " + VAlq_Ed.jtxtClienteCom.getText()
                    + "\n DNI del comprador:      " + VCli_Sel.jtblClientes.getValueAt(fila, 3).toString()
                    + "\n Dirección:              " + direccionEntrega
                    + "\n Traslado:               " + VAlq_Ed.jcbxTraslado.getSelectedItem().toString()                    
                    + "\n Costo Alquiler:         " + precioAlquiler
                    + "\n Costo Traslado:         " + precioTraslado
                    + "\n Garantía (15% alq):     " + garantia
                    + "\n IGV (alq. + tras.):     " + IGV
                    + "\n********************** DETALLES ********************");
                       
            for (int i = 0; i < VAlq_Ed.jtblTablaVenta.getRowCount(); i++) {
                VAlq_Conf.jtxaBorradorRecibo.append("\n\tHerramienta Nro." + (i+1)
                                                    + "\n\t\tNombre: " + VAlq_Ed.jtblTablaVenta.getValueAt(i, 2)
                                                    + "\n\t\tPrecio: " + VAlq_Ed.jtblTablaVenta.getValueAt(i, 6)
                                                    + "\n\t\tDías a alquilar: " +  diasAlquiler
                                                    + "\n\t\tTotal: " + Double.parseDouble(VAlq_Ed.jtblTablaVenta.getValueAt(i, 6).toString())*diasAlquiler);
            }
                                
            VAlq_Conf.jtxaBorradorRecibo.append("\n****************************************************"
                                            + "\n Monto a pagar:   S/" + montofinal
                                            + "\n Monto a pagar redondeado:   S/." + redondeado.format(montofinal)
                                            + "\n Monto a Facturar (sin garantía):   S/." + redondeado.format(montofinal - garantia));
        }
}

    @Override
    public void actionPerformed(ActionEvent e) {
            if (e.getSource() == VAlq_Conf.jbtnCancelarCompra) {
                VAlq_Conf.dispose();
            }

            if (e.getSource() == VAlq_Conf.jbtnConfirmarCompra) {
                //grabando cabecera de alquiler                
                alquiler = Formatos.FormatoAlquiler.LeerAlquiler(fechaAlquiler, diasAlquiler,
                        fechaSalidaHerramienta,fechaRetornoHerramienta,
                        montofinal,garantia,precioTraslado,precioAlquiler, estado,
                        conTraslado,direccionEntrega,serieFacBol,nroFacBol,serieCorrFacBol,
                        idempleado,idcliente);
                cruda.Alquiler_Insertar(alquiler);                
                int idalquiler = cruda.ConsultarCantidadDeFacturas();
                
                //grabando detalles de alquiler
                for (int i = 0; i < VAlq_Ed.jtblTablaVenta.getRowCount(); i++) {
                    DetallesAlquiler detA = new DetallesAlquiler();
                    detA = Formatos.FormatoDetalleAlquiler.LeerDetalleAlquiler((Double.parseDouble(VAlq_Ed.jtblTablaVenta.getValueAt(i, 6).toString())*diasAlquiler) ,
                             Integer.parseInt(VAlq_Ed.jtblTablaVenta.getValueAt(i, 0).toString()), idalquiler);
                    crudda.InsertarRegistroDetallesAlquiler(detA);
                    crudh.ActualizarRegistroHerramientasAlquiler(Integer.parseInt(VAlq_Ed.jtblTablaVenta.getValueAt(i, 0).toString()));
                }
                
                //grabando pago de alquiler
                pago = new Pago();
                pago.setIdAlquiler(idalquiler);
                pago.setImpTotal(alquiler.getImp_Total());
                pago.setFormaDePago(VAlq_Conf.cmbTipoPago.getSelectedItem().toString());
                pago.setNroTransaccion(VAlq_Conf.txtNroTransaccion.getText());                
                CRUDPago crudpg = new CRUDPago();
                crudpg.Pago_Insertar(pago);
                
                //grabando movimientos del pago
                
                    //alquiler
                Movimiento movA = new Movimiento();
                movA.setIdAlquiler(idalquiler);
                movA.setConcepto("Alquiler");
                movA.setIdEmpleado(idempleado);
                movA.setTipoEfectivoElectronico(VAlq_Conf.cmbTipoPago.getSelectedItem().toString());
                movA.setAnulado(false);
                movA.setMonto(alquiler.getImp_Alquiler());
                movA.setTipoIngresoSalida("Ingreso");
                CRUDMovimiento crudm = new CRUDMovimiento();
                crudm.Movimiento_Insertar(movA);
                
                  //garantía
                Movimiento movG = new Movimiento();
                movG.setIdAlquiler(idalquiler);
                movG.setConcepto("Garantia");
                movG.setIdEmpleado(idempleado);
                movG.setTipoEfectivoElectronico(VAlq_Conf.cmbTipoPago.getSelectedItem().toString());
                movG.setAnulado(false);
                movG.setMonto(alquiler.getImp_Garantia());
                movG.setTipoIngresoSalida("Ingreso");
                crudm.Movimiento_Insertar(movG);
                
                 //traslado
                
                 if (alquiler.getImp_Traslado() > 0) {
                    Movimiento movT = new Movimiento();
                    movT.setIdAlquiler(idalquiler);
                    movT.setConcepto("Traslado");
                    movT.setIdEmpleado(idempleado);
                    movT.setTipoEfectivoElectronico(VAlq_Conf.cmbTipoPago.getSelectedItem().toString());
                    movT.setAnulado(false);
                    movT.setMonto(alquiler.getImp_Traslado());
                    movT.setTipoIngresoSalida("Ingreso"); 
                    crudm.Movimiento_Insertar(movT);
                }
                
                VAlq_Conf.dispose();
            }
        }
    }
