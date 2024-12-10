package btc.com.Interfaces;

import btc.com.Model.MapItem;
import java.util.List;

public interface MapInterface {
	int getId();
	int getMapSizeX();
	int getMapSize();
	List<MapItem> getMapItems();
	String[] getMapArray(); // Für das eindimensionale Array
}
