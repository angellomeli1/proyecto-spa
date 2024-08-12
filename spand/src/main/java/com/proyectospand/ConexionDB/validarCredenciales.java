package com.proyectospand.ConexionDB;

import com.proyectospand.Entidades.Empleados;
import com.proyectospand.Entidades.TipoEmpleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class validarCredenciales {
    
    public Empleados autenticarLogin(String user, String password) {
        String query = "SELECT e.idEmpleado, e.nombreEmp, e.apellidosEmp, e.calle, e.numero, e.colonia, e.nss, e.fechaContrato, e.activo, e.clave, "
                     + "t.idTipoEmpleado, t.nombreTipo, t.sueldo "
                     + "FROM empleado e "
                     + "JOIN tipoEmpleado t ON e.TipoEmpleado_idTipoEmpleado = t.idTipoEmpleado "
                     + "WHERE e.nombreEmp = ? AND e.clave = ?";
        try (Connection conexion = conexionDB.getIntance().getConnection()) {
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1, user);
            statement.setString(2, password);
            
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    // Cargar la información del empleado desde el ResultSet
                    int idEmpleado = resultSet.getInt("idEmpleado");
                    String nombreEmp = resultSet.getString("nombreEmp");
                    String apellidosEmp = resultSet.getString("apellidosEmp");
                    String calle = resultSet.getString("calle");
                    String numero = resultSet.getString("numero");
                    String colonia = resultSet.getString("colonia");
                    String nss = resultSet.getString("nss");
                    Date fechaDeContrato = resultSet.getDate("fechaContrato");
                    boolean activo = resultSet.getBoolean("activo");
                    String contrasena = resultSet.getString("clave");
                    
                    // Información del tipo de empleado
                    int idTipoEmpleado = resultSet.getInt("idTipoEmpleado");
                    String nombreTipo = resultSet.getString("nombreTipo");
                    double sueldo = resultSet.getDouble("sueldo");
                    TipoEmpleado tipo = new TipoEmpleado(idTipoEmpleado, nombreTipo, sueldo);
                    
                    // Crear el objeto Empleados con la información obtenida
                    Empleados empleado = new Empleados(idEmpleado, nombreEmp, tipo, apellidosEmp, calle, numero, colonia, nss, fechaDeContrato, activo, contrasena);
                    
                    // Retornar el objeto Empleados
                    return empleado;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null; // Devuelve null si las credenciales son incorrectas
    }
}