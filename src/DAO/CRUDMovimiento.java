package DAO;

import Formatos.Mensajes;
import Modelo.Movimiento;
import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Locale;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CRUDMovimiento extends ConectarBD {
       
    
    public CRUDMovimiento() {
    }

    
    public void Movimiento_Insertar(Movimiento mov) {
        try {
            this.obtenerconexion();
            // preparedStatament permite especificar parametros en la consulta a traves del simbolo la interrogante (?)
            ps = conexion.prepareStatement("INSERT INTO movimiento (idAlquiler, idEmpleado, fecEjecucion, tipoIngresoSalida, concepto, tipoEfectivoElectronico, monto, observ, anulado) "
                    + " VALUES(?,?,?,?,?,?,?,?,?);");
            ps.setInt(1, mov.getIdAlquiler());
            ps.setInt(2, mov.getIdEmpleado());
            ps.setObject(3, LocalDate.now());
            ps.setString(4, mov.getTipoIngresoSalida());
            ps.setString(5, mov.getConcepto());
            ps.setString(6, mov.getTipoEfectivoElectronico());
            ps.setDouble(7, mov.getMonto());
            ps.setString(8, mov.getObserv());
            ps.setBoolean(9, mov.isAnulado());          
            ps.executeUpdate(); // actualiza y ejecuta la consulta            
            
            
            //actualizando el monto total en caja
            if ("Efectivo".equals(mov.getTipoEfectivoElectronico())){
                
                String sql = "";
                
                if ("Ingreso".equals(mov.getTipoIngresoSalida())) {
                    sql = "UPDATE caja SET montoEfectivo = montoEfectivo + " + mov.getMonto() + " "
                            + "WHERE ID = 1" ;
                }
                
                if ("Salida".equals(mov.getTipoIngresoSalida())) {
                    sql = "UPDATE caja SET montoEfectivo = montoEfectivo - " + mov.getMonto() + " "
                            + "WHERE ID = 1" ;
                }
                
                  ps = conexion.prepareStatement(sql);
                  ps.executeUpdate(); // actualiza y ejecuta la consulta
            }
            
        } catch (Exception ex) {
            Mensajes.M1("ERROR! No se puede insertar el registro..." + ex);
        } finally {
            this.cerrarconexion();
        }
    }
    
    public void MostrarMovimientosIngresoEfectivo(JTable tabla,JDateChooser fechaDesde, 
        JDateChooser fechaHasta){
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String fechaFormateada = sdf.format(fechaDesde.getDate());
        
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String fechaFormateada2 = sdf2.format(fechaHasta.getDate());
        
        String sqlQry = "SELECT M.ID, M.fecEjecucion, M.tipoIngresoSalida, M.concepto, C.nombrecompleto, M.monto, M.tipoEfectivoElectronico, E.nombre, A.ID "
                    + "FROM movimiento M LEFT JOIN alquiler A ON M.idAlquiler = A.ID "
                    + "LEFT JOIN cliente C ON A.idCliente = C.ID "
                    + "LEFT JOIN empleado E ON M.idEmpleado = E.ID "
                    + "WHERE M.anulado = 0 AND tipoIngresoSalida = 'Ingreso' AND tipoEfectivoElectronico = 'Efectivo' "
                    + "AND M.fecEjecucion BETWEEN '" +  fechaFormateada + "' AND '" + fechaFormateada2 + "'";
        
        MostrarLista(tabla, sqlQry);
    }
    
      public void MostrarMovimientosSalidasEfectivo(JTable tabla,JDateChooser fechaDesde, 
             JDateChooser fechaHasta){
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String fechaFormateada = sdf.format(fechaDesde.getDate());
        
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String fechaFormateada2 = sdf2.format(fechaHasta.getDate());
        
        String sqlQry = "SELECT M.ID, M.fecEjecucion, M.tipoIngresoSalida, M.concepto, C.nombrecompleto, M.monto, M.tipoEfectivoElectronico, E.nombre, A.ID "
                    + "FROM movimiento M LEFT JOIN alquiler A ON M.idAlquiler = A.ID "
                    + "LEFT JOIN cliente C ON A.idCliente = C.ID "
                    + "LEFT JOIN empleado E ON M.idEmpleado = E.ID "
                    + "WHERE M.anulado = 0 AND tipoIngresoSalida = 'Salida' AND tipoEfectivoElectronico = 'Efectivo' "
                    + "AND M.fecEjecucion BETWEEN '" +  fechaFormateada + "' AND '" + fechaFormateada2 + "'";
        
        MostrarLista(tabla, sqlQry);
    }
      
    public void MostrarMovimientosIngresosME(JTable tabla,JDateChooser fechaDesde, 
             JDateChooser fechaHasta){
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String fechaFormateada = sdf.format(fechaDesde.getDate());
        
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String fechaFormateada2 = sdf2.format(fechaHasta.getDate());
        
        String sqlQry = "SELECT M.ID, M.fecEjecucion, M.tipoIngresoSalida, M.concepto, C.nombrecompleto, M.monto, M.tipoEfectivoElectronico, E.nombre, A.ID "
                    + "FROM movimiento M LEFT JOIN alquiler A ON M.idAlquiler = A.ID "
                    + "LEFT JOIN cliente C ON A.idCliente = C.ID "
                    + "LEFT JOIN empleado E ON M.idEmpleado = E.ID "
                    + "WHERE M.anulado = 0 AND tipoIngresoSalida = 'Ingreso' AND tipoEfectivoElectronico = 'Electrónico' "
                    + "AND M.fecEjecucion BETWEEN '" +  fechaFormateada + "' AND '" + fechaFormateada2 + "'";
        
        MostrarLista(tabla, sqlQry);
    }
       
    
        
    public void MostrarLista(JTable tabla, String XSQLQuery) {
        String titulos[] = {"ID", "Fecha", "Tipo", "Concepto", "Cliente", "Monto", "Forma", "Empleado", "Alquiler"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        tabla.setModel(modelo);       
        try {
            this.obtenerconexion();
            rs = st.executeQuery(XSQLQuery);
            while (rs.next()){               
                Object[] mov = new Object[]{
                rs.getInt(1), 
                rs.getDate(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5),
                rs.getDouble(6),
                rs.getString(7),
                rs.getString(8),
                rs.getInt(9),                
                };
                modelo.addRow(mov); 
            } //Fin del while
        //conexion.close();       
        } catch (Exception ex) {
            Mensajes.M1("ERROR! No se pueden mostrar los registros de la tabla alquilerres..." + ex);
        } finally {
            this.cerrarconexion();
        }
    }     
  
    
    public double DameTotalEnCaja(){
        double res = 0;
        try {
            this.obtenerconexion();
            rs = st.executeQuery("SELECT COALESCE(SUM(montoEfectivo), 0) AS total FROM caja;");
            if (rs.next()) {//Si tiene registro la consulta
                res = rs.getDouble(1);
            }
        } catch (Exception ex) {
            Mensajes.M1("ERROR! No se pueden mostrar los registros de la tabla caja..." + ex);
        } finally {
            this.cerrarconexion();
        }
        return res;
    }
    
     public double DameTotalIngME(){
        double res = 0;
        try {
            this.obtenerconexion();
            rs = st.executeQuery("SELECT COALESCE(SUM(monto), 0) AS total FROM movimiento "
                    + "WHERE tipoEfectivoElectronico = 'Electrónico' AND tipoIngresoSalida = 'Ingreso' "
                    + "AND fecEjecucion = '" + LocalDate.now()+ "';");
            if (rs.next()) {//Si tiene registro la consulta
                res = rs.getDouble(1);
            }
        } catch (Exception ex) {
            Mensajes.M1("ERROR! No se pueden mostrar los registros de la tabla caja..." + ex);
        } finally {
            this.cerrarconexion();
        }
        return res;
    }
    
    
}
