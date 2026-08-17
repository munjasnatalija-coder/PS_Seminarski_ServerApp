/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domain.Kupac;
import domain.Zaposleni;
import java.util.List;
import operation.kupac.UcitajKupceSO;
import operation.login.LoginSO;

/**
 *
 * @author Natalija
 */
public class Controller {
    private static Controller instance;

    private Controller() {
    }
    
    public static Controller getInstance(){
        if(instance == null)
            instance = new Controller();
        return instance;
    }

    public Zaposleni login(Zaposleni trazenZaposleni) throws Exception {
        LoginSO operacija = new LoginSO();
        operacija.execute(trazenZaposleni, null);
        System.out.println("Klasa kontroler server:"+operacija.getZaposleni());
        return operacija.getZaposleni();
    }

    public List<Kupac> ucitajKupce() throws Exception {
        UcitajKupceSO operacija = new UcitajKupceSO();
        operacija.execute(new Kupac(), null);
        System.out.println("Klasa kontroler server: "+operacija.getKupci());
        return operacija.getKupci();
    }
}
