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
    //desde
    SimpleDateFormat sdf1;
    String ff1;
    
    //hasta
    SimpleDateFormat sdf2;
    String ff2;
    
    
     public void MostrarHerramientasAlquiladasPorFecha(JTable tabla,JDateChooser fechaDesde, 
             JDateChooser fechaHasta, JLabel cha, JLabel tr ){ 
         
        sdf1 = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        ff1 = sdf1.format(fechaDesde.getDate());
        
        sdf2  = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        ff2 = sdf2.format(fechaHasta.getDate());
         
        String titulos[]={"Cod.alquiler","fech creación","Dias de alquiler","fech salida","fech retorno","Cliente","Importe total","estado"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        tabla.setModel(modelo);        
        
        int numeracion=0;
        double recaudacionTotal = 0;
        try { 
            this.obtenerconexion();            
            String query = "SELECT a.ID,a.fecHoraCreacion,a.diasAlquiler,a.fecHoraSalida,a.fecHoraRetorno,c.nombrecompleto,a.imp_Total,a.estado FROM alquiler a \n" +
            "inner join detallesalquiler da on a.ID = da.ID\n" +
            "inner join herramienta h on h.ID = da.idHerramienta\n" +
            "inner join  cliente c on c.ID = a.idCliente\n" +
            "WHERE  fecHoraCreacion BETWEEN ? AND ?";
            
            ps = conexion.prepareStatement(query);
            ps.setString(1,ff1);         
            ps.setString(2, ff2);
            rs = ps.executeQuery();
            
        while(rs.next()){
            numeracion++;
            Reporte re = new Reporte();  
            re.setCodAlquiler( rs.getInt("ID"));
            re.setFechaCreacion(rs.getDate("fecHoraCreacion"));            
            re.setDiasAlquiler(rs.getInt("diasAlquiler"));
            re.setFechaSalida(rs.getDate("fecHoraSalida"));
            re.setFechaRetorno(rs.getDate("fecHoraRetorno"));             
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
    
     
     
     public void Mostrar10HerramientasAlquiladas(JTable tabla,JDateChooser fechaDesde, 
             JDateChooser fechaHasta,JLabel jLabel_descripcion){ 
         
        sdf1 = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        ff1 = sdf1.format(fechaDesde.getDate());
        
        sdf2  = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        ff2 = sdf2.format(fechaHasta.getDate());
        
        
        String titulos[]={"Cod producto", "Nombre", "Año fabric.","Fech adquisión", "Peso","Precio alquiler", "Nro. alquileres", "Estado","Ingreso generado"};
        
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        tabla.setModel(modelo);    

        int numeracion=0;   
        try {
         this.obtenerconexion(); 
        String query = "SELECT dv.idHerramienta,h.nombre,h.anioFabricacion,h.fecAdquisicion,h.peso,h.imp_PrecioAlquiler,h.nroAlquileres,h.estado, SUM(dv.imp_montofinal) AS ingresos_generados\n" +
                        "FROM detallesalquiler dv\n" +
                        "JOIN alquiler v ON dv.idAlquiler = v.ID\n" +
                        "inner join herramienta h on dv.idHerramienta = h.ID\n" +
                        "where v.fecHoraCreacion between ? and ?\n" +
                        "GROUP BY  dv.idHerramienta\n" +
                        "ORDER BY ingresos_generados DESC\n" +
                        "LIMIT 10;\n" +
                        "             ";   
        
            ps = conexion.prepareStatement(query);
            ps.setString(1,ff1);         
            ps.setString(2, ff2);
            rs = ps.executeQuery();
            
        while(rs.next()){
            numeracion++;            
            Herramienta her = new Herramienta();       
            
            her.setID(rs.getInt("idHerramienta"));         
            her.setNombre(rs.getString("nombre"));          
            her.setAnioFabricacion(rs.getInt("anioFabricacion"));
            her.setFecAdquisicion(LocalDate.parse(rs.getString("fecAdquisicion")));
            her.setPeso(rs.getDouble("peso"));  
            her.setImp_PrecioAlquiler(rs.getDouble("imp_PrecioAlquiler"));
            her.setNroAlquileres(rs.getInt("nroAlquileres"));
            her.setEstado(rs.getString("estado"));
            her.setImporteFinal(rs.getDouble("ingresos_generados"));
             
            modelo.addRow(her.Reporte10Herramienta(numeracion)); 
        } 
         jLabel_descripcion.setText("Lista de las 10 herramientas que mas ingreso generaron");
        
        ManejadorTablas.FormatoTablaClientes(tabla);
        
        } catch (SQLException ex) {
            Mensajes.M1("Error! No se puedes mostrar los registros del reporte" + ex);
        }finally{
            this.cerrarconexion();
        }           
     }
     

    public void MostrarHerramientasNuncaSeAlquilo(JTable tabla,JDateChooser fechaDesde, 
             JDateChooser fechaHasta, JLabel jLabel_descripcion){
        
        sdf1 = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        ff1 = sdf1.format(fechaDesde.getDate());
        
        sdf2  = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        ff2 = sdf2.format(fechaHasta.getDate());
        
        String titulos[]={"Cod producto", "Nombre", "Año fabric.","Fech adquisión", "Peso","precio de alquiler", "Nro. alquileres", "Estado"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        tabla.setModel(modelo);   
        
        int numeracion = 0;
        
        try {
            this.obtenerconexion();  
            
            String query = "SELECT \n" +
"            h.ID,       \n" +
"            h.nombre,   \n" +
"            h.anioFabricacion, \n" +
"            h.fecAdquisicion,\n" +
"            h.peso,\n" +
"            h.imp_PrecioAlquiler, \n" +
"            h.nroAlquileres,\n" +  
"            h.estado\n" +
"            FROM\n" +
"            herramienta h\n" +
"            WHERE\n" +
"           h.nroAlquileres = 0 and h.fecAdquisicion between ?  and ? ;";
            
            ps = conexion.prepareStatement(query);
            ps.setString(1,ff1);         
            ps.setString(2, ff2);
            rs = ps.executeQuery();
            
        while(rs.next()){
            
            numeracion++;
            Herramienta her = new Herramienta();
            
             her.setID(rs.getInt(1));         
            her.setNombre(rs.getString(2));          
            her.setAnioFabricacion(rs.getInt(3));
            her.setFecAdquisicion(LocalDate.parse(rs.getString(4)));
            her.setPeso(rs.getDouble(5));  
            her.setImp_PrecioAlquiler(rs.getDouble(6));
            her.setNroAlquileres(rs.getInt(7));
            her.setEstado(rs.getString(8)); 
            
            
            modelo.addRow(her.ReporteHerramientaNucaAlquiladas(numeracion));

        }
         jLabel_descripcion.setText("Lista de herramientas que nunca se alquilaron");
         ManejadorTablas.FormatoTablaHerramientas(tabla);
    }catch (SQLException ex) {
            Mensajes.M1("Error! No se puedes mostrar los registros del reporte" + ex);
    }finally{
            this.cerrarconexion();
    }
}
    
}
