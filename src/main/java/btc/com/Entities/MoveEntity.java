package btc.com.Entities;

import jakarta.persistence.*;

@Entity(name = "MoveEntity")
@Table(name = "move")
public class MoveEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "move_id")
	private int id;

	@Column(name = "player_id", nullable = false)
	private int playerId;

	@Column(name = "movent_type", nullable = false)
	private String moventType;

	@Column(name = "map_index", nullable = false)
	private int mapIndex;

	@Column(name = "parameter", nullable = false)
	private String parameter;

	@Column(name = "game_id", nullable = false)
	private int gameId;

	public MoveEntity() {}

	public MoveEntity(int playerId, String moventType, int mapIndex, String parameter, int gameId) {
		this.playerId = playerId;
		this.moventType = moventType;
		this.mapIndex = mapIndex;
		this.parameter = parameter;
		this.gameId = gameId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public String getMoventType() {
		return moventType;
	}

	public void setMoventType(String moventType) {
		this.moventType = moventType;
	}

	public int getMapIndex() {
		return mapIndex;
	}

	public void setMapIndex(int mapIndex) {
		this.mapIndex = mapIndex;
	}

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
}
