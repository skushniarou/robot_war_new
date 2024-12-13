package btc.com.Controller;
import btc.com.Services.MapService;
import btc.com.Entities.MapEntity;

import java.util.List;

public class MainController {
	public static void main(String[] args) {
		MapService mapService = new MapService();

		try {
		List<MapEntity> allMaps = mapService.getAllMaps();
		for (MapEntity map : allMaps) {
			System.out.println("Karte: " + map);
		}
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

	}
}
