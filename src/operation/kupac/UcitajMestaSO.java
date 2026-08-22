/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.kupac;

import domain.Mesto;
import java.util.List;
import operation.AbstractSO;

/**
 *
 * @author Natalija
 */
public class UcitajMestaSO extends AbstractSO {
    private List<Mesto> mesta = null;

    @Override
    protected void precondition(Object param) throws Exception {

    }

    @Override
    protected void executeOperation(Object param, String kljuc) throws Exception {
        mesta = repository.getAll(new Mesto(), null);
    }

    public List<Mesto> getMesta() {
        return mesta;
    }
    
}
