package Modelo;

public class Detalles {

    private int iddetalles;
    private double subtotal;
    private double descuento;
    private double montofinal;
    private double costodelivety;
    private String direcciondelivery;
    private double igv;

    public Detalles() {
    }

    public int getIddetalles() {
        return iddetalles;
    }

    public void setIddetalles(int iddetalles) {
        this.iddetalles = iddetalles;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getMontofinal() {
        return montofinal;
    }

    public void setMontofinal(double montofinal) {
        this.montofinal = montofinal;
    }

    public double getIgv() {
        return igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public double getCostodelivety() {
        return costodelivety;
    }

    public void setCostodelivety(double costodelivety) {
        this.costodelivety = costodelivety;
    }

    public String getDirecciondelivery() {
        return direcciondelivery;
    }

    public void setDirecciondelivery(String direcciondelivery) {
        this.direcciondelivery = direcciondelivery;
    }

}
