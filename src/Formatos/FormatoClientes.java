/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Formatos;

import Modelo.Cliente;
import Vst.Cliente.VstCliente_Nvo;
import Vst.Cliente.VstCliente_Editar;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

/**
 *
 * @author User
 */
public class FormatoClientes {
    
    public static Cliente LeerCliente(VstCliente_Nvo f1){
        Cliente cli=new Cliente();
        SimpleDateFormat ff = new SimpleDateFormat("yyyy-MM-dd");
        cli.setNombrecompleto(f1.jtxtNombreCompleto.getText());
        cli.setTelefono(f1.jtxtTelefono.getText());
        cli.setDireccion(f1.jtxtDireccion.getText());
        cli.setFecNacimiento(LocalDate.parse(ff.format(f1.jdtcFechaNacimiento.getCalendar().getTime())));
        cli.setNumeroIdentificacion(f1.jtxtNumerodeIdentificacion.getText());
        
        return cli;
    }
    
    public static void LimpiarEntradas(VstCliente_Nvo AE){
        AE.jtxtNombreCompleto.setText("");
        AE.jtxtDireccion.setText("");
        AE.jtxtTelefono.setText("");
        AE.jtxtNumerodeIdentificacion.setText("");
        AE.jdtcFechaNacimiento.setDateFormatString("");
        AE.jtxtNombreCompleto.requestFocus();
    }   

    
    public static Cliente EditarCliente(VstCliente_Editar f1){
        Cliente cli=new Cliente();
        SimpleDateFormat ff = new SimpleDateFormat("yyyy-MM-dd");
        cli.setNombrecompleto(f1.jtxtEditarNombreCompleto.getText());
        cli.setTelefono(f1.jtxtEditarTelefono.getText());
        cli.setDireccion(f1.jtxtEditarDireccion.getText());
        cli.setFecNacimiento(LocalDate.parse(ff.format(f1.jdtcEditarFechaNacimiento.getCalendar().getTime())));
        cli.setRucDni(f1.jcbxEditarDniORuc.getSelectedItem().toString());
        cli.setNumeroIdentificacion(f1.jtxtEditarNumerodeIdentificacion.getText());
        return cli;
    }
  
    
}
