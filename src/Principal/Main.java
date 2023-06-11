package Principal;

import Controlador.CtrlMenuPrincipal;
import Controlador.Ctrllogin;
import Modelo.Empleado;
  

public class Main {

    /*Ejecuta aquí*/
        
    public static Empleado UsrActual;

    public static Vst.VstLogin VLogin;
    public static Controlador.Ctrllogin CLogin;
    
    public static Vst.VstMenuPrincipal VMP;
    public static CtrlMenuPrincipal CMP;
        

    public static void main(String[] args) {

        VLogin = new Vst.VstLogin();
        CLogin = new Ctrllogin(VLogin);
    }
}
