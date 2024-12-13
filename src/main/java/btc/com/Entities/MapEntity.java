package btc.com.Entities;

import btc.com.Model.MapItem;
import jakarta.persistence.*;

import java.util.List;

@Entity(name = "MapEntity")
@Table (name = "map")
public class MapEntity {
	@Column(name = "map_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column (name = "mapSizeX", nullable = false)
	private int mapSizeX;
	@Column (name = "mapSize", nullable = false)
	private int mapSize;
	@Column(name = "map_name", nullable = false)
	private String mapName;

	@OneToMany(mappedBy = "map", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<MapItemEntity> mapItems;

	public MapEntity() {
	}

	public MapEntity(String mapName, int mapSizeX, int mapSize, List<MapItemEntity> mapItems) {
		if (mapSizeX <= 0 || mapSize <= 0) {
			throw new IllegalArgumentException("Map size must be positive");
		}
		this.mapName = mapName;
		this.mapSizeX = mapSizeX;
		this.mapSize = mapSize;
		this.mapItems = mapItems;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getMapName() {
		return mapName;
	}

	public void setMapName(String mapName) {
		this.mapName = mapName;
	}

	public List<MapItemEntity> getMapItems() {
		return mapItems;
	}

	public void setMapItems(List<MapItemEntity> mapItems) {
		this.mapItems = mapItems;
	}
}