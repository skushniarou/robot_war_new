package btc.com;

import btc.com.Enums.MapItemType;
import btc.com.Model.Item;
import btc.com.Model.MapItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapItemTest {

	@Test
	void testMapItemCreation() {
		// Test für gültige MapItem nach Typ: Robot
		MapItem robot = new MapItem(MapItemType.ROBOT, 1, null);
		assertEquals(MapItemType.ROBOT, robot.getType(), "Type should be ROBOT");
		assertEquals(1, robot.getIndex(), "Index should be 1");
		assertNull(robot.getProperties(), "Robot should have null properties (not implemented now)");

		// Test für gültige MapItem nach Typ: Item
		Item itemProperties = new Item(btc.com.Enums.ItemType.ATTACK_DAMAGE);
		MapItem item = new MapItem(MapItemType.ITEM, 2, itemProperties);
		assertEquals(MapItemType.ITEM, item.getType(), "Type should be ITEM");
		assertEquals(2, item.getIndex(), "Index should be 2");
		assertNotNull(item.getProperties(), "Item should have properties");
		assertInstanceOf(Item.class, item.getProperties(), "Properties should be of type Item");


		// Test für gültige MapItem nach Typ: Item
		MapItem wall = new MapItem(MapItemType.WALL, 3, null);
		assertEquals(MapItemType.WALL, wall.getType(), "Type should be WALL");
		assertEquals(3, wall.getIndex(), "Index should be 3");
		assertNull(robot.getProperties(), "Wall should have null properties (not implemented now)");
	}

	@Test
	void testMapItemCreationWithInvalidIndex() {
		// Test für negative index -> Position in Array
		assertThrows(IllegalArgumentException.class, () -> new MapItem(MapItemType.ROBOT, -1, null),
				"Index cannot be 0 or negative");
	}

	@Test
	void testToString() {
		MapItem wall = new MapItem(MapItemType.WALL, 3, null);
		String expected = "MapItem {type=WALL, index=3}";
		assertEquals(expected, wall.toString(), "toString should return the correct format");
	}
}