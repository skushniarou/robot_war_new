package btc.com.Model;

import btc.com.Entities.ItemEntity;
import btc.com.Enums.ItemType;

public class Item {

	private ItemType type;

	public Item(ItemType type) {
		this.type = type;
	}

	public Item(ItemEntity entity) {
		this.type = entity.getType();
	}

	public ItemType getType() {
		return type;
	}

	public void applyToRobot(Robot robot) {
		switch (type) {
			case ATTACK_DAMAGE:
				robot.setAttackDamage(robot.getAttackDamage() + 10);
				break;
			case ATTACK_RANGE:
				robot.setAttackRange(robot.getAttackRange() + 5);
				break;
			case MOVEMENT_RATE:
				robot.setMovementRate(robot.getMovementRate() + 2);
				break;
			default:
				throw new IllegalArgumentException("Unknown ItemType: " + type);
		}
	}
}