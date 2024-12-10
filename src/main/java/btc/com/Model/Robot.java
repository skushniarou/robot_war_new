package btc.com.Model;

import btc.com.Interfaces.RobotInterface;

public class Robot implements RobotInterface {
	private int id;
	private String name;
	private int health;
	private int attackDamage;
	private int attackRange;
	private int movementRate;

	// Constructor
	public Robot(int id, String name, int health, int attackDamage, int attackRange, int movementRate) {
		this.id = id;
		this.name = name;
		this.health = health;
		this.attackDamage = attackDamage;
		this.attackRange = attackRange;
		this.movementRate = movementRate;
	}

	// Getter methods
	@Override
	public int getId() {
		return id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getHealth() {
		return health;
	}

	@Override
	public int getAttackDamage() {
		return attackDamage;
	}

	public void setAttackDamage(int attackDamage) {
		this.attackDamage = attackDamage;
	}

	@Override
	public int getAttackRange() {
		return attackRange;
	}

	public void setAttackRange(int attackRange) {
		this.attackRange = attackRange;
	}

	@Override
	public int getMovementRate() {
		return movementRate;
	}

	public void setMovementRate(int movementRate) {
		this.movementRate = movementRate;
	}

	@Override
	public void takeDamage(int damage) {
		this.health -= damage;
	}

	@Override
	public boolean isAlive() {
		return this.health > 0;
	}

	@Override
	public String toString() {
		return "Robot {" +
				"id=" + id +
				", name='" + name + '\'' +
				", health=" + health +
				", attackDamage=" + attackDamage +
				", attackRange=" + attackRange +
				", movementRate=" + movementRate +
				'}';
	}
}
