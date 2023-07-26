
package Modelo;

public class Caja{
   private int ID;
   private double montoEfectivo;

    public Caja(int ID, double montoEfectivo) {
        this.ID = ID;
        this.montoEfectivo = montoEfectivo;
    }
   
    public Caja() {        
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public double getMontoEfectivo() {
        return montoEfectivo;
    }

    public void setMontoEfectivo(double montoEfectivo) {
        this.montoEfectivo = montoEfectivo;
    }  
   
}



