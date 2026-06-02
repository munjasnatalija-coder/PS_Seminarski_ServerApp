/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository.db;

import java.io.IOException;
import java.sql.SQLException;
import repository.Repository;

/**
 *
 * @author Natalija
 */
public interface DbRepository<T, K> extends Repository<T,K> {
    //odnosi se na metode koje se rade nad bazom kao celina
    default public void connect() throws SQLException, IOException{
        DbConnectionFactory.getInstance().getConnection();
    }
    
    default public void disconnect() throws SQLException, IOException{
        DbConnectionFactory.getInstance().getConnection().close();
    }
    
    default public void commit() throws SQLException, IOException{
        DbConnectionFactory.getInstance().getConnection().commit();
    }
    
    default public void rollback() throws SQLException, IOException{
        DbConnectionFactory.getInstance().getConnection().rollback();
    }
    
}
