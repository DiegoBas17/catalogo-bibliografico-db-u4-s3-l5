package diegoBasili.dao;

import com.github.javafaker.Faker;
import diegoBasili.entities.Biblioteca;
import diegoBasili.entities.Libro;
import diegoBasili.entities.Rivista;
import diegoBasili.enums.Periodicità;
import diegoBasili.exeptions.NotFoundEx;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

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
        System.out.println("il libro" + elemento_biblioteca.getTitolo() + "è stato salvato");
    }

    public Biblioteca findById(int id) throws NotFoundEx {
        Biblioteca elemento_biblioteca = em.find(Biblioteca.class, id);
        if (elemento_biblioteca == null) {
            throw new NotFoundEx(id);
        }
        return elemento_biblioteca;
    }

    public void findByIdAndDelete(int id) throws NotFoundEx {
        Biblioteca elemento_biblioteca = findById(id);
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
    }

    public void creazioneLibro() {
        Libro a = new Libro(1, faker.book().title(), 2000, faker.random().nextInt(300), faker.book().genre(), faker.book().author());
        Libro b = new Libro(2, faker.book().title(), 2010, faker.random().nextInt(300), faker.book().genre(), faker.book().author());
        Libro c = new Libro(3, faker.book().title(), 2002, faker.random().nextInt(300), faker.book().genre(), faker.book().author());
        Libro d = new Libro(4, faker.book().title(), 2003, faker.random().nextInt(300), faker.book().genre(), faker.book().author());
        Libro e = new Libro(5, faker.book().title(), 2005, faker.random().nextInt(300), faker.book().genre(), faker.book().author());
        Libro f = new Libro(6, faker.book().title(), 2008, faker.random().nextInt(300), faker.book().genre(), faker.book().author());
        Libro g = new Libro(7, faker.book().title(), 2012, faker.random().nextInt(300), faker.book().genre(), faker.book().author());
        Libro h = new Libro(8, faker.book().title(), 2015, faker.random().nextInt(300), faker.book().genre(), faker.book().author());
        Libro i = new Libro(9, faker.book().title(), 2017, faker.random().nextInt(300), faker.book().genre(), faker.book().author());
        Libro l = new Libro(10, faker.book().title(), 2022, faker.random().nextInt(300), faker.book().genre(), faker.book().author());
    }
}
