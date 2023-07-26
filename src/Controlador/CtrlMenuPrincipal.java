package Controlador;

import Vst.Empleado.VstEmpleado_Lista;
import Vst.Tipo.VstTipo_Lista;
import Formatos.Mensajes;
import Principal.Main;
import Vst.Alquiler.VstAlquiler_Lista;
import Vst.Alquiler.VstAlquiler_Devolver;
import Vst.Caja.VstCaja;
import Vst.Cliente.VstCliente_Lista;
import Vst.Herramienta.VstHerramienta_Lista;
import Vst.Reporte.VstReportes;
import Vst.VstMenuPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vst.Mantenimiento.VstMantenimiento_Lista;


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
    
    //--- Reporte --------------------------------------------------------------
    public static Vst.Reporte.VstReportes VReportes = new VstReportes();
    public static CtrlReporte CReportes = new CtrlReporte(VReportes); 
    
    
    //--- Caja --------------------------------------------------------------
    public static Vst.Caja.VstCaja VCaja = new VstCaja();
    public static CtrlCaja CCaja = new CtrlCaja(VCaja); 
            
      //--- Mantenimiento ------------------------------------------------------------------------------
    public static Vst.Mantenimiento.VstMantenimiento_Lista VMantenimiento_Lista = new VstMantenimiento_Lista();
    public static CtrlMantenimiento_Lista CMantenimiento = new CtrlMantenimiento_Lista(VMantenimiento_Lista);
    
    //--- Recibos -----------------------------------------------------------------------------------------
//    public static Vst.Recibo.VstAdminHistoFac VHistoFac;
//    public static Controlador_Administrar_Factura_Cliente CHistoFac;
//    
//    public static VstReciboVista1 VRecibo;
//    public static CtrlRecibo CRecibo;

 
   
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
        VstMenuPrin.BtnCaja.addActionListener(this);        
        VstMenuPrin.BtnReporte.addActionListener(this);
        VstMenuPrin.BtnEmpleados.addActionListener(this);    
        VstMenuPrin.BtnMantenimiento.addActionListener(this);
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
        
        //Caja
        if (e.getSource() == VstMenuPrin.BtnCaja) {
            VstMenuPrin.jdesktoppnlContenedor.removeAll();           
            VstMenuPrin.jdesktoppnlContenedor.add(VCaja);
            CCaja.CargarMovimientosDiaAct();
        }  
        
        //Reporte
        if (e.getSource() == VstMenuPrin.BtnReporte) {
            VstMenuPrin.jdesktoppnlContenedor.removeAll();           
            VstMenuPrin.jdesktoppnlContenedor.add(VReportes);
        }  
        
        //Mantenimiento
        if (e.getSource() == VstMenuPrin.BtnMantenimiento) {
            VstMenuPrin.jdesktoppnlContenedor.removeAll();           
            VstMenuPrin.jdesktoppnlContenedor.add(VMantenimiento_Lista);
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
