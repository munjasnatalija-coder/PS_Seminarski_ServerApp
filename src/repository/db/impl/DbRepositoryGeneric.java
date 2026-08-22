/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.db.impl;

import domain.GenericEntity;
import java.util.ArrayList;
import java.util.List;
import repository.db.DbRepository;
import java.sql.*;
import repository.db.DbConnectionFactory;

/**
 *
 * @author Natalija
 */
public class DbRepositoryGeneric implements DbRepository<GenericEntity, Long> {

    @Override
    public List<GenericEntity> getAll(GenericEntity param, String uslov) throws Exception {
        List<GenericEntity> lista = new ArrayList<>();
        
        String upit = param.getSelectQuery();
        if(uslov != null)
            upit +=uslov;
        System.out.println(upit);
        
        Connection connection = DbConnectionFactory.getInstance().getConnection();
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(upit);
        lista = param.getList(rs);
        
        rs.close();
        st.close();
        
        return lista;
    }

    @Override
    public void add(GenericEntity entity) throws Exception {
        String upit = "INSERT INTO "+entity.getTableName()+" ("+entity.getColumnNameForInsert()+
                ")"+" VALUES ( "+ entity.getInsertValue()+")";
        System.out.println(upit);
        
        Connection connection = DbConnectionFactory.getInstance().getConnection();
        Statement st = connection.createStatement();
        st.executeUpdate(upit);
        
        st.close();
        
    }

    @Override
    public void edit(GenericEntity entity) throws Exception {
        String upit = "UPDATE "+entity.getTableName()+" SET "+entity.getUpdateValue();
        System.out.println(upit);
        
        Connection connection = DbConnectionFactory.getInstance().getConnection();
        Statement st = connection.createStatement();
        st.executeUpdate(upit);
        
        st.close();
    }

    @Override
    public void delete(GenericEntity entity) throws Exception {
        String upit = "DELETE FROM "+entity.getTableName()+" WHERE "+entity.getId();
        System.out.println(upit);
        
        Connection connection = DbConnectionFactory.getInstance().getConnection();
        Statement st = connection.createStatement();
        st.executeUpdate(upit);
        
        st.close();
    }

    @Override
    public List<GenericEntity> getAll() throws Exception {
//        List<GenericEntity> lista = new ArrayList<>();
//        GenericEntity param =
//        String upit = "SELECT * FROM "+param.getTableName();
//        System.out.println(upit);
//        
//        Connection connection = DbConnectionFactory.getInstance().getConnection();
//        Statement st = connection.createStatement();
//        ResultSet rs = st.executeQuery(upit);
//        lista = param.getList(rs);
//        
//        rs.close();
//        st.close();
//        
//        return lista;
        return null;
    }

    @Override
    public GenericEntity getById(Long k) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
