package dall;

import Entities.Client;

import javax.persistence.EntityManager;
public class ClientDAL {
    private final EntityManager em;

    public ClientDAL() {
     this.em = ConnectionDAL.getConnection();
    }

    public void saveClient(Client client) {
        em.getTransaction().begin();
        em.persist(client);
        em.getTransaction().commit();
    }

}
