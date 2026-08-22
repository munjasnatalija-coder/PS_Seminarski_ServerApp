/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domain.Kupac;
import domain.Mesto;
import domain.Zaposleni;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import operation.kupac.KreirajKupcaSO;
import operation.kupac.PromeniKupceSO;
import operation.kupac.UcitajKupceSO;
import operation.kupac.UcitajMestaSO;
import operation.login.LoginSO;
import operation.smena.UbaciSmenuSO;

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
        if(operacija.getZaposleni().equals(null))
            throw new Exception("Ne postoji zaposleni u sistemu");
        else 
            return operacija.getZaposleni();
    }

    public List<Kupac> ucitajKupce() throws Exception {
        UcitajKupceSO operacija = new UcitajKupceSO();
        operacija.execute(new Kupac(), null);
        System.out.println("Klasa kontroler server: "+operacija.getKupci());
        return operacija.getKupci();
    }

    public void ubaciSmenu(Map<String, LocalDateTime> smene) throws Exception {
        UbaciSmenuSO operacija = new UbaciSmenuSO();
        operacija.execute(smene, null);
    }

    public List<Mesto> ucitajMesta() throws Exception {
        UcitajMestaSO operacija = new UcitajMestaSO();
        operacija.execute(null, null);
        if(operacija.getMesta().equals(null))
            throw new Exception("Greska ucitavanje mesta.");
        else
            return operacija.getMesta();
    }

    public void kreirajKupca(Kupac kupac) throws Exception {
        KreirajKupcaSO operacija = new KreirajKupcaSO();
        operacija.execute(kupac, null);
    }

    public void promeniKupca(Kupac kupac) throws Exception {
        PromeniKupceSO op = new PromeniKupceSO();
        op.execute(kupac, null);
    }
}
