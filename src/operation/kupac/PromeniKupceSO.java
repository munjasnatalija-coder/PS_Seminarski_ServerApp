/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.kupac;

import domain.Kupac;
import operation.AbstractSO;

/**
 *
 * @author Natalija
 */
public class PromeniKupceSO extends AbstractSO {

    @Override
    protected void precondition(Object param) throws Exception {
        if (!(param instanceof Kupac)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Kupac!");
        }
    }

    @Override
    protected void executeOperation(Object param, String kljuc) throws Exception {
        repository.edit(param);
    }
    
}
