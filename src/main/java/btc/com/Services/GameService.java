package btc.com.Services;

import btc.com.Entities.GameEntity;
import btc.com.hibernate.Connection;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class GameService {

	// 1. Spiel erstellen
	public void createGame(int mapId, String status, String players) {
		Session session = Connection.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			GameEntity game = new GameEntity(mapId, status, players);
			session.save(game);
			transaction.commit();
			System.out.println("Spiel erstellt mit Map-ID: " + mapId);
		} catch (Exception e) {
			if (transaction != null) transaction.rollback();
			e.printStackTrace();
		} finally {
			Connection.closeSession(session);
		}
	}

	// 2. Spiel nach ID löschen
	public void deleteGame(int gameId) {
		Session session = Connection.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			GameEntity game = session.get(GameEntity.class, gameId);
			if (game != null) {
				session.delete(game);
				System.out.println("Spiel gelöscht mit ID: " + gameId);
			} else {
				System.out.println("Spiel mit ID " + gameId + " nicht gefunden.");
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) transaction.rollback();
			e.printStackTrace();
		} finally {
			Connection.closeSession(session);
		}
	}

	// 3. Alle Spiele aus der Datenbank ablesen
	public List<GameEntity> getAllGames() {
		Session session = Connection.openSession();
		try {
			String hql = "FROM GameEntity";
			Query<GameEntity> query = session.createQuery(hql, GameEntity.class);
			return query.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			Connection.closeSession(session);
		}
	}
}
