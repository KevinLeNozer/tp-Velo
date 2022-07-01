package Entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Gyoropode extends CycleAutonomie{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "seqGyropode", strategy = "increment")
    private long id;

    @Column(name = "tailleMinimale")
    private int tailleMinimale;

    public Gyoropode() {
    }

    public Gyoropode(int tailleMinimale) {
        this.tailleMinimale = tailleMinimale;
    }

    public Gyoropode(int autnomieKm, int tailleMinimale) {
        super(autnomieKm);
        this.tailleMinimale = tailleMinimale;
    }

    public Gyoropode(String marque, String modele, LocalDate dateAchat, double prixheurs, int autnomieKm, int tailleMinimale) {
        super(marque, modele, dateAchat, prixheurs, autnomieKm);
        this.tailleMinimale = tailleMinimale;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public int getTailleMinimale() {
        return tailleMinimale;
    }

    public void setTailleMinimale(int tailleMinimale) {
        this.tailleMinimale = tailleMinimale;
    }

}
