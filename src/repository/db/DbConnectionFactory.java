/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;


/**
 *
 * @author Natalija
 */
public class DbConnectionFactory {
    private Connection connection;
    private static DbConnectionFactory instance;

    private DbConnectionFactory() {
    }
    
    public static DbConnectionFactory getInstance(){
        if(instance == null)
            instance = new DbConnectionFactory();
        return instance;
    }
    
    public Connection getConnection() throws SQLException,IOException{
        if(connection == null || connection.isClosed()){
            try {
                Properties properties = new Properties();
                properties.load(new FileInputStream("config/properties.properties"));
                
                String url = properties.getProperty("url");
                String user = properties.getProperty("user");
                String password = properties.getProperty("password");
                
                connection = DriverManager.getConnection(url, user, password);
                connection.setAutoCommit(false);

            } catch (SQLException e) {
                System.out.println("Neuspesno uspotavljena konekcia!\n"+e.getMessage());
                e.printStackTrace();
            }
        }
        return connection;
    }
    
}
