package DAO;

import Formatos.ManejadorTablas;
import Formatos.Mensajes;
import Modelo.TipoHerramienta;
import Modelo.Herramienta;
import java.time.LocalDate;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CRUDherramientas extends ConectarBD {

    public CRUDherramientas() {
    }

    //-- lista completa de herramientas
    public void MostrarHerramientasEnTabla(JTable tabla, JLabel etiqueta) {
        
        String sqlQry = "SELECT ID, nroSerie, nombre, idTipo, imp_ValorReferencial, anioFabricacion, peso, imp_PrecioAlquiler, fecAdquisicion, nroAlquileres, "
                + " estado FROM herramienta;";
        MostrarLista(tabla, etiqueta, sqlQry);
    } 
    
    //-- Lista completa de herramientas DISPONIBLES
    public void MostrarHerramientasEnTabla_Disponibles(JTable tabla, JLabel etiqueta) {
        
        String SrtSQL = "SELECT ID, nroSerie, nombre, idTipo, imp_ValorReferencial, anioFabricacion, peso, imp_PrecioAlquiler, fecAdquisicion, nroAlquileres, "
                        + "estado FROM herramienta WHERE estado = 'DISPONIBLE';";          
        MostrarLista(tabla, etiqueta, SrtSQL);
    }
    
    
    public void MostrarHerramientasEnTablaSegunElTipo(JTable tabla, JLabel etiqueta, int tipo){
            
        String sqlQry = "SELECT ID, nroSerie, nombre, idTipo, imp_ValorReferencial, anioFabricacion, peso, imp_PrecioAlquiler, fecAdquisicion, nroAlquileres, "
                + " estado FROM herramienta WHERE idTipo = "+tipo;
//        
//        if (!"".equals(XTipo)) {
//           sqlQry  += "AND TH.nombreTipo ='" + XTipo;
//        }        
//        
        MostrarLista(tabla, etiqueta, sqlQry);
    }
    
    //método interno para cargar lista de herramienta
    private void MostrarLista(JTable tabla, JLabel etiqueta, String XSQLQuery) {
        String titulos[] = {"ID", "Serie", "Nombre", "Tipo", "Valor Referencial", "Año fabric.", "Peso", "Precio", "Nro. alquileres", "Estado"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        tabla.setModel(modelo);
        int numeracion = 0;
        try {
            this.obtenerconexion();
            rs = st.executeQuery(XSQLQuery);
            while (rs.next()) {
                numeracion++;
                Herramienta her = new Herramienta();
                //se está obviando la descripción a propósito proque es muy larga, saldrá cuando se abra solo una herramienta

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

                CRUDtipos crude = new CRUDtipos();
                TipoHerramienta tp = crude.ConsultarTipoPorId(her.getIdTipo());
                her.setTipo(tp);

                modelo.addRow(her.RegistroHerramientas(numeracion));
            } //Fin del while
            //conexion.close();
            etiqueta.setText("Numero de registros : " + numeracion);
            ManejadorTablas.FormatoTablaHerramientas(tabla);
        } catch (Exception ex) {
            Mensajes.M1("ERROR! No se pueden mostrar los registros de la tabla herramientas..." + ex);
            System.out.println(ex);
        } finally {
            this.cerrarconexion();
        }
    }

    public void MostrarHerramientasEnTablaAlquiler(JTable tabla, String Xtipo, String Xmarca) {
        String titulos[] = {"ID", "Nro. Serie", "Nombre", "Tipo", "Valor Referencial", "Peso", "Precio por día", "Nro. alquileres"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        tabla.setModel(modelo);
        int numeracion = 0;
        
        String SQLQuery = "SELECT H.ID, H.nroSerie, H.nombre, H.idTipo, H.imp_ValorReferencial, H.peso, H.imp_PrecioAlquiler, H.nroAlquileres FROM herramienta H "
                    + " INNER JOIN tipoherramienta TH ON H.idTipo = TH.ID WHERE estado = 'DISPONIBLE'";
        
        if (!"".equals(Xtipo)) {
           SQLQuery  += " AND TH.nombreTipo ='" + Xtipo + "'";
        }
        
        if (!"".equals(Xmarca)) {
           SQLQuery  += " AND H.nombre LIKE '%" + Xmarca + "%'";
        }
                
        try {
            this.obtenerconexion();
            rs = st.executeQuery(SQLQuery);
            while (rs.next()) {
                numeracion++;
                Herramienta her = new Herramienta();

                her.setID(rs.getInt(1));
                her.setNroSerie(rs.getString(2));
                her.setNombre(rs.getString(3));
                her.setIdTipo(rs.getInt(4));
                her.setImp_ValorReferencial(rs.getDouble(5));
                her.setPeso(rs.getDouble(6));
                her.setImp_PrecioAlquiler(rs.getDouble(7));
                her.setNroAlquileres(rs.getInt(8));

                CRUDtipos crudt = new CRUDtipos();
                TipoHerramienta tp = crudt.ConsultarTipoPorId(her.getIdTipo());
                her.setTipo(tp);

                modelo.addRow(her.RegistroHerramientaAlquiler(numeracion));
            } //Fin del while

        } catch (Exception ex) {
            Mensajes.M1("ERROR! No se pueden mostrar los registros de la tabla herramientas..." + ex);
            System.out.println(ex);
        } finally {
            this.cerrarconexion();
        }
    }

    public Herramienta ConsultarRegistroHerramienta(int Xid) {
        Herramienta her = null; //Vacio
        try {
            this.obtenerconexion();
            rs = st.executeQuery("SELECT ID, nroSerie, nombre, idTipo, imp_ValorReferencial, anioFabricacion, peso, imp_PrecioAlquiler, fecAdquisicion, nroAlquileres, "
                    + " estado, descripcion FROM herramienta WHERE ID = " + Xid);
            if (rs.next()) {//Si tiene registro la consulta
                her = new Herramienta();
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
                her.setDescripcion(rs.getString(12));

                CRUDtipos crude = new CRUDtipos();
                TipoHerramienta tp = crude.ConsultarTipoPorId(her.getIdTipo());
                her.setTipo(tp);
            }
            //conexion.close();
        } catch (Exception ex) {
            Mensajes.M1("ERROR! No se puede recuperar el registro del empleado..." + ex);
        } finally {
            this.cerrarconexion();
        }
        return her;
    }

    public void InsertarRegistroHerramienta(Herramienta xher) {
        try {
            this.obtenerconexion();
            // preparedStatament permite especificar parametros en la consulta a traves del simbolo la interrogante (?)

            ps = conexion.prepareStatement("INSERT INTO herramienta(nroSerie, nombre, idTipo, imp_ValorReferencial, anioFabricacion, descripcion, peso, imp_PrecioAlquiler, "
                    + " fecAdquisicion, nroAlquileres, estado)  VALUES (?,?,?,?,?,?,?,?,?,?,?);");

            ps.setString(1, xher.getNroSerie());
            ps.setString(2, xher.getNombre());
            ps.setInt(3, xher.getIdTipo());
            ps.setDouble(4, xher.getImp_ValorReferencial());
            ps.setInt(5, xher.getAnioFabricacion());
            ps.setString(6, xher.getDescripcion());
            ps.setDouble(7, xher.getPeso());
            ps.setDouble(8, xher.getImp_PrecioAlquiler());
            ps.setObject(9, xher.getFecAdquisicion());
            ps.setInt(10, xher.getNroAlquileres());
            ps.setString(11, xher.getEstado());

            //ejecuta la consulta
            ps.executeUpdate();

            Mensajes.M1("Datos registrados correctamente...");
            //conexion.close();
        } catch (Exception ex) {
            Mensajes.M1("ERROR! No se puede insertar el registro..." + ex);
        } finally {
            this.cerrarconexion();
        }
    }

    public void ActualizarRegistroHerramienta(int Xid, Herramienta xher) {
        try {
            this.obtenerconexion();
            ps = conexion.prepareStatement("UPDATE herramienta SET nroSerie = ?, nombre = ?, idTipo = ?, imp_ValorReferencial = ?,anioFabricacion = ?,descripcion = ? "
                    + " ,peso = ?,imp_PrecioAlquiler = ?,fecAdquisicion = ?,nroAlquileres = ? ,estado = ? WHERE ID = ?");
            ps.setString(1, xher.getNroSerie());
            ps.setString(2, xher.getNombre());
            ps.setInt(3, xher.getIdTipo());
            ps.setDouble(4, xher.getImp_ValorReferencial());
            ps.setInt(5, xher.getAnioFabricacion());
            ps.setString(6, xher.getDescripcion());
            ps.setDouble(7, xher.getPeso());
            ps.setDouble(8, xher.getImp_PrecioAlquiler());
            ps.setObject(9, xher.getFecAdquisicion());
            ps.setInt(10, xher.getNroAlquileres());
            ps.setString(11, xher.getEstado());
            ps.setInt(12, Xid);

            ps.executeUpdate();
            ps.close();
            Mensajes.M1("Datos actualizados correctamente");
            //conexion.close();

        } catch (Exception ex) {
            Mensajes.M1("ERROR! No se puede actualizar el registro empleados..." + ex);
        } finally {
            this.cerrarconexion();
        }
    }

    // esto no sé si se usa (SC 12/05/23)--------------------------
    public int ConsultarIdEmpleadoPorUsuario(String usuario) {
        int id = 0; //Vacio
        try {
            this.obtenerconexion();
            rs = st.executeQuery("SELECT idempleado FROM empleado WHERE usuario = '" + usuario + "'");
            if (rs.next()) {//Si tiene registro la consulta

                id = rs.getInt(1);

            }
            //conexion.close();
        } catch (Exception ex) {
            Mensajes.M1("ERROR! No se puede recuperar el id del empleado por usuario..." + ex);
        } finally {
            this.cerrarconexion();
        }
        return id;
    }

    public void ActualizarRegistroHerramientasAlquiler(int id) {
        try {
            this.obtenerconexion();
            ps = conexion.prepareStatement("UPDATE herramienta SET estado = 'ALQUILADO' WHERE herramienta.ID = ?;");
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();

        } catch (Exception ex) {
            Mensajes.M1("ERROR! No se puede actualizar el registro empleados..." + ex);
        } finally {
            this.cerrarconexion();
        }
    }   

}
