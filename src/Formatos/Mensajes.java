package Formatos;
//Libreria
import javax.swing.JOptionPane;
public class Mensajes {
    
    public static void M1(String mensaje){
        JOptionPane.showMessageDialog(null, "<html><font face='Monospace'>"+ mensaje);
        //"<html><font face='Calibri' size='15' color='red'>Hello"
    }
    public static String M2(String mensaje){
        return JOptionPane.showInputDialog("<html><font face='Monospace'>"+ mensaje);
    }
    
    public static int M3(String titulo,String mensaje){
        return JOptionPane.showConfirmDialog(null, "<html><font face='Monospace'>"+ mensaje, titulo, JOptionPane.OK_CANCEL_OPTION);
    } //Si el boton a presionar es OK retorna el 0
} // Fin de la clase