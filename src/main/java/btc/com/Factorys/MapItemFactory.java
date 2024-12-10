package btc.com.Factorys;

import btc.com.Enums.MapItemType;
import btc.com.Model.Item;
import btc.com.Model.MapItem;

public class MapItemFactory {
	public static MapItem createMapItemFromIndex(int index) {
		// Zuweisung basierend auf Index
		switch (index) {
			case 1:
				return new MapItem(MapItemType.ROBOT, index, null);
			case 2:
				// Ein MapItem vom Typ ITEM zufällig generieren und zurückgeben
				Item randomItem = ItemFactory.createItem();
				return new MapItem(MapItemType.ITEM, index, randomItem);
			case 3:
				//ToDo: Verschiede Arten von Walls defenieren und implimintieren
				return new MapItem(MapItemType.WALL, index, null);
			default:
				throw new IllegalArgumentException("Invalid index: " + index + ". Must be 1 (ROBOT), 2 (ITEM), or 3 (WALL)");
		}
	}
}
