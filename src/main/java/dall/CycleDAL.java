package dall;

import Entities.Cycle;

import javax.persistence.EntityManager;
public class CycleDAL {

    private final EntityManager em;

    public CycleDAL() {
        this.em = ConnectionDAL.getConnection();
    }

    public void saveCycle(Cycle cycle) {
        em.getTransaction().begin();
        em.persist(cycle);
        em.getTransaction().commit();
    }
}


