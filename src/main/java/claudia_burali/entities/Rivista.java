package claudia_burali.entities;

import claudia_burali.enums.Periodicita;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Rivista extends Catalogo {
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Periodicita periodicita;

    // Default constructor
    public Rivista() {}

    // Constructor with parameters
    public Rivista(long isbn, String titolo, int anno_pubblicazione, int numero_pagine, Periodicita periodicita) {
        super(isbn, titolo, anno_pubblicazione, numero_pagine);
        this.periodicita = periodicita;
    }

    // Getters and setters
    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }

    @Override
    public String toString() {
        return "Rivista{" +
                "periodicita=" + periodicita +
                '}';
    }
}
