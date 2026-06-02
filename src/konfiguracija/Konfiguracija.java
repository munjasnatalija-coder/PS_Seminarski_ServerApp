/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package konfiguracija;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Natalija
 */
public class Konfiguracija {
    private static Konfiguracija instance;
    private Properties konf;

    private Konfiguracija() {
        try {
            konf = new Properties();
            konf.load(new FileInputStream("config\\properties.properties"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public static Konfiguracija getInstance(){
        if(instance == null)
            instance = new Konfiguracija();
        return instance;
    }

    public String getProperty(String key){
        return konf.getProperty(key, "n/a");
    }
    
    public void setProperty(String key, String value){
        konf.setProperty(key, value);
    }
    
    public void sacuvajIzmene(){
        try {
            konf.store(new FileOutputStream("config\\properties.properties"), null);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
