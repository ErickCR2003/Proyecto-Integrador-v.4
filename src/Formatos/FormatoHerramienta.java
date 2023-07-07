package Formatos;

import Vst.Herramienta.VstHerramienta;
import Modelo.Herramienta;
import DAO.CRUDherramientas;
import Principal.Main;
import Vst.Herramienta.VstHerramienta_Editar;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class FormatoHerramienta {

    public static void LimpiarEntradasLN(VstHerramienta XVHerrN) {
       
        XVHerrN.cmbTipoHerramienta.setSelectedIndex(0);
        XVHerrN.txtNroSerie.setText("");
        XVHerrN.txtNombre.setText("");    
        XVHerrN.txtDescrip.setText("");       
        XVHerrN.txtPrecXdia.setText("");       
        XVHerrN.txtPeso.setText("");       
        XVHerrN.txtAnioFabrica.setText("");       
        XVHerrN.txtFecAdquisicion.setDateFormatString("");     
        XVHerrN.txtNroAlquileres.setText("");      
        XVHerrN.txtImpValorRef.setText("");
        XVHerrN.txtNroSerie.requestFocus();
        
    }
    
    public static Herramienta LeerHerramienta(VstHerramienta ve) {

        SimpleDateFormat ff = new SimpleDateFormat("yyyy-MM-dd");
        var Her = new Herramienta();
        Her.setIdTipo(ve.cmbTipoHerramienta.getSelectedIndex()+1);
        Her.setNroSerie(ve.txtNroSerie.getText());
        Her.setNombre(ve.txtNombre.getText());
        Her.setDescripcion(ve.txtDescrip.getText());
        Her.setEstado(ve.jcbxEstado.getSelectedItem().toString());
        Her.setImp_PrecioAlquiler(Double.parseDouble(ve.txtPrecXdia.getText()));
        Her.setPeso(Double.parseDouble(ve.txtPeso.getText()));
        Her.setAnioFabricacion(Integer.parseInt(ve.txtAnioFabrica.getText()));
        Her.setFecAdquisicion(LocalDate.parse(ff.format(ve.txtFecAdquisicion.getCalendar().getTime())));
        Her.setNroAlquileres(Integer.parseInt(ve.txtNroAlquileres.getText()));  
        Her.setImp_ValorReferencial(Double.parseDouble(ve.txtImpValorRef.getText()));

        return Her;
    }
    
    public static Herramienta LeerHerramienta(VstHerramienta_Editar ve) {

        SimpleDateFormat ff = new SimpleDateFormat("yyyy-MM-dd");
        var Her = new Herramienta();
        Her.setIdTipo(ve.cmbTipoHerramienta.getSelectedIndex()+1);
        Her.setNroSerie(ve.txtNroSerie.getText());
        Her.setNombre(ve.txtNombre.getText());
        Her.setDescripcion(ve.txtDescrip.getText());
        Her.setEstado(ve.jcbxEstado.getSelectedItem().toString());
        Her.setImp_PrecioAlquiler(Double.parseDouble(ve.txtPrecXdia.getText()));
        Her.setPeso(Double.parseDouble(ve.txtPeso.getText()));
        Her.setAnioFabricacion(Integer.parseInt(ve.txtAnioFabrica.getText()));
        Her.setFecAdquisicion(LocalDate.parse(ff.format(ve.txtFecAdquisicion.getCalendar().getTime())));
        Her.setNroAlquileres(Integer.parseInt(ve.txtNroAlquileres.getText()));  
        Her.setImp_ValorReferencial(Double.parseDouble(ve.txtImpValorRef.getText()));

        return Her;
    }
    
    public static void LimpiarEntradas(VstHerramienta_Editar XVHerrN) {
       
        XVHerrN.cmbTipoHerramienta.setSelectedIndex(0);
        XVHerrN.txtNroSerie.setText("");
        XVHerrN.txtNombre.setText("");    
        XVHerrN.txtDescrip.setText("");       
        XVHerrN.txtPrecXdia.setText("");       
        XVHerrN.txtPeso.setText("");       
        XVHerrN.txtAnioFabrica.setText("");       
        XVHerrN.txtFecAdquisicion.setDateFormatString("");     
        XVHerrN.txtNroAlquileres.setText("");      
        XVHerrN.txtImpValorRef.setText("");
        XVHerrN.txtNroSerie.requestFocus();
        
    }
  
    
}
