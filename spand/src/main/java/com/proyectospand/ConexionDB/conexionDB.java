package com.proyectospand.ConexionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class conexionDB {
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/";
    private final String DB = "dbspa";

    public Connection conn;

    public conexionDB(){
        this.conn = null;
    }

    public Connection conectar(String USER, String PASS){
        try {
            Class.forName(DRIVER);
            this.conn= DriverManager.getConnection(URL+DB,USER, PASS);
            System.out.println("Conectado");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println("Error");
        }
        return this.conn;
    }

    public Connection desconectar(){
        try {
            this.conn.close();
            System.out.println("Desconectado");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());  
            System.out.println("Error al desconectar");
        }
        return this.conn;
    }

}