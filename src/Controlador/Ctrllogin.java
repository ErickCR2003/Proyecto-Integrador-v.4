package Controlador;
import DAO.CRUDempleados;
import Formatos.Mensajes;
import Principal.Main;
import Vst.VstLogin;
import Vst.VstMenuPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ctrllogin implements ActionListener {

    VstLogin vista;
    CRUDempleados crude;

    public Ctrllogin(VstLogin lg) {

        vista = lg;
        crude = new CRUDempleados();
        vista.jbtnIniciarSesion.addActionListener(this);
        vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        //Verificando si existe usuario y contraseña
        if (!crude.ExisteUsrPass(vista.jtxtUsuario.getText(), vista.jpswContraseña.getText())) {
            Mensajes.M1("Usuario y Contraseña no encontrados");
            return;
        
        }
        //si pasó, se obtiene usuario
        if (!crude.UsrEstaActivo(vista.jtxtUsuario.getText(), vista.jpswContraseña.getText())) {
            Mensajes.M1("Usuario no activo, comuníquese con el administrador del sistema");
            return;
        }
        
         //si llega hasta aquí el usuario es válido
        Main.UsrActual =  crude.CargarUsuario(vista.jtxtUsuario.getText(), vista.jpswContraseña.getText());       
        
        //abrir menu principal            
        
        Main.VMP = new VstMenuPrincipal();
        Main.CMP = new CtrlMenuPrincipal(Main.VMP);
        Main.VLogin.dispose();        
    }
    
}
