package btc.com.Entities;

import jakarta.persistence.*;
import java.util.List;

@Entity(name = "GameEntity")
@Table(name = "game")
public class GameEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "game_id")
	private int id;

	@Column(name = "map_id", nullable = false)
	private int mapId;

	@Column(name = "status", nullable = false)
	private String status;

	@Column(name = "players")
	private String players;

	public GameEntity() {}

	public GameEntity(int mapId, String status, String players) {
		this.mapId = mapId;
		this.status = status;
		this.players = players;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMapId() {
		return mapId;
	}

	public void setMapId(int mapId) {
		this.mapId = mapId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPlayers() {
		return players;
	}

	public void setPlayers(String players) {
		this.players = players;
	}
}
