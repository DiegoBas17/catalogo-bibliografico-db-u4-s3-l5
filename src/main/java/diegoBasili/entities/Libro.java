package diegoBasili.entities;

import jakarta.persistence.Entity;

@Entity
/*@Table(name = "libro")*/
public class Libro extends Biblioteca {
    private String autore;
    private String genere;

    /*Costruttore*/
    public Libro() {
    }

    public Libro(int codice_isbn, String titolo, int anno_di_pubblicazione, int numero_pagine, String genere, String autore) {
        super(codice_isbn, titolo, anno_di_pubblicazione, numero_pagine);
        this.genere = genere;
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "autore='" + autore + '\'' +
                ", genere='" + genere + '\'' +
                "} " + super.toString();
    }
}
