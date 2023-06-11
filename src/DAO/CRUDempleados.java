package DAO;

import Formatos.ManejadorTablas;
import Formatos.Mensajes;
import Modelo.Empleado;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CRUDempleados extends ConectarBD{

    public CRUDempleados() {
    }
    
    //Metodo que muestra los registros de la tabla Empleados en un JTable
    public void MostrarEmpleadosEnTabla(JTable tabla, JLabel etiqueta) {
        String titulos[] = {"ID", "Usuario", "Nombre", "Apellido", "Num. Celular", "Correo", "DNI", "F.Nac", "Tipo", "Genero", "Activo"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        tabla.setModel(modelo);
        int numeracion = 0;
        try {
            this.obtenerconexion();
            rs = st.executeQuery("SELECT ID, usuario, nombre,apellido,telefono,email,dni,fecNacimiento,tipo,genero,activo FROM empleado;");
            while (rs.next()) {
                numeracion++;
                Empleado emp = new Empleado();
                emp.setIdEmpleado(rs.getInt(1));
                emp.setUsuario(rs.getString(2));
                emp.setNombre(rs.getString(3));
                emp.setApellido(rs.getString(4));
                emp.setTelefono(rs.getString(5));
                emp.setEmail(rs.getString(6));
                emp.setDni(rs.getString(7));
                emp.setFecNacimiento(LocalDate.parse(rs.getString(8)));
                emp.setTipo(rs.getString(9));
                emp.setGenero(rs.getString(10));
                emp.setActivo(rs.getBoolean(11));
                
                modelo.addRow(emp.RegistroEmpleados(numeracion));
            } //Fin del while
            //conexion.close();
            etiqueta.setText("Número de registros : " + numeracion);

            ManejadorTablas.FormatoTablaEmpleados(tabla);
            //conexion.close();

        } catch (Exception ex) {
            Mensajes.M1("ERROR! No se pueden mostrar los registros de la tabla empleado..." + ex);
        } finally {
            this.cerrarconexion();
        }
    } //Fin del metodo
    
    public void InsertarRegistroEmp(Empleado emp) {
        try {
            this.obtenerconexion();
            // preparedStatament permite especificar parametros en la consulta a traves del simbolo la interrogante (?)
            ps = conexion.prepareStatement("INSERT INTO empleado(usuario,contraseña,nombre,apellido,telefono,email,fecNacimiento,tipo,genero,dni,activo) VALUES(?,?,?,?,?,?,?,?,?,?,?);");
            ps.setString(1, emp.getUsuario()); // actualiza la primera interrogante(?) con datos del empleado
            ps.setString(2, emp.getContraseña());// actualiza la segunda interrogante(?)
            ps.setString(3, emp.getNombre());
            ps.setString(4, emp.getApellido());
            ps.setString(5, emp.getTelefono());
            ps.setString(6, emp.getEmail());
            ps.setObject(7, emp.getFecNacimiento());
            ps.setString(8, emp.getTipo());
            ps.setString(9, emp.getGenero());
            ps.setString(10, emp.getDni());
            ps.setBoolean(11, emp.getActivo());
            ps.executeUpdate(); // actualiza y ejecuta la consulta|
            Mensajes.M1("Datos registrados correctamente...");
            //conexion.close();
        } catch (Exception ex) {
            Mensajes.M1("ERROR! No se puede insertar el registro.." + ex);
        } finally {
            this.cerrarconexion();
        }
    }
    
    //Metodo que recibe un Empleado y actualiza el registro segun el dni
    public void ActualizarRegistroEmp(String dni, Empleado empac) {

        try {
            this.obtenerconexion();
            ps = conexion.prepareStatement("UPDATE empleado SET usuario = ?,contraseña = ?, nombre = ?,apellido =?, telefono = ?,email = ?,fecNacimiento=?,tipo=?,genero=?,activo=?,dni=? WHERE dni=?");
            ps.setString(1, empac.getUsuario());
            ps.setString(2, empac.getContraseña());
            ps.setString(3, empac.getNombre());
            ps.setString(4, empac.getApellido());
            ps.setString(5, empac.getTelefono());
            ps.setString(6, empac.getEmail());
            ps.setObject(7, empac.getFecNacimiento());
            ps.setString(8, empac.getTipo());
            ps.setString(9, empac.getGenero());
            ps.setObject(10, empac.getActivo());
            ps.setString(11, empac.getDni());
            ps.setString(12, dni);
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
    
    //Metodo que recibe el dni y retorna el registro del Empleado 
    public Empleado ConsultarRegistroEmp(String dni) {
        Empleado emp = null; //Vacio
        try {
            this.obtenerconexion();
            rs = st.executeQuery("SELECT ID,usuario,contraseña,nombre,apellido,telefono,email,fecNacimiento,tipo,genero,activo,dni FROM empleado WHERE dni = " + dni);
            if (rs.next()) {//Si tiene registro la consulta
                emp = new Empleado();
                emp.setIdEmpleado(rs.getInt(1));
                emp.setUsuario(rs.getString(2));
                emp.setContraseña(rs.getString(3));
                emp.setNombre(rs.getString(4));
                emp.setApellido(rs.getString(5));
                emp.setTelefono(rs.getString(6));
                emp.setEmail(rs.getString(7));
                emp.setFecNacimiento(LocalDate.parse(rs.getString(8)));
                emp.setTipo(rs.getString(9));
                emp.setGenero(rs.getString(10));
                emp.setActivo(rs.getBoolean(11));
                emp.setDni(rs.getString(12));
            }
            //conexion.close();
        } catch (Exception ex) {
            Mensajes.M1("ERROR! No se puede recuperar el registro del empleado..." + ex);
        } finally{
            this.cerrarconexion();
        }
        return emp;
    }
    
    public String ConsultarUsuario(String usuario, String contraseña) {
        String emp = null; //Vacio
        try {
            this.obtenerconexion();
            rs = st.executeQuery("SELECT tipo,Estado FROM empleado WHERE usuario ='" + usuario + "' and contraseña='" + contraseña + "'");
            if (rs.next()) {//Si tiene registro la consulta
                emp = "Usuario Encontrado " + rs.getString(1) + " " + rs.getString(2);
            } else {
                emp = "No encontrado";
            }
            //conexion.close();
        } catch (Exception ex) {
            Mensajes.M1("ERROR! No se puede recuperar el registro del empleado..." + ex);
        } finally {
            this.cerrarconexion();
        }
        return emp;
    }
         
    
    public boolean ExisteUsrPass(String Xusuario, String Xcontrasenia) {       
        try {
            this.obtenerconexion();
            String consulta = "SELECT * FROM empleado WHERE usuario = ? AND contraseña = ? LIMIT 1";            
            ps = conexion.prepareStatement(consulta);
            ps.setString(1, Xusuario);
            ps.setString(2, Xcontrasenia);            
            rs = ps.executeQuery();
            return rs.next();
            //conexion.close();
        } catch (SQLException ex) {
            Mensajes.M1("ERROR! No se puede recuperar el nombre del usuario del empleado..." + ex);
            return false;
        } finally {
            this.cerrarconexion();            
        }        
    }
    
    public boolean UsrEstaActivo(String Xusuario, String Xcontrasenia) {       
        try {
            this.obtenerconexion();
            String consulta = "SELECT * FROM empleado WHERE usuario = ? AND contraseña = ? AND activo = true LIMIT 1";            
            ps = conexion.prepareStatement(consulta);
            ps.setString(1, Xusuario);
            ps.setString(2, Xcontrasenia);            
            rs = ps.executeQuery();
             return rs.next();
            //conexion.close();
        } catch (SQLException ex) {
            Mensajes.M1("ERROR! No se puede verificar si el usuario está activo" + ex);
            return false;
        } finally {
            this.cerrarconexion();            
        }        
    }
    
      public Empleado CargarUsuario(String Xusuario, String Xcontrasenia) {        
          Empleado Usr = new Empleado();
          try {
            this.obtenerconexion();
            String consulta = "SELECT * FROM empleado WHERE usuario = ? AND contraseña = ? AND activo = true LIMIT 1";            
            ps = conexion.prepareStatement(consulta);
            ps.setString(1, Xusuario);
            ps.setString(2, Xcontrasenia);            
            rs = ps.executeQuery();
            if (rs.next()) {//Si tiene registro la consulta               
                String nom = rs.getString("nombre");
                Usr.setNombre(nom);
                Usr.setTipo(rs.getString("tipo"));
                String idEmpleadoStr = rs.getString("ID");
                int idEmpleadoInt = Integer.parseInt(idEmpleadoStr);
                Usr.setIdEmpleado(idEmpleadoInt);
                return Usr;
            } else {
                return null;
            }
            //conexion.close();
        } catch (Exception ex) {
            Mensajes.M1("ERROR! No se puede recuperar el registro del empleado..." + ex);
            return null;
        } finally {
            this.cerrarconexion();
        }        
    }
    
    
    

    public Empleado ConsultarRegistroEmpByID(int id) {
        Empleado emp = null; //Vacio
        try {
            this.obtenerconexion();
            rs = st.executeQuery("SELECT usuario FROM empleado WHERE ID =" + id);
            if (rs.next()) {//Si tiene registro la consulta
                emp = new Empleado();
                emp.setUsuario(rs.getString(1));               
            }
            //conexion.close();
        } catch (Exception ex) {
            Mensajes.M1("ERROR! No se puede recuperar el registro del empleado..." + ex);
        } finally{
            this.cerrarconexion();
        }
        return emp;
    }
    
 
      
   
}
