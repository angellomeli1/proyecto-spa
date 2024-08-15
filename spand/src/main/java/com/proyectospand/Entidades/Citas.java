package com.proyectospand.Entidades;
import java.util.Date;
public class Citas {
    private int idCita;
    private Clientes cliente;
    private Empleados empleado;
    private Date fecha;
    private String descripcion;
    private double costo;

    public Citas() {
        this.idCita = 0;
        this.cliente = new Clientes();
        this.empleado = new Empleados();
        this.fecha = new Date();
        this.descripcion = "";
        this.costo = 0;
    }

    public Citas(int idCita, Clientes cliente, Empleados empleado, Date fecha, String descripcion, double costo) {
        this.idCita = idCita;
        this.cliente = cliente;
        this.empleado = empleado;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.costo = costo;
    }

    public Citas(Citas cita) {
        this.idCita = cita.idCita;
        this.cliente = cita.cliente;
        this.empleado = cita.empleado;
        this.fecha = cita.fecha;
        this.descripcion = cita.descripcion;
        this.costo = cita.costo;
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public Clientes getCliente() {
        return cliente;
    } 

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public Empleados getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleados empleado) {
        this.empleado = empleado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
}
