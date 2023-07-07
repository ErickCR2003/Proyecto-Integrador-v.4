package DAO;

import Formatos.Mensajes;
import Modelo.Editorial;
import Modelo.TipoLibro;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CRUDtipolibro1 extends ConectarBD{

    ArrayList<String> listaTipolibros = new ArrayList<>();
    
    public CRUDtipolibro1() {
    }
    
    public void MostrarTipoLibroEnTabla(JTable tabla,JLabel etiqueta){
        String titulos[]={"ID","Nombre","Estado","Descuento","Porcentaje Descuento"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        tabla.setModel(modelo);
        int numeracion=0;
        try {
            this.obtenerconexion();
            rs=st.executeQuery("SELECT idtipolibro, nombreTipo, estado, descuento, porcentajeDescuento FROM tipolibro;");
        while(rs.next()){
            numeracion++;
            TipoLibro tip= new TipoLibro();
            tip.setIdlibro(rs.getInt(1));
            tip.setNombreTipo(rs.getString(2));
            tip.setEstado(rs.getString(3));
            tip.setDescuento(rs.getInt(4));
            tip.setPorcentajeDescuento(rs.getDouble(5));
            modelo.addRow(tip.RegistroTipoLibro(numeracion));
        }
        etiqueta.setText("Numero de registros : " + numeracion);
        
        
        
        } catch (Exception ex) {
            Mensajes.M1("Error! No se puedes mostrar los registro de la tabla tipolibro " + ex);
        }finally{
            this.cerrarconexion();
    }
        

    }//Fin del metodo
    
    public void InsertarRegistroTipoLibro(TipoLibro tipo){
        try {
            this.obtenerconexion();
            ps = conexion.prepareStatement("INSERT INTO tipolibro(nombreTipo, descuento, porcentajeDescuento, estado) VALUES(?,?,?,'ACTIVO');");
            ps.setString(1, tipo.getNombreTipo());
            ps.setInt(2, tipo.getDescuento());
            ps.setDouble(3, tipo.getPorcentajeDescuento());
            ps.executeUpdate();
            Mensajes.M1("Datos registrados correcatamente...");
        } catch (Exception ex) {
            Mensajes.M1("Error! no se puede insertar el registro... sasaas" + ex);
        }finally{
            this.cerrarconexion();
        }
    }
    
    //Metodo que recibe una Editorial y actualiza el registro segun el id
    public void ActualizarRegistroTipoLibro(int id, TipoLibro tip) {

        try {
            this.obtenerconexion();
            ps = conexion.prepareStatement("UPDATE tipolibro SET nombreTipo = ?,estado = ?,descuento = ?,porcentajeDescuento = ? WHERE idtipolibro=?");
            ps.setString(1, tip.getNombreTipo());
            ps.setString(2, tip.getEstado());
            ps.setInt(3, tip.getDescuento());
            ps.setDouble(4, tip.getPorcentajeDescuento());
            ps.setInt(5, id);
            ps.executeUpdate();
            ps.close();
            Mensajes.M1("Datos actualizados correctamente");
            //conexion.close();

        } catch (Exception ex) {
            Mensajes.M1("ERROR! No se puede actualizar el registro tipolibros..." + ex);
        } finally {
            this.cerrarconexion();
        }
    }
    
    //Metodo que recibe el id y retorna el registro de la editorial 
    public TipoLibro ConsultarRegistroTipoLibro(int id) {
        TipoLibro tip = null; //Vacio
        try {
            this.obtenerconexion();
            rs = st.executeQuery("SELECT idtipolibro,nombreTipo,estado, descuento, porcentajeDescuento FROM tipolibro WHERE idtipolibro =" + id);
            if (rs.next()) {//Si tiene registro la consulta
                tip = new TipoLibro();
                tip.setIdlibro(rs.getInt(1));
                tip.setNombreTipo(rs.getString(2));
                tip.setEstado(rs.getString(3));
                tip.setDescuento(rs.getInt(4));
                tip.setPorcentajeDescuento(rs.getDouble(5));
            }
            //conexion.close();
        } catch (Exception ex) {
            Mensajes.M1("ERROR! No se puede recuperar el registro de tipolibro..." + ex);
        } finally{
            this.cerrarconexion();
        }
        return tip;
    }
    
    public ArrayList<String> RegistrarTipoLibroComboBox(){
        try{
            this.obtenerconexion();
            rs = st.executeQuery("SELECT nombreTipo FROM tipolibro WHERE estado = 'activo'");
                
            while (rs.next()) {
              listaTipolibros.add(rs.getString(1));
              
            }
            //conexion.close();
            
        }catch(Exception ex){
            Mensajes.M1("ERROR! No se puede insertar los tipolibros al combobox..."+ex);
        } finally {
            this.cerrarconexion();
        }
        return listaTipolibros;
        
    }
    
    public TipoLibro ConsultarTipolibroPorId(int id){
        TipoLibro tip = null; //Vacio
        try {
            this.obtenerconexion();
            rs = st.executeQuery("SELECT * FROM tipolibro WHERE idtipolibro ="+id);
            if(rs.next()) {//Si tiene registro la consulta
                tip = new TipoLibro();
                tip.setIdlibro(rs.getInt(1));
                tip.setNombreTipo(rs.getString(2));
                tip.setEstado(rs.getString(3));
                tip.setPorcentajeDescuento(rs.getDouble(5));
            }
            
        } catch (Exception ex) {
            Mensajes.M1("ERROR! No se puede recuperar el registro de tipolibro..."+ex);
        } finally {
            this.cerrarconexion();
        }
        return tip;
    }
    
    public int ConsultarIdTipoLibroPorNombre(String nombre){
        int idtipolibro = 0; //Vacio
        try {
            this.obtenerconexion();
            rs = st.executeQuery("SELECT idtipolibro FROM tipolibro WHERE nombreTipo ='"+nombre+"'");
            if(rs.next()) {//Si tiene registro la consulta
                idtipolibro = rs.getInt(1);
            }
            
        } catch (Exception ex) {
            Mensajes.M1("ERROR! No se puede recuperar el registro de tipolibro..."+ex);
        } finally {
            this.cerrarconexion();
        }
        return idtipolibro;
    }
    
}
