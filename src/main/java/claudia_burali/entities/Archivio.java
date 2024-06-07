package claudia_burali.entities;

import claudia_burali.enums.Periodicita;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class Archivio {
    private EntityManagerFactory emf;
    private EntityManager em;

    public Archivio() {
        emf = Persistence.createEntityManagerFactory("U4_W3_D5");
        em = emf.createEntityManager();
    }

    public void aggiungiElemento(Catalogo elemento) {
        em.getTransaction().begin();
        em.persist(elemento);
        em.getTransaction().commit();
    }

    public void rimuoviElemento(String isbn) {
        em.getTransaction().begin();
        Catalogo elemento = em.find(Catalogo.class, isbn);
        if (elemento != null) {
            em.remove(elemento);
        }
        em.getTransaction().commit();
    }

    public Catalogo ricercaPerIsbn(long isbn) {
        return em.find(Catalogo.class, isbn);
    }

    public List<Catalogo> ricercaPerAnnoPubblicazione(int anno) {
        return em.createQuery("SELECT e FROM Catalogo e WHERE e.annoPubblicazione = :anno", Catalogo.class)
                .setParameter("anno", anno)
                .getResultList();
    }

    public List<Libro> ricercaPerAutore(String autore) {
        return em.createQuery("SELECT l FROM Libro l WHERE l.autore = :autore", Libro.class)
                .setParameter("autore", autore)
                .getResultList();
    }

    public List<Catalogo> ricercaPerTitolo(String titolo) {
        return em.createQuery("SELECT e FROM Catalogo e WHERE e.titolo LIKE :titolo", Catalogo.class)
                .setParameter("titolo", "%" + titolo + "%")
                .getResultList();
    }

    public List<Prestito> ricercaElementiInPrestito(String numeroDiTessera) {
        return em.createQuery("SELECT p FROM Prestito p WHERE p.utente.numeroDiTessera = :numeroDiTessera AND p.dataRestituzioneEffettiva IS NULL", Prestito.class)
                .setParameter("numeroDiTessera", numeroDiTessera)
                .getResultList();
    }

    public List<Prestito> ricercaPrestitiScaduti() {
        return em.createQuery("SELECT p FROM Prestito p WHERE p.dataRestituzioneEffettiva IS NULL AND p.dataRestituzionePrevista < CURRENT_DATE", Prestito.class)
                .getResultList();
    }

    public List<Rivista> ricercaPerPeriodicita(Periodicita periodicita) {
        return em.createQuery("SELECT r FROM Rivista r WHERE r.periodicita = :periodicita", Rivista.class)
                .setParameter("periodicita", periodicita)
                .getResultList();
    }
}
