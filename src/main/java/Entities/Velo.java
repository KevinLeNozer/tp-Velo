package Entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Velo extends Cycle{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "seqVelo", strategy = "increment")
    private long id;

    @Column(name = "nombreVitesse")
    private int nombreVitesse;

    public Velo() {
    }

    public Velo(int nombreVitesse) {
        this.nombreVitesse = nombreVitesse;
    }

    public int getNombreVitesse() {
        return nombreVitesse;
    }

    public void setNombreVitesse(int nombreVitesse) {
        this.nombreVitesse = nombreVitesse;
    }

    public Velo(String marque, String modele, LocalDate dateAchat, int nombreVitesse, double prixHeurs) {
        super(marque, modele, dateAchat, prixHeurs);
        this.setNombreVitesse(nombreVitesse);
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
