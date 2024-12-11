package btc.com.Entities;

import jakarta.persistence.*;

@Entity(name = "MapItem")
@Table (name = "map_item")
public class MapItemEntity {
	@Column(name = "map_item_id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "type")
	private String type;
	@Column(name = "index")
	private int index;
	@Column(name = "properties")
	private String properties;

	public MapItemEntity() {
	}

	public MapItemEntity(String type, int index, String properties) {
		if (index < 0) {
			throw new IllegalArgumentException("Index cannot be negative");
		}
		this.type = type;
		this.index = index;
		this.properties = properties;
	}

	public int getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getProperties() {
		return properties;
	}

	public void setProperties(String properties) {
		this.properties = properties;
	}
}
