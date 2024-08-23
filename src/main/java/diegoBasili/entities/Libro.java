package diegoBasili.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "libro")
public class Libro extends Biblioteca {
    private String autore;
    private String genere;

    /*Costruttore*/
    public Libro(int codice_isbn, String titolo, int anno_di_pubblicazione, int numero_pagine, String genere, String autore) {
        super(codice_isbn, titolo, anno_di_pubblicazione, numero_pagine);
        this.genere = genere;
        this.autore = autore;
    }
}
