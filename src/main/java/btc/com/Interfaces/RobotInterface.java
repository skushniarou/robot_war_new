package btc.com.Interfaces;

import btc.com.Model.Robot;

public interface RobotInterface {
	int getId();
	String getName();
	int getHealth();
	int getAttackDamage();
	int getAttackRange();
	int getMovementRate();
	void takeDamage(int damage);
	boolean isAlive();

	static Robot create(int id, String name, int health, int attackDamage, int attackRange, int movementRate) {
		if (id <= 0){
			throw new IllegalArgumentException("ID cannot be 0 or negative");
		}
		if (name == null || name.trim().isEmpty()) {
			throw new IllegalArgumentException("Robot name cannot be null or empty");
		}
		if (health <= 0) {
			throw new IllegalArgumentException("Health cannot be 0 or negative");
		}
		if (attackDamage <= 0) {
			throw new IllegalArgumentException("Attack Damage cannot be 0 or negative");
		}
		if (attackRange <= 0) {
			throw new IllegalArgumentException("Attack range cannot be 0 or negative");
		}
		if (movementRate <= 0) {
			throw new IllegalArgumentException("Movement rate must be greater than 0");
		}
		return new Robot(id, name, health, attackDamage, attackRange, movementRate);
	}
}
