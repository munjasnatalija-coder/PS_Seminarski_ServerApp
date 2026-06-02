/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import java.util.List;

/**
 *
 * @author Natalija
 */
public interface Repository<T, K> {
    //sve genericke metode za sve objekte
    List<T> getAll(T t, String uslov) throws Exception;
    void add(T t) throws Exception;
    void edit(T t) throws Exception;
    void delete(T t) throws Exception;
    List<T> getAll() throws Exception;
    T getById(K k) throws Exception;
};
