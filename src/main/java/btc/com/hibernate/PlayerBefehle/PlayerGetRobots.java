package btc.com.hibernate.PlayerBefehle;

import btc.com.Entities.RobotEntity;
import btc.com.Services.PlayerService;
import btc.com.hibernate.Connection;
import org.hibernate.Session;

import java.util.List;

public class PlayerGetRobots {
	public static void main(String[] args) {
		PlayerService playerService = new PlayerService();
		Session session = Connection.openSession();

		try {
			int playerId = 1; // ID des Spielers, dessen Roboter abgefragt werden sollen
			List<RobotEntity> robots = playerService.getRobotsByPlayer(playerId);

			System.out.println("Roboter des Spielers mit ID " + playerId + ":");
			for (RobotEntity robot : robots) {
				System.out.println("Robot ID: " + robot.getId() + ", Name: " + robot.getName());
			}
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
