package btc.com;

import btc.com.Enums.ItemType;
import btc.com.Factorys.ItemFactory;
import btc.com.Model.Item;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ItemFactoryTest {

	// Test, ob ein zufälliges Item erstellt wird
	@Test
	void testCreateItem() {
		Item item = ItemFactory.createItem();
		assertNotNull(item, "Item should not be null");
		assertNotNull(item.getType(), "Item type should not be null");
	}

	// Test, ob das erstellte Item einen gültigen ItemType hat
	@Test
	void testCreateItemGeneratesValidType() {
		Item item = ItemFactory.createItem();
		ItemType type = item.getType();

		boolean isValidType = false;
		for (ItemType validType : ItemType.values()) {
			if (validType == type) {
				isValidType = true;
				break;
			}
		}

		assertTrue(isValidType, "Item type should be one of the valid ItemType values");
	}
}