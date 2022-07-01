package Entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Gyroroue extends CycleAutonomie{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "seqGyroroue", strategy = "increment")
    private long id;

    public Gyroroue() {
    }

    public Gyroroue(int autnomieKm) {
        super(autnomieKm);
    }

    public Gyroroue(String marque, String modele, LocalDate dateAchat, double prixheurs, int autnomieKm) {
        super(marque, modele, dateAchat, prixheurs, autnomieKm);
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

}
