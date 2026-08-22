/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation;
import repository.Repository;
import repository.db.impl.DbRepositoryGeneric;
import repository.db.DbRepository;

/**
 *
 * @author Natalija
 */
public abstract class AbstractSO {
    protected final Repository repository;

    public AbstractSO() {
        this.repository = new DbRepositoryGeneric();
    }
    
    public void execute(Object param, String kljuc) throws Exception {
        try {
            precondition(param);
            executeOperation(param, kljuc);
            comitTransaction();
            System.out.println("Uspesno izvrsena operacija!!!");
        } catch (Exception e) {
            System.out.println("Greska kod cuvanja proizvoda!!!");
            rollbackTransaction();
            throw e;
        }
    }

    protected abstract void precondition(Object param) throws Exception;

    protected abstract void executeOperation(Object param, String kljuc) throws Exception;
    
    private void startTransaction() throws Exception {
        ((DbRepository) repository).connect();
    }

    private void comitTransaction() throws Exception {
        ((DbRepository) repository).commit();
    }

    private void rollbackTransaction() throws Exception {
        ((DbRepository) repository).rollback();
    }
    
    
}
