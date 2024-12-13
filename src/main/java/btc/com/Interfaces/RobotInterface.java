package btc.com.Interfaces;

public interface RobotInterface {
	int getId();
	String getName();
	void setName(String name);
	int getHealth();
	void setHealth(int health);
	int getAttackDamage();
	void setAttackDamage(int attackDamage);
	int getAttackRange();
	void setAttackRange(int attackRange);
	int getMovementRate();
	void setMovementRate(int movementRate);
}

