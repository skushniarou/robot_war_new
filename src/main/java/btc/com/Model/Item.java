package btc.com.Model;

import btc.com.Enums.ItemType;

public class Item {
	private ItemType type; // Typ des Items

	// Konstruktor
	public Item(ItemType type) {
		this.type = type;
	}

	public ItemType getType() {
		return type;
	}

	// Effekt des Items auf einen Roboter anwenden
	public void applyToRobot(Robot robot) {
		switch (type) {
			case ATTACK_DAMAGE:
				robot.setAttackDamage(robot.getAttackDamage() + 10); // Beispiel: Erhöhe Angriffsstärke um 10
				break;
			case ATTACK_RANGE:
				robot.setAttackRange(robot.getAttackRange() + 5); // Beispiel: Erhöhe Angriffsreichweite um 5
				break;
			case MOVEMENT_RATE:
				robot.setMovementRate(robot.getMovementRate() + 2); // Beispiel: Erhöhe Bewegungsrate um 2
				break;
			default:
				throw new IllegalArgumentException("Unknown ItemType: " + type);
		}
	}

	@Override
	public String toString() {
		return "Item {type=" + type + "}";
	}
}
