package btc.com.hibernate.PlayerBefehle;

import btc.com.Services.PlayerService;
import btc.com.hibernate.Connection;
import org.hibernate.Session;

public class PlayerCreate {
	public static void main(String[] args) {
		Session session = Connection.openSession();

		try {
			// Erstelle einen neuen Player mit einer gültigen Robot-ID (z.B. 1)
			PlayerService.createPlayer(session, 1);
			Thread.sleep(5000);
		} catch (Exception e) {
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
			e.printStackTrace();
		} finally {
			Connection.closeSession(session);
			Connection.shutdown();
		}
	}
}