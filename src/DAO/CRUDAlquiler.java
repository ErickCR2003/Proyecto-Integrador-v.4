package DAO;

import Formatos.Mensajes;
import Modelo.Cliente;
import Modelo.Empleado;
import Modelo.Alquiler;
import Modelo.Herramienta;
import Modelo.TipoHerramienta;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BarcodeQRCode;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;

public class CRUDAlquiler extends ConectarBD {

    public CRUDAlquiler() {
    }

//    public void MostrarFacturasClienteDNI(JTable tabla, String dni) {
//        String titulos[] = {"Nro° Factura", "Fecha Emision", "Empleado Responsable", "Subtotal", "Descuento", 
//                            "Costo Delivery","Cantidad", "Monto Final"};
//        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
//        tabla.setModel(modelo);
//
//        try {
//            this.obtenerconexion();
//            rs = st.executeQuery("SELECT facturas.idfactura, facturas.fecha, facturas.idempleado, facturas.iddetalles FROM facturas\n"
//                    + "JOIN detalles ON facturas.iddetalles = detalles.iddetalles\n"
//                    + "JOIN cliente ON facturas.idcliente = cliente.idcliente\n"
//                    + "JOIN empleado ON facturas.idempleado = empleado.idempleado\n"
//                    + "WHERE cliente.tipoIdentificacion = 'DNI' AND cliente.numeroIdentifacion = '"+dni+"'");
//            while (rs.next()) {
//                Factura fact = new Factura();
//                fact.setIdfactura(rs.getInt(1));
//                fact.setFecha(LocalDate.parse(rs.getString(2)));
//                fact.setIdempleado(rs.getInt(3));
//                fact.setIddetalles(rs.getInt(4));
//
//                CRUDempleados crude = new CRUDempleados();
//                Empleado datosemp = crude.ConsultarRegistroEmpByID(fact.getIdempleado());
//                fact.setEmpleado(datosemp);
//
//                CRUDdetalles crudd = new CRUDdetalles();
//                Detalles datosdet = crudd.ConsultarRegistroDet(fact.getIddetalles());
//                fact.setDetalles(datosdet);
//                                
//                modelo.addRow(fact.RegistroFactura());
//            } //Fin del while
//
//        } catch (Exception ex) {
//            Mensajes.M1("ERROR!" + ex);
//        } finally {
//            this.cerrarconexion();
//        }
//    }

//    public void MostrarFacturasEmpresaRUC(JTable tabla, String ruc) {
//        String titulos[] = {"Nro° Factura", "Fecha Emision", "Empleado Responsable", "Subtotal", "Descuento", 
//                            "Costo Delivery","Cantidad", "Monto Final"};
//        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
//        tabla.setModel(modelo);
//
//        try {
//            this.obtenerconexion();
//            rs = st.executeQuery("SELECT facturas.idfactura, facturas.fecha, facturas.idempleado, facturas.iddetalles FROM facturas\n"
//                    + "JOIN detalles ON facturas.iddetalles = detalles.iddetalles\n"
//                    + "JOIN cliente ON facturas.idcliente = cliente.idcliente\n"
//                    + "JOIN empleado ON facturas.idempleado = empleado.idempleado\n"
//                    + "WHERE cliente.tipoIdentificacion = 'RUC' AND cliente.numeroIdentifacion = '"+ruc+"'");
//            while (rs.next()) {
//                Factura fact = new Factura();
//                fact.setIdfactura(rs.getInt(1));
//                fact.setFecha(LocalDate.parse(rs.getString(2)));
//                fact.setIdempleado(rs.getInt(3));
//                fact.setIddetalles(rs.getInt(4));
//
//                CRUDempleados crude = new CRUDempleados();
//                Empleado datosemp = crude.ConsultarRegistroEmpByID(fact.getIdempleado());
//                fact.setEmpleado(datosemp);
//
//                CRUDdetalles crudd = new CRUDdetalles();
//                Detalles datosdet = crudd.ConsultarRegistroDet(fact.getIddetalles());
//                fact.setDetalles(datosdet);
//                                
//                modelo.addRow(fact.RegistroFactura());
//            } //Fin del while
//
//        } catch (Exception ex) {
//            Mensajes.M1("ERROR! No se pueden mostrar los registros de la tabla Vuelos en proceso..." + ex);
//        } finally {
//            this.cerrarconexion();
//        }
//    }

//    public void MostrarFacturasPorFechaEspecifica(JTable tabla, String fechaEspecifica) {
//        String titulos[] = {"Nro° Factura", "Fecha Emision", "Empleado Responsable", "Subtotal", "Descuento", 
//                            "Costo Delivery","Cantidad", "Monto Final"};
//        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
//        tabla.setModel(modelo);
//
//        try {
//            this.obtenerconexion();
//            rs = st.executeQuery("SELECT * FROM facturas WHERE fecha = '"+fechaEspecifica+"'");
//            while (rs.next()) {
//                Factura fact = new Factura();
//                fact.setIdfactura(rs.getInt(1));
//                fact.setFecha(LocalDate.parse(rs.getString(2)));
//                fact.setIdempleado(rs.getInt(3));
//                fact.setIddetalles(rs.getInt(4));
//
//                CRUDempleados crude = new CRUDempleados();
//                Empleado datosemp = crude.ConsultarRegistroEmpByID(fact.getIdempleado());
//                fact.setEmpleado(datosemp);
//
//                CRUDdetalles crudd = new CRUDdetalles();
//                Detalles datosdet = crudd.ConsultarRegistroDet(fact.getIddetalles());
//                fact.setDetalles(datosdet);
//                                
//                modelo.addRow(fact.RegistroFactura());
//            } //Fin del while
//
//        } catch (Exception ex) {
//            Mensajes.M1("ERROR! No se pueden mostrar los registros de la tabla Vuelos en proceso..." + ex);
//        } finally {
//            this.cerrarconexion();
//        }
//    }
    
//    public void MostrarFacturasPorFechaRango(JTable tabla, String fechaInicio, String fechaFin) {
//        String titulos[] = {"Nro° Factura", "Fecha Emision", "Empleado Responsable", "Subtotal", "Descuento", 
//                            "Costo Delivery","Cantidad", "Monto Final"};
//        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
//        tabla.setModel(modelo);
//
//        try {
//            this.obtenerconexion();
//            rs = st.executeQuery("SELECT * FROM facturas WHERE fecha BETWEEN '"+fechaInicio+"' AND '"+fechaFin+"'");
//            while (rs.next()) {
//                Factura fact = new Factura();
//                fact.setIdfactura(rs.getInt(1));
//                fact.setFecha(LocalDate.parse(rs.getString(2)));
//                fact.setIdempleado(rs.getInt(3));
//                fact.setIddetalles(rs.getInt(4));
//
//                CRUDempleados crude = new CRUDempleados();
//                Empleado datosemp = crude.ConsultarRegistroEmpByID(fact.getIdempleado());
//                fact.setEmpleado(datosemp);
//
//                CRUDdetalles crudd = new CRUDdetalles();
//                Detalles datosdet = crudd.ConsultarRegistroDet(fact.getIddetalles());
//                fact.setDetalles(datosdet);
//                                
//                modelo.addRow(fact.RegistroFactura());
//            } //Fin del while
//
//        } catch (Exception ex) {
//            Mensajes.M1("ERROR! No se pueden mostrar los registros de la tabla Vuelos en proceso..." + ex);
//        } finally {
//            this.cerrarconexion();
//        }
//    }
//    
//    public void ConsultarTotalGanadoEnElDia(String fechaEspecifica, JLabel etiqueta) {
//        double totalganado = 0; //Vacio
//        try {
//            this.obtenerconexion();
//            rs = st.executeQuery("SELECT SUM(montofinal) FROM detalles\n" +
//                                 "JOIN facturas ON detalles.iddetalles = facturas.iddetalles WHERE fecha = '" + fechaEspecifica + "'");
//            if (rs.next()) {//Si tiene registro la consulta
//                totalganado = rs.getDouble(1);
//            }
//            etiqueta.setText("Ingreso del Dia:  S/." + totalganado);
//            //conexion.close();
//        } catch (Exception ex) {
//            Mensajes.M1("ERROR!..." + ex);
//        } finally {
//            this.cerrarconexion();
//        } 
//    }
//    
//    public void ConsultarTotalGanadoEnRango(String fechaInicio, String fechaFin, JLabel etiqueta) {
//        double totalganado = 0; //Vacio
//        try {
//            this.obtenerconexion();
//            rs = st.executeQuery("SELECT SUM(montofinal) FROM detalles\n" +
//                                 "JOIN facturas ON detalles.iddetalles = facturas.iddetalles WHERE fecha BETWEEN '"+fechaInicio+"' AND '"+fechaFin+"'");
//            if (rs.next()) {//Si tiene registro la consulta
//                totalganado = rs.getDouble(1);
//            }
//            etiqueta.setText("Ingreso Total:  S/." + totalganado);
//            //conexion.close();
//        } catch (Exception ex) {
//            Mensajes.M1("ERROR!..." + ex);
//        } finally {
//            this.cerrarconexion();
//        } 
//    }

    public int ConsultarCantidadDeFacturas() {
        int cantidad = 0; //Vacio
        try {
            this.obtenerconexion();
            rs = st.executeQuery("SELECT COUNT(*) FROM alquiler;");
            if (rs.next()) {//Si tiene registro la consulta
                cantidad = rs.getInt(1);
            }
            
            //conexion.close();
        } catch (Exception ex) {
            Mensajes.M1("ERROR!..." + ex);
        } finally {
            this.cerrarconexion();
        } 
        return cantidad;
    }
    
    public void Alquiler_Insertar(Alquiler alq) {
        try {
            this.obtenerconexion();
            // preparedStatament permite especificar parametros en la consulta a traves del simbolo la interrogante (?)
            ps = conexion.prepareStatement("INSERT INTO alquiler (fecHoraCreacion, diasAlquiler, fecHoraSalida, fecHoraRetorno, imp_Total,"
                    + "imp_Garantia,imp_Traslado,estado,conTraslado,direccionEntrega,SerieFacBol,NroFacBol,serieCorrFacBol,idEmpleado,idCliente) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
            ps.setObject(1, alq.getFecHoraCreacion());
            ps.setInt(2, alq.getDiasAlquiler());
            ps.setObject(3, alq.getFecHoraSalida());
            ps.setObject(4, alq.getFecHoraRetorno());
            ps.setDouble(5, alq.getImp_Total());
            ps.setDouble(6, alq.getImp_Garantia());
            ps.setDouble(7, alq.getImp_Traslado());
            ps.setString(8, alq.getEstado());
            ps.setBoolean(9, alq.isConTraslado());
            ps.setString(10, alq.getDireccionEntrega());
            ps.setString(11, alq.getSerieFacBol());
            ps.setInt(12, alq.getNroFacBol());
            ps.setString(13, alq.getSerieCorrFacBol());
            ps.setInt(14, alq.getIdEmpleado());
            ps.setInt(15, alq.getIdCliente());
            ps.executeUpdate(); // actualiza y ejecuta la consulta
            
            Mensajes.M1("Datos registrados correctamente...");  
        } catch (Exception ex) {
            Mensajes.M1("ERROR! No se puede insertar el registro..." + ex);
        } finally {
            this.cerrarconexion();
        }
    }
    
        
      public void Alquiler_Lista(JTable tabla, JLabel etiqueta) {
        String titulos[] = {"ID", "Estado", "NomCliente", "Tipo Doc.", "Ruc/Dni", "Fecha Salida", "Fecha Retorno", "Factura", "Importe", "Empleado" };
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        tabla.setModel(modelo);
        int numeracion = 0;
        try {
            this.obtenerconexion();
            rs = st.executeQuery("SELECT ID, estado, NomCliente, TipoRucDniCli, RucDniCli, fecHoraSalida, fecHoraRetorno, SerieCorrFacBol, imp_Total, NomEmpleado FROM lst_alquileres;");
            while (rs.next()) {
                numeracion++;
                Object[] alq = new Object[]{
                rs.getInt(1), 
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5),
                rs.getDate(6),
                rs.getDate(7),
                rs.getString(8),
                rs.getDouble(9),
                rs.getString(10)
                };
                modelo.addRow(alq); 
            } //Fin del while
            //conexion.close();
            etiqueta.setText("Numero de registros : " + numeracion);
            } catch (Exception ex) {
                Mensajes.M1("ERROR! No se pueden mostrar los registros de la tabla alquilerres..." + ex);
            } finally {
                this.cerrarconexion();
            }
        }
    
    
    
    public int UltimoRegistroFactura() {
        int id = 0;
        try {
            this.obtenerconexion();
            rs = st.executeQuery("SELECT herramienta.ID FROM herramienta ORDER BY ID DESC LIMIT 1;");
            if (rs.next()) {//Si tiene registro la consulta
                id = rs.getInt(1);
            }

        } catch (Exception ex) {
            Mensajes.M1("ERROR! No se pueden mostrar los registros de la tabla Vuelos en proceso..." + ex);
        } finally {
            this.cerrarconexion();
        }
        return id;
    }
    
//        public Factura UltimoRegistroFactura() {
//        Factura fact = null;
//        try {
//            this.obtenerconexion();
//            rs = st.executeQuery("SELECT * FROM facturas ORDER BY idfactura DESC LIMIT 1;");
//            while (rs.next()) {
//                fact = new Factura();
//                fact.setIdfactura(rs.getInt(1));
//                fact.setFecha(LocalDate.parse(rs.getString(2)));
//                fact.setIdempleado(rs.getInt(3));
//                fact.setIddetalles(rs.getInt(4));
//                fact.setIdcliente(rs.getInt(5));
//
//                CRUDempleados crude = new CRUDempleados();
//                Empleado datosemp = crude.ConsultarRegistroEmpByID(fact.getIdempleado());
//                fact.setEmpleado(datosemp);
//
//                
//                CRUDclientes crudc = new CRUDclientes();
//                Cliente datoscli = crudc.ConsultarRegistroCliente_Recibo(fact.getIdcliente());
//                fact.setCliente(datoscli);
//                                            
//            } //Fin del while
//
//        } catch (Exception ex) {
//            Mensajes.M1("ERROR! No se pueden mostrar los registros de la tabla Vuelos en proceso..." + ex);
//        } finally {
//            this.cerrarconexion();
//        }
//        return fact;
//    }
    
    public void ImprimirPDF(int numrecibo, String fecha,String dniCliente,String nomCliente,String hora, String vendedor,double descuento,int cantProductos,double subtotal,double igv, double totalGeneral, List lista) {
        try {
            String DatoRUC = "";
            String mensaje = "¡Gracias por su compra!";
            String empresa = "Voltea la página";
            String establecimiento = "Establecimiento";
            String datoRUC = "204141185428";
            String direccionEst = "Bolognesi 510, Miraflores 15076";
            String distritoEst = "Miraflores";
            
            
            Font fontEspacio = new Font(Font.FontFamily.COURIER, 3, Font.NORMAL, BaseColor.BLACK);
            Font fuente = new Font(Font.FontFamily.COURIER, 8, Font.NORMAL, BaseColor.BLACK); //Fuente
            Font negrita = new Font(Font.FontFamily.COURIER, 8, Font.BOLD, BaseColor.BLACK); //Fuente

            Rectangle pageSize = new Rectangle(226f, 842.2f);
            String url = FileSystemView.getFileSystemView().getDefaultDirectory().getPath();
            FileOutputStream archivo;
            File salida = new File(url + File.separator + "Impresion.pdf"); //Nombre de guardado

            archivo = new FileOutputStream(salida);
            Document doc = new Document(pageSize, (float) 15, 15, 10, 10);//tamaño de página, borde izquierdo, borde derecho, margen superior , margen inferior
            PdfWriter.getInstance(doc, archivo);
            doc.open();

            //Contenido del ticket
            //Titulo empresa
            Paragraph DatosEmpresa = new Paragraph();
            DatosEmpresa.add(new Phrase(empresa.toUpperCase(), fuente));//Añadimos el nombre de la empresa
            DatosEmpresa.setAlignment(Element.ALIGN_CENTER);
            doc.add(DatosEmpresa);//Agregamos el texto al documento
            //doc.add(Chunk.NEWLINE);//Salto de linea

            //Titulo nombre Establecimiento
            Paragraph nombreEstablecimiento = new Paragraph();
            nombreEstablecimiento.add(new Phrase(establecimiento.toUpperCase(), fuente));//Añadimos el establecimiento
            nombreEstablecimiento.setAlignment(Element.ALIGN_CENTER);
            doc.add(nombreEstablecimiento);//Agregamos el texto al documento
            //doc.add(Chunk.NEWLINE);//Salto de linea

            //Titulo RUC
            Paragraph RUC = new Paragraph();
            RUC.add(new Phrase(datoRUC.toUpperCase(), fuente));//Añadimos el RUC
            RUC.setAlignment(Element.ALIGN_CENTER);
            doc.add(RUC);//Agregamos el texto al documento
            //doc.add(Chunk.NEWLINE);//Salto de linea

            //Titulo Direccion
            Paragraph Direccion = new Paragraph();
            Direccion.add(new Phrase(direccionEst.toUpperCase(), fuente));//Añadimos la direcciòn del establecimiento
            Direccion.setAlignment(Element.ALIGN_CENTER);
            doc.add(Direccion);//Agregamos el texto al documento
            //doc.add(Chunk.NEWLINE);//Salto de linea

            //Titulo Distrit
            Paragraph Distrito = new Paragraph();
            Distrito.add(new Phrase(distritoEst.toUpperCase(), fuente));//Añadimos el distrito de la empresa
            Distrito.setAlignment(Element.ALIGN_CENTER);
            doc.add(Distrito);//Agregamos el texto al documento
            //doc.add(Chunk.NEWLINE);//Salto de linea

            //Titulo empresa
            Paragraph FacturaElectronica = new Paragraph();
            FacturaElectronica.add(new Phrase("BOLETA DE VENTA ELECTRONICA", negrita));
            FacturaElectronica.setAlignment(Element.ALIGN_CENTER);
            doc.add(FacturaElectronica);//Agregamos el texto al documento
            //doc.add(Chunk.NEWLINE);//Salto de linea
            DecimalFormat localFormat = new DecimalFormat("000");
            //Titulo Direccion
            Paragraph NumeroFactura = new Paragraph();
            NumeroFactura.add(new Phrase(localFormat.format(1) + "-" + localFormat.format(1) + " N° " + String.valueOf(numrecibo).toUpperCase(), fuente));
            NumeroFactura.setAlignment(Element.ALIGN_CENTER);
            doc.add(NumeroFactura);//Agregamos el texto al documento
            doc.add(Chunk.NEWLINE);//Salto de linea
            //doc.add(Chunk.NEWLINE);//Salto de linea

            //Datos de facturación
            PdfPTable Datos = new PdfPTable(2);
            Datos.setWidthPercentage(100);

            float[] tamanoDatosFacturacion = new float[]{50f, 50f};
            Datos.setWidths(tamanoDatosFacturacion);
            Datos.setHorizontalAlignment(Element.ALIGN_LEFT);
            Datos.getDefaultCell().setBorder(0);

            //Insertar Fecha de Emision
            Datos.addCell(new Phrase("Fecha de emisión  :".toUpperCase(), fuente));
            Datos.addCell(new Phrase(fecha.toUpperCase(), fuente));
            //Insertar Documento de Identidad
            Datos.addCell(new Phrase("DOC. IDENTIDAD    :".toUpperCase(), fuente));
            Datos.addCell(new Phrase(dniCliente.toUpperCase(), fuente));
            //Insertar comprador
            Datos.addCell(new Phrase("Señor/a           :".toUpperCase(), fuente));
            Datos.addCell(new Phrase(nomCliente.toUpperCase(), fuente));
            //Insertar Hora
            Datos.addCell(new Phrase("HORA              :".toUpperCase(), fuente));
            Datos.addCell(new Phrase(hora.toUpperCase(), fuente));
            //Insertar Nª local
            Datos.addCell(new Phrase("LOCAL             :".toUpperCase(), fuente));
            Datos.addCell(new Phrase(localFormat.format(1).toUpperCase(), fuente));
            //Insertar CAJA
            Datos.addCell(new Phrase("CAJA              :".toUpperCase(), fuente));
            Datos.addCell(new Phrase(localFormat.format(1).toUpperCase(), fuente));
            //Insertar Tipo de Moneda
            Datos.addCell(new Phrase("TIPO DE MONEDA    :".toUpperCase(), fuente));
            Datos.addCell(new Phrase("NUEVO SOL".toUpperCase(), fuente));
            //Insertar Vendedor
            Datos.addCell(new Phrase("Vendedor          :".toUpperCase(), fuente));
            Datos.addCell(new Phrase(vendedor.toUpperCase(), fuente));

            doc.add(Datos);
            doc.add(Chunk.NEWLINE);//Salto de linea

            //Mostrar datos del producto
            //Contenido del Documento
            PdfPTable producto = new PdfPTable(3);
            producto.setWidthPercentage(100);

            //creamos 4 espacios en el encabezado
            float[] tamanoProducto = new float[]{20f, 60f, 20f};
            producto.setWidths(tamanoProducto);
            producto.setHorizontalAlignment(Element.ALIGN_LEFT);
            producto.getDefaultCell().setBorder(0);

            //Encabezado productos
            PdfPCell Codigo = new PdfPCell(new Phrase("CÓDIGO", negrita));
            PdfPCell DescPro = new PdfPCell(new Phrase("DESCRIPCIÓN" + "\nCANTIDAD X PRECIO UNITARIO\n", negrita));
            PdfPCell TotalPro = new PdfPCell(new Phrase("TOTAL", negrita));

            Codigo.setBorder(PdfPCell.TOP);//Bordes superiores
            DescPro.setBorder(PdfPCell.TOP);//Bordes superiores
            TotalPro.setBorder(PdfPCell.TOP);//Bordes superiores

            producto.addCell(Codigo);
            producto.addCell(DescPro);
            producto.addCell(TotalPro);
            //Agregado de un espacio
            PdfPCell espacio = new PdfPCell(new Phrase(" ", fontEspacio));
            espacio.setBorder(PdfPCell.BOTTOM);//Bordes inferiores

            producto.addCell(espacio);//Insertamos el espacio
            producto.addCell(espacio);//Insertamos el espacio
            producto.addCell(espacio);//Insertamos el espacio
            
            List <Herramienta> libroLista = lista;
            
            for (int i = 0; i < lista.size(); i++) {
//                producto.addCell(new Phrase(String.valueOf(libroLista.get(i).getIdlibro()), fuente));
//                producto.addCell(new Phrase(libroLista.get(i).getTitulo() + "\n " + libroLista.get(i).getCantidad() + " X " + libroLista.get(i).getPrecio(), fuente));
//                producto.addCell(new Phrase(String.valueOf(libroLista.get(i).getCantidad()*libroLista.get(i).getPrecio()), fuente));
            }
    
            
            doc.add(producto);//Fin detalle Productos

            //Mostrar Total a Pagar
            doc.add(Chunk.NEWLINE);

            PdfPTable Operacion = new PdfPTable(2);
            Operacion.setWidthPercentage(100);

            float[] tamanoOperacion = new float[]{80f, 20f};
            Operacion.setWidths(tamanoOperacion);
            Operacion.getDefaultCell().setBorder(0);
            Operacion.setHorizontalAlignment(Element.ALIGN_RIGHT);

            DecimalFormat formateador = new DecimalFormat("####.##");
            DecimalFormat redondeado = new DecimalFormat("####.#");

            //Insertar Descuentos
            Operacion.addCell(new Phrase("TOTAL DESCUENTOS      S/".toUpperCase(), fuente));
            Operacion.addCell(new Phrase(formateador.format(descuento).toUpperCase(), fuente));
            //Insertar Total Articulos
            Operacion.addCell(new Phrase("LIBROS DIFERENTES".toUpperCase(), fuente));
            Operacion.addCell(new Phrase(String.valueOf(cantProductos).toUpperCase(), fuente));
            //Insertar OP EXONERADA
            Operacion.addCell(new Phrase("OP. EXONERADA         S/".toUpperCase(), fuente));
            Operacion.addCell(new Phrase("0.00".toUpperCase(), fuente));
            //Insertar OP INAFECTA
            Operacion.addCell(new Phrase("OP. INAFECTA          S/".toUpperCase(), fuente));
            Operacion.addCell(new Phrase("0.00".toUpperCase(), fuente));
            //Insertar OP GRAVADA
            Operacion.addCell(new Phrase("OP. GRAVADA           S/".toUpperCase(), fuente));
            Operacion.addCell(new Phrase(formateador.format(subtotal).toUpperCase(), fuente));
            //Insertar I.S.C
            Operacion.addCell(new Phrase("I.S.C.".toUpperCase(), fuente));
            Operacion.addCell(new Phrase(" ".toUpperCase(), fuente));
            //Insertar I.G.V
            Operacion.addCell(new Phrase("I.G.V.                S/".toUpperCase(), fuente));
            Operacion.addCell(new Phrase(formateador.format(igv).toUpperCase(), fuente));
            //Insertar IMPORTE TOTAL
            Operacion.addCell(new Phrase("IMPORTE TOTAL         S/".toUpperCase(), fuente));
            Operacion.addCell(new Phrase(formateador.format(totalGeneral).toUpperCase(), fuente));
            //Insertar REDONDEO
            //Operacion.addCell(new Phrase("REDONDEO              S/".toUpperCase(), fuente));
            //Operacion.addCell(new Phrase(redondeado.format(totalGeneral).toUpperCase(), fuente));
            //Insertar REDONDEO
            //Operacion.addCell(new Phrase("IMPORTE A PAGAR       S/".toUpperCase(), fuente));
            //Operacion.addCell(new Phrase(redondeado.format(totalGeneral).toUpperCase(), fuente));
            doc.add(Operacion);

            doc.add(Chunk.NEWLINE);//Salto de linea
            //Generar QR
            float[] tamañoQR = new float[]{30f, 40f, 30f};
            PdfPTable QR = new PdfPTable(3);
            QR.setWidthPercentage(100);
            QR.setWidths(tamañoQR);
            QR.setHorizontalAlignment(Element.ALIGN_CENTER);
            QR.getDefaultCell().setBorder(0);
            DecimalFormat numero_de_venta = new DecimalFormat("00000000");
            String textCodigoQR = DatoRUC + "|" + "03" + "|" + localFormat.format(1) + "-" + localFormat.format(1) + "|" + numero_de_venta.format(numrecibo) + "|" + igv + "|" + totalGeneral + "|" + fecha + "|" + "0" + "|" + "1";
            BarcodeQRCode codigoBarrasQR = new BarcodeQRCode(textCodigoQR, 0, 0, null);

            QR.addCell("");
            QR.addCell(codigoBarrasQR.getImage());
            QR.addCell("");
            doc.add(QR);//Fin insertar QR
            doc.add(Chunk.NEWLINE);//Salto de linea

            //Mensaje de empresa
            Paragraph Mensaje = new Paragraph();
            Mensaje.add(new Phrase(mensaje.toUpperCase(), fuente));
            Mensaje.setAlignment(Element.ALIGN_CENTER);
            doc.add(Mensaje);//Agregamos el texto al documento

            doc.close();//Cierra el pdf
            archivo.close();//Cierra el archivo

            //Impresiòn del pdf
            FileInputStream inputStream = null;

            try {
                String urlxd = FileSystemView.getFileSystemView().getDefaultDirectory().getPath();
                inputStream = new FileInputStream(urlxd + "\\Impresion.pdf");
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al guardar");
            }
            if (inputStream == null) {
                System.err.println("error");
                return;
            } else {
                Mensajes.M1("Se ha creado el pdf.");
            }
            /*DocFlavor docFormat = DocFlavor.INPUT_STREAM.AUTOSENSE;
            Doc document = new SimpleDoc(inputStream, docFormat, null);
            PrintRequestAttributeSet attributeSet = new HashPrintRequestAttributeSet();
            PrintService defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();

            if (defaultPrintService != null) {
                DocPrintJob printJob = defaultPrintService.createPrintJob();
                try {
                    printJob.print(document, attributeSet);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                System.err.println("No existen impresoras instaladas");
            }*/

            inputStream.close();
            //imprimirFin(subTotal, total, dineroR, devolucion); //ESTE METODO NO SE UTILIZARA

        } catch (DocumentException | HeadlessException | IOException e) {

        }
    }
}
