package com.proyectospand.ConexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//Esta clase es la encargada de hacer las validaciones para otorgar el acceso al sistema siempre y cuando el 
//usuario y la contraseña coincidan con alguno de los empleados.
public class validarCredenciales {
    //Esto se logra mediante el metodo autenticarlogin el cual toma como parametros el usuairo y contraseña.
    public boolean autenticarLogin(String user, String password){
        //Query para la base de datos, donde se selecciona la coincidencia del usuario y la contraseña
        String query = "SELECT * FROM empleado where nombreEmp = ? and clave = ? ";

        //La consulta se realiza en la base de datos, primero se otorga una conexión de la pool de conexiones
        try (Connection conexion = conexionDB.getIntance().getConnection()) {
            //Se prepara la consulta para la base de datos
            PreparedStatement statement = conexion.prepareStatement(query);
            //Se insertan los valores de usuario y contraseña en la consulta
            statement.setString(1, user);
            statement.setString(2, password);

            //Se realiza la consulta
            try (ResultSet resultSet = statement.executeQuery()){
                //Se retorna el resultado, resultSet.next() retorna true si hay coincidencias
                return resultSet.next();
            }
        } catch (SQLException e) {
            //En caso de error se retorna false y se manda el error por consola
            e.printStackTrace();
            return false;
        }
    }
}
