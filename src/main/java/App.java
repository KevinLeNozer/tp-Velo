import Entities.Gyoropode;
import Entities.Gyroroue;
import Entities.Velo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory entityManager = Persistence.createEntityManagerFactory("tp-cycles");

        EntityManager em = entityManager.createEntityManager();

        LocalDate dateDachat = LocalDate.of(2020, 10, 24);
        LocalDate dateDachatGyro = LocalDate.of(2021, 8, 12);
        LocalDate dateDachatGyroroue = LocalDate.of(2019, 11, 5);
        Velo velo = new Velo("Rockrider", "VTT", dateDachat, 21, 4.90);
        Gyoropode gyropode = new Gyoropode("Naka", "Electrique", dateDachatGyro, 18.90, 50, 160);
        Gyroroue gyroroue = new Gyroroue("Naka", "Electrique", dateDachatGyroroue, 29.90, 30);


        em.getTransaction().begin();
        em.persist(gyroroue);
        em.persist(velo);
        em.persist(gyropode);
        em.getTransaction().commit();
    }
}
