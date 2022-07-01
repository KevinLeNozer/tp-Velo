package dall;

import Entities.Location;

import javax.persistence.EntityManager;

public class LocationDAL {
    private final EntityManager em;

    public LocationDAL() {
        this.em = ConnectionDAL.getConnection();
    }

    public void saveLocation(Location location) {
        em.getTransaction().begin();
        em.persist(location);
        em.getTransaction().commit();
    }
}
