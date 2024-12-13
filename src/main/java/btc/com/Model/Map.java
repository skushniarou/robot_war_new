package btc.com.Model;

import btc.com.Interfaces.MapInterface;
import btc.com.Factorys.MapItemFactory;

public class Map implements MapInterface {
	private int id;
	private int mapSizeX;
	private int mapSize;
	private MapItem[] mapItems;

	public Map(int id, int mapSizeX, int mapSize, MapItem[] rawMapItems) {
		if (mapSizeX <= 0 || mapSize <= 0) {
			throw new IllegalArgumentException("Map size must be positive");
		}
		this.id = id;
		this.mapSizeX = mapSizeX;
		this.mapSize = mapSize;
		this.mapItems = new MapItem[mapSize];
	}

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
	public MapItem[] getMapItems() {
		return mapItems;
	}
}
