package Entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Cycle")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Cycle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "seq", strategy = "increment")
    private long id;

    @Column(name = "marque", length = 60, nullable = false, unique = false)
    private String marque;

    @Column(name = "modele", length = 60, nullable = false, unique = false)
    private String modele;

    @Column(name = "dateAchat")
    private LocalDate dateAchat;

    @Column(name = "prixHeurs")
    private double prixheurs;

    @Column(name = "estLouer",  nullable = false)
    private boolean estLouer = false;

    public Cycle() {
    }

    public Cycle(String marque, String modele, LocalDate dateAchat, double prixheurs) {
        this.marque = marque;
        this.modele = modele;
        this.dateAchat = dateAchat;
        this.prixheurs = prixheurs;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public LocalDate getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(LocalDate dateAchat) {
        this.dateAchat = dateAchat;
    }

    public double getPrixheurs() {
        return prixheurs;
    }

    public void setPrixheur(double prixheurs) {
        this.prixheurs = prixheurs;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cycle{");
        sb.append(", marque='").append(marque).append('\'');
        sb.append(", modele='").append(modele).append('\'');
        sb.append(", dateAchat=").append(dateAchat);
        sb.append('}');
        return sb.toString();
    }
}
