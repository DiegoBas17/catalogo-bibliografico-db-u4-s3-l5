package diegoBasili.dao;

import com.github.javafaker.Faker;
import diegoBasili.entities.Biblioteca;
import diegoBasili.entities.Libro;
import diegoBasili.entities.Rivista;
import diegoBasili.enums.Periodicità;
import diegoBasili.exeptions.NotFoundEx;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Locale;

public class BibliotecaDAO {
    private final EntityManager em;
    Faker faker = new Faker(Locale.ITALIAN);

    public BibliotecaDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Biblioteca elemento_biblioteca) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(elemento_biblioteca);
        transaction.commit();
        System.out.println("l'elemento " + elemento_biblioteca.getTitolo() + "è stato salvato");
    }

    public Biblioteca findByIsbn(int isbn) throws NotFoundEx {
        Biblioteca elemento_biblioteca = em.find(Biblioteca.class, isbn);
        if (elemento_biblioteca == null) {
            throw new NotFoundEx(isbn);
        }
        return elemento_biblioteca;
    }

    public void findByIsbnAndDelete(int isbn) throws NotFoundEx {
        Biblioteca elemento_biblioteca = findByIsbn(isbn);
        em.getTransaction().begin();
        em.remove(elemento_biblioteca);
        em.getTransaction().commit();
        System.out.println("il libro" + elemento_biblioteca.getTitolo() + "è stato eliminato");
    }

    public void creazioneRiviste() {
        Rivista a = new Rivista(1, faker.book().title(), 2000, faker.random().nextInt(300), Periodicità.MENSILE);
        Rivista b = new Rivista(2, faker.book().title(), 2010, faker.random().nextInt(300), Periodicità.SEETIMANALE);
        Rivista c = new Rivista(3, faker.book().title(), 2002, faker.random().nextInt(300), Periodicità.SEMESTRALE);
        Rivista d = new Rivista(4, faker.book().title(), 2003, faker.random().nextInt(300), Periodicità.MENSILE);
        Rivista e = new Rivista(5, faker.book().title(), 2005, faker.random().nextInt(300), Periodicità.MENSILE);
        Rivista f = new Rivista(6, faker.book().title(), 2008, faker.random().nextInt(300), Periodicità.SEMESTRALE);
        Rivista g = new Rivista(7, faker.book().title(), 2012, faker.random().nextInt(300), Periodicità.MENSILE);
        Rivista h = new Rivista(8, faker.book().title(), 2015, faker.random().nextInt(300), Periodicità.MENSILE);
        Rivista i = new Rivista(9, faker.book().title(), 2017, faker.random().nextInt(300), Periodicità.MENSILE);
        Rivista l = new Rivista(10, faker.book().title(), 2022, faker.random().nextInt(300), Periodicità.MENSILE);
        BibliotecaDAO bd = new BibliotecaDAO(em);
        bd.save(a);
        bd.save(b);
        bd.save(c);
        bd.save(d);
        bd.save(e);
        bd.save(f);
        bd.save(g);
        bd.save(h);
        bd.save(i);
        bd.save(l);
    }

    public void creazioneLibro() {
        Libro a = new Libro(11, faker.book().title(), 2000, faker.random().nextInt(300), faker.book().genre(), faker.book().author());
        Libro b = new Libro(12, faker.book().title(), 2010, faker.random().nextInt(300), faker.book().genre(), faker.book().author());
        Libro c = new Libro(13, faker.book().title(), 2002, faker.random().nextInt(300), faker.book().genre(), faker.book().author());
        Libro d = new Libro(14, faker.book().title(), 2003, faker.random().nextInt(300), faker.book().genre(), faker.book().author());
        Libro e = new Libro(15, faker.book().title(), 2005, faker.random().nextInt(300), faker.book().genre(), faker.book().author());
        Libro f = new Libro(16, faker.book().title(), 2008, faker.random().nextInt(300), faker.book().genre(), faker.book().author());
        Libro g = new Libro(17, faker.book().title(), 2012, faker.random().nextInt(300), faker.book().genre(), faker.book().author());
        Libro h = new Libro(18, faker.book().title(), 2015, faker.random().nextInt(300), faker.book().genre(), faker.book().author());
        Libro i = new Libro(19, faker.book().title(), 2017, faker.random().nextInt(300), faker.book().genre(), faker.book().author());
        Libro l = new Libro(20, faker.book().title(), 2022, faker.random().nextInt(300), faker.book().genre(), faker.book().author());
        BibliotecaDAO bd = new BibliotecaDAO(em);
        bd.save(a);
        bd.save(b);
        bd.save(c);
        bd.save(d);
        bd.save(e);
        bd.save(f);
        bd.save(g);
        bd.save(h);
        bd.save(i);
        bd.save(l);
    }

    public List<Biblioteca> ricercaPerAnnoDiPubblicazione(int anno_di_pubblicazione) {
        TypedQuery<Biblioteca> query = em.createQuery("SELECT a FROM Biblioteca a WHERE a.anno_di_pubblicazione = :anno", Biblioteca.class);
        query.setParameter("anno", anno_di_pubblicazione);
        if (query.getResultList().isEmpty()) {
            System.out.println("Non libri pubblicati in questa libreria in questo anno:" + anno_di_pubblicazione);
        }
        return query.getResultList();
    }

    public List<Libro> ricercaPerAutore(String autore) {
        TypedQuery<Libro> query = em.createQuery("SELECT a FROM Libro a WHERE a.autore = :autore ", Libro.class);
        query.setParameter("autore", autore);
        if (query.getResultList().isEmpty()) {
            System.out.println("Non ci sono libri di questo autore: " + autore + "in questa libreria");
        }
        return query.getResultList();
    }

    public List<Biblioteca> ricercaPerTitolo(String titolo) {
        TypedQuery<Biblioteca> query = em.createQuery("SELECT a FROM Biblioteca a WHERE a.titolo LIKE :titolo ", Biblioteca.class);
        query.setParameter("titolo", "%" + titolo + "%");
        if (query.getResultList().isEmpty()) {
            System.out.println("Non ci sono libri con questo titolo: " + titolo + "in questa libreria");
        }
        return query.getResultList();
    }
}
