import Entities.*;
import dall.ClientDAL;
import dall.ConnectionDAL;
import dall.CycleDAL;

import javax.persistence.EntityManager;
import java.time.LocalDate;
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
        List<Cycle> cycleList = new ArrayList<>();
        cycleList.add(velo);
        cycleList.add(gyropode);
        cycleList.add(gyroroue);

        Client client = new Client("Toto", "Titi", 160, 30.00);
        Client client1 = new Client("Tata", "Tutu", 185, 30.00);
        Client client2 = new Client("Tonton", "Tictic", 175, 30.00);
        List<Client> clientList = new ArrayList<>();
        clientList.add(client);
        clientList.add(client1);
        clientList.add(client2);


        ConnectionDAL connectionDAL = new ConnectionDAL();

        EntityManager em = connectionDAL.getConnection();

        CycleDAL cycleDal = new CycleDAL(em);
        ClientDAL cleintDal = new ClientDAL();

        for (Cycle cycle : cycleList) {
            cycleDal.saveCycle(cycle);
        }

        for (Client clients : clientList) {
            cleintDal.saveClient(clients);
        }
    }
}
