package btc.com.Client;

import btc.com.Services.RobotService;
import btc.com.hibernate.Connection;
import org.hibernate.Session;

public class RobotController {
	public static void main(String[] args) {
		synchronized (RobotController.class){
		Session session = Connection.openSession();

		try {
			RobotService.createRobot(session, "Charlie", 10, 4, 5, 3);
			Thread.sleep(5000);

		} catch (Exception e) {
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
			e.printStackTrace();
		}

			try {
				RobotService.readRobot(session,7);
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}

		try {
			RobotService.updateRobot(session, 7, "Rebecca", 20, 10, 5, 3);
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}


		try {
			RobotService.readRobot(session,7);
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}


		try{
			RobotService.readAllRobots(session);
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}


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
}
