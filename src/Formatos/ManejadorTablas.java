package Formatos;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

public class ManejadorTablas {
    
    //Metodo que especifica un ancho de las columnas de tabla
    public static void AnchoColumnas(JTable t,int numcolumna,int ancho){
        TableColumn column;
        column = t.getColumnModel().getColumn(numcolumna);
        column.setPreferredWidth(ancho);
    }
    
    //Metodo que justifica los datos de una columna
    public static void JustificarCelda(JTable t,int numcolumna){
        DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
        modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);
        t.getColumnModel().getColumn(numcolumna).setCellRenderer(modelocentrar);
    }
    
    //Metodo que le da formato a la JTable de la tabla Empleados
    public static void FormatoTablaEmpleados(JTable tabla){
        for (int i = 0; i < 11; i++) {
            JustificarCelda(tabla, i);
        }  
        
    }
    
    public static void FormatoTablaHerramientas(JTable tabla){
        for (int i = 0; i < 10; i++) {
            JustificarCelda(tabla, i);
        }       
    }
    
    public static void FormatoTablaTipos(JTable tabla){
        for (int i = 0; i < 3; i++) {
            JustificarCelda(tabla, i);
        }       
    }
    
    public static void FormatoTablaClientes(JTable tabla){
        for (int i = 0; i < 7; i++) {
            JustificarCelda(tabla, i);
        }       
    }
    
     public static void FormatoTablaMantenimiento(JTable tabla){
        for (int i = 0; i < 7; i++) {
            JustificarCelda(tabla, i);
        }       
    }
    
}
