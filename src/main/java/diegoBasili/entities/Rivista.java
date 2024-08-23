package diegoBasili.entities;

import diegoBasili.enums.Periodicità;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "rivista")
public class Rivista extends Biblioteca {
    private Periodicità periodicita;

    /*Costruttore*/

    public Rivista(int codice_isbn, String titolo, int anno_di_pubblicazione, int numero_pagine, Periodicità periodicita) {
        super(codice_isbn, titolo, anno_di_pubblicazione, numero_pagine);
        this.periodicita = periodicita;
    }
}
