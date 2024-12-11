package btc.com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Connection {
    private static final SessionFactory sessionFactory;

    //Stellt die Verbindung zur Datenbank her
    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            System.out.println("Verbunden!");
        } catch (RuntimeException ex) {
            System.out.println("Fehler!");
            throw new ExceptionInInitializerError(ex);
        }
    }

    //Erstellt eine Session
    public static Session openSession() {
        return sessionFactory.openSession();
    }

    //Schließt die Session
    public static void closeSession(Session session) {
            session.close();
    }

    //Schließt die SessionFactory
    public static void shutdown() {
        sessionFactory.close();
    }
}
