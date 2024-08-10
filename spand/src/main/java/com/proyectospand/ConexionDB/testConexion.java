package com.proyectospand.ConexionDB;

import java.sql.Connection;
import java.sql.SQLException;

public class testConexion {
    public static void main(String[] args) {

        validarCredenciales autenticarCredenciales = new validarCredenciales();

        if(autenticarCredenciales.autenticarLogin("Irving Santos","Irvingon")){
            System.out.println("El usuario ha ingresado al sistema.");
            
            try (Connection conexion = conexionDB.getIntance().getConnection()) {
                if(conexion != null){
                    System.out.println("El usuario se ha conectado a la base de datos.");
                } else {
                    System.out.println("Hubo un error al obtener una conexion");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } 

        } else {
            System.out.println("Usuario o contraseña incorrecta.");
        }
    }
}
