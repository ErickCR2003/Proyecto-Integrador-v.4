package DAO;

import Formatos.ManejadorTablas;
import Formatos.Mensajes;
import Modelo.TipoHerramienta;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CRUDtipos extends ConectarBD {

    ArrayList<String> listaTipos = new ArrayList<>();

    public CRUDtipos() {
    }

    public void MostrarTipoEnTabla(JTable tabla, JLabel etiqueta) {
        String titulos[] = {"ID", "Nombre", "Descripción"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        tabla.setModel(modelo);
        int numeracion = 0;
        try {
            this.obtenerconexion();
            rs = st.executeQuery("SELECT * FROM tipoherramienta;");
            while (rs.next()) {
                numeracion++;
                TipoHerramienta edi = new TipoHerramienta();
                edi.setID(rs.getInt(1));
                edi.setNombreTipo(rs.getString(2));
                edi.setDescripcion(rs.getString(3));

                modelo.addRow(edi.RegistroTipoHerramienta(numeracion));
            }
            etiqueta.setText("Numero de registros : " + numeracion);
            ManejadorTablas.FormatoTablaTipos(tabla);

        } catch (Exception ex) {
            Mensajes.M1("Error! No se puedes mostrar los registro de la tabla Tipo" + ex);
        } finally {
            this.cerrarconexion();
        }

    }//Fin del metodo

    public void InsertarRegistroTipo(TipoHerramienta edi) {
        try {
            this.obtenerconexion();
            ps = conexion.prepareStatement("INSERT INTO tipoherramienta(nombreTipo, descripcion) VALUES(?,?);");
            ps.setString(1, edi.getNombreTipo());
            ps.setString(2, edi.getDescripcion());
            ps.executeUpdate();
            Mensajes.M1("Datos registrados correcatamente...");
        } catch (Exception ex) {
            Mensajes.M1("Error! no se puede insertar el registro..." + ex);
        } finally {
            this.cerrarconexion();
        }
    }

    //Metodo que recibe una Editorial y actualiza el registro segun el id
    public void ActualizarRegistroTipo(int id, TipoHerramienta edi) {

        try {
            this.obtenerconexion();
            ps = conexion.prepareStatement("UPDATE tipoherramienta SET nombreTipo = ?,descripcion = ? WHERE ID =?");
            ps.setString(1, edi.getNombreTipo());
            ps.setString(2, edi.getDescripcion());
            ps.setInt(3, edi.getID());
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
    public TipoHerramienta ConsultarRegistroTipo(int Xid) {
        TipoHerramienta edi = null; //Vacio
        try {
            this.obtenerconexion();
            rs = st.executeQuery("SELECT ID, nombreTipo, descripcion FROM tipoherramienta WHERE ID = " + Xid);
            if (rs.next()) {//Si tiene registro la consulta
                edi = new TipoHerramienta();
                edi.setID(rs.getInt(1));
                edi.setNombreTipo(rs.getString(2));
                edi.setDescripcion(rs.getString(3));
            }
            //conexion.close();
        } catch (Exception ex) {
            Mensajes.M1("ERROR! No se puede recuperar el registro de la editorial..." + ex);
        } finally {
            this.cerrarconexion();
        }
        return edi;
    }

    public ArrayList<String> RegistrarTiposComboBox() {
        try {
            this.obtenerconexion();
            rs = st.executeQuery("SELECT nombreTipo FROM tipoherramienta");

            while (rs.next()) {
                listaTipos.add(rs.getString(1));
            }
            //conexion.close();

        } catch (Exception ex) {
            Mensajes.M1("ERROR! No se puede insertar los editoriales al combobox..." + ex);
        } finally {
            this.cerrarconexion();
        }
        return listaTipos;

    }

    public TipoHerramienta ConsultarTipoPorId(int Xid) {
        TipoHerramienta editorial = null; //Vacio
        try {
            this.obtenerconexion();
            rs = st.executeQuery("SELECT * FROM tipoherramienta WHERE ID = " + Xid);
            if (rs.next()) {//Si tiene registro la consulta
                editorial = new TipoHerramienta();
                editorial.setID(rs.getInt(1));
                editorial.setNombreTipo(rs.getString(2));
                editorial.setDescripcion(rs.getString(3));
            }

        } catch (Exception ex) {
            Mensajes.M1("ERROR! No se puede recuperar el registro del destino..." + ex);
        } finally {
            this.cerrarconexion();
        }
        return editorial;
    }

    public int ConsultarIdTipoPorNombre(String Xnombre) {
        int ideditorial = 0; //Vacio
        try {
            this.obtenerconexion();
            rs = st.executeQuery("SELECT ID FROM tipoherramienta WHERE nombreTipo = '" + Xnombre + "'");
            if (rs.next()) {//Si tiene registro la consulta
                ideditorial = rs.getInt(1);
            }

        } catch (Exception ex) {
            Mensajes.M1("ERROR! No se puede recuperar el registro del tipo..." + ex);
        } finally {
            this.cerrarconexion();
        }
        return ideditorial;
    }

}
