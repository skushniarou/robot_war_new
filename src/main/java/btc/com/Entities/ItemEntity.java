package btc.com.Entities;

import btc.com.Enums.ItemType;
import jakarta.persistence.*;

@Entity(name = "Item")
@Table(name = "items")
public class ItemEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "item_id")
	private int id;

	@Enumerated(EnumType.STRING)
	@Column(name = "item_type", nullable = false)
	private ItemType type;

	public ItemEntity() {}

	public ItemEntity(ItemType type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public ItemType getType() {
		return type;
	}

	public void setType(ItemType type) {
		this.type = type;
	}
}