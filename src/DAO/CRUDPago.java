package DAO;

import Formatos.Mensajes;
import Modelo.Pago;
import Modelo.Empleado;
import Modelo.Alquiler;
import Modelo.Herramienta;
import Modelo.Movimiento;
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

public class CRUDPago extends ConectarBD {

       
    
    public CRUDPago() {
    }

    
    public void Pago_Insertar(Pago pg) {
        try {
            this.obtenerconexion();
            // preparedStatament permite especificar parametros en la consulta a traves del simbolo la interrogante (?)
            ps = conexion.prepareStatement("INSERT INTO Pago(fecHoraCreacion, idAlquiler, imp_Total, formaDePago, nroTransaccion) "
                    + " VALUES(?,?,?,?,?);");
            ps.setObject(1, LocalDate.now());
            ps.setInt(2, pg.getIdAlquiler());
            ps.setDouble(3, pg.getImpTotal());
            ps.setString(4, pg.getFormaDePago());
            ps.setString(5, pg.getNroTransaccion());
            ps.executeUpdate(); // actualiza y ejecuta la consulta
            
            //Mensajes.M1("Datos registrados correctamente...");  
        } catch (Exception ex) {
            Mensajes.M1("ERROR! No se puede insertar el registro..." + ex);
        } finally {
            this.cerrarconexion();
        }
    }
}
