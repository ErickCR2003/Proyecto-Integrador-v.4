
package DAO;

import Formatos.ManejadorTablas;
import Formatos.Mensajes;
import Modelo.Empleado;
import Modelo.Herramienta;
import Modelo.OrdenMantenimiento;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CRUDmantenimiento extends ConectarBD {
    
    public CRUDmantenimiento() {
    }
    
    public void MostrarOrdenesEnTabla(JTable tabla, JLabel etiqueta) {
        String titulos[] = {"ID", "Fecha de Creacion", "Fecha de Cierre", "Estado", "Costo de Reparacion", "Herramienta", "Empleado"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        tabla.setModel(modelo);
        int numeracion = 0;
        try {
            this.obtenerconexion();
            rs = st.executeQuery("SELECT `ID`, `fecCreacion`, `fecCierre`, `estado`, `costoReparacion`, `idHerramienta`, `idEmpleado` FROM `ordenmantenimiento`");
            while (rs.next()) {
                numeracion++;
                OrdenMantenimiento orM = new OrdenMantenimiento();
                //se está obviando la descripción a propósito proque es muy larga, saldrá cuando se abra solo una herramienta

                orM.setID(rs.getInt(1));
                orM.setFecCreacion(LocalDate.parse(rs.getString(2)));
                orM.setFecCierre(LocalDate.parse(rs.getString(3)));
                orM.setEstado(rs.getString(4));
                orM.setCostoReparacion(rs.getDouble(5));
                orM.setId_herramienta(rs.getInt(6));
                orM.setId_empleado(rs.getInt(7));

                CRUDherramientas crudh = new CRUDherramientas();
                Herramienta her = crudh.ConsultarRegistroHerramienta(orM.getId_herramienta());
                orM.setHer(her);
                
                CRUDempleados crude = new CRUDempleados();
                Empleado emp = crude.ConsultarRegistroEmpByID(orM.getId_empleado());
                orM.setEmp(emp);

                modelo.addRow(orM.RegistroOrdenesMantenimiento(numeracion));
            } //Fin del while
            //conexion.close();
            etiqueta.setText("Numero de registros : " + numeracion);
            ManejadorTablas.FormatoTablaMantenimiento(tabla);
        } catch (Exception ex) {
            Mensajes.M1("ERROR! En CRUDmantenimeinto - MostrarOrdenesEnTabla..." + ex);
            System.out.println(ex);
        } finally {
            this.cerrarconexion();
        }
    }

    public OrdenMantenimiento ConsultarRegistroMantenimiento(int Xid) {
        OrdenMantenimiento orM = null; //Vacio
        try {
            this.obtenerconexion();
            rs = st.executeQuery("SELECT * FROM ordenmantenimiento WHERE ID = " + Xid);
            if (rs.next()) {//Si tiene registro la consulta
                orM = new OrdenMantenimiento();
                
                orM.setID(rs.getInt(1));
                orM.setFecCreacion(LocalDate.parse(rs.getString(2)));
                orM.setFecCierre(LocalDate.parse(rs.getString(3)));
                orM.setEstado(rs.getString(4));
                orM.setProblema(rs.getString(5));
                orM.setReparacion(rs.getString(6));
                orM.setCostoReparacion(rs.getDouble(7));
                orM.setId_herramienta(rs.getInt(8));
                orM.setId_empleado(rs.getInt(9));

                CRUDherramientas crudh = new CRUDherramientas();
                Herramienta her = crudh.ConsultarRegistroHerramienta(orM.getId_herramienta());
                orM.setHer(her);
                
                CRUDempleados crude = new CRUDempleados();
                Empleado emp = crude.ConsultarRegistroEmpByID(orM.getId_empleado());
                orM.setEmp(emp);
                
            }
            //conexion.close();
        } catch (Exception ex) {
            Mensajes.M1("ERROR! CRUDmantenimiento - ConsultarRegistroMantenimiento..." + ex);
        } finally {
            this.cerrarconexion();
        }
        return orM;
    }
    
    public void InsertarRegistroOrdenMantenimiento(OrdenMantenimiento orM) {
        try {
            this.obtenerconexion();
            // preparedStatament permite especificar parametros en la consulta a traves del simbolo la interrogante (?)

            ps = conexion.prepareStatement("INSERT INTO `ordenmantenimiento`(`fecCreacion`, `fecCierre`, `estado`, "
                    + "`problema`, `reparacion`, `costoReparacion`, "
                    + "`idHerramienta`, `idEmpleado`)  VALUES (?,?,?,?,?,?,?,?);");

            ps.setObject(1, orM.getFecCreacion());
            ps.setObject(2, orM.getFecCierre());
            ps.setString(3, orM.getEstado());
            ps.setString(4, orM.getProblema());
            ps.setString(5, orM.getReparacion());
            ps.setDouble(6, orM.getCostoReparacion());
            ps.setInt(7, orM.getId_herramienta());
            ps.setInt(8, orM.getId_empleado());

            //ejecuta la consulta
            ps.executeUpdate();
            //conexion.close();
        } catch (SQLException ex) {
            Mensajes.M1("ERROR! No se puede insertar el registro en la tabla Mantenimiento..." + ex);
        } finally {
            this.cerrarconexion();
        }
    }  
    
}
