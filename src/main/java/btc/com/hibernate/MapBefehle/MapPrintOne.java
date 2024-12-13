package btc.com.hibernate.MapBefehle;

import btc.com.Entities.MapEntity;
import btc.com.Services.MapService;

import static btc.com.View.MapView.printMapAs2D;

public class MapPrintOne {
	public static void main(String[] args) {
		MapService mapService = new MapService();

		try {
			// Abrufen einer spezifischen Karte
			MapEntity map = mapService.getMap(1);
			System.out.println("Kartenname: " + map.getMapName());
			System.out.println("Karte ID: " + map.getId());
			System.out.println("Karte Größe: " + map.getMapSize());
			System.out.println("Map Darstellung:");
			printMapAs2D(map);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}
}
