package btc.com.hibernate.RobotBefehle;

import btc.com.Services.RobotService;
import btc.com.hibernate.Connection;
import org.hibernate.Session;

public class RobotDelete {
	public static void main(String[] args) {
		Session session = Connection.openSession();
		try {
			RobotService.deleteRobot(session, 7);
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		Connection.closeSession(session);
		Connection.shutdown();
	}
}
