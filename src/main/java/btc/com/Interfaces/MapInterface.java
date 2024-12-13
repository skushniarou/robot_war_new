package btc.com.Interfaces;

import btc.com.Model.MapItem;

public interface MapInterface {
	int getId();
	int getMapSizeX();
	int getMapSize();
	MapItem[] getMapItems();
}
