package DAO;

import Formatos.Mensajes;
import Modelo.Autor;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CRUDautores extends ConectarBD{

    
    ArrayList<String> listaAutores = new ArrayList<>();
    
    public CRUDautores() {
    }
    //Metodo que muestra los registros de la tabla Autores en un JTable
    public void MostrarAutoresEnTabla(JTable tabla, JLabel etiqueta) {
        String titulos[] = {"Idautor", "Nombre", "Estado","Descuento","Porcentaje Descuento"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        tabla.setModel(modelo);
        int numeracion = 0;
        try {
            this.obtenerconexion();
            rs = st.executeQuery("SELECT idautor, nombre,estado, descuento,porcentajeDescuento FROM autor;");
            while (rs.next()) {
                numeracion++;
                Autor aut = new Autor();
                aut.setIdautor(rs.getInt(1));
                aut.setNombre(rs.getString(2));
                aut.setEstado(rs.getString(3));
                aut.setDescuento(rs.getString(4));
                aut.setPorcentajeDescuento(rs.getDouble(5));
                modelo.addRow(aut.RegistroAutores(numeracion));
            } //Fin del while
            //conexion.close();
            etiqueta.setText("Número de registros : " + numeracion);

//            ManejadorTablas.FormatoTablaAutores(tabla);
            //conexion.close();

        } catch (Exception ex) {
            Mensajes.M1("ERROR! No se pueden mostrar los registros de la tabla autor..." + ex);
        } finally {
            this.cerrarconexion();
        }
    } //Fin del metodo
    public void InsertarRegistroAutor(Autor aut) {
        try {
            this.obtenerconexion();
            // preparedStatament permite especificar parametros en la consulta a traves del simbolo la interrogante (?)
            ps = conexion.prepareStatement("INSERT INTO autor(nombre,descuento,porcentajeDescuento,estado) VALUES(?,?,?,'ACTIVO');");
            ps.setString(1, aut.getNombre()); // actualiza la primera interrogante(?) con datos del empleado
            ps.setString(2,aut.getDescuento());
            ps.setDouble(3, aut.getPorcentajeDescuento());
            ps.executeUpdate(); // actualiza y ejecuta la consulta|
            Mensajes.M1("Datos registrados correctamente...");
            //conexion.close();
        } catch (Exception ex) {
            Mensajes.M1("ERROR! No se puede insertar el registro de autores" + ex);
        } finally {
            this.cerrarconexion();
        }
    }
    
    //Metodo que recibe un Autor y actualiza el registro segun el id
    public void ActualizarRegistroAutor(int id, Autor aut) {

        try {
            this.obtenerconexion();
            ps = conexion.prepareStatement("UPDATE autor SET nombre = ?,estado = ?,descuento = ?,porcentajeDescuento = ? WHERE idautor=?");
            ps.setString(1, aut.getNombre());
            ps.setString(2, aut.getEstado());
            ps.setString(3, aut.getDescuento());
            ps.setDouble(4, aut.getPorcentajeDescuento());
            ps.setInt(5, id);
            ps.executeUpdate();
            ps.close();
            Mensajes.M1("Datos actualizados correctamente");
            //conexion.close();

        } catch (Exception ex) {
            Mensajes.M1("ERROR! No se puede actualizar el registro autores..." + ex);
        } finally {
            this.cerrarconexion();
        }
    }
    
    //Metodo que recibe el id y retorna el registro del autor 
    public Autor ConsultarRegistroAutor(int id) {
        Autor aut = null; //Vacio
        try {
            this.obtenerconexion();
            rs = st.executeQuery("SELECT idautor,nombre,estado,descuento,porcentajeDescuento FROM autor WHERE idautor =" + id);
            if (rs.next()) {//Si tiene registro la consulta
                aut = new Autor();
                aut.setIdautor(rs.getInt(1));
                aut.setNombre(rs.getString(2));
                aut.setEstado(rs.getString(3));
                aut.setDescuento(rs.getString(4));
                aut.setPorcentajeDescuento(rs.getDouble(5));
            }
            //conexion.close();
        } catch (Exception ex) {
            Mensajes.M1("ERROR! No se puede recuperar el registro del autor..." + ex);
        } finally{
            this.cerrarconexion();
        }
        return aut;
    }
    
    public ArrayList<String> RegistrarAutoresComboBox(){
        try{
            this.obtenerconexion();
            rs = st.executeQuery("SELECT nombre FROM autor WHERE estado = 'activo'");
                
            while (rs.next()) {
              listaAutores.add(rs.getString(1));
              
            }
            //conexion.close();
            
        }catch(Exception ex){
            Mensajes.M1("ERROR! No se puede insertar los autores al combobox..."+ex);
        } finally {
            this.cerrarconexion();
        }
        return listaAutores;
        
    }
    
    public Autor ConsultarAutorPorId(int id){
        Autor autor = null; //Vacio
        try {
            this.obtenerconexion();
            rs = st.executeQuery("SELECT * FROM autor WHERE idautor ="+id);
            if(rs.next()) {//Si tiene registro la consulta
                autor = new Autor();
                autor.setIdautor(rs.getInt(1));
                autor.setNombre(rs.getString(2));
                autor.setEstado(rs.getString(3));
                autor.setPorcentajeDescuento(rs.getDouble(5));
            }
            
        } catch (Exception ex) {
            Mensajes.M1("ERROR! No se puede recuperar el registro del destino..."+ex);
        } finally {
            this.cerrarconexion();
        }
        return autor;
    }
    
    public int ConsultarIdAutorPorNombre(String nombre){
        int idautor = 0; //Vacio
        try {
            this.obtenerconexion();
            rs = st.executeQuery("SELECT idautor FROM autor WHERE nombre ='"+nombre+"'");
            if(rs.next()) {//Si tiene registro la consulta
                idautor = rs.getInt(1);
            }
            
        } catch (Exception ex) {
            Mensajes.M1("ERROR! No se puede recuperar el registro del autor..."+ex);
        } finally {
            this.cerrarconexion();
        }
        return idautor;
    }
}
