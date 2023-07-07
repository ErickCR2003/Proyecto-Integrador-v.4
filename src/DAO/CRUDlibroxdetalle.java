package DAO;

import Formatos.Mensajes;

public class CRUDlibroxdetalle extends ConectarBD {

    public CRUDlibroxdetalle() {
    }

    public int ConsultarCantidadporID(int iddetalles) {
        int cantidad = 0; //Vacio
        try {
            this.obtenerconexion();
            rs = st.executeQuery("SELECT COUNT(*) FROM librosxdetalle WHERE iddetalles =" + iddetalles);
            if (rs.next()) {//Si tiene registro la consulta

                cantidad = rs.getInt(1);
            }
        } catch (Exception ex) {
            Mensajes.M1("ERROR! No se puede recuperar el registro del destino..." + ex);
        } finally {
            this.cerrarconexion();
        }
        return cantidad;
    }
    
    public void InsertarRegistroLibroxDetalles(int idlibro,int iddetalles) {
        try {
            this.obtenerconexion();
            // preparedStatament permite especificar parametros en la consulta a traves del simbolo la interrogante (?)
            ps = conexion.prepareStatement("INSERT INTO librosxdetalle (idlibro,iddetalles) "
                    + "VALUES("+idlibro+","+iddetalles+");");
            
            
            ps.executeUpdate(); // actualiza y ejecuta la consulta|
            
            //conexion.close();
        } catch (Exception ex) {
            Mensajes.M1("ERROR! No se puede insertar el registro... fwefasfssef" + ex);
        } finally {
            this.cerrarconexion();
        }
    }
    
}
