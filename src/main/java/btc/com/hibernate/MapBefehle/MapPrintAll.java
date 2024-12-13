package btc.com.hibernate.MapBefehle;

import btc.com.Entities.MapEntity;
import btc.com.Services.MapService;

import java.util.List;

public class MapPrintAll {
	public static void main(String[] args) {
		MapService mapService = new MapService();

		// Alle Maps abrufen und ausgeben
		try {
			List<MapEntity> allMaps = mapService.getAllMaps();
			for (MapEntity map : allMaps) {
				System.out.println("Karte ID: " + map.getId());
				System.out.println("Kartenname: " + map.getMapName());
				System.out.println("Kartenbreite: " + map.getMapSizeX());
				System.out.println("Kartengröße: " + map.getMapSize());
				System.out.println("-------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
