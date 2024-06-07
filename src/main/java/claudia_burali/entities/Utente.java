package claudia_burali.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String cognome;
    @Column(nullable = false)
    private LocalDate data_nascita;
    @Column(nullable = false)
    private String numero_tessera;

    @OneToMany(mappedBy = "utente")
    private List <Prestito> prestiti;
    // Default constructor
    public Utente() {}

    // Constructor with parameters
    public Utente(String nome, String cognome, LocalDate data_nascita, String numero_tessera) {
        this.nome = nome;
        this.cognome = cognome;
        this.data_nascita = data_nascita;
        this.numero_tessera = numero_tessera;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDate getData_nascita() {
        return data_nascita;
    }

    public void setData_nascita(LocalDate data_nascita) {
        this.data_nascita = data_nascita;
    }

    public String getNumero_tessera() {
        return numero_tessera;
    }

    public void setNumero_tessera(String numero_tessera) {
        this.numero_tessera = numero_tessera;
    }

    public List<Prestito> getPrestiti() {
        return prestiti;
    }

    public void setPrestiti(List<Prestito> prestiti) {
        this.prestiti = prestiti;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", data_nascita=" + data_nascita +
                ", numero_tessera='" + numero_tessera + '\'' +
                '}';
    }
}
