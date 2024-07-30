package com.proyectospand.Entidades;

public class Producto {
    // Atributos
    private int idProducto;
    private String nombreProducto;
    private String descripcion;
    private double precioActual;
    private int cantidadExistencia;
    private double precioAnterior;
    
    // CONSTRUCTORES
    // Constructor vacío
    public Producto(){
        this.idProducto = 0;
        this.nombreProducto = "";
        this.descripcion = "";
        this.precioActual = 0.0;
        this.cantidadExistencia = 0;
        this.precioAnterior = 0.0;
    }// Fin del constructor vacío

    // Constructor con parámetros
    public Producto(int idProducto, String nombreProducto, String descripcion, double precioActual,
            int cantidadExistencia, double precioAnterior) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.descripcion = descripcion;
        this.precioActual = precioActual;
        this.cantidadExistencia = cantidadExistencia;
        this.precioAnterior = precioAnterior;
    }// Fin del constructor con parámetros

    //Constructor con copia
    public Producto(Producto producto){
        this.idProducto = producto.idProducto;
        this.nombreProducto = producto.nombreProducto;
        this.descripcion = producto.descripcion;
        this.precioActual = producto.precioActual;
        this.cantidadExistencia = producto.cantidadExistencia;
        this.precioAnterior = producto.precioAnterior;
    }// Fin del constructor con copia

    // ENCAPSULAMIENTO
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioActual() {
        return precioActual;
    }

    public void setPrecioActual(double precioActual) {
        this.precioActual = precioActual;
    }

    public int getCantidadExistencia() {
        return cantidadExistencia;
    }

    public void setCantidadExistencia(int cantidadExistencia) {
        this.cantidadExistencia = cantidadExistencia;
    }

    public double getPrecioAnterior() {
        return precioAnterior;
    }

    public void setPrecioAnterior(double precioAnterior) {
        this.precioAnterior = precioAnterior;
    }// Fin del encapsulamiento

    // Métodos
    
}
