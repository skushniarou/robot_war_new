package btc.com.Factorys;

import btc.com.Entities.ItemEntity;
import btc.com.Enums.ItemType;
import btc.com.Model.MapItem;

import java.util.Random;

public class MapItemFactory {

	public static MapItem createMapItemFromItemEntity(ItemEntity itemEntity, int index) {
		return new MapItem(btc.com.Enums.MapItemType.ITEM, index);
	}

	public static ItemEntity generateRandomItem() {
		ItemType[] types = ItemType.values();
		ItemType randomType = types[new Random().nextInt(types.length)];
		return new ItemEntity(randomType);
	}
}

