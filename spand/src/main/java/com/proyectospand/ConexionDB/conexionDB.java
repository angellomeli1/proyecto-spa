package com.proyectospand.ConexionDB;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.Duration;

import org.apache.commons.dbcp2.BasicDataSource;

public class conexionDB {

    private final String DB = "dbspa";
    private final String URL = "jdbc:mysql://localhost:3306/";
    private final String USER = "nuevoUsuario";
    private final String PASS = "123";

    private static conexionDB dataSource;
    private BasicDataSource basicDataSource;

    private conexionDB(){
        basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        basicDataSource.setUsername(USER);
        basicDataSource.setPassword(PASS);
        basicDataSource.setUrl(URL+DB);

        basicDataSource.setMinIdle(5);
        basicDataSource.setMaxIdle(20);
        basicDataSource.setMaxTotal(50);
        basicDataSource.setMaxWait(Duration.ofMillis(10000));
    }

    public static conexionDB getIntance(){
        if(dataSource == null){
            dataSource = new conexionDB(); 
        }
        return dataSource;
    }

    public Connection getConnection(){
        Connection connect = null;
        try {
            connect = this.basicDataSource.getConnection();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connect;

    }

    public void closeConnection (Connection connection) throws SQLException{
        connection.close();
    }

}