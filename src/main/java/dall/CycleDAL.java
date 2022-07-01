package dall;

import Entities.Cycle;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class CycleDAL {

    private final EntityManager em;

    public CycleDAL(EntityManager em) {
        this.em = ConnectionDAL.getConnection();
    }

    public void saveCycle(Cycle cycle) {
        em.getTransaction().begin();
        em.persist(cycle);
        em.getTransaction().commit();
    }
}


