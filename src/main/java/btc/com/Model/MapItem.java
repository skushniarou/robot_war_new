package btc.com.Model;

import btc.com.Enums.MapItemType;
import btc.com.Interfaces.MapItemInterface;

public class MapItem implements MapItemInterface {

	private MapItemType type; // Enum für Typ des Map-Items (z. B. ROBOT, ITEM, WALL)
	private int index; // ToDo: Sollte eine Position in Array Sein
	private Object properties; //ToDo: In Service reinpacken
								 /* Hier werden alle Daten von Objekt gespeichert, je nach Typ.
							      Wir nutzen Properties, weil die MapItemType-Liste kann
							      in jeder Moment erweitert werden*/

	// Constructor
	public MapItem(MapItemType type, int index, Object properties) {
		if (index < 0) {
			throw new IllegalArgumentException("Index cannot be negative");
		}
		this.type = type;
		this.index = index;
		this.properties = properties;
	}

	@Override
	public MapItemType getType() {
		return type;
	}

	@Override
	public int getIndex() {
		return index;
	}

	@Override
	public Object getProperties() {
		return properties;
	}

	@Override
	public String toString() {
		return "MapItem {" +
				"type=" + type +
				", index=" + index +
				'}';
	}

}
