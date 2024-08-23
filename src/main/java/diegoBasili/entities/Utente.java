package diegoBasili.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "utente")
public class Utente {
    @Id
    @GeneratedValue
    private long numero_tessera;
    private String nome;
    private String cognome;
    private LocalDate data_di_nascita;
    
    @OneToMany(mappedBy = "utente")
    private Set<Prestito> prestiti;

    /*Costruttore*/
    public Utente(String nome, String cognome, LocalDate data_di_nascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.data_di_nascita = data_di_nascita;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getData_di_nascita() {
        return data_di_nascita;
    }

    public void setData_di_nascita(LocalDate data_di_nascita) {
        this.data_di_nascita = data_di_nascita;
    }

    public long getNumero_tessera() {
        return numero_tessera;
    }


}
