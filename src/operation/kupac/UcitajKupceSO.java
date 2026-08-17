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
public class UcitajKupceSO extends AbstractSO{
    private List<Kupac> kupci;

    @Override
    protected void precondition(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param, String kljuc) throws Exception {
        //kupci = repository.getAll();
        kupci = repository.getAll(param, null);
    }

    public List<Kupac> getKupci() {
        return kupci;
    }
    
}
