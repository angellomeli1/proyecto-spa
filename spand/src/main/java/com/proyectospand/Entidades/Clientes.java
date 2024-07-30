package com.proyectospand.Entidades;

public class Clientes {
    // Atributos
    private int idCliente;
    private String nombreCliente;
    private String apellidos;
    private String calle;
    private String numero;
    private String colonia;
    
    // CONSTRUCTORES
    // Constructor vacío
    public Clientes() {
        this.idCliente = 0;
        this.nombreCliente = "";
        this.apellidos = "";
        this.calle = "";
        this.numero = "";
        this.colonia = "";
    }// Fin del constructor vacío

    // Constructor con parámetros
    public Clientes(int idCliente, String nombreCliente, String apellidos, String calle, String numero,
            String colonia) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.apellidos = apellidos;
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
    }// Fin del constructor con parámetros

    // Constructor con copia
    public Clientes(Clientes cliente){
        this.idCliente = cliente.idCliente;
        this.nombreCliente = cliente.nombreCliente;
        this.apellidos = cliente.apellidos;
        this.calle = cliente.calle;
        this.numero = cliente.numero;
        this.colonia = cliente.colonia;
    }// Fin del constructor con copia

    // ENCAPSULAMIENTO
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    } // Fin del encapsulamiento

    // Métodos
    
    
}
