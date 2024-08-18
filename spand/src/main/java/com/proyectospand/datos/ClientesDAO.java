// package com.proyectospand.datos;
// import java.sql.Connection;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.util.ArrayList;
// import java.util.List;
// import com.proyectospand.ConexionDB.conexionDB;
// import com.proyectospand.Entidades.Empleados;
// import com.proyectospand.datos.interfaces.Crud;
// public class ClientesDAO implements Crud{
//     private static final String LISTAR_EMPLEADO_QUERY = "SELECT * FROM empleado";
//     //El primer campo es para el id del empleado que llama al procedimiento almacenado
//     private static final String AGREGAR_EMPLEADO_PROD = "{CALL AgregarEmpleado(?,?,?,?,?,?,?,?,?,?,?)}";
//     private static final String ACTUALIZAR_EMPLEADO_PROD = "{CALL ActualizarEmpleado(?,?,?,?,?,?,?,?,?,?,?)}";
//     private static final String DESACTIVAR_EMPLEADO_PROD = "{CALL EliminarEmpleado(?,?)}";
//     private static final String ACTIVAR_EMPLADO_QUERY = "UPDATE empleado set activo = ? where id = ?";
//     private static final String BUSCAR_EMPLEADO_QUERY = "SELECT * FROM EMPLEADO WHERE nombeEmp = ?";

//     @Override
//     public List listar() {
//          List<Empleados> empleados = new ArrayList<>();
//          String query = LISTAR_EMPLEADO_QUERY;
//          try(Connection conn = conexionDB.getIntance().getConnection()){
//              PreparedStatement statement = conn.prepareStatement(query);
//              ResultSet resultSet = statement.executeQuery();

//              while(resultSet.next()){
//                  Empleados empleado = new Empleados();
//                  empleados.add(empleado);
//              }
//          } catch (Exception e) {             
//              e.printStackTrace();
//          }
//          return empleados;
//     }
    
//     @Override
//     public boolean insertar(Object obj) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'insertar'");
//     }
//     @Override
//     public boolean actualizar(Object obj) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'actualizar'");
//     }
//     @Override
//     public boolean desactivar(int id) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'desactivar'");
//     }
//     @Override
//     public boolean activar(int id) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'activar'");
//     }


// }
