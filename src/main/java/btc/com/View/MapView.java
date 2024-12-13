package btc.com.View;

import btc.com.Entities.MapEntity;
import btc.com.Entities.MapItemEntity;

import java.util.List;

public class MapView {
	public static void printMapAs2D(MapEntity map) {
		int mapSizeX = map.getMapSizeX();
		int mapSize = map.getMapSize();
		List<MapItemEntity> mapItems = map.getMapItems();

		final int cellWidth = 9;

		for (int i = 0; i < mapSize; i++) {
			if (i % mapSizeX == 0 && i != 0) {
				System.out.println(); // Zeilenumbruch bei Spaltenende
			}

			int finalI = i;
			MapItemEntity item = mapItems.stream()
					.filter(mi -> mi.getIndex() == finalI)
					.findFirst()
					.orElse(null);

			String cellContent;
			if (item != null) {
				cellContent = item.getType().toString(); // Typ des Items
			} else {
				cellContent = " "; // Leere Zelle
			}
			System.out.print(formatCell(cellContent, cellWidth));
		}
		System.out.println();
	}

	private static String formatCell(String content, int width) {
		String formatted = "[ " + content.trim();
		while (formatted.length() < width - 1) formatted += " ";
		formatted += "]";
		return formatted;
	}
}
