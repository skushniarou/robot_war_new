package btc.com.Services;

import btc.com.Entities.PlayerEntity;
import btc.com.Entities.RobotEntity;
import btc.com.hibernate.Connection;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class PlayerService {

	public static void createPlayer(Session session, int robotId) {
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			PlayerEntity player = new PlayerEntity(robotId);
			session.save(player);
			transaction.commit();
			System.out.println("Player erstellt mit Robot-ID: " + robotId);
		} catch (Exception e) {
			if (transaction != null) transaction.rollback();
			e.printStackTrace();
		}
	}

	public void deletePlayer(int playerId) {
		Session session = Connection.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			PlayerEntity player = session.get(PlayerEntity.class, playerId);
			if (player != null) {
				session.delete(player);
				System.out.println("Player gelöscht mit ID: " + playerId);
			} else {
				System.out.println("Player mit ID " + playerId + " nicht gefunden.");
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) transaction.rollback();
			e.printStackTrace();
		} finally {
			Connection.closeSession(session);
		}
	}

	public List<RobotEntity> getRobotsByPlayer(int playerId) {
		Session session = Connection.openSession();
		try {
			String hql = "SELECT r FROM RobotEntity r " +
					"JOIN PlayerEntity p ON r.id = p.robotId " +
					"WHERE p.id = :playerId";
			Query<RobotEntity> query = session.createQuery(hql, RobotEntity.class);
			query.setParameter("playerId", playerId);
			return query.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			Connection.closeSession(session);
		}
	}
}