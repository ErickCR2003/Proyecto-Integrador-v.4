
package Formatos;

import Modelo.DetallesAlquiler;

public class FormatoDetalleAlquiler {
    public static DetallesAlquiler LeerDetalleAlquiler(double imrPorHerramienta, int idherramienta, int idalquiler){
        DetallesAlquiler det = new DetallesAlquiler();
        det.setImp_montofinal(imrPorHerramienta);
        det.setIdAlquiler(idalquiler);
        det.setIdHerramienta(idherramienta);
        return det;
    }
}
