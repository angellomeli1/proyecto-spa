package com.proyectospand.datos;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.proyectospand.ConexionDB.conexionDB;
import com.proyectospand.Entidades.Empleados;
import com.proyectospand.datos.interfaces.Crud;
import com.proyectospand.Entidades.TipoEmpleado;
public class EmpleadosDAO implements Crud{
    private static final String LISTAR_EMPLEADO_QUERY = "SELECT e.idEmpleado, e.nombreEmp, e.apellidosEmp, e.calle, e.numero, e.colonia, e.nss, e.fechaContrato, e.activo, e.clave, " +
                   "t.idTipoEmpleado, t.nombreTipo, t.sueldo " +
                   "FROM empleado e " +
                   "JOIN tipoempleado t ON e.TipoEmpleado_idTipoEmpleado = t.idTipoEmpleado " +
                   "ORDER BY e.idEmpleado";
    //El primer campo es para el id del empleado que llama al procedimiento almacenado
    private static final String AGREGAR_EMPLEADO_PROD = "{CALL AgregarEmpleado(?,?,?,?,?,?,?,?,?,?,?)}";
    private static final String ACTUALIZAR_EMPLEADO_PROD = "{CALL ActualizarEmpleado(?,?,?,?,?,?,?,?,?,?,?,?)}";
    private static final String DESACTIVAR_EMPLEADO_PROD = "{CALL EliminarEmpleado(?,?)}";
    private static final String ACTIVAR_EMPLEADO_QUERY = "UPDATE empleado set activo = ? where idEmpleado = ?";
    private static final String BUSCAR_EMPLEADO_QUERY = "SELECT e.idEmpleado, e.nombreEmp, e.apellidosEmp, e.calle, e.numero, e.colonia, e.nss, e.fechaContrato, e.activo, e.clave, " +
                       "t.idTipoEmpleado, t.nombreTipo, t.sueldo " +
                       "FROM empleado e " +
                       "JOIN tipoempleado t ON e.TipoEmpleado_idTipoEmpleado = t.idTipoEmpleado " +
                       "WHERE LOWER(e.nombreEmp) LIKE ? OR LOWER(e.apellidosEmp) LIKE ?";

    private conexionDB connection;

    public EmpleadosDAO() {
        this.connection = conexionDB.getIntance();
    }
    @Override
    public List<Empleados> listar() {
        List<Empleados> empleados = new ArrayList<>();
        String query = LISTAR_EMPLEADO_QUERY;

        try (Connection conn = connection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("idEmpleado"));
            System.out.println("Nombre: " + rs.getString("nombreEmp"));
                TipoEmpleado tipo = new TipoEmpleado(
                    rs.getInt("idTipoEmpleado"),
                    rs.getString("nombreTipo"),
                    rs.getDouble("sueldo")
                );

                Empleados empleado = new Empleados(
                    rs.getInt("idEmpleado"),
                    rs.getString("nombreEmp"),
                    tipo,
                    rs.getString("apellidosEmp"),
                    rs.getString("calle"),
                    rs.getString("numero"),
                    rs.getString("colonia"),
                    rs.getString("nss"),
                    rs.getDate("fechaContrato"),
                    rs.getBoolean("activo"),
                    rs.getString("clave")
                );

                empleados.add(empleado);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return empleados;
    }
    
    @Override
    public boolean insertar(Object obj,Empleados empleadoE) {
        if ((obj instanceof Empleados)) {
            Empleados empleado = (Empleados) obj;
            boolean agregado = false;
            try (Connection conn = connection.getConnection();
                 CallableStatement stmt = conn.prepareCall(AGREGAR_EMPLEADO_PROD)) {
                 stmt.setInt(1, empleadoE.getTipo().getIdTipoEmpleado());
                 stmt.setInt(2, empleado.getTipo().getIdTipoEmpleado());
                 stmt.setString(3, empleado.getNombreEmp());
                 stmt.setString(4, empleado.getApellidosEmp());
                 stmt.setString(5, empleado.getCalle());
                 stmt.setString(6, empleado.getNumero());
                 stmt.setString(7, empleado.getColonia());
                 stmt.setString(8, empleado.getNss());
                 java.util.Date fecha = empleado.getFechaDeContrato();
                 java.sql.Date fechaSQL = new java.sql.Date(fecha.getTime());
                 stmt.setDate(9, fechaSQL);
                 stmt.setBoolean(10, empleado.getActivo());
                 stmt.setString(11, empleado.getContrasena());

                 int resultado = stmt.executeUpdate();
                 if (resultado > 0) {
                     agregado = true;
                 }
            } catch(SQLException e) {
                e.printStackTrace();
            }  
            return agregado; 
        } else {
            throw new IllegalArgumentException("El objeto no es una instancia de Empleados.");
        }
    }
    @Override
    public boolean actualizar(Object obj,Empleados empleadoE) {
        if ((obj instanceof Empleados)) {
            Empleados empleado = (Empleados) obj;
            boolean actualizado = false;
            try (Connection conn = connection.getConnection();
                 CallableStatement stmt = conn.prepareCall(ACTUALIZAR_EMPLEADO_PROD)) {
                 stmt.setInt(1, empleadoE.getTipo().getIdTipoEmpleado());
                 stmt.setInt(2,empleado.getIdEmpleado());
                 stmt.setInt(3,empleado.getTipo().getIdTipoEmpleado());
                 stmt.setString(4, empleado.getNombreEmp());
                 stmt.setString(5, empleado.getApellidosEmp());
                 stmt.setString(6, empleado.getCalle());
                 stmt.setString(7, empleado.getNumero());
                 stmt.setString(8, empleado.getColonia());
                 stmt.setString(9, empleado.getNss());
                 java.util.Date fecha = empleado.getFechaDeContrato();
                 java.sql.Date fechaSQL = new java.sql.Date(fecha.getTime());
                 stmt.setDate(10, fechaSQL);
                 stmt.setBoolean(11, empleado.getActivo());
                 stmt.setString(12, empleado.getContrasena());

                 int resultado = stmt.executeUpdate();
                 if (resultado > 0) {
                     actualizado = true;
                 }
            } catch(SQLException e) {
                e.printStackTrace();
            }  
            return actualizado; 
        } else {
            throw new IllegalArgumentException("El objeto no es una instancia de Empleados.");
        }
    }
    @Override
    public boolean desactivar(int id,Empleados empleadoE) {
        boolean desactivado = false;
        try (Connection conn = connection.getConnection();
             CallableStatement stmt = conn.prepareCall(DESACTIVAR_EMPLEADO_PROD)) {
            stmt.setInt(1, empleadoE.getIdEmpleado());
            stmt.setInt(2, id);
            int resultado = stmt.executeUpdate();
            if (resultado > 0) {
                desactivado = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return desactivado;
    }
    @Override
    public boolean activar(int id) {
        boolean activado = false;
        try(Connection conn = connection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(ACTIVAR_EMPLEADO_QUERY)) {
            stmt.setInt(1, 1);
            stmt.setInt(2, id);
            int resultado = stmt.executeUpdate();
            if (resultado > 0) {
                activado = true;
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return activado;
    }

    public List<Empleados> buscar(String nombre) {
        List<Empleados> empleados = new ArrayList<>();
    
        try (Connection conn = connection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(BUSCAR_EMPLEADO_QUERY)) {
    
            stmt.setString(1, "%" + nombre.toLowerCase() + "%");
            stmt.setString(2, "%" + nombre.toLowerCase() + "%");
    
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    TipoEmpleado tipo = new TipoEmpleado(
                        rs.getInt("idTipoEmpleado"),
                        rs.getString("nombreTipo"),
                        rs.getDouble("sueldo")
                    );
    
                    Empleados empleado = new Empleados(
                        rs.getInt("idEmpleado"),
                        rs.getString("nombreEmp"),
                        tipo,
                        rs.getString("apellidosEmp"),
                        rs.getString("calle"),
                        rs.getString("numero"),
                        rs.getString("colonia"),
                        rs.getString("nss"),
                        rs.getDate("fechaContrato"),
                        rs.getBoolean("activo"),
                        rs.getString("clave")
                    );
    
                    empleados.add(empleado);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return empleados;
    }

}
