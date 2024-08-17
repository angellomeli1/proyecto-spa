package com.proyectospand.Entidades;
import java.util.Date;
public class Empleados {
    // Atributos
    private int idEmpleado;
    private String nombreEmp;
    private TipoEmpleado tipo;
    private String apellidosEmp;
    private String calle;
    private String numero;
    private String colonia;
    private String nss;
    private Date fechaDeContrato;
    private boolean activo;
    private String contrasena;

    // Metodos
    public Empleados() {
        this.idEmpleado = 0;
        this.nombreEmp = "";
        this.tipo = new TipoEmpleado();
        this.apellidosEmp = "";
        this.calle = "";
        this.numero = "";
        this.colonia = "";
        this.nss = "";
        this.activo = true;
        this.contrasena = "";
    }

    public Empleados(int idEmpleado, String nombreEmp, TipoEmpleado tipo, String apellidosEmp, String calle, String numero, String colonia, String nss, Date fechaDeContrato, boolean activo, String contrasena) {
        this.idEmpleado = idEmpleado;
        this.nombreEmp = nombreEmp;
        this.tipo = tipo;
        this.apellidosEmp = apellidosEmp;
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.nss = nss;
        this.fechaDeContrato = fechaDeContrato;
        this.activo = activo;
        this.contrasena = contrasena;
    }

    // ENCAPSULAMIENTO


    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombreEmp() {
        return nombreEmp;
    }

    public void setNombreEmp(String nombreEmp) {
        this.nombreEmp = nombreEmp;
    }

    public TipoEmpleado getTipo() {
        return tipo;
    }

    public void setTipo(TipoEmpleado tipo) {
        this.tipo = tipo;
    }

    public String getApellidosEmp() {
        return apellidosEmp;
    }

    public void setApellidosEmp(String apellidosEmp) {
        this.apellidosEmp = apellidosEmp;
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
    }

    public String getNss() {
        return nss;
    }

    public void setNss(String nss) {
        this.nss = nss;
    }

    public Date getFechaDeContrato() {
        return fechaDeContrato;
    }

    public void setFechaDeContrato(Date fechaDeContrato) {
        this.fechaDeContrato = fechaDeContrato;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

}
