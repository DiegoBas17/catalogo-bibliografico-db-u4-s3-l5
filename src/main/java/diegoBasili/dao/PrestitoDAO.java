package diegoBasili.dao;

import diegoBasili.entities.Prestito;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class PrestitoDAO {
    private final EntityManager em;

    public PrestitoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Prestito prestito) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(prestito);
        transaction.commit();
        System.out.println("il prestito " + prestito.getPrestito_id() + "è stato salvato");
    }

    public List<Prestito> ricercaPerTessera(long numero_tessera) {
        TypedQuery<Prestito> query = em.createQuery("SELECT p FROM Prestito p WHERE p.utente.numero_tessera = :numero_tessera", Prestito.class);
        query.setParameter("numero_tessera", numero_tessera);
        if (query.getResultList().isEmpty()) {
            System.out.println("Non ci sono prestiti allegati a questa tessera:" + numero_tessera);
        }
        return query.getResultList();
    }

    public List<Prestito> ricercaPrestitiScaduti() {
        TypedQuery<Prestito> query = em.createQuery("SELECT p FROM Prestito p WHERE p.data_restituzione_effettiva IS NULL", Prestito.class);
        if (query.getResultList().isEmpty()) {
            System.out.println("Non ci sono prestiti scaduti");
        }
        return query.getResultList();
    }
}
