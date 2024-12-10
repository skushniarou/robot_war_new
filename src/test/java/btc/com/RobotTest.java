package btc.com;

import btc.com.Interfaces.RobotInterface;
import btc.com.Model.Robot;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RobotTest {
	@Test
	void testCreateRobot() {
		Robot robot = RobotInterface.create(1, "Bobby", 10, 3, 3, 4);

		assertEquals(1, robot.getId());
		assertEquals("Bobby", robot.getName());
		assertEquals(10, robot.getHealth());
		assertEquals(3, robot.getAttackDamage());
		assertEquals(3, robot.getAttackRange());
		assertEquals(4, robot.getMovementRate());
	}

	@Test
	void testCreateRobotWithInvalidValues() {
		assertThrows(IllegalArgumentException.class, () ->
						RobotInterface.create(0, "Olaf",10,10,10,10),
				"Should throw an exception for id = 0");
		assertThrows(IllegalArgumentException.class, () ->
						RobotInterface.create(-1, "Olaf",10,10,10,10),
				"Should throw an exception for negative id");
		assertThrows(IllegalArgumentException.class, () ->
						RobotInterface.create(1,"Olaf", 0, 10, 10, 10),
				"Should throw an exception for health = 0"
		);
		assertThrows(IllegalArgumentException.class, () ->
						RobotInterface.create(1,"Olaf", -10, 10, 10, 10),
				"Should throw an exception for negative health"
		);
		assertThrows(IllegalArgumentException.class, () ->
						RobotInterface.create(1,"Olaf", 10, 0, 10, 10),
				"Should throw an exception for attack damage = 0"
		);
		assertThrows(IllegalArgumentException.class, () ->
						RobotInterface.create(1,"Olaf", 10, -10, 10, 10),
				"Should throw an exception for negative attack damage"
		);
		assertThrows(IllegalArgumentException.class, () ->
						RobotInterface.create(1,"Olaf", 10, 10, 0, 10),
				"Should throw an exception for attack range = 0"
		);
		assertThrows(IllegalArgumentException.class, () ->
						RobotInterface.create(1,"Olaf", 10, 10, -10, 10),
				"Should throw an exception for negative attack range "
		);
		assertThrows(IllegalArgumentException.class, () ->
						RobotInterface.create(1,"Olaf", 10, 10, 10, 0),
				"Should throw an exception for movement rate = 0"
		);
		assertThrows(IllegalArgumentException.class, () ->
						RobotInterface.create(1,"Olaf", 10, 10, 10, -10),
				"Should throw an exception for negative movement rate"
		);
	}

	@Test
	void testCreateRobotWithEmptyName(){
		assertThrows(IllegalArgumentException.class, () ->
						RobotInterface.create(1,"", 1, 2, 3, 4),
				"Should throw an exception for empty name"
		);
		assertThrows(IllegalArgumentException.class, () ->
						RobotInterface.create(1,null, 1, 2, 3, 4),
				"Should throw an exception for null name"
		);
	}

	@Test
	void testTakeDamage() {
		Robot robot = new Robot(1, "Bobby", 10, 3, 3, 4);

		robot.takeDamage(2);
		assertEquals(8, robot.getHealth(), "Health should be reduced by 2");

		robot.takeDamage(8);
		assertEquals(0, robot.getHealth(), "Health should be reduced by 10 and can equal 0");

		robot.takeDamage(1);
		assertEquals(-1, robot.getHealth(), "Health can drop below 0");
	}

	@Test
	void testIsAlive() {
		Robot robot = new Robot(1, "Bobby", 10, 3, 3, 4);

		assertTrue(robot.isAlive(), "Robot should be alive initially");

		robot.takeDamage(10);
		assertFalse(robot.isAlive(), "Robot should not be alive after health reaches 0");

		robot.takeDamage(1);
		assertFalse(robot.isAlive(), "Robot should not be alive after health falls below 0");
	}

	@Test
	void testToString() {
		Robot robot = new Robot(1, "Bobby", 10, 3, 3, 4);
		String expected = "Robot {id=1, name='Bobby', health=10, attackDamage=3, attackRange=3, movementRate=4}";

		assertEquals(expected, robot.toString(), "toString should return the correct format");
	}

}