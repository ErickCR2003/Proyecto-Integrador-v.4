package DAO;
//Libreria
import java.sql.*;
import Formatos.Mensajes;
public class ConectarBD implements Parametros{
    public Connection conexion;
    public Statement st;
    public ResultSet rs;
    public ResultSetMetaData rsmeta;
    public PreparedStatement ps;
    
    //Constructor
    public ConectarBD() {
//        try {
//            Class.forName(DRIVER);
//            conexion = DriverManager.getConnection(RUTA,USUARIO,CLAVE);
//        } catch (Exception ex) {
//            Mensajes.M1("ERROR! No se puede conectar la BD..."+ex);
//        }
        
    }
    public Connection obtenerconexion(){
        try{
         Class.forName(DRIVER);
         conexion = DriverManager.getConnection(RUTA,USUARIO,CLAVE);
         st = conexion.createStatement();
         return conexion;
        }catch (Exception ex){
            Mensajes.M1("ERROR! No se puede conectar la BD..."+ex);
            return null;
        }
        
    }
    
   public void cerrarconexion(){
       try {
           conexion.close();
       } catch (Exception e) {
            Mensajes.M1("ERROR! No se pudo cerrar la BD..."+e);
       }
   }
    
}
