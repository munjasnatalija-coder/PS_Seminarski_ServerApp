/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.kupac;

import domain.Kupac;
import java.util.List;
import operation.AbstractSO;

/**
 *
 * @author Natalija
 */
public class KreirajKupcaSO extends AbstractSO {

    @Override
    protected void precondition(Object param) throws Exception {
        if(!(param instanceof Kupac))
            throw new Exception("Prosleđeni objekat nije instanca klase Kupac.");
        
        Kupac k = (Kupac)param;
        List<Kupac> kupci = repository.getAll(param, null);
        
        for (Kupac kupac : kupci) {
            if (kupac.getEmail().equals(k.getEmail())) {
                throw new Exception("Kupac sa tim emailom vec postoji!");
            }
            if (kupac.getBrojTelefona().equals(k.getBrojTelefona())) {
                throw new Exception("Kupac sa tim telefonom vec postoji!");
            }
        }
             
    }

    @Override
    protected void executeOperation(Object param, String kljuc) throws Exception {
        repository.add(param);
    }
    
}
