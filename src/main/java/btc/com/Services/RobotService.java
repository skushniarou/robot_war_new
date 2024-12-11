package btc.com.Services;

import btc.com.Entities.RobotEntity;
import btc.com.hibernate.Connection;
import btc.com.hibernate.KundeEntity;
import org.hibernate.Session;

public class RobotService {

	public static void createRobot( Session session, String name, int health, int attackDamage, int attackRange, int movementRate) {

		try {
			session.beginTransaction();
			RobotEntity robot = new RobotEntity();
			robot.setName(name);
			robot.setHealth(health);
			robot.setAttackDamage(attackDamage);
			robot.setAttackRange(attackRange);
			robot.setMovementRate(movementRate);

			session.persist(robot);
			session.getTransaction().commit();
			System.out.println("Roboter mit " + robot.getId() + " wurde erstellt.");
		} catch (Exception e) {
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
			e.printStackTrace();
		}
	}

	public static void updateRobot(Session session, int robotId, String name, int health, int attackDamage, int attackRange, int movementRate) {
		session.beginTransaction();
		RobotEntity robot = session.get(RobotEntity.class, robotId);
		if (robot != null) {
			robot.setName(name);
			robot.setHealth(health);
			robot.setAttackDamage(attackDamage);
			robot.setAttackRange(attackRange);
			robot.setMovementRate(movementRate);

			session.merge(robot);
			session.getTransaction().commit();
			System.out.println("Roboter mit ID " + robotId + " wurde aktualisiert.");
		} else {
			System.out.println("Roboter mit ID " + robotId + " wurde nicht gefunden.");
		}
	}

	public static void readRobot(Session session, int robotId){
		RobotEntity robot = session.get(RobotEntity.class, robotId);
		if (robot != null) {
			System.out.println(robot.getId()+", "
					+robot.getName()+", "
					+robot.getHealth()+", "
					+robot.getAttackDamage()+", "
					+robot.getAttackRange()+", "
					+robot.getMovementRate());
		} else {
			System.out.println("Roboter mit ID " + robotId + " wurde abgefragt.");
		}
	}

	public static void deleteRobot(Session session, int robotId) {
		session.beginTransaction();
		RobotEntity robot = session.get(RobotEntity.class, robotId);
		if (robot != null) {
			session.remove(robot);
			session.getTransaction().commit();
			System.out.println("Roboter mit ID " + robotId + " wurde gelöscht.");
		} else {
			System.out.println("Roboter mit ID " + robotId + " wurde nicht gefunden.");
		}
	}
}