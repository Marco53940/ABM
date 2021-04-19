package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public static Connection conectar(){
        Connection con = null;

        String password= "";
        String usuario= "root";
        String url = "jdbc:mysql://marco-pc:3306/abm?user="+usuario
                +"&password="+password + "&useSSL=false";
        try{
            con = DriverManager.getConnection(url);
            if(con!=null){
                System.out.println("conectado");
                            }

        }
        catch (SQLException e){
            System.out.println("No se pudo contectar a la base de datos");
            e.printStackTrace();
        }
        return con;
    }
}
