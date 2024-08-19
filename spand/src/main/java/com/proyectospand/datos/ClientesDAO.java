package com.proyectospand.datos;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.proyectospand.ConexionDB.conexionDB;
import com.proyectospand.Entidades.Clientes;
import com.proyectospand.Entidades.Empleados;
import com.proyectospand.datos.interfaces.Crud;
public class ClientesDAO implements Crud{
    private static final String LISTAR_CLIENTE_QUERY = "SELECT * FROM cliente";
    //El primer campo es para el id del empleado que llama al procedimiento almacenado
    private static final String AGREGAR_CLIENTE_PROD = "{CALL AgregarCliente(?,?,?,?,?,?,?)}";
    private static final String ACTUALIZAR_CLIENTE_PROD = "{CALL ActualizarCliente(?,?,?,?,?,?,?,?)}";
    private static final String DESACTIVAR_CLIENTE_PROD = "{CALL EliminarCliente(?,?)}";
    private static final String ACTIVAR_CLIENTE_QUERY = "UPDATE cliente set activo = ? where idCliente = ?";
    private static final String BUSCAR_CLIENTE_QUERY = "SELECT * FROM cliente WHERE LOWER(nombreCliente) LIKE ?";

    private conexionDB connection;

    public ClientesDAO() {
        this.connection = conexionDB.getIntance();
    }


    @Override
    public List<Clientes> listar() {
         List<Clientes> clientes = new ArrayList<>();
         String query = LISTAR_CLIENTE_QUERY;
         try(Connection conn = connection.getConnection()){
             PreparedStatement statement = conn.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery();

             while(resultSet.next()){
                Clientes cliente = new Clientes(
                    resultSet.getInt("idCliente"),
                    resultSet.getString("nombreCliente"),
                    resultSet.getString("apellidos"),
                    resultSet.getString("calle"),
                    resultSet.getString("numero"),
                    resultSet.getString("colonia"),
                    resultSet.getBoolean("activo")
                );
                clientes.add(cliente);
             }
         } catch (SQLException e) {             
             e.printStackTrace();
         }
         return clientes;
    }
    
    @Override
    public boolean insertar(Object obj, Empleados empleadoE) {
        if(obj instanceof Clientes){
            Clientes cliente = (Clientes) obj;
            boolean agregado = false;
            try(Connection conn = connection.getConnection()){
                CallableStatement stmt = conn.prepareCall(AGREGAR_CLIENTE_PROD);
                stmt.setInt(1,empleadoE.getTipo().getIdTipoEmpleado());
                stmt.setString(2,cliente.getNombreCliente());
                stmt.setString(3,cliente.getApellidos());
                stmt.setString(4,cliente.getCalle());
                stmt.setString(5,cliente.getNumero());
                stmt.setString(6,cliente.getColonia());
                stmt.setBoolean(7,cliente.getActivo());
                int resultado = stmt.executeUpdate();
                if(resultado > 0){
                    agregado = true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return agregado;
        } else {
            throw new IllegalArgumentException("El objeto no es de tipo Proveedor");
        }
    }
    @Override
    public boolean actualizar(Object obj,Empleados empleadoE) {
        if(obj instanceof Clientes){
            Clientes cliente = (Clientes) obj;
            boolean actualizado = false;
            try(Connection conn = connection.getConnection()){
                CallableStatement stmt = conn.prepareCall(ACTUALIZAR_CLIENTE_PROD);
                stmt.setInt(1,empleadoE.getTipo().getIdTipoEmpleado());
                stmt.setInt(2,cliente.getIdCliente());
                stmt.setString(3,cliente.getNombreCliente());
                stmt.setString(4,cliente.getApellidos());
                stmt.setString(5,cliente.getCalle());
                stmt.setString(6,cliente.getNumero());
                stmt.setString(7,cliente.getColonia());
                stmt.setBoolean(8,cliente.getActivo());
                int resultado = stmt.executeUpdate();
                if(resultado > 0){
                    actualizado = true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return actualizado;
        } else {
            throw new IllegalArgumentException("El objeto no es de tipo Proveedor");
        }
    }
    @Override
    public boolean desactivar(int id, Empleados empleadoE) {
        boolean desactivado = false;
        try(Connection conn = connection.getConnection()){
            CallableStatement stmt = conn.prepareCall(DESACTIVAR_CLIENTE_PROD);
            stmt.setInt(1,id);
            stmt.setInt(2,empleadoE.getTipo().getIdTipoEmpleado());
            int resultado = stmt.executeUpdate();
            if(resultado > 0){
                desactivado = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return desactivado;
    }
    @Override
    public boolean activar(int id) {
        boolean activado = false;
        try(Connection conn = connection.getConnection()){
            PreparedStatement stmt = conn.prepareStatement(ACTIVAR_CLIENTE_QUERY);
            stmt.setBoolean(1, true);
            stmt.setInt(2, id);
            int resultado = stmt.executeUpdate();
            if (resultado > 0) {
                activado = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return activado;
    }

    public List<Clientes> buscar(String buscar){
        List<Clientes> clientes = new ArrayList<>();
        try(Connection conn = connection.getConnection()){
            PreparedStatement stmt = conn.prepareStatement(BUSCAR_CLIENTE_QUERY);
            stmt.setString(1, "%" + buscar + "%");
            ResultSet resultSet = stmt.executeQuery();
            while(resultSet.next()){
                Clientes cliente = new Clientes(
                    resultSet.getInt("idCliente"),
                    resultSet.getString("nombreCliente"),
                    resultSet.getString("apellidos"),
                    resultSet.getString("calle"),
                    resultSet.getString("numero"),
                    resultSet.getString("colonia"),
                    resultSet.getBoolean("activo")
                );
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }
}
