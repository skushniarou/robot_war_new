package btc.com.hibernate;

import org.hibernate.Session;

public class MainRead {
    public static void main(String[] args) {
        Session session = Connection.openSession();



        KundeEntity data = session.get(KundeEntity.class,12);
        System.out.println(data.getName()+", "+data.getVorname());


        Connection.closeSession(session);
        Connection.shutdown();

    }
}
