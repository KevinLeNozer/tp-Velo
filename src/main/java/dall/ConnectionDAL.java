package dall;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
public class ConnectionDAL {
    private static EntityManagerFactory entityManager = Persistence.createEntityManagerFactory("tp-cycles");

    public ConnectionDAL() {
    }

    public static EntityManager getConnection() {
        return entityManager.createEntityManager();
    }
}
