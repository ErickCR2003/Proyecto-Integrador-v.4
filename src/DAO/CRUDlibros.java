package DAO;

import Formatos.Mensajes;
import Modelo.Editorial;
import Modelo.Autor;
import Modelo.Empleado;
import Modelo.Libro;
import Modelo.TipoLibro;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CRUDlibros extends ConectarBD {

    public CRUDlibros() {
    }

    public void MostrarLibrosEnTabla(JTable tabla, JLabel etiqueta) {
        String titulos[] = {"ID", "Titulo", "Autor", "Editorial","Tipo de Libro" ,"Precio","Numero de Paginas", "Stock","Descuento","Porcentaje" ,"ID. Empleado"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        tabla.setModel(modelo);
        int numeracion = 0;
        try {
            this.obtenerconexion();
            rs = st.executeQuery("SELECT idlibro, titulo, idautor, ideditorial,idtipolibro, precio,numeropaginas, stock, idempleado FROM libros;");
            while (rs.next()) {
                numeracion++;
                Libro libro = new Libro();
                libro.setIdlibro(rs.getInt(1));
                libro.setTitulo(rs.getString(2));
                libro.setIdautor(rs.getInt(3));
                libro.setIdeditorial(rs.getInt(4));
                libro.setIdtipolibro(rs.getInt(5));
                libro.setPrecio(rs.getDouble(6));
                libro.setNumpagina(rs.getInt(7));
                libro.setStock(rs.getInt(8));
                libro.setIdempleado(rs.getInt(9));

                CRUDeditoriales crude = new CRUDeditoriales();
                Editorial editorial = crude.ConsultarEditorialPorId(libro.getIdeditorial());
                libro.setEditorial(editorial);
                
                CRUDtipolibro1 crud = new CRUDtipolibro1();
                TipoLibro tipo = crud.ConsultarTipolibroPorId(libro.getIdtipolibro());
                libro.setTipolibros(tipo);

                CRUDautores cruda = new CRUDautores();
                Autor autor = cruda.ConsultarAutorPorId(libro.getIdautor());
                libro.setAutor(autor);
                modelo.addRow(libro.RegistroLibros(numeracion));
            } //Fin del while
            //conexion.close();
            etiqueta.setText("Numero de registros : " + numeracion);
        } catch (Exception ex) {
            Mensajes.M1("ERROR! No se pueden mostrar los registros de la tabla empleado..." + ex);
        } finally {
            this.cerrarconexion();
        }
    } //Fin del metodo

    public Libro ConsultarRegistroLibro(int id) {
        Libro libro = null; //Vacio
        try {
            this.obtenerconexion();
            rs = st.executeQuery("SELECT idlibro,titulo,idautor,ideditorial,idtipolibro,precio,numeropaginas,stock,idempleado FROM libros WHERE idlibro =" + id);
            if (rs.next()) {//Si tiene registro la consulta
                libro = new Libro();
                libro.setIdlibro(rs.getInt(1));
                libro.setTitulo(rs.getString(2));
                libro.setIdautor(rs.getInt(3));
                libro.setIdeditorial(rs.getInt(4));
                libro.setIdtipolibro(rs.getInt(5));
                libro.setPrecio(rs.getDouble(6));
                libro.setNumpagina(rs.getInt(7));
                libro.setStock(rs.getInt(8));
                libro.setIdempleado(rs.getInt(9));

                CRUDeditoriales crude = new CRUDeditoriales();
                Editorial editorial = crude.ConsultarEditorialPorId(libro.getIdeditorial());
                libro.setEditorial(editorial);

                CRUDautores cruda = new CRUDautores();
                Autor autor = cruda.ConsultarAutorPorId(libro.getIdautor());
                libro.setAutor(autor);
            }
            //conexion.close();
        } catch (Exception ex) {
            Mensajes.M1("ERROR! No se puede recuperar el registro del empleado..." + ex);
        } finally {
            this.cerrarconexion();
        }
        return libro;
    }
    
    public void InsertarRegistroLibro(Libro libro){
        try{
            this.obtenerconexion();
            // preparedStatament permite especificar parametros en la consulta a traves del simbolo la interrogante (?)
            
            ps = conexion.prepareStatement("INSERT INTO libros (titulo,idautor,ideditorial,idempleado,precio,stock,idtipolibro,numeropaginas)  VALUES (?,?,?,?,?,?,?,?);");
            ps.setString(1, libro.getTitulo());
            ps.setInt(2, libro.getIdautor());
            ps.setInt(3, libro.getIdeditorial());
            ps.setInt(4, libro.getIdempleado());
            ps.setDouble(5, libro.getPrecio());
            ps.setInt(6, libro.getStock());
            ps.setInt(7, libro.getIdtipolibro());
            ps.setInt(8, libro.getNumpagina());
            ps.executeUpdate();
            Mensajes.M1("Datos registrados correctamente...");
            //conexion.close();
        }catch(Exception ex){
            Mensajes.M1("ERROR! No se puede insertar el registro..."+ex);
        } finally {
            this.cerrarconexion();
        }
    }

    public void ActualizarRegistroLibros(int id, Libro libro) {
        try {
            this.obtenerconexion();
            ps = conexion.prepareStatement("UPDATE libros SET titulo = ?, idautor = ?, ideditorial = ?, idtipolibro = ?,precio = ?,numeropaginas = ? ,stock = ? WHERE idlibro=?");
            ps.setString(1, libro.getTitulo());
            ps.setInt(2, libro.getIdautor());
            ps.setInt(3, libro.getIdeditorial());
            ps.setInt(4, libro.getIdtipolibro());
            ps.setDouble(5, libro.getPrecio());
            ps.setInt(6, libro.getNumpagina());
            ps.setInt(7, libro.getStock());
            ps.setInt(8, id);
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
    public int ConsultarIdEmpleadoPorUsuario(String usuario){
        int id = 0; //Vacio
        try {
            this.obtenerconexion();
            rs = st.executeQuery("SELECT idempleado FROM empleado WHERE usuario = '"+usuario+"'");
            if(rs.next()) {//Si tiene registro la consulta
                
               id = rs.getInt(1);
               
            }
            //conexion.close();
        } catch (Exception ex) {
            Mensajes.M1("ERROR! No se puede recuperar el id del empleado por usuario..."+ex);
        } finally {
            this.cerrarconexion();
        }
        return id;
    }
    
    public int ConsultarIdempleadoporIdLibro(int idlibro) {
        int idemp = 0; //Vacio
        try {
            this.obtenerconexion();
            rs = st.executeQuery("SELECT idempleado FROM libros WHERE idlibro ="+ idlibro );
            if (rs.next()) {//Si tiene registro la consulta

                idemp = rs.getInt(1);
            }
            //conexion.close();
        } catch (Exception ex) {
            Mensajes.M1("ERROR! No se puede recuperar el id empleado por id vuelo..." + ex);
        } finally {
            this.cerrarconexion();
        }
        return idemp;
    }
    
    public void ActualizarRegistroLibrosExistentes(int id, int cantidad) {
        try {
            this.obtenerconexion();
            ps = conexion.prepareStatement("UPDATE libros SET stock = stock + ? WHERE idlibro=?");
            ps.setInt(1, cantidad);
            ps.setInt(2, id);
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
    
    public void MostrarLibrosPorCodigoEnTabla(JTable tabla, int idlibro) {
        String titulos[] = {"ID", "Titulo", "Autor", "Editorial", "Tipo" , "Precio", "Num. Paginas" ,"Stock","Descuento"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        tabla.setModel(modelo);
        int numeracion = 0;
        try {
            this.obtenerconexion();
            rs = st.executeQuery("SELECT idlibro, titulo, idautor, ideditorial, idtipolibro ,precio, numeropaginas , stock FROM libros where idlibro = "+idlibro+";");
            while (rs.next()) {
                numeracion++;
                Libro libro = new Libro();
                libro.setIdlibro(rs.getInt(1));
                libro.setTitulo(rs.getString(2));
                libro.setIdautor(rs.getInt(3));
                libro.setIdeditorial(rs.getInt(4));
                libro.setIdtipolibro(rs.getInt(5));
                libro.setPrecio(rs.getDouble(6));
                libro.setNumpagina(rs.getInt(7));
                libro.setStock(rs.getInt(8));
                

                CRUDeditoriales crude = new CRUDeditoriales();
                Editorial editorial = crude.ConsultarEditorialPorId(libro.getIdeditorial());
                libro.setEditorial(editorial);

                CRUDautores cruda = new CRUDautores();
                Autor autor = cruda.ConsultarAutorPorId(libro.getIdautor());
                libro.setAutor(autor);
                
                CRUDtipolibro1 crudt = new CRUDtipolibro1();
                TipoLibro tipo = crudt.ConsultarTipolibroPorId(libro.getIdtipolibro());
                libro.setTipolibros(tipo);
                
                if(rs.getInt(8) > 0){
                    modelo.addRow(libro.RegistroLibrosVenta(numeracion));
                }
                
                
            } //Fin del while
            //conexion.close();
        } catch (Exception ex) {
            Mensajes.M1("ERROR! No se pueden mostrar los registros de la tabla empleado..." + ex);
        } finally {
            this.cerrarconexion();
        }
    } //Fin del metodo
    
    public void MostrarLibrosPorAutorEnTabla(JTable tabla, int idautor) {
        String titulos[] = {"ID", "Titulo", "Autor", "Editorial", "Tipo" , "Precio", "Num. Paginas" ,"Stock","Descuento"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        tabla.setModel(modelo);
        int numeracion = 0;
        try {
            this.obtenerconexion();
            rs = st.executeQuery("SELECT idlibro, titulo, idautor, ideditorial, idtipolibro ,precio, numeropaginas , stock FROM libros where idautor = "+idautor+";");
            while (rs.next()) {
                numeracion++;
                Libro libro = new Libro();
                libro.setIdlibro(rs.getInt(1));
                libro.setTitulo(rs.getString(2));
                libro.setIdautor(rs.getInt(3));
                libro.setIdeditorial(rs.getInt(4));
                libro.setIdtipolibro(rs.getInt(5));
                libro.setPrecio(rs.getDouble(6));
                libro.setNumpagina(rs.getInt(7));
                libro.setStock(rs.getInt(8));
                

                CRUDeditoriales crude = new CRUDeditoriales();
                Editorial editorial = crude.ConsultarEditorialPorId(libro.getIdeditorial());
                libro.setEditorial(editorial);

                CRUDautores cruda = new CRUDautores();
                Autor autor = cruda.ConsultarAutorPorId(libro.getIdautor());
                libro.setAutor(autor);
                
                CRUDtipolibro1 crudt = new CRUDtipolibro1();
                TipoLibro tipo = crudt.ConsultarTipolibroPorId(libro.getIdtipolibro());
                libro.setTipolibros(tipo);
                
                if(rs.getInt(8) > 0){
                    modelo.addRow(libro.RegistroLibrosVenta(numeracion));
                }
                
                
            } //Fin del while
            //conexion.close();
        } catch (Exception ex) {
            Mensajes.M1("ERROR! No se pueden mostrar los registros de la tabla empleado..." + ex);
        } finally {
            this.cerrarconexion();
        }
    } //Fin del metodo
    
    public void MostrarLibrosPorTituloEnTabla(JTable tabla, String titulo) {
        String titulos[] = {"ID", "Titulo", "Autor", "Editorial", "Tipo" , "Precio", "Num. Paginas" ,"Stock","Descuento"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        tabla.setModel(modelo);
        int numeracion = 0;
        try {
            this.obtenerconexion();
            rs = st.executeQuery("SELECT idlibro, titulo, idautor, ideditorial, idtipolibro ,precio, numeropaginas , stock FROM libros where titulo = '"+titulo+"'");
            while (rs.next()) {
                numeracion++;
                Libro libro = new Libro();
                libro.setIdlibro(rs.getInt(1));
                libro.setTitulo(rs.getString(2));
                libro.setIdautor(rs.getInt(3));
                libro.setIdeditorial(rs.getInt(4));
                libro.setIdtipolibro(rs.getInt(5));
                libro.setPrecio(rs.getDouble(6));
                libro.setNumpagina(rs.getInt(7));
                libro.setStock(rs.getInt(8));
                

                CRUDeditoriales crude = new CRUDeditoriales();
                Editorial editorial = crude.ConsultarEditorialPorId(libro.getIdeditorial());
                libro.setEditorial(editorial);

                CRUDautores cruda = new CRUDautores();
                Autor autor = cruda.ConsultarAutorPorId(libro.getIdautor());
                libro.setAutor(autor);
                
                CRUDtipolibro1 crudt = new CRUDtipolibro1();
                TipoLibro tipo = crudt.ConsultarTipolibroPorId(libro.getIdtipolibro());
                libro.setTipolibros(tipo);
                
                if(rs.getInt(8) > 0){
                    modelo.addRow(libro.RegistroLibrosVenta(numeracion));
                }
                
                
            } //Fin del while
            //conexion.close();
        } catch (Exception ex) {
            Mensajes.M1("ERROR! No se pueden mostrar los registros de la tabla empleado..." + ex);
        } finally {
            this.cerrarconexion();
        }
    } //Fin del metodo
    
    public Libro ConsultarRegistroLibroPortituloLibro(String titulo) {
        Libro libro = null; //Vacio
        try {
            this.obtenerconexion();
            rs = st.executeQuery("SELECT idlibro,titulo,idautor,ideditorial,precio,stock,idempleado FROM libros WHERE titulo = '" + titulo+"'");
            if (rs.next()) {//Si tiene registro la consulta
                libro = new Libro();
                libro.setIdlibro(rs.getInt(1));
                libro.setTitulo(rs.getString(2));
                libro.setIdautor(rs.getInt(3));
                libro.setIdeditorial(rs.getInt(4));
                libro.setPrecio(rs.getDouble(5));
                libro.setStock(rs.getInt(6));
                libro.setIdempleado(rs.getInt(7));

                CRUDeditoriales crude = new CRUDeditoriales();
                Editorial editorial = crude.ConsultarEditorialPorId(libro.getIdeditorial());
                libro.setEditorial(editorial);

                CRUDautores cruda = new CRUDautores();
                Autor autor = cruda.ConsultarAutorPorId(libro.getIdautor());
                libro.setAutor(autor);
            }
            //conexion.close();
        } catch (Exception ex) {
            Mensajes.M1("ERROR! No se puede recuperar el registro del empleado..." + ex);
        } finally {
            this.cerrarconexion();
        }
        return libro;
    }
    
    public void MostrarLibrosPorIdEditorialEnTabla(JTable tabla, int id) {
        String titulos[] = {"ID", "Titulo", "Autor", "Editorial", "Tipo" , "Precio", "Num. Paginas" ,"Stock","Descuento"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        tabla.setModel(modelo);
        int numeracion = 0;
        try {
            this.obtenerconexion();
            rs = st.executeQuery("SELECT idlibro, titulo, idautor, ideditorial, idtipolibro ,precio, numeropaginas , stock FROM libros where ideditorial = "+id);
            while (rs.next()) {
                numeracion++;
                Libro libro = new Libro();
                libro.setIdlibro(rs.getInt(1));
                libro.setTitulo(rs.getString(2));
                libro.setIdautor(rs.getInt(3));
                libro.setIdeditorial(rs.getInt(4));
                libro.setIdtipolibro(rs.getInt(5));
                libro.setPrecio(rs.getDouble(6));
                libro.setNumpagina(rs.getInt(7));
                libro.setStock(rs.getInt(8));
                

                CRUDeditoriales crude = new CRUDeditoriales();
                Editorial editorial = crude.ConsultarEditorialPorId(libro.getIdeditorial());
                libro.setEditorial(editorial);

                CRUDautores cruda = new CRUDautores();
                Autor autor = cruda.ConsultarAutorPorId(libro.getIdautor());
                libro.setAutor(autor);
                
                CRUDtipolibro1 crudt = new CRUDtipolibro1();
                TipoLibro tipo = crudt.ConsultarTipolibroPorId(libro.getIdtipolibro());
                libro.setTipolibros(tipo);
                
                if(rs.getInt(8) > 0){
                    modelo.addRow(libro.RegistroLibrosVenta(numeracion));
                }
                
                
            } //Fin del while
            //conexion.close();
        } catch (Exception ex) {
            Mensajes.M1("ERROR! No se pueden mostrar los registros de la tabla empleado..." + ex);
        } finally {
            this.cerrarconexion();
        }
    } //Fin del metodo
    
    public void MostrarLibrosPorIdTipolibroEnTabla(JTable tabla, int id) {
        String titulos[] = {"ID", "Titulo", "Autor", "Editorial", "Tipo" , "Precio", "Num. Paginas" ,"Stock","Descuento"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        tabla.setModel(modelo);
        int numeracion = 0;
        try {
            this.obtenerconexion();
            rs = st.executeQuery("SELECT idlibro, titulo, idautor, ideditorial, idtipolibro ,precio, numeropaginas , stock FROM libros where idtipolibro = "+id);
            while (rs.next()) {
                numeracion++;
                Libro libro = new Libro();
                libro.setIdlibro(rs.getInt(1));
                libro.setTitulo(rs.getString(2));
                libro.setIdautor(rs.getInt(3));
                libro.setIdeditorial(rs.getInt(4));
                libro.setIdtipolibro(rs.getInt(5));
                libro.setPrecio(rs.getDouble(6));
                libro.setNumpagina(rs.getInt(7));
                libro.setStock(rs.getInt(8));
                

                CRUDeditoriales crude = new CRUDeditoriales();
                Editorial editorial = crude.ConsultarEditorialPorId(libro.getIdeditorial());
                libro.setEditorial(editorial);

                CRUDautores cruda = new CRUDautores();
                Autor autor = cruda.ConsultarAutorPorId(libro.getIdautor());
                libro.setAutor(autor);
                
                CRUDtipolibro1 crudt = new CRUDtipolibro1();
                TipoLibro tipo = crudt.ConsultarTipolibroPorId(libro.getIdtipolibro());
                libro.setTipolibros(tipo);
                
                if(rs.getInt(8) > 0){
                    modelo.addRow(libro.RegistroLibrosVenta(numeracion));
                }
                
                
            } //Fin del while
            //conexion.close();
        } catch (Exception ex) {
            Mensajes.M1("ERROR! No se pueden mostrar los registros de la tabla empleado..." + ex);
        } finally {
            this.cerrarconexion();
        }
    } //Fin del metodo
    
    public void ActualizarRegistroLibrosPorIDVentas(int id, int cantidad) {
        try {
            this.obtenerconexion();
            ps = conexion.prepareStatement("UPDATE libros SET stock = stock-"+cantidad+" WHERE idlibro = "+id+";");
            ps.executeUpdate();
            ps.close();
            
            //conexion.close();

        } catch (Exception ex) {
            Mensajes.M1("ERROR! No se puede actualizar el registro empleados..." + ex);
        } finally {
            this.cerrarconexion();
        }
    }
}
