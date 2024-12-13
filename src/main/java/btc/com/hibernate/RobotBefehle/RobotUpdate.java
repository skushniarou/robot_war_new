package btc.com.hibernate.RobotBefehle;

import btc.com.Services.RobotService;
import btc.com.hibernate.Connection;
import org.hibernate.Session;

public class RobotUpdate {
	public static void main(String[] args) {
		Session session = Connection.openSession();

		try {
			RobotService.updateRobot(session, 7, "Rebecca", 20, 10, 5, 3);
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		Connection.closeSession(session);
		Connection.shutdown();
	}
}
