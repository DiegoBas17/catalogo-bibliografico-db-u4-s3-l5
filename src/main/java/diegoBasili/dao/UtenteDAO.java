package diegoBasili.dao;

import diegoBasili.entities.Utente;
import diegoBasili.exeptions.NotFoundEx;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class UtenteDAO {
    private final EntityManager em;

    public UtenteDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Utente utente) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(utente);
        transaction.commit();
        System.out.println("l'utente" + utente.getCognome() + "è stato salvato");
    }

    public Utente findById(int id) throws NotFoundEx {
        Utente utente = em.find(Utente.class, id);
        if (utente == null) {
            throw new NotFoundEx(id);
        }
        return utente;
    }
}
