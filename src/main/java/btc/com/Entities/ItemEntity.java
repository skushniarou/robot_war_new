package btc.com.Entities;

import jakarta.persistence.*;

@Entity(name = "Item")
@Table (name = "item")
public class ItemEntity {
	@Column(name = "item_id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "item_type")
	@Enumerated(EnumType.STRING)
	private String type;

	public ItemEntity() {
	}

	public ItemEntity(String type) {
		this.type = type;
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
}