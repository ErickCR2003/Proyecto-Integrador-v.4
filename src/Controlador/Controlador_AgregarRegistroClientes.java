/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.CRUDclientes;
import Formatos.FormatoClientes;
import Formatos.Mensajes;
import Modelo.Cliente;
import Vista_Empleado1.AñadirRegistroClientes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author User
 */
public class Controlador_AgregarRegistroClientes implements ActionListener{
    Cliente clie;
    AñadirRegistroClientes vista;
    CRUDclientes crude;
    Controlador_AdministrarRegistroClientesEmpresa controladorAdminRegistroClieEmpre;
    
    
    
    public Controlador_AgregarRegistroClientes(AñadirRegistroClientes AÑRC,Controlador_AdministrarRegistroClientesEmpresa CARC) {
       vista=AÑRC;
       vista.jbtnRegistrar.addActionListener(this);
       controladorAdminRegistroClieEmpre=CARC;
       crude = new CRUDclientes();
       vista.setVisible(true);
       vista.setLocationRelativeTo(null);
    }
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== vista.jbtnRegistrar){
           /*if(vista.jtxtNombreCompleto.getText().isEmpty() || vista.jtxtDireccion.getText().isEmpty()
                    || vista.jtxtTelefono.getText().isEmpty()|| vista.jtxtNumerodeIdentificacion.getText().isEmpty() ||
                    vista.jdtcFechaNacimiento.getDate() == null){
                Mensajes.M1("Complete todos los campos");
            }else*/
            if(vista.jtxtNombreCompleto.getText().isEmpty()){
               Mensajes.M1("Complete el campo de Nombre");
            }else if(vista.jtxtDireccion.getText().isEmpty()){
                Mensajes.M1("Complete la Direccion");
            }else if(vista.jtxtTelefono.getText().isEmpty()){
                Mensajes.M1("Complete el campo de Telefono");
            }else if(vista.jtxtNumerodeIdentificacion.getText().isEmpty()){
                Mensajes.M1("Complete el campo de Numero de Identificacion");
            }else if(vista.jdtcFechaNacimiento.getDate() == null){
                Mensajes.M1("Complete el campo de Fecha de Nacimiento");
            }else{
            clie=FormatoClientes.LeerCliente(vista);
            crude=new CRUDclientes();
            crude.InsertarRegistroClientes(clie);
            FormatoClientes.LimpiarEntradas(vista);
            controladorAdminRegistroClieEmpre.ActualizarFormulario();
            }
        }
    }
    












}