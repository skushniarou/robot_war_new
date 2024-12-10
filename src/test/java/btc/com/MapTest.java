package btc.com;

import btc.com.Model.Map;
import btc.com.Model.MapItem;
import org.junit.jupiter.api.Test;
import btc.com.Enums.MapItemType;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MapTest {

	@Test
	void testMapCreationValid() {
		// Benötigte MapItems und Map erstellen
		MapItem item1 = new MapItem(MapItemType.ROBOT, 1, null);
		MapItem item2 = new MapItem(MapItemType.ITEM, 2, null);
		List<MapItem> mapItems = Arrays.asList(item1, item2);
		Map map = new Map(1234, 10, 100, mapItems);

		assertEquals(1234, map.getId(), "Map ID should be 1234");
		assertEquals(10, map.getMapSizeX(), "Map size X should be 10");
		assertEquals(100, map.getMapSize(), "Map size should be 100");
		assertEquals(mapItems, map.getMapItems(), "Map items should match the input list");

		String[] mapArray = map.getMapArray();
		assertEquals("ROBOT", mapArray[1], "Array index 1 should contain ROBOT");
		assertEquals("ITEM", mapArray[2], "Array index 2 should contain ITEM");
		assertEquals("", mapArray[0], "Array index 0 should be empty");
		assertEquals("", mapArray[3], "Array index 3 should be empty");
	}

	@Test
	void testEmptyMapItems() {
		// Benötigte MapItemsListe und Map erstellen
		List<MapItem> emptyMapItems = Arrays.asList();
		Map map = new Map(1234, 10, 100, emptyMapItems);

		assertEquals(1234, map.getId());
		assertEquals(10, map.getMapSizeX());
		assertEquals(100, map.getMapSize());
		assertEquals(emptyMapItems, map.getMapItems(), "Map items should be an empty list");

		String[] mapArray = map.getMapArray();
		for (String cell : mapArray) {
			assertEquals("", cell, "Array cells should be empty for empty map items");
		}
	}

	@Test
	void testInvalidMapSize() {
		assertThrows(IllegalArgumentException.class, () -> new Map(1234, 0, 100, null),
				"Map size X cannot be zero or negative");
		assertThrows(IllegalArgumentException.class, () -> new Map(1234, 10, -1, null),
				"Map size cannot be zero or negative");
	}

	@Test
	void testToString() {
		// Benötigte MapItems und Map erstellen
		MapItem item1 = new MapItem(MapItemType.ROBOT, 1, null);
		MapItem item2 = new MapItem(MapItemType.ITEM, 2, null);
		List<MapItem> mapItems = Arrays.asList(item1, item2);
		Map map = new Map(1234, 10, 100, mapItems);

		// Erwartet
		String expected = "Map {id=1234, mapSizeX=10, mapSize=100, mapItems=[MapItem {type=ROBOT, index=1, properties=null}, MapItem {type=ITEM, index=2, properties=null}], mapArray=[, ROBOT, ITEM, , , , , , , ]}";
		assertEquals(expected, map.toString(), "toString should return the correct format");
	}
}