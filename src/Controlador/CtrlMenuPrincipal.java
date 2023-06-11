package Controlador;

import Vst.Empleado.VstEmpleado_Lista;
import Vst.Alquiler.VstAlquiler_Confirmar;
import Vst.Alquiler.VstAlquiler_PrecDirec;
import Vst.Recibo.VstReciboVista1;
import Vst.Tipo.VstTipo_Lista;

import Formatos.Mensajes;
import Principal.Main;
import Vst.Alquiler.VstAlquiler;
import Vst.Alquiler.VstAlquiler_Lista;
import Vst.Cliente.VstCliente_Lista;
import Vst.Herramienta.VstHerramienta_Lista;
import Vst.VstMenuPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CtrlMenuPrincipal implements ActionListener {
    
    //--- Alquiler ------------------------------------------------------------------------------------
    public static Vst.Alquiler.VstAlquiler_Lista VAlq_Lista = new VstAlquiler_Lista();
    public static CtrlAlquiler_Lista CAlq_Lista = new CtrlAlquiler_Lista(VAlq_Lista);     
    
    //--- Herramienta ----------------------------------------------------------------------------------
    public static Vst.Herramienta.VstHerramienta_Lista VHerr_Lista = new VstHerramienta_Lista();
    public static CtrlHerramienta_Lista CHerr_Lista = new CtrlHerramienta_Lista(VHerr_Lista);    
    
    //--- Tipo Herramienta -----------------------------------------------------------------------------
    public static VstTipo_Lista VTipo_Lista = new VstTipo_Lista();
    public static Controlador.CtrlTipo_Lista CTipo_Lista = new CtrlTipo_Lista(VTipo_Lista); 
    
    //--- Empleado --------------------------------------------------------------------------------------    
    public static Vst.Empleado.VstEmpleado_Lista VEmpleado_Lista = new VstEmpleado_Lista();
    public static CtrlEmpleado_Lista CEmpleado_Lista = new CtrlEmpleado_Lista(VEmpleado_Lista);
    
    //--- Cliente -----------------------------------------------------------------------------------------
    public static Vst.Cliente.VstCliente_Lista VCliente_Lista = new VstCliente_Lista();
    public static CtrlCliente_Lista CCliente_Lista = new CtrlCliente_Lista(VCliente_Lista);   
            
    //--- Recibos -----------------------------------------------------------------------------------------
//    public static Vst.Recibo.VstAdminHistoFac VHistoFac;
//    public static Controlador_Administrar_Factura_Cliente CHistoFac;
//    
//    public static VstReciboVista1 VRecibo;
//    public static CtrlRecibo CRecibo;

    //--- Reporte --------------------------------------------------------------
//    public static Vst.Reporte.VstReportes VReportes;
//    public static Controlador.Controlador_Administrar_Reporte CReportes;
   
    //--- Menú principal -------------------------------------------------------
    public static VstMenuPrincipal VstMenuPrin;
    
    //--------------------------------------------------------------------------
    
    
    
    
    public CtrlMenuPrincipal(VstMenuPrincipal XVstMenuP) {

        VstMenuPrin = XVstMenuP;

        VstMenuPrin.BtnAlquileres.addActionListener(this);
        VstMenuPrin.BtnHerramientas.addActionListener(this);
        VstMenuPrin.BtnClientes.addActionListener(this);
        VstMenuPrin.BtnTipoHerr.addActionListener(this);       
        VstMenuPrin.BtnHistorialFact.addActionListener(this);
        VstMenuPrin.BtnReportes.addActionListener(this);
        VstMenuPrin.BtnEmpleados.addActionListener(this);
        VstMenuPrin.BtnCerrarSesion.addActionListener(this);

        //inicia con alquiler
        VstMenuPrin.jdesktoppnlContenedor.removeAll();        
        VstMenuPrin.jdesktoppnlContenedor.add(VAlq_Lista);
        
        VstMenuPrin.show();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //empleados
        if (e.getSource() == VstMenuPrin.BtnEmpleados) {
            VstMenuPrin.jdesktoppnlContenedor.removeAll();            
            VstMenuPrin.jdesktoppnlContenedor.add(VEmpleado_Lista);
        }   
        
        //herramientas
        if (e.getSource() == VstMenuPrin.BtnHerramientas) {
            VstMenuPrin.jdesktoppnlContenedor.removeAll();          
            VstMenuPrin.jdesktoppnlContenedor.add(VHerr_Lista);
        } 
                
         //Tipo herramientas
        if (e.getSource() == VstMenuPrin.BtnTipoHerr) {
            VstMenuPrin.jdesktoppnlContenedor.removeAll();          
            VstMenuPrin.jdesktoppnlContenedor.add(VTipo_Lista);
        } 
      
        //alquileres
        if (e.getSource() == VstMenuPrin.BtnAlquileres) {
            VstMenuPrin.jdesktoppnlContenedor.removeAll();            
            VstMenuPrin.jdesktoppnlContenedor.add(VAlq_Lista);
        }         
        
        //clientes
        if (e.getSource() == VstMenuPrin.BtnClientes) {
            VstMenuPrin.jdesktoppnlContenedor.removeAll();           
            VstMenuPrin.jdesktoppnlContenedor.add(VCliente_Lista);
        }      
        
        
        // Cerrar sesión
         if (e.getSource() == VstMenuPrin.BtnCerrarSesion) {
            int respuesta = Mensajes.M3("Confirmación", "¿Confirma que desea cerrar sesión?"); // si la respuesta es OK representa 0
            if (respuesta == 0) {
                VstMenuPrin.jdesktoppnlContenedor.removeAll();
                VstMenuPrin.dispose();
                Main.VLogin  = new Vst.VstLogin();
                Main.CLogin = new Ctrllogin(Main.VLogin);
            }
        }    
      
    }    
}
