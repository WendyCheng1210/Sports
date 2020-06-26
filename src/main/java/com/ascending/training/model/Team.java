package com.ascending.training.model;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "teams")
public class Team {

    public Team(){}
    public Team(String name, String abbreviation, Integer formed_year){
        this.name = name;
        this.abbreviation = abbreviation;
        this.formed_year = formed_year;
    }

    public String toString(){
        return "Team ID:" + id + " Name:" + name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "abbreviation")
    private String abbreviation;

    @Column(name = "formed_year")
    private Integer formed_year;

    @OneToMany(mappedBy = "team",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private Set<Player> players;


    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public void setFormed_year(Integer formed_year) {
        this.formed_year = formed_year;
    }

    public long getId() {
        return id;
    }

    public String getName(){
        return name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public Integer getFormed_year() {
        return formed_year;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }
}
