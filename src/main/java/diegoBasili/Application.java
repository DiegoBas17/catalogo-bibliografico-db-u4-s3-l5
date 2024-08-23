package diegoBasili;

import diegoBasili.dao.BibliotecaDAO;
import diegoBasili.dao.PrestitoDAO;
import diegoBasili.dao.UtenteDAO;
import diegoBasili.entities.Biblioteca;
import diegoBasili.entities.Prestito;
import diegoBasili.entities.Utente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("catalogo_db");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        BibliotecaDAO bd = new BibliotecaDAO(em);
        //bd.creazioneRiviste();
        //bd.creazioneLibro();
        System.out.println("ricerca per anno di pubblicazione");
        bd.ricercaPerAnnoDiPubblicazione(2000).forEach(System.out::println);
        System.out.println("ricerca per autore");
        bd.ricercaPerAutore("Audenico Leone").forEach(System.out::println);
        System.out.println("ricerca per titolo");
        bd.ricercaPerTitolo("a").forEach(System.out::println);

        Utente gabriel = new Utente("gabriel", "azamfiri", LocalDate.of(1997, 5, 25));
        Utente eddy = new Utente("eddy", "turpo", LocalDate.of(1997, 5, 25));
        Utente arianna = new Utente("arianna", "loreti", LocalDate.of(1997, 5, 25));
        UtenteDAO ud = new UtenteDAO(em);
        //ud.save(gabriel);
        //ud.save(eddy);
        //ud.save(arianna);

        Biblioteca libroprestito1 = bd.findById(1);
        Utente gabrielT = ud.findById(1);
        Prestito prestito1 = new Prestito(gabrielT, libroprestito1, LocalDate.now(), null);
        PrestitoDAO pd = new PrestitoDAO(em);
        //pd.save(prestito1);
        System.out.println("ricerca tramite tessera");
        pd.ricercaPerTessera(1).forEach(System.out::println);
        System.out.println("Ricerca Prestiti scaduti:");
        pd.ricercaPrestitiScaduti().forEach(System.out::println);
        System.out.println("fin qui tutto bene...");
    }
}
