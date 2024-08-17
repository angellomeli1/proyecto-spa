package com.proyectospand.datos;
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
    private static final String ACTUALIZAR_EMPLEADO_PROD = "{CALL ActualizarEmpleado(?,?,?,?,?,?,?,?,?,?,?)}";
    private static final String DESACTIVAR_EMPLEADO_PROD = "{CALL EliminarEmpleado(?,?)}";
    private static final String ACTIVAR_EMPLADO_QUERY = "UPDATE empleado set activo = ? where id = ?";
    private static final String BUSCAR_EMPLEADO_QUERY = "SELECT * FROM EMPLEADO WHERE nombeEmp = ?";

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
    public boolean insertar(Object obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertar'");
    }
    @Override
    public boolean actualizar(Object obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizar'");
    }
    @Override
    public boolean desactivar(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'desactivar'");
    }
    @Override
    public boolean activar(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'activar'");
    }


}
