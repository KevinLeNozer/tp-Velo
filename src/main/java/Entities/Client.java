package Entities;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.IndexColumn;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "Client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "seqClient", strategy = "increment")
    private long id;

    @Column(name = "nom", length = 50, nullable = false, unique = false)
    private String nom;

    @Column(name = "prenom", length = 50, nullable = false, unique = false)
    private String prenom;

    @Column(name = "tailleClient")
    private int tailleClient;

    @Column(name = "valeurPortefeuille")
    private double valeurPortefeuille;


    public Client() {
    }

    public Client(String nom, String prenom, int tailleClient, double valeurPortefeuille) {
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setTailleClient(tailleClient);
        this.setValeurPortefeuille(valeurPortefeuille);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getTailleClient() {
        return tailleClient;
    }

    public void setTailleClient(int tailleClient) {
        this.tailleClient = tailleClient;
    }

    public double getValeurPortefeuille() {
        return valeurPortefeuille;
    }

    public void setValeurPortefeuille(double valeurPortefeuille) {
        this.valeurPortefeuille = valeurPortefeuille;
    }
}
