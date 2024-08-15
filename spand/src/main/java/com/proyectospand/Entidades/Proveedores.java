package com.proyectospand.Entidades;

public class Proveedores {
    // Atributos
    private int idProveedores;
    private String nombreProv;
    private String calle;
    private String colonia;
    private TelefonoProveedor telefono = new TelefonoProveedor();
    private CorreoProveedor correo = new CorreoProveedor();

    // CONSTRUCTORES
    // Constructor vacío
    public Proveedores(){
        this.idProveedores = 0;
        this.nombreProv = "";
        this.calle = "";
        this.colonia = "";
        this.telefono = new TelefonoProveedor();
        this.correo = new CorreoProveedor();
    }// Fin del constructor vacío

    // Constructor con parámetros
    public Proveedores(int idProveedores, String nombreProv, String calle, String colonia, TelefonoProveedor telefono, CorreoProveedor correo) {
        this.idProveedores = idProveedores;
        this.nombreProv = nombreProv;
        this.calle = calle;
        this.colonia = colonia;
        this.telefono = telefono;
        this.correo = correo;
    }// Fin del constructor con parámetros

    // Constructor con copia
    public Proveedores(Proveedores provedor){
        this.idProveedores = provedor.idProveedores;
        this.nombreProv = provedor.nombreProv;
        this.calle = provedor.calle;
        this.colonia = provedor.colonia;
        this.telefono = provedor.telefono;
        this.correo = provedor.correo;
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
    }

    public TelefonoProveedor getTelefono() {
        return telefono;
    }

    public void setTelefono(TelefonoProveedor telefono) {
        this.telefono = telefono;
    }

    public CorreoProveedor getCorreo() {
        return correo;
    }

    public void setCorreo(CorreoProveedor correo) {
        this.correo = correo;
    }

    public class TelefonoProveedor{
        private int id;
        private String numero;

        public TelefonoProveedor() {
            this.id = 0;
            this.numero = "";
        }

        public TelefonoProveedor(int id, String numero) {
            this.id = id;
            this.numero = numero;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNumero() {
            return numero;
        }

        public void setNumero(String numero) {
            this.numero = numero;
        }
    }
        
    public class CorreoProveedor{
        private int id;
        private String correo;

        public CorreoProveedor() {
            this.id = 0;
            this.correo = "";
        }

        public CorreoProveedor(int id, String correo) {
            this.id = id;
            this.correo = correo;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCorreo() {
            return correo;
        }

        public void setCorreo(String correo) {
            this.correo = correo;   
        }
    }
}
