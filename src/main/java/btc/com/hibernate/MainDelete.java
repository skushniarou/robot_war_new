package btc.com.hibernate;

import org.hibernate.Session;

public class MainDelete {
    public static void main(String[] args) {
        Session session = Connection.openSession();

        session.beginTransaction();

        KundeEntity data = session.get(KundeEntity.class,17);
        session.remove(data);

        session.getTransaction().commit();
        Connection.closeSession(session);
        Connection.shutdown();
    }
}
