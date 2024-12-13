package btc.com.hibernate.RobotBefehle;

import btc.com.Services.RobotService;
import btc.com.hibernate.Connection;
import org.hibernate.Session;

public class RobotCreate {
	public static void main(String[] args) {
		Session session = Connection.openSession();

		try {
			RobotService.createRobot(session, "Bobby", 10, 4, 5, 3);
			Thread.sleep(5000);

		} catch (Exception e) {
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
			e.printStackTrace();
		}
		Connection.closeSession(session);
		Connection.shutdown();
	}
}
