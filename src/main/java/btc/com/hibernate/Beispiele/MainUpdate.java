package btc.com.hibernate.Beispiele;

import btc.com.hibernate.Connection;
import org.hibernate.Session;

public class MainUpdate {
    public static void main(String[] args) {
        Session session = Connection.openSession();

        session.beginTransaction();

        KundeEntity data = session.get(KundeEntity.class,12);
        data.setVorname("Martina");
        session.merge(data);

        session.getTransaction().commit();
        Connection.closeSession(session);
        Connection.shutdown();
    }
}
