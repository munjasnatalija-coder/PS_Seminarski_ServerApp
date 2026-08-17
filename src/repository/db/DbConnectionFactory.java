/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.db;

import java.io.IOException;
import java.sql.*;
import konfiguracija.Konfiguracija;


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
                String url = Konfiguracija.getInstance().getProperty("url");
                String user = Konfiguracija.getInstance().getProperty("user");
                String password = Konfiguracija.getInstance().getProperty("password");
                
                connection = DriverManager.getConnection(url, user, password);
                connection.setAutoCommit(false);

            } catch (SQLException e) {
                System.out.println("Neuspešno uspotavljena konekcija!\n"+e.getMessage());
                e.printStackTrace();
                throw e;
            }
        }
        return connection;
    }
    
}
