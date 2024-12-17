package btc.com.Services;

import btc.com.Entities.MoveEntity;
import btc.com.hibernate.Connection;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class MoveService {

	// 1. Move erstellen
	public void createMove(int playerId, String moventType, int mapIndex, String parameter, int gameId) {
		Session session = Connection.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			MoveEntity move = new MoveEntity(playerId, moventType, mapIndex, parameter, gameId);
			session.save(move);
			transaction.commit();
			System.out.println("Move erstellt für Game-ID: " + gameId);
		} catch (Exception e) {
			if (transaction != null) transaction.rollback();
			e.printStackTrace();
		} finally {
			Connection.closeSession(session);
		}
	}

	// 2. Alle Moves für eine bestimmte game_id ablesen
	public List<MoveEntity> getMovesByGameId(int gameId) {
		Session session = Connection.openSession();
		try {
			String hql = "FROM MoveEntity m WHERE m.gameId = :gameId";
			Query<MoveEntity> query = session.createQuery(hql, MoveEntity.class);
			query.setParameter("gameId", gameId);
			return query.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			Connection.closeSession(session);
		}
	}
}
