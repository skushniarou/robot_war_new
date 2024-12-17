package btc.com.Entities;

import jakarta.persistence.*;

@Entity(name = "PlayerEntity")
@Table(name = "player")
public class PlayerEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "player_id")
	private int id;

	@Column(name = "robot_id", nullable = false)
	private int robotId;

	public PlayerEntity() {}

	public PlayerEntity(int robotId) {
		this.robotId = robotId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRobotId() {
		return robotId;
	}

	public void setRobotId(int robotId) {
		this.robotId = robotId;
	}
}
