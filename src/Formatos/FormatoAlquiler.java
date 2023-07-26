
package Formatos;

import Modelo.Alquiler;
import Vst.Alquiler.VstAlquiler;
import java.time.LocalDate;


public class FormatoAlquiler {

    public static void LimpiarEntradas(VstAlquiler BV) {
        BV.jtxtMarcaHerramienta.setText("");
        BV.jcbxTipo.setSelectedIndex(0);
    }

    public static void LimpiarEntradasTabla(VstAlquiler BV) {
        BV.jtxtClienteCom.setText("");
        BV.jtxtDirecciónObra.setText("");
        BV.jcbxTraslado.setSelectedIndex(0);
        BV.jspnDiasdeAlquiler.setValue(0);
        BV.jspnPrecioTraslado.setValue(0);
    }
    
    public static Alquiler LeerAlquiler(LocalDate fecHoraCreacion,int diasAlquiler,LocalDate fecHoraSalida,
                        LocalDate fecHoraRetorno,double imp_Total,double imp_Garantia,double imp_Traslado,double imp_Alquiler,
                        String estado, boolean conTraslado,String direccionEntrega,String serieFacBol, int NroFacBol,
                        String serieCorrFacBol,int idEmpleado,int idCliente){
        Alquiler alq = new Alquiler();
        alq.setFecHoraCreacion(fecHoraCreacion);
        alq.setDiasAlquiler(diasAlquiler);
        alq.setFecHoraSalida(fecHoraSalida);
        alq.setFecHoraRetorno(fecHoraRetorno);
        alq.setImp_Total(imp_Total);
        alq.setImp_Garantia(imp_Garantia);
        alq.setImp_Traslado(imp_Traslado);
        alq.setImp_Alquiler(imp_Alquiler);
        alq.setEstado(estado);
        alq.setConTraslado(conTraslado);
        alq.setDireccionEntrega(direccionEntrega);
        alq.setSerieFacBol(serieFacBol);
        alq.setSerieCorrFacBol(serieCorrFacBol);
        alq.setIdCliente(idCliente);
        alq.setIdEmpleado(idEmpleado);
        return alq;
    }
}
