package btc.com.Entities;

import btc.com.Model.MapItem;
import jakarta.persistence.*;

import java.util.List;

@Entity(name = "Map")
@Table (name = "map")
public class MapEntity {
	@Column(name = "map_id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column (name = "mapSizeX")
	private int mapSizeX;
	@Column (name = "mapSize")
	private int mapSize;
	@OneToMany (mappedBy = "map", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<MapItem> mapItems;
	@Column (name = "mapArray")
	private String[] mapArray;

	public MapEntity() {
	}

	public MapEntity(int mapSizeX, int mapSize, List<MapItem> mapItems, String[] mapArray) {
		if (mapSizeX <= 0 || mapSize <= 0) {
			throw new IllegalArgumentException("Map size must be positive");
		}
		this.mapSizeX = mapSizeX;
		this.mapSize = mapSize;
		this.mapItems = mapItems;
		this.mapArray = mapArray;
	}

	public int getId() {
		return id;
	}

	public int getMapSizeX() {
		return mapSizeX;
	}

	public void setMapSizeX(int mapSizeX) {
		this.mapSizeX = mapSizeX;
	}

	public int getMapSize() {
		return mapSize;
	}

	public void setMapSize(int mapSize) {
		this.mapSize = mapSize;
	}

	public List<MapItem> getMapItems() {
		return mapItems;
	}

	public void setMapItems(List<MapItem> mapItems) {
		this.mapItems = mapItems;
	}

	public String[] getMapArray() {
		return mapArray;
	}

	public void setMapArray(String[] mapArray) {
		this.mapArray = mapArray;
	}
}