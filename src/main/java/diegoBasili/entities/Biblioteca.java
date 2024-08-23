package diegoBasili.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "biblioteca")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Biblioteca {
    @Id
    private int codice_isbn;
    private String titolo;
    private int anno_di_pubblicazione;
    private int numero_pagine;

    /*Costruttore*/
    public Biblioteca(int codice_isbn, String titolo, int anno_di_pubblicazione, int numero_pagine) {
        this.codice_isbn = codice_isbn;
        this.titolo = titolo;
        this.anno_di_pubblicazione = anno_di_pubblicazione;
        this.numero_pagine = numero_pagine;
    }

    public int getCodice_isbn() {
        return codice_isbn;
    }

    public void setCodice_isbn(int codice_isbn) {
        this.codice_isbn = codice_isbn;
    }

    public int getAnno_di_pubblicazione() {
        return anno_di_pubblicazione;
    }

    public void setAnno_di_pubblicazione(int anno_di_pubblicazione) {
        this.anno_di_pubblicazione = anno_di_pubblicazione;
    }

    public int getNumero_pagine() {
        return numero_pagine;
    }

    public void setNumero_pagine(int numero_pagine) {
        this.numero_pagine = numero_pagine;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    @Override
    public String toString() {
        return "Biblioteca{" +
                "codice_isbn=" + codice_isbn +
                ", titolo='" + titolo + '\'' +
                ", anno_di_pubblicazione=" + anno_di_pubblicazione +
                ", numero_pagine=" + numero_pagine +
                '}';
    }
}
