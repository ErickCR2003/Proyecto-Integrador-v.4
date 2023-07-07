/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Formatos;

import Vista_Empleado1.BuscarLibros_Venta;

/**
 *
 * @author admin
 */
public class FormatoVenta {
    
     public static void LimpiarEntradas(BuscarLibros_Venta BV){
        BV.jtxtTituloLibro.setText("");
        BV.jspnCodigoLibro.setValue(0);
        BV.jcbxAutor.setSelectedIndex(0);
        BV.jcbxeditorial.setSelectedIndex(0);
        BV.jcbxtipolibro.setSelectedIndex(0);
    }
    
}
