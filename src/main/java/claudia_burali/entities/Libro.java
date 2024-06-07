package claudia_burali.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Libro extends Catalogo {
    @Column(nullable = false)
    private String autore;
    @Column(nullable = false)
    private String genere;

    // Default constructor
    public Libro() {}

    // Constructor with parameters
    public Libro(long isbn, String titolo, int anno_pubblicazione, int numero_pagine, String autore, String genere) {
        super(isbn, titolo, anno_pubblicazione, numero_pagine);
        this.autore = autore;
        this.genere = genere;
    }

    // Getters and setters
    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "autore='" + autore + '\'' +
                ", genere='" + genere + '\'' +
                '}';
    }
}
