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
import com.proyectospand.Entidades.Producto;
import com.proyectospand.datos.interfaces.Crud;

public class ProductoDAO implements Crud {

    //QUERYS para los productos

    private static final String LISTAR_PRODUCTO_QUERY = "SELECT * FROM producto";
    private static final String AGREGAR_PRODUCTO_PROD = "{CALL AgregarProducto(?,?,?,?,?,?)}";
    private static final String ACTUALIZAR_PRODUCTO_PROD = "{CALL ActualizarProducto(?,?,?,?,?,?,?)}";
    private static final String DESACTIVAR_PRODUCTO_PROD = "{CALL EliminarProducto(?,?)}";
    private static final String ACTIVAR_PRODUCTO_QUERY = "UPDATE producto SET activo = ? where idProducto = ?";
    private static final String BUSCAR_PRODUCTO_QUERY = "SELECT * FROM producto where LOWER(nombreProducto) LIKE ?";
    
    //Fin QUERYS para los productos


    private conexionDB connection;

    public ProductoDAO() {
        this.connection = connection.getIntance();
    }

    @Override
    public List<Producto> listar() {
        List<Producto> productos = new ArrayList<>();
        try (Connection conn = connection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(LISTAR_PRODUCTO_QUERY);
             ResultSet rs = stmt.executeQuery()) {
            
            while(rs.next()){
                Producto producto = new Producto(
                    rs.getInt("idProducto"),
                    rs.getString("nombreProducto"),
                    rs.getString("descripcion"),
                    rs.getDouble("precioActual"),
                    rs.getInt("cantidadExistencia"),
                    rs.getBoolean("activo")
                );
                productos.add(producto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productos;
    }

    @Override
    public boolean insertar(Object obj, Empleados empleadoE) {
        if((obj instanceof Producto)){
            Producto producto = (Producto) obj;
            boolean agregado = false;
            try (Connection conn = connection.getConnection();
                CallableStatement stmt = conn.prepareCall(AGREGAR_PRODUCTO_PROD)){
                stmt.setInt(1,empleadoE.getTipo().getIdTipoEmpleado());
                stmt.setString(2,producto.getNombreProducto());
                stmt.setString(3,producto.getDescripcion());
                stmt.setDouble(4,producto.getPrecioActual());
                stmt.setInt(5,producto.getCantidadExistencia());
                stmt.setBoolean(6,producto.getActivo());
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
    public boolean actualizar(Object obj, Empleados empleadoE) {
        if((obj instanceof Producto)){
            Producto producto = (Producto) obj;
            boolean actualizado = false;
            try (Connection conn = connection.getConnection();
                CallableStatement stmt = conn.prepareCall(ACTUALIZAR_PRODUCTO_PROD)){
                stmt.setInt(1, empleadoE.getTipo().getIdTipoEmpleado());
                stmt.setInt(2,producto.getIdProducto());
                stmt.setString(3,producto.getNombreProducto());
                stmt.setString(4,producto.getDescripcion());
                stmt.setDouble(5,producto.getPrecioActual());
                stmt.setInt(6,producto.getCantidadExistencia());
                stmt.setBoolean(7,producto.getActivo());
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
        try (Connection conn = connection.getConnection();
            CallableStatement stmt = conn.prepareCall(DESACTIVAR_PRODUCTO_PROD)){
            stmt.setInt(1,empleadoE.getTipo().getIdTipoEmpleado());
            stmt.setInt(2,id);
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
        try (Connection conn = connection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(ACTIVAR_PRODUCTO_QUERY)){
            stmt.setBoolean(1,true);
            stmt.setInt(2,id);
            int resultado = stmt.executeUpdate();
            if(resultado > 0){
                activado = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return activado;
    }

    public List<Producto> buscar(String nombre) {
        List<Producto> productos = new ArrayList<>();
        try (Connection conn = connection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(BUSCAR_PRODUCTO_QUERY)){
            stmt.setString(1, "%" + nombre.toLowerCase() + "%");
            try (ResultSet rs = stmt.executeQuery()){
                while(rs.next()){
                    Producto producto = new Producto(
                        rs.getInt("idProducto"),
                        rs.getString("nombreProducto"),
                        rs.getString("descripcion"),
                        rs.getDouble("precioActual"),
                        rs.getInt("cantidadExistencia"),
                        rs.getBoolean("activo")
                    );
                    productos.add(producto);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productos;
    }

}
