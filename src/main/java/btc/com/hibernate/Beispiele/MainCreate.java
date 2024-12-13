package btc.com.hibernate.Beispiele;

import btc.com.hibernate.Connection;
import org.hibernate.Session;

public class MainCreate {
    public static void main(String[] args) {
        Session session = Connection.openSession();

        session.beginTransaction();

        KundeEntity kunde = new KundeEntity();
        kunde.setName("Mustermann");
        kunde.setVorname("Anna");
        kunde.setGeburtsdatum("01.01.2020");
        kunde.setStrasse("Musterstraße");
        kunde.setHausnummer(1);
        kunde.setHausnummerzusatz("A");
        kunde.setPlz(123456);
        kunde.setOrt("Musterort");
        kunde.setLand("Musterland");

        session.persist(kunde);

        session.getTransaction().commit();
        Connection.closeSession(session);
        Connection.shutdown();

    }
}
