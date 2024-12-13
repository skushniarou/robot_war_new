package btc.com.Entities;


import btc.com.Enums.MapItemType;
import jakarta.persistence.*;

@Entity(name = "MapItemEntity")
@Table (name = "map_item")
public class MapItemEntity {
	@Column(name = "map_item_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private MapItemType type;
	@Column(name = "index_position", nullable = false)
	private int index;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "map_id", nullable = false)
	private MapEntity map;

	public MapItemEntity() {}

	public MapItemEntity(MapItemType type, int index) {
		if (index < 0) {
			throw new IllegalArgumentException("Index cannot be negative");
		}
		this.type = type;
		this.index = index;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public MapItemType getType() {
		return type;
	}

	public void setType(MapItemType type) {
		this.type = type;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public MapEntity getMap() {
		return map;
	}

	public void setMap(MapEntity map) {
		this.map = map;
	}
}
