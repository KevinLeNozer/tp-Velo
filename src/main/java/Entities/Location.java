package Entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "seqLocation", strategy = "increment")
    private long id;

    @Column(name = "dateDebutLocation")
    private LocalDateTime dateDebutLocation;

    @Column(name = "dateFintLocation")
    private LocalDateTime dateFinLocation;

    @Column(name = "locationHeurs")
    private int locationHeurs;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "location_cycles",
            joinColumns = @JoinColumn(name = "location_id"),
            inverseJoinColumns = @JoinColumn(name = "cycles_id"))
    private Set<Cycle> cycles = new LinkedHashSet<>();


    public Set<Cycle> getCycles() {
        return cycles;
    }

    public void setCycles(Set<Cycle> cycles) {
        this.cycles = cycles;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Location() {
    }

    public Location(LocalDateTime dateDebutLocation, LocalDateTime dateFinLocation, int locationHeurs, Client client, Set<Cycle> cycles) {
        this.dateDebutLocation = dateDebutLocation;
        this.dateFinLocation = dateFinLocation;
        this.locationHeurs = locationHeurs;
        this.client = client;
        this.cycles = cycles;
    }

    public int getLocationHeurs() {
        return locationHeurs;
    }

    public void setLocationHeurs(int locationHeurs) {
        this.locationHeurs = locationHeurs;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getDateDebutLocation() {
        return dateDebutLocation;
    }

    public void setDateDebutLocation(LocalDateTime dateDebutLocation) {
        this.dateDebutLocation = dateDebutLocation;
    }

    public LocalDateTime getDateFinLocation() {
        return dateFinLocation;
    }

    public void setDateFinLocation(LocalDateTime dateFinLocation) {
        this.dateFinLocation = dateFinLocation;
    }
}