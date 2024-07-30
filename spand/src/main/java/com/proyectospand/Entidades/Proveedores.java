package com.proyectospand.Entidades;

public class Proveedores {
    // Atributos
    private int idProveedores;
    private String nombreProv;
    private String calle;
    private String colonia;

    // CONSTRUCTORES
    // Constructor vacío
    public Proveedores(){
        this.idProveedores = 0;
        this.nombreProv = "";
        this.calle = "";
        this.colonia = "";
    }// Fin del constructor vacío

    // Constructor con parámetros
    public Proveedores(int idProveedores, String nombreProv, String calle, String colonia) {
        this.idProveedores = idProveedores;
        this.nombreProv = nombreProv;
        this.calle = calle;
        this.colonia = colonia;
    }// Fin del constructor con parámetros

    // Constructor con copia
    public Proveedores(Proveedores provedor){
        this.idProveedores = provedor.idProveedores;
        this.nombreProv = provedor.nombreProv;
        this.calle = provedor.calle;
        this.colonia = provedor.colonia;
    }// Fin del constructor con copia

    // ENCAPSULAMIENTO
    public int getIdProveedores() {
        return idProveedores;
    }

    public void setIdProveedores(int idProveedores) {
        this.idProveedores = idProveedores;
    }

    public String getNombreProv() {
        return nombreProv;
    }

    public void setNombreProv(String nombreProv) {
        this.nombreProv = nombreProv;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }// Fin del encapsulamiento

    // Métodos
        
}
