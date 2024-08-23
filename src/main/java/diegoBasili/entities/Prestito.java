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
    @Column(name = "data_restituzione_effettiva", nullable = true)
    private LocalDate data_restituzione_effettiva;

    public Prestito() {
    }

    public Prestito(Utente utente, Biblioteca elemento_prestato, LocalDate data_prestito, LocalDate data_restituzione_effettiva) {
        this.utente = utente;
        this.elemento_prestato = elemento_prestato;
        this.data_prestito = data_prestito;
        this.data_restituzione_prevista = restituzione_prevista(data_prestito);
        this.data_restituzione_effettiva = data_restituzione_effettiva;
    }

    public LocalDate restituzione_prevista(LocalDate dataPrestito) {
        return dataPrestito.plusDays(30);
    }

    public int getPrestito_id() {
        return prestito_id;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Biblioteca getElemento_prestato() {
        return elemento_prestato;
    }

    public void setElemento_prestato(Biblioteca elemento_prestato) {
        this.elemento_prestato = elemento_prestato;
    }

    public LocalDate getData_prestito() {
        return data_prestito;
    }

    public void setData_prestito(LocalDate data_prestito) {
        this.data_prestito = data_prestito;
    }

    public LocalDate getData_restituzione_prevista() {
        return data_restituzione_prevista;
    }

    public void setData_restituzione_prevista(LocalDate data_restituzione_prevista) {
        this.data_restituzione_prevista = data_restituzione_prevista;
    }

    public LocalDate getData_restituzione_effettiva() {
        return data_restituzione_effettiva;
    }

    public void setData_restituzione_effettiva(LocalDate data_restituzione_effettiva) {
        this.data_restituzione_effettiva = data_restituzione_effettiva;
    }

    @Override
    public String toString() {
        return "Prestito{" +
                "prestito_id=" + prestito_id +
                ", utente=" + utente.getNome() +
                ", elemento_prestato=" + elemento_prestato.getTitolo() +
                ", data_prestito=" + data_prestito +
                ", data_restituzione_prevista=" + data_restituzione_prevista +
                ", data_restituzione_effettiva=" + data_restituzione_effettiva +
                '}';
    }
}
