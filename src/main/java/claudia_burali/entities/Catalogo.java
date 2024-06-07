package claudia_burali.entities;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Catalogo {
    @Id
    private long isbn;
    @Column(nullable = false)
    private String titolo;
    @Column(nullable = false)
    private int anno_pubblicazione;
    @Column(nullable = false)
    private int numero_pagine;

    // Default constructor
    public Catalogo() {}

    // Constructor with parameters
    public Catalogo(long isbn, String titolo, int anno_pubblicazione, int numero_pagine) {
        this.isbn = isbn;
        this.titolo = titolo;
        this.anno_pubblicazione = anno_pubblicazione;
        this.numero_pagine = numero_pagine;
    }

    // Getters and setters
    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnnoPubblicazione() {
        return anno_pubblicazione;
    }

    public void setAnnoPubblicazione(int anno_pubblicazione) {
        this.anno_pubblicazione = anno_pubblicazione;
    }

    public int getNumeroPagine() {
        return numero_pagine;
    }

    public void setNumeroPagine(int numero_pagine) {
        this.numero_pagine = numero_pagine;
    }
}