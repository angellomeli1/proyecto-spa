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
import com.proyectospand.Entidades.Proveedores;
import com.proyectospand.datos.interfaces.Crud;;
public class ProveedoresDAO implements Crud{ 
    //QUERYS PARA LOS PROVEEDORES
    private static final String LISTAR_PROVEEDOR_QUERY = "SELECT * FROM proveedores";
    private static final String AGREGAR_PROVEEDOR_PROD = "{CALL AgregarProveedor(?,?,?,?,?)}";
    private static final String ACTUALIZAR_PROVEEDOR_PROD = "{CALL ActualizarProveedor(?,?,?,?,?,?)}";
    private static final String DESACTIVAR_PROVEEDOR_PROD = "UPDATE proveedores set activo = ? where idProveedores = ?";
    private static final String ACTIVAR_PROVEEDOR_QUERY = "UPDATE proveedores set activo = ? where idProveedores = ?";
    private static final String BUSCAR_PROVEEDORES_QUERY = "SELECT * FROM proveedores WHERE LOWER(nombreProv) LIKE ?";
    //FIN QUERYS PARA LOS PROVEEDOREs

    private conexionDB connection;

    public ProveedoresDAO(){
        this.connection = conexionDB.getIntance();
    }

    @Override
    public List<Proveedores> listar() {
        List<Proveedores> proveedores = new ArrayList<>(); 
        try (Connection conn = connection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(LISTAR_PROVEEDOR_QUERY);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Proveedores proveedor = new Proveedores(
                    rs.getInt("idProveedores"),
                    rs.getString("nombreProv"),
                    rs.getString("calle"),
                    rs.getString("colonia"),
                    rs.getBoolean("activo")
                );
                proveedores.add(proveedor);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return proveedores;
    }

    @Override
    public boolean insertar(Object obj, Empleados empleadoE) {
        if((obj instanceof Proveedores)){
            Proveedores proveedor = (Proveedores) obj;
            boolean agregado = false;
            try (Connection conn = connection.getConnection();
                CallableStatement stmt = conn.prepareCall(AGREGAR_PROVEEDOR_PROD)){
                stmt.setInt(1,empleadoE.getTipo().getIdTipoEmpleado());
                stmt.setString(2,proveedor.getNombreProv());
                stmt.setString(3,proveedor.getCalle());
                stmt.setString(4,proveedor.getColonia());
                stmt.setBoolean(5,true);
                int resultado = stmt.executeUpdate();
                if(resultado > 0){
                    agregado = true;
                }
            } catch(SQLException e){
                e.printStackTrace();
            }
            return agregado;
        } else {
            throw new IllegalArgumentException("El objeto no es de tipo Proveedor");
        }
    }

    @Override
    public boolean actualizar(Object obj, Empleados empleadoE) {
        if((obj instanceof Proveedores)){
            Proveedores proveedor = (Proveedores) obj;
            boolean actualizado = false;
            try (Connection conn = connection.getConnection();
                CallableStatement stmt = conn.prepareCall(ACTUALIZAR_PROVEEDOR_PROD)){
                    stmt.setInt(1,empleadoE.getTipo().getIdTipoEmpleado());
                    stmt.setInt(2,proveedor.getIdProveedores());
                    stmt.setString(3,proveedor.getNombreProv());
                    stmt.setString(4,proveedor.getCalle());
                    stmt.setString(5,proveedor.getColonia());
                    stmt.setBoolean(6,proveedor.getActivo());
                    int resultado = stmt.executeUpdate();
                    if(resultado > 0){
                        actualizado = true;
                    }
            } catch(SQLException e){
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
            PreparedStatement stmt = conn.prepareStatement(DESACTIVAR_PROVEEDOR_PROD)) {
                stmt.setBoolean(1,false);
                stmt.setInt(2,id);
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
        try (Connection conn = connection.getConnection();
            CallableStatement stmt = conn.prepareCall(ACTIVAR_PROVEEDOR_QUERY)) {
            stmt.setBoolean(1, true);
            stmt.setInt(2, id);
            int resultado = stmt.executeUpdate();
            if (resultado > 0) {
                activado = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return activado;
    }

    public List<Proveedores> buscar(String nombre){
        List<Proveedores> provedores = new ArrayList<>();
        try (Connection conn = connection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(BUSCAR_PROVEEDORES_QUERY)) {
                stmt.setString(1, "%" + nombre.toLowerCase() + "%");
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        Proveedores proveedor = new Proveedores(
                            rs.getInt("idProveedores"),
                            rs.getString("nombreProv"),
                            rs.getString("calle"),
                            rs.getString("colonia"),
                            rs.getBoolean("activo")
                        );
                        provedores.add(proveedor);
                    }
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return provedores;
    }
}
