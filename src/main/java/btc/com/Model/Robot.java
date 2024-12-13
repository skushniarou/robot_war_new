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

	public Robot() {}

	// Konstruktor zum Laden aus einer RobotEntity
	public Robot(btc.com.Entities.RobotEntity entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.health = entity.getHealth();
		this.attackDamage = entity.getAttackDamage();
		this.attackRange = entity.getAttackRange();
		this.movementRate = entity.getMovementRate();
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getAttackDamage() {
		return attackDamage;
	}

	public void setAttackDamage(int attackDamage) {
		this.attackDamage = attackDamage;
	}

	public int getAttackRange() {
		return attackRange;
	}

	public void setAttackRange(int attackRange) {
		this.attackRange = attackRange;
	}

	public int getMovementRate() {
		return movementRate;
	}

	public void setMovementRate(int movementRate) {
		this.movementRate = movementRate;
	}
}
