/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.CRUDMovimiento;
import DAO.CRUDreportes;
import Formatos.Mensajes;
import Modelo.Movimiento;
import Principal.Main;
import Vst.Caja.VstCaja;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;


public class CtrlCaja implements ActionListener{    
     VstCaja vista;
     CRUDMovimiento crudm;
     double impEfecCaja;
     double impIngME;
     double impRetiro;
    
      public CtrlCaja(VstCaja XVCaja) {
        vista = XVCaja;         
       
        //-- Asociar eventos de la vista al controlador                         
        vista.btnRetiroDeCaja.addActionListener(this);
        vista.btnActualizarListas.addActionListener(this);                
        
        //-- Mostrar
        vista.setVisible(true);  
    }

   
      
    public void  CargarMovimientosDiaAct(){     
        
        vista.fecha_desde.setDate(java.sql.Date.valueOf(LocalDate.now()));
        vista.fecha_hasta.setDate(java.sql.Date.valueOf(LocalDate.now())); 
        CargarMovimientosRango();        
    }
    
    public void  CargarMovimientosRango(){                     
        CargarTablasMovimientos();        
        CargarMontoEnCaja();        
    }
    
     private void CargarTablasMovimientos(){
        crudm = new CRUDMovimiento();
        crudm.MostrarMovimientosIngresoEfectivo(vista.tablaIngEfectivo, vista.fecha_desde,
                 vista.fecha_hasta);
        crudm.MostrarMovimientosSalidasEfectivo(vista.tablaSalEfectivo, vista.fecha_desde,
                 vista.fecha_hasta);
        crudm.MostrarMovimientosIngresosME(vista.tablaIngME, vista.fecha_desde,
                 vista.fecha_hasta);
    }
    
     
     private void CargarMontoEnCaja(){
     
        impEfecCaja = crudm.DameTotalEnCaja();
        impIngME = crudm.DameTotalIngME();
     
        vista.lblTotalEnCaja.setText("S/ " + impEfecCaja );
        vista.lblTotalME.setText("S/ " + impIngME);
     }
      
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == vista.btnActualizarListas) {
            
            CargarMovimientosRango();                        
        }
        
        
        if (e.getSource() == vista.btnRetiroDeCaja) {
            
            impRetiro = Double.parseDouble(vista.txtImpRetiro.getValue().toString());
            
            if ( impRetiro <= 0) {
                Mensajes.M1("Ingrese un monto en la casilla de cantidad a retirar");
            }else{
                if (impRetiro < impEfecCaja) {
                    CRUDMovimiento crudr = new CRUDMovimiento();
                    Movimiento movR = new Movimiento();
                    //movR.setIdAlquiler(alq.getID());
                    movR.setConcepto("Retiro");
                    movR.setIdEmpleado(Main.UsrActual.getID());
                    movR.setTipoEfectivoElectronico("Efectivo");
                    movR.setAnulado(false);
                    movR.setMonto(impRetiro);
                    movR.setTipoIngresoSalida("Salida");
                    crudr.Movimiento_Insertar(movR);
                    CargarMovimientosRango();
                    vista.txtImpRetiro.setValue(0);
                    Mensajes.M1("Retiro realizado correctamente");
                    
                }else{
                    Mensajes.M1("El monto a retirar es mayor que el monto disponible en caja");
                }
            }
            
            
        }
    }       
}
