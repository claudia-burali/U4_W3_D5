package claudia_burali.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Prestito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;

    @OneToOne
    private Catalogo elemento_prestato;
    @Column(nullable = false)
    private LocalDate data_inizio_prestito;
    @Column(nullable = false)
    private LocalDate data_restituzione_prevista;
    private LocalDate data_restituzione_effettiva;

    // Default constructor
    public Prestito() {}

    // Constructor with parameters
    public Prestito(Utente utente, Catalogo elemento_prestato, LocalDate data_inizio_prestito, LocalDate data_restituzione_prevista) {
        this.utente = utente;
        this.elemento_prestato = elemento_prestato;
        this.data_inizio_prestito = data_inizio_prestito;
        this.data_restituzione_prevista = data_inizio_prestito.plusDays(30);
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Catalogo getElementoPrestato() {
        return elemento_prestato;
    }

    public void setElementoPrestato(Catalogo elemento_prestato) {
        this.elemento_prestato = elemento_prestato;
    }

    public LocalDate getDataInizioPrestito() {
        return data_inizio_prestito;
    }

    public void setDataInizioPrestito(LocalDate data_inizio_prestito) {
        this.data_inizio_prestito = data_inizio_prestito;
    }

    public LocalDate getDataRestituzionePrevista() {
        return data_restituzione_prevista;
    }

    public void setDataRestituzionePrevista(LocalDate data_restituzione_prevista) {
        this.data_restituzione_prevista = data_restituzione_prevista;
    }

    public LocalDate getDataRestituzioneEffettiva() {
        return data_restituzione_effettiva;
    }

    public void setDataRestituzioneEffettiva(LocalDate data_restituzione_effettiva) {
        this.data_restituzione_effettiva = data_restituzione_effettiva;
    }
}
