import Entities.*;
import dall.ClientDAL;
import dall.ConnectionDAL;
import dall.CycleDAL;
import dall.LocationDAL;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class App {
    public static void main(String[] args) {

        LocalDate dateDachat = LocalDate.of(2020, 10, 24);
        LocalDate dateDachatGyro = LocalDate.of(2021, 8, 12);
        LocalDate dateDachatGyroroue = LocalDate.of(2019, 11, 5);
        Velo velo = new Velo("Rockrider", "VTT", dateDachat, 21, 4.90);
        Gyoropode gyropode = new Gyoropode("Naka", "Electrique", dateDachatGyro, 18.90, 50, 160);
        Gyroroue gyroroue = new Gyroroue("Naka", "Electrique", dateDachatGyroroue, 29.90, 30);
        Set<Cycle> cycleList = new HashSet<>();
        cycleList.add(gyropode);
        cycleList.add(gyroroue);

        Client client = new Client("Toto", "Titi", 160, 30.00, new HashSet<Location>());
        Client client1 = new Client("Tata", "Tutu", 185, 30.00, new HashSet<Location>());
        Client client2 = new Client("Tonton", "Tictic", 175, 30.00, new HashSet<Location>());
        List<Client> clientList = new ArrayList<>();
        clientList.add(client1);
        clientList.add(client2);


        LocalDateTime dateDebutLocation = LocalDateTime.now();
        LocalDateTime dateFinLocation = LocalDateTime.now().plusWeeks(1);
        Location location = new Location();
        location.setDateDebutLocation(dateDebutLocation);
        location.setDateFinLocation(dateFinLocation);
        location.setLocationHeurs(2);
        location.setClient(client);
        client.getLocations().add(location);
        velo.getLocations().add(location);
        location.getCycles().add(velo);

        ConnectionDAL connectionDAL = new ConnectionDAL();

        EntityManager em = connectionDAL.getConnection();

        CycleDAL cycleDal = new CycleDAL();
        ClientDAL clientDal = new ClientDAL();
        LocationDAL locationDal = new LocationDAL();

        for (Cycle cycle : cycleList) {
            cycleDal.saveCycle(cycle);
        }

        for (Client clients : clientList) {
            clientDal.saveClient(clients);
        }

        locationDal.saveLocation(location);
    }
}
