package diegoBasili.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "prestito")
public class Prestito {
    @Id
    @GeneratedValue
    private int prestito_id;
    @ManyToOne
    @JoinColumn(name = "numero_tessera")
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "codice_isbn")
    private Biblioteca elemento_prestato;

    private LocalDate data_prestito;
    private LocalDate data_restituzione_prevista;
    private LocalDate data_restituzione_effettiva;

    public LocalDate restituzione_prevista(LocalDate dataPrestito) {
        return dataPrestito.plusDays(30);
    }

}
