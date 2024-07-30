package com.proyectospand.Entidades;

public class TipoEmpleado {
    // Atributos
    private int idTipoEmpleado;
    private String nombreTipo;
    private double sueldo;

    // CONSTRUCTORES
    // Constructor vacío
    public TipoEmpleado(){
        this.idTipoEmpleado = 0;
        this.nombreTipo = "";
        this.sueldo = 0.0;
    }// Fin del constructor vacío

    // Constuctor con parámetros
    public TipoEmpleado(int idTipoEmpleado, String nombreTipo, double sueldo) {
        this.idTipoEmpleado = idTipoEmpleado;
        this.nombreTipo = nombreTipo;
        this.sueldo = sueldo;
    }// Fin del constructor con parámetros

    // Constructor con copia
    public TipoEmpleado(TipoEmpleado tipo){
        this.idTipoEmpleado = tipo.idTipoEmpleado;
        this.nombreTipo = tipo.nombreTipo;
        this.sueldo = tipo.sueldo;
    }// Fin del constructor con copia

    // ENCAPSULAMIENTO
    public int getIdTipoEmpleado() {
        return idTipoEmpleado;
    }

    public void setIdTipoEmpleado(int idTipoEmpleado) {
        this.idTipoEmpleado = idTipoEmpleado;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }// Fin del encapsulamiento

    // Métodos
    
}
