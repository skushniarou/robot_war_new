package btc.com.Factorys;

import btc.com.Enums.ItemType;
import btc.com.Model.Item;

import java.util.Random;

public class ItemFactory {
	private static final Random RANDOM = new Random();

	public static Item createItem() {
		ItemType[] itemTypes = ItemType.values();

		// Zufälligen Index generieren
		int randomIndex = RANDOM.nextInt(itemTypes.length);
		return new Item(itemTypes[randomIndex]);
	}
}
