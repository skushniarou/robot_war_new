package btc.com;

import btc.com.Enums.MapItemType;
import btc.com.Factorys.MapItemFactory;
import btc.com.Model.Item;
import btc.com.Model.MapItem;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MapItemFactoryTest {

	@Test
	void testCreateMapItemFromIndexValid() {
		// Test für Index 1 (ROBOT)
		MapItem robot = MapItemFactory.createMapItemFromIndex(1);
		assertEquals(MapItemType.ROBOT, robot.getType());
		assertEquals(1, robot.getIndex());
		assertNull(robot.getProperties(), "Robot should not have properties (not implemented now)");

		// Test für Index 2 (ITEM)
		MapItem itemMapItem = MapItemFactory.createMapItemFromIndex(2);
		assertEquals(MapItemType.ITEM, itemMapItem.getType());
		assertEquals(2, itemMapItem.getIndex());
		assertNotNull(itemMapItem.getProperties(), "Item should have properties");
		assertTrue(itemMapItem.getProperties() instanceof Item, "Properties should be of type Item");

		// Test für Index 3 (WALL)
		MapItem wall = MapItemFactory.createMapItemFromIndex(3);
		assertEquals(MapItemType.WALL, wall.getType());
		assertEquals(3, wall.getIndex());
		assertNull(wall.getProperties(), "Walls should not have properties (not implemented now)");
	}

	@Test
	void testCreateFromInvalidIndex() {
		// Ungültige Indizes
		assertThrows(IllegalArgumentException.class, () -> MapItemFactory.createMapItemFromIndex(0));
		assertThrows(IllegalArgumentException.class, () -> MapItemFactory.createMapItemFromIndex(-1));
		assertThrows(IllegalArgumentException.class, () -> MapItemFactory.createMapItemFromIndex(99999999));
	}

	@Test
	void testRandomItemProperties() {
		// Sicherstellen, dass ein Item vom Typ ITEM zufällig erstellt wird
		MapItem itemMapItem = MapItemFactory.createMapItemFromIndex(2);
		assertNotNull(itemMapItem.getProperties(), "Item properties should not be null");

		Item item = (Item) itemMapItem.getProperties();
		assertNotNull(item.getType(), "Item type should not be null");
	}
}