package com.proyectospand.ConexionDB;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.dbcp2.BasicDataSource;

public class conexionDB {

    //Partes esenciales para la conexion a la base de datos mediante el pool de conexiones
    private final String DB = "dbspa";
    private final String URL = "jdbc:mysql://localhost:3306/";
    //Usuario que va a crear el pool de conexiones.
    private final String USER = "connectionPool";
    private final String PASS = "1234567890";

    //Objeto statico de la clase para que solo exista una instancia.
    private static conexionDB dataSource;
    //Objeto de la libreria commons-dbcp2
    private BasicDataSource basicDataSource;

    private static final Logger LOGGER = Logger.getLogger(conexionDB.class.getName());

    private conexionDB(){
        //Al momento de crear por primera vez la instancia se abre el pool de conexiones
        basicDataSource = new BasicDataSource();
        //Se definen las propiedades de la base de datos como el driver, url, el usuario y la contraseña
        basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        basicDataSource.setUsername(USER);
        basicDataSource.setPassword(PASS);
        basicDataSource.setUrl(URL+DB);

        basicDataSource.setMinIdle(5);
        basicDataSource.setMaxIdle(20);
        basicDataSource.setMaxTotal(50);
        basicDataSource.setMaxWait(Duration.ofMillis(10000));
    }

    //Metodo para obtener la instancia de la clase con el patrón singleton
    public static conexionDB getIntance(){
        //Si no existe la instancia la crea
        if(dataSource == null){
            dataSource = new conexionDB(); 
        }
        //Devuelve la instancia
        return dataSource;
    }


    //El metodo get connection se encargará de otorgar una conexión de la pool a la base de datos.
    public Connection getConnection() throws SQLException{
        Connection connect = null;
        try {
            connect = this.basicDataSource.getConnection();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE,"Error al obtener la conexión a la base de datos", e);
            throw e;
        }
        return connect;
    }

    //Metodo para cerrar la conexión a la base de datos
    public void closeConnection (Connection connection) throws SQLException{
        connection.close();
    }

}