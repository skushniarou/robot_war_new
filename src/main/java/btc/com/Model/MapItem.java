package btc.com.Model;

import btc.com.Enums.MapItemType;
import btc.com.Interfaces.MapItemInterface;

public class MapItem implements MapItemInterface {

	private MapItemType type;
	private int index;

	public MapItem(MapItemType type, int index) {
		this.type = type;
		this.index = index;
	}

	@Override
	public MapItemType getType() {
		return type;
	}

	@Override
	public int getIndex() {
		return index;
	}
}