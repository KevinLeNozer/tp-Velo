package Entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
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
    private LocalDate dateDebutLocation;

    @Column(name = "dateFintLocation")
    private LocalDate dateFinLocation;

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

    public Location(LocalDate dateDebutLocation, LocalDate dateFinLocation, Client client, Set<Cycle> cycles) {
        this.dateDebutLocation = dateDebutLocation;
        this.dateFinLocation = dateFinLocation;
        this.client = client;
        this.cycles = cycles;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDateDebutLocation() {
        return dateDebutLocation;
    }

    public void setDateDebutLocation(LocalDate dateDebutLocation) {
        this.dateDebutLocation = dateDebutLocation;
    }

    public LocalDate getDateFinLocation() {
        return dateFinLocation;
    }

    public void setDateFinLocation(LocalDate dateFinLocation) {
        this.dateFinLocation = dateFinLocation;
    }
}