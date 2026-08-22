/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.smena;

import domain.Smena;
import java.time.LocalDateTime;
import java.util.Map;
import operation.AbstractSO;

/**
 *
 * @author Natalija
 */
public class UbaciSmenuSO extends AbstractSO {

    @Override
    protected void precondition(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param, String kljuc) throws Exception {
        Map<String, LocalDateTime> smene = (Map<String, LocalDateTime>)param;
        
        LocalDateTime pocetakSmene = smene.get("pocetakSmene");
        LocalDateTime krajSmene = smene.get("krajSmene");
        
        Smena smena = new Smena(pocetakSmene, krajSmene);
        repository.add(smena);
    }
    
}
