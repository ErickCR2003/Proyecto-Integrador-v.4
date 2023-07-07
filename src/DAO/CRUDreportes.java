/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Formatos.ManejadorTablas;
import Formatos.Mensajes;
import Modelo.Alquiler;
import Modelo.Herramienta;
import Modelo.Reporte;
import Modelo.TipoHerramienta;
import com.toedter.calendar.JDateChooser;
import java.beans.Statement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author julis
 */
public class CRUDreportes extends ConectarBD {
        
     public void MostrarHerramientasAlquiladasPorFecha(JTable tabla,JDateChooser fechaDesde, 
             JDateChooser fechaHasta, JLabel cha, JLabel tr ){ 
         
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String fechaFormateada = sdf.format(fechaDesde.getDate());
        
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String fechaFormateada2 = sdf2.format(fechaHasta.getDate());
         
        String titulos[]={"Cod. alquiler","fecha creacion","cod. herramienta","Descripcion","Precio","Cliente","Importe total","estado"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        tabla.setModel(modelo);        
        
        int numeracion=0;
        double recaudacionTotal = 0;
        try {
            this.obtenerconexion();            
            String query = "SELECT a.ID,a.fecHoraCreacion,da.idHerramienta,h.nombre,h.imp_PrecioAlquiler,c.nombrecompleto,a.imp_Total,a.estado FROM alquiler a \n" +
            "inner join detallesalquiler da on a.ID = da.ID\n" +
            "inner join herramienta h on h.ID = da.idHerramienta\n" +
            "inner join  cliente c on c.ID = a.idCliente\n" +
            "WHERE  fecHoraCreacion BETWEEN ? AND ?";
            
            ps = conexion.prepareStatement(query);
            ps.setString(1,fechaFormateada);         
            ps.setString(2, fechaFormateada2);
            rs = ps.executeQuery();
            
        while(rs.next()){
            numeracion++;
            Reporte re = new Reporte();  
            re.setCodAlquiler( rs.getInt("ID"));
            re.setFechaCreacion(rs.getDate("fecHoraCreacion"));
            re.setCodHerramienta(rs.getInt("idHerramienta"));
            re.setNombreHerramienta(rs.getString("nombre"));
            re.setPrecioAlquiler(rs.getDouble("imp_PrecioAlquiler"));           
            re.setNombreCliente(rs.getString("nombrecompleto"));
            re.setImporteTotal(rs.getDouble("imp_Total"));
            re.setEstado(rs.getString("estado"));         
                    
            recaudacionTotal = recaudacionTotal + re.getImporteTotal();
            
            modelo.addRow(re.RegistroReporte(numeracion));            
            
        }
        cha.setText("Total de herramientas alquiladas : " + numeracion);
        tr.setText("Total recaudado: " + recaudacionTotal);
        
        ManejadorTablas.FormatoTablaClientes(tabla);
        
        } catch (SQLException ex) {
            Mensajes.M1("Error! No se puedes mostrar los registros del reporte" + ex);
        }finally{
            this.cerrarconexion();
        }
     }
    
     
     
     public void Mostrar10HerramientasAlquiladas(JTable tabla){         
        String titulos[]={"Cod. alquiler","fecha creacion","cod. herramienta","Descripcion","Precio","Cliente","Importe total","estado"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        tabla.setModel(modelo);       
        
        int numeracion=0;   
        try {
         this.obtenerconexion(); 
        String query = "SELECT a.ID, a.fecHoraCreacion, h.ID, h.nombre, h.imp_PrecioAlquiler, SUM(a.imp_Total) AS total_ingreso, c.nombrecompleto, a.estado " +
                 "FROM alquiler a " +
                 "INNER JOIN detallesalquiler da ON a.ID = da.ID " +
                 "INNER JOIN herramienta h ON h.ID = da.idHerramienta " +
                 "INNER JOIN cliente c ON c.ID = a.idCliente " +
                 "GROUP BY a.ID " +
                 "ORDER BY total_ingreso DESC " +
                 "LIMIT 10;";
         
        ps = conexion.prepareStatement(query);
        rs = ps.executeQuery();
            
        while(rs.next()){
            numeracion++;
            System.out.println("perro"+rs);
            Reporte re = new Reporte();  
            re.setCodAlquiler(rs.getInt("ID"));
            re.setFechaCreacion(rs.getDate("fecHoraCreacion"));
            re.setCodHerramienta(rs.getInt("ID"));
            re.setNombreHerramienta(rs.getString("nombre"));
            re.setPrecioAlquiler(rs.getDouble("imp_PrecioAlquiler"));
            re.setNombreCliente(rs.getString("nombrecompleto"));
            re.setImporteTotal(rs.getDouble("total_ingreso")); // Corregido para utilizar el alias total_ingreso
            re.setEstado(rs.getString("estado"));     
             
            modelo.addRow(re.RegistroReporte(numeracion));   
        }     
        
        ManejadorTablas.FormatoTablaClientes(tabla);
        
        } catch (SQLException ex) {
            Mensajes.M1("Error! No se puedes mostrar los registros del reporte" + ex);
        }finally{
            this.cerrarconexion();
        }           
     }
     

    public void MostrarHerramientasNuncaSeVendio(JTable tabla){
        String titulos[] = {"ID", "Serie", "Nombre", "Tipo", "Valor Referencial", "Año fabric.", "Peso", "Precio", "Nro. alquileres", "Estado"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        tabla.setModel(modelo);  
        
        int numeracion = 0;
        
        try {
            this.obtenerconexion();            
            String query = "SELECT \n" +
            "    h.ID,\n" +
            "    h.nroSerie,\n" +
            "    h.nombre,\n" +
            "    h.idTipo,\n" +
            "    h.imp_ValorReferencial,\n" +
            "    h.anioFabricacion,\n" +
            "    h.peso,\n" +
            "    h.imp_PrecioAlquiler,\n" +
            "    h.fecAdquisicion,\n" +
            "    h.nroAlquileres,\n" +
            "    h.estado\n" +
            "FROM\n" +
            "    herramienta h\n" +
            "WHERE\n" +
            "    h.ID NOT IN (SELECT DISTINCT\n" +
            "            da.idHerramienta\n" +
            "        FROM\n" +
            "            alquiler a\n" +
            "                INNER JOIN\n" +
            "            detallesalquiler da ON a.ID = da.ID);";
            
            ps = conexion.prepareStatement(query);           
            rs = ps.executeQuery();
            
        while(rs.next()){
            
            numeracion++;
            Herramienta her = new Herramienta();
            
            her.setID(rs.getInt(1));
            her.setNroSerie(rs.getString(2));
            her.setNombre(rs.getString(3));
            her.setIdTipo(rs.getInt(4));
            her.setImp_ValorReferencial(rs.getDouble(5));
            her.setAnioFabricacion(rs.getInt(6));
            her.setPeso(rs.getDouble(7));
            her.setImp_PrecioAlquiler(rs.getDouble(8));
            her.setFecAdquisicion(LocalDate.parse(rs.getString(9)));
            her.setNroAlquileres(rs.getInt(10));
            her.setEstado(rs.getString(11));
            
            CRUDtipos crudt = new CRUDtipos();
            TipoHerramienta tp = crudt.ConsultarTipoPorId(her.getIdTipo());
            her.setTipo(tp);
            
            modelo.addRow(her.RegistroHerramientaAlquiler(numeracion));

        }
         ManejadorTablas.FormatoTablaHerramientas(tabla);
    }catch (SQLException ex) {
            Mensajes.M1("Error! No se puedes mostrar los registros del reporte" + ex);
    }finally{
            this.cerrarconexion();
    }
}
    
}
