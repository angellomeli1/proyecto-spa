package com.proyectospand.Entidades;

public class Venta {
    // Atributos
    private int idVenta;
    private Clientes idCliente;
    private Empleados idEmpleados;
    private String fechaVenta;
    private double total;

    // Constructores
    // Constructor vacío
    public Venta(){
        this.idVenta = 0;
        this.idCliente = null;
        this.idEmpleados = null;
        this.fechaVenta = "";
        this.total = 0.0;
    }// Fin del constructor vacío

    // Constructor con parámetros
    public Venta(int idVenta, Clientes idCliente, Empleados idEmpleados, String fechaVenta, double total) {
        this.idVenta = idVenta;
        this.idCliente = idCliente;
        this.idEmpleados = idEmpleados;
        this.fechaVenta = fechaVenta;
        this.total = total;
    }// Fin del constructor con parámetros

    // Constructor con copia
    public Venta(Venta venta){
        this.idVenta = venta.idVenta;
        this.idCliente = venta.idCliente;
        this.idEmpleados = venta.idEmpleados;
        this.fechaVenta = venta.fechaVenta;
        this.total = venta.total;
    }// Fin del constructor con copia

    // ENCAPSULAMIENTO
    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public Clientes getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Clientes idCliente) {
        this.idCliente = idCliente;
    }

    public Empleados getIdEmpleados() {
        return idEmpleados;
    }

    public void setIdEmpleados(Empleados idEmpleados) {
        this.idEmpleados = idEmpleados;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    // Métodos

}
