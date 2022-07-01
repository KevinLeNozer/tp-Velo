package Entities;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class CycleAutonomie extends Cycle{

    private int autnomieKm;

    public CycleAutonomie() {
    }

    public CycleAutonomie(int autnomieKm) {
        this.autnomieKm = autnomieKm;
    }

    public CycleAutonomie(String marque, String modele, LocalDate dateAchat, double prixheurs, int autnomieKm) {
        super(marque, modele, dateAchat, prixheurs);
        this.autnomieKm = autnomieKm;
    }
}
