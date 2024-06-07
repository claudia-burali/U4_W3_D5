package claudia_burali;

import claudia_burali.dao.UtenteDAO;
import claudia_burali.entities.*;
import claudia_burali.enums.Periodicita;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("U4_W3_D5");
    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        UtenteDAO utenteDAO = new UtenteDAO(em);
        Utente utente1 = new Utente("Mario", "Rossi", LocalDate.of(1998,8, 12), "11111111");
        utenteDAO.saveUtente(utente1);
    }
}





