package btc.com.hibernate.PlayerBefehle;

import btc.com.Services.PlayerService;
import btc.com.hibernate.Connection;
import org.hibernate.Session;

public class PlayerDelete {
	public static void main(String[] args) {
		PlayerService playerService = new PlayerService();
		Session session = Connection.openSession();

		try {
			int playerId = 1; // ID des zu löschenden Spielers
			playerService.deletePlayer(playerId);
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
