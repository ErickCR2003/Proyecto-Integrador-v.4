package Controlador;

import Formatos.Mensajes;
import Principal.Main;
import Vista1.ConfirmarCompra;
import Vista_Empleado1.BuscarLibros_Venta;
import Vista_Empleado1.PrecioDireccion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador_PrecioDireccion implements ActionListener{

    PrecioDireccion vista;
    BuscarLibros_Venta vista2;
    
    public Controlador_PrecioDireccion(PrecioDireccion PD, BuscarLibros_Venta BV) {
        vista = PD;
        vista2 = BV;
        
        vista.jlblDireccion.setText("DIRECCION: "+vista2.jtxtDirección.getText());
        vista.jbtnCancelar.addActionListener(this);
        vista.jbtnConfirmar.addActionListener(this);
        vista.jtxtprecio.setText("0.0");
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vista.jbtnCancelar){
            Main.VPD.dispose();
        }
        
        if(e.getSource() == vista.jbtnConfirmar){
            if(Double.parseDouble(vista.jtxtprecio.getText()) <= 0){
                Mensajes.M1("EL PRECIO TIENE QUE SER MAYOR A 0");
            } else {
            Main.VCC = new ConfirmarCompra();
            Main.CCC = new Controlador_ConfirmarCompra(Main.VCC,Main.VBLV,Main.VES,this.vista,Main.VAD, Main.VL);
            Main.VPD.dispose();
            }
        }
    }
    
}
