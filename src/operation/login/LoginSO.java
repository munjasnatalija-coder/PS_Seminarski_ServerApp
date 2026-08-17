/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.login;

import domain.Zaposleni;
import java.util.List;
import operation.AbstractSO;

/**
 *
 * @author Natalija
 */
public class LoginSO extends AbstractSO {
    private Zaposleni zaposleni;

    public Zaposleni getZaposleni() {
        return zaposleni;
    }

    @Override
    protected void precondition(Object param) throws Exception {
        
    }

    @Override
    protected void executeOperation(Object param, String kljuc) throws Exception {
        List<Zaposleni> sviZaposleni = repository.getAll((Zaposleni)param, null);
        System.out.println("Klasa LoginSO: "+sviZaposleni);
        
        for (Zaposleni z : sviZaposleni) {
            if(z.equals((Zaposleni)param)){
                zaposleni = z;
                System.out.println(z);
                return;
            }
        }
        
        zaposleni = null;
    }

    
}
