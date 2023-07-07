
package DAO;

import Formatos.Mensajes;
import Modelo.Detalles;

public class CRUDdetalles extends ConectarBD{

    public CRUDdetalles() {
    }
    
    public Detalles ConsultarRegistroDet(int iddetalles) {
        Detalles det = null; //Vacio
        try {
            this.obtenerconexion();
            rs = st.executeQuery("SELECT * FROM detalles WHERE iddetalles =" + iddetalles);
            if (rs.next()) {//Si tiene registro la consulta
                det = new Detalles();
                det.setIddetalles(rs.getInt(1));
                det.setSubtotal(rs.getDouble(2));
                det.setDescuento(rs.getDouble(3));
                det.setMontofinal(rs.getDouble(4));
                det.setCostodelivety(rs.getDouble(5));
                det.setDirecciondelivery(rs.getString(6));
                det.setIgv(rs.getDouble(7));
                
            }
            //conexion.close();
        } catch (Exception ex) {
            Mensajes.M1("ERROR! No se puede recuperar el registro del empleado..." + ex);
        } finally{
            this.cerrarconexion();
        }
        return det;
    }
    
    public void InsertarRegistroDetalles(double subtotal,double descuento, double montofinal, double costodelivery,String direccion,double igv) {
        try {
            this.obtenerconexion();
            // preparedStatament permite especificar parametros en la consulta a traves del simbolo la interrogante (?)
            ps = conexion.prepareStatement("INSERT INTO detalles (subtotal,descuento,montofinal,costodelivery,direcciondelivery,igv) "
                    + "VALUES("+subtotal+","+descuento+","+montofinal+","+costodelivery+",'"+direccion+"',"+igv+");");
            
            
            ps.executeUpdate(); // actualiza y ejecuta la consulta|
            Mensajes.M1("Datos registrados correctamente...");
            //conexion.close();
        } catch (Exception ex) {
            Mensajes.M1("ERROR! No se puede insertar el registro... fwefasfssef" + ex);
        } finally {
            this.cerrarconexion();
        }
    }
    
    public int ConsultarCantidadDeDetalles() {
        int can = 0;
        try {
            this.obtenerconexion();
            rs = st.executeQuery("SELECT COUNT(*) FROM detalles; ");
            
            if (rs.next()) {//Si tiene registro la consulta
                can = rs.getInt(1);
                
            }
            //conexion.close();
        } catch (Exception ex) {
            Mensajes.M1("ERROR! No se puede recuperar el registro del empleado..." + ex);
        } finally{
            this.cerrarconexion();
        }
        return can;
    }
    
}
