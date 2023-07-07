package DAO;

import Formatos.Mensajes;
import Modelo.Editorial;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CRUDeditoriales extends ConectarBD{

    ArrayList<String> listaEditoriales = new ArrayList<>();
    
    public CRUDeditoriales() {
    }
    
    public void MostrarEditorialEnTabla(JTable tabla,JLabel etiqueta){
        String titulos[]={"ID","Nombre","Estado","Descuento","Porcentaje Descuento"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        tabla.setModel(modelo);
        int numeracion=0;
        try {
            this.obtenerconexion();
            rs=st.executeQuery("SELECT ideditorial, nombre, estado, descuento, porcentajeDescuento FROM editorial;");
        while(rs.next()){
            numeracion++;
            Editorial edi= new Editorial();
            edi.setIdeditorial(rs.getInt(1));
            edi.setNombre(rs.getString(2));
            edi.setEstado(rs.getString(3));
            edi.setDescuento(rs.getInt(4));
            edi.setPorcentajeDescuento(rs.getDouble(5));
            modelo.addRow(edi.RegistroEditoriales(numeracion));
        }
        etiqueta.setText("Numero de registros : " + numeracion);

        } catch (Exception ex) {
            Mensajes.M1("Error! No se puedes mostrar los registro de la tabla editorial " + ex);
        }finally{
            this.cerrarconexion();
    }
        

    }//Fin del metodo
    
    public void InsertarRegistroEdi(Editorial edi){
        try {
            this.obtenerconexion();
            ps = conexion.prepareStatement("INSERT INTO editorial(nombre,descuento,porcentajeDescuento,estado) VALUES(?,?,?,'ACTIVO');");
            ps.setString(1, edi.getNombre());
            ps.setInt(2,edi.getDescuento());
            ps.setDouble(3, edi.getPorcentajeDescuento());
            ps.executeUpdate();
            Mensajes.M1("Datos registrados correcatamente...");
        } catch (Exception ex) {
            Mensajes.M1("Error! no se puede insertar el registro... sasaas" + ex);
        }finally{
            this.cerrarconexion();
        }
    }
    
    //Metodo que recibe una Editorial y actualiza el registro segun el id
    public void ActualizarRegistroEditorial(int id, Editorial edi) {

        try {
            this.obtenerconexion();
            ps = conexion.prepareStatement("UPDATE editorial SET nombre = ?,estado = ?,descuento = ?, porcentajeDescuento = ? WHERE ideditorial=?");
            ps.setString(1, edi.getNombre());
            ps.setString(2, edi.getEstado());
            ps.setInt(3, edi.getDescuento());
            ps.setDouble(4, edi.getPorcentajeDescuento());
            ps.setInt(5, id);
            ps.executeUpdate();
            ps.close();
            Mensajes.M1("Datos actualizados correctamente");
            //conexion.close();

        } catch (Exception ex) {
            Mensajes.M1("ERROR! No se puede actualizar el registro editoriales..." + ex);
        } finally {
            this.cerrarconexion();
        }
    }
    
    //Metodo que recibe el id y retorna el registro de la editorial 
    public Editorial ConsultarRegistroEditorial(int id) {
        Editorial edi = null; //Vacio
        try {
            this.obtenerconexion();
            rs = st.executeQuery("SELECT ideditorial,nombre,estado, descuento, porcentajeDescuento FROM editorial WHERE ideditorial =" + id);
            if (rs.next()) {//Si tiene registro la consulta
                edi = new Editorial();
                edi.setIdeditorial(rs.getInt(1));
                edi.setNombre(rs.getString(2));
                edi.setEstado(rs.getString(3));
                edi.setDescuento(rs.getInt(4));
                edi.setPorcentajeDescuento(rs.getDouble(5));
            }
            //conexion.close();
        } catch (Exception ex) {
            Mensajes.M1("ERROR! No se puede recuperar el registro de la editorial..." + ex);
        } finally{
            this.cerrarconexion();
        }
        return edi;
    }
    
    public ArrayList<String> RegistrarEditorialesComboBox(){
        try{
            this.obtenerconexion();
            rs = st.executeQuery("SELECT nombre FROM editorial WHERE estado = 'activo'");
                
            while (rs.next()) {
              listaEditoriales.add(rs.getString(1));
              
            }
            //conexion.close();
            
        }catch(Exception ex){
            Mensajes.M1("ERROR! No se puede insertar los editoriales al combobox..."+ex);
        } finally {
            this.cerrarconexion();
        }
        return listaEditoriales;
        
    }
    
    public Editorial ConsultarEditorialPorId(int id){
        Editorial editorial = null; //Vacio
        try {
            this.obtenerconexion();
            rs = st.executeQuery("SELECT * FROM editorial WHERE ideditorial ="+id);
            if(rs.next()) {//Si tiene registro la consulta
                editorial = new Editorial();
                editorial.setIdeditorial(rs.getInt(1));
                editorial.setNombre(rs.getString(2));
                editorial.setEstado(rs.getString(3));
                editorial.setPorcentajeDescuento(rs.getDouble(5));
            }
            
        } catch (Exception ex) {
            Mensajes.M1("ERROR! No se puede recuperar el registro del destino..."+ex);
        } finally {
            this.cerrarconexion();
        }
        return editorial;
    }
    
    public int ConsultarIdEditorialPorNombre(String nombre){
        int ideditorial = 0; //Vacio
        try {
            this.obtenerconexion();
            rs = st.executeQuery("SELECT ideditorial FROM editorial WHERE nombre ='"+nombre+"'");
            if(rs.next()) {//Si tiene registro la consulta
                ideditorial = rs.getInt(1);
            }
            
        } catch (Exception ex) {
            Mensajes.M1("ERROR! No se puede recuperar el registro de la editorial..."+ex);
        } finally {
            this.cerrarconexion();
        }
        return ideditorial;
    }
    
}
