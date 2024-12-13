package btc.com.Services;

import btc.com.Entities.MapEntity;
import btc.com.hibernate.Connection;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class MapService {

	public MapEntity getMap(int id) {
		Session session = Connection.openSession();
		try {
			Query<MapEntity> query = session.createQuery(
					"SELECT m FROM MapEntity m LEFT JOIN FETCH m.mapItems WHERE m.id = :id",
					MapEntity.class
			);
			query.setParameter("id", id);
			MapEntity map = query.uniqueResult();
			if (map == null) {
				throw new IllegalArgumentException("Map with ID " + id + " not found");
			}
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			Connection.closeSession(session);
		}
	}

	public List<MapEntity> getAllMaps() {
		Session session = Connection.openSession();
		try {
			Query<MapEntity> query = session.createQuery(
					"SELECT m FROM MapEntity m", // Keine MapItems laden
					MapEntity.class
			);
			return query.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			Connection.closeSession(session);
		}
	}
}
