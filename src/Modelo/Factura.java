package Modelo;

import DAO.CRUDherramientaXdetalle;
import java.time.LocalDate;

public class Factura {

    private int idfactura;
    private LocalDate fecha;
    private int idempleado;
    private int iddetalles;
    private int idcliente;
    CRUDherramientaXdetalle crudlxd;

    private Detalles detalles;

    private Empleado empleado;

    private Cliente cliente;

    public Factura() {
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getIdfactura() {
        return idfactura;
    }

    public void setIdfactura(int idfactura) {
        this.idfactura = idfactura;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(int idempleado) {
        this.idempleado = idempleado;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public int getIddetalles() {
        return iddetalles;
    }

    public void setIddetalles(int iddetalles) {
        this.iddetalles = iddetalles;
    }

    public Detalles getDetalles() {
        return detalles;
    }

    public void setDetalles(Detalles detalles) {
        this.detalles = detalles;
    }

    public Object[] RegistroFactura() {

        crudlxd = new CRUDherramientaXdetalle();
        int cantidadlibros = crudlxd.ConsultarCantidadporID(detalles.getIddetalles());
        Object[] fila = {idfactura, fecha, empleado.getUsuario(),
            detalles.getSubtotal(), detalles.getDescuento(), detalles.getCostodelivety(),
            cantidadlibros, detalles.getMontofinal()};
        return fila;
    }
}
