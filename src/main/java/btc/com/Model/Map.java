package btc.com.Model;

import btc.com.Interfaces.MapInterface;
import java.util.List;

public class Map implements MapInterface {
	private int id; // Einzigartige ID der Karte
	private int mapSizeX; // Größe der X-Achse
	private int mapSize; // Gesamtgröße der Karte
	private List<MapItem> mapItems; // Liste der MapItems
	private String[] mapArray; // Eindimensionales Array für die Karte als Strings

	// Konstruktor
	public Map(int id, int mapSizeX, int mapSize, List<MapItem> mapItems) {
		if (mapSizeX <= 0 || mapSize <= 0) {
			throw new IllegalArgumentException("Map size must be positive");
		}
		this.id = id;
		this.mapSizeX = mapSizeX;
		this.mapSize = mapSize;
		this.mapItems = mapItems;
		this.mapArray = new String[mapSize]; // Initialisiere das Array basierend auf der Karten-Größe
		populateMapArray(); // Befülle das Array basierend auf den MapItems
	}

	// Getter-Methoden
	@Override
	public int getId() {
		return id;
	}

	@Override
	public int getMapSizeX() {
		return mapSizeX;
	}

	@Override
	public int getMapSize() {
		return mapSize;
	}

	@Override
	public List<MapItem> getMapItems() {
		return mapItems;
	}

	@Override
	public String[] getMapArray() {
		return mapArray;
	}

	// Private Methode zum Befüllen des Arrays
	private void populateMapArray() {
		// Initialisiere das Array mit leeren Strings
		for (int i = 0; i < mapArray.length; i++) {
			mapArray[i] = ""; // Standardwert
		}

		// Füge die MapItems ins Array ein
		for (MapItem item : mapItems) {
			int index = item.getIndex(); // Index des Items
			if (index < mapArray.length) {
				mapArray[index] = item.getType().toString(); // Speichere den Typ des Items als String
			}
		}
	}

	@Override
	public String toString() {
		StringBuilder mapArrayStr = new StringBuilder("[");
		for (String cell : mapArray) {
			mapArrayStr.append(cell.isEmpty() ? "EMPTY" : cell).append(", ");
		}
		if (mapArray.length > 0) {
			mapArrayStr.setLength(mapArrayStr.length() - 2); // Entferne das letzte Komma
		}
		mapArrayStr.append("]");

		return "Map {" +
				"id=" + id +
				", mapSizeX=" + mapSizeX +
				", mapSize=" + mapSize +
				", mapItems=" + mapItems +
				", mapArray=" + mapArrayStr +
				'}';
	}
}
