package com.proyectospand.ConexionDB;

import java.sql.Connection;
import java.sql.SQLException;

public class testConexion {
    public static void main(String[] args) {
        try {
            Connection c = conexionDB.getIntance().getConnection();
            if (c != null){
                System.out.println("Conectado");
                conexionDB.getIntance().closeConnection(c);
            } else {
                System.out.println("No conectado");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
