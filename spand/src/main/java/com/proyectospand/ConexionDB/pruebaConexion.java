package com.proyectospand.ConexionDB;

import java.util.Scanner;

public class pruebaConexion {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        conexionDB con = new conexionDB();
        System.out.print("Usuario: ");
        String usuario = input.nextLine();
        System.out.print("Contraseña: ");
        String pass = input.nextLine();
        con.conectar(usuario, pass);
        input.close();
    }
}
