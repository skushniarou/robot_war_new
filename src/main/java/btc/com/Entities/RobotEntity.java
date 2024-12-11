package btc.com.Entities;

import jakarta.persistence.*;

@Entity(name = "Robot")
@Table (name = "robot")
public class RobotEntity {
	@Column(name = "robot_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "health")
	private int health;
	@Column(name = "attack_damage")
	private int attackDamage;
	@Column(name = "attack_range")
	private int attackRange;
	@Column(name = "movement_range")
	private int movementRate;

	public RobotEntity() {}

	public RobotEntity(String name, int health, int attackDamage, int attackRange, int movementRate) {
		this.name = name;
		this.health = health;
		this.attackDamage = attackDamage;
		this.attackRange = attackRange;
		this.movementRate = movementRate;
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
