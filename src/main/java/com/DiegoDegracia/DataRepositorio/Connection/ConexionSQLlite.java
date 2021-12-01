package com.DiegoDegracia.DataRepositorio.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionSQLlite {
    private static String URL_CONEXION = "jdbc:sqlite:src/main/java/com/DBSqlite/chinook.db";

    public static Connection NuevaConexion(){
        try{
            Connection conn = DriverManager.getConnection(URL_CONEXION);
            return conn;
        }catch (SQLException e){
            throw new Error(e);
        }
    }
}
