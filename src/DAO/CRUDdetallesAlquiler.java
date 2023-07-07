
package DAO;

import Formatos.Mensajes;
import Modelo.DetallesAlquiler;

public class CRUDdetallesAlquiler extends ConectarBD{
    
    public void InsertarRegistroDetallesAlquiler(DetallesAlquiler det) {
        try {
            this.obtenerconexion();
            // preparedStatament permite especificar parametros en la consulta a traves del simbolo la interrogante (?)
            
            ps = conexion.prepareStatement("INSERT INTO detallesalquiler(idAlquiler, idHerramienta, imp_montofinal)  VALUES (?,?,?);");
            ps.setInt(1, det.getIdAlquiler());
            ps.setInt(2, det.getIdHerramienta());
            ps.setDouble(3, det.getImp_montofinal());
            ps.executeUpdate();
            
        } catch (Exception ex) {
            Mensajes.M1("ERROR! No se puede insertar el registro..." + ex);
        } finally {
            this.cerrarconexion();
        }
    }
}
