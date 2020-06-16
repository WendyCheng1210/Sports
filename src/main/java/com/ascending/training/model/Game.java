package com.ascending.training.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "games")
public class Game {
    public Game(){}
//    public Game(long id, String name, String location){
//        this.id = id;
//        this.name = name;
//        this.location = location;
//    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;

//    @JoinColumn(name = "team1")
//    @JoinColumn(name = "team2")
//    private long team;
//
//
//    @OneToMany(mappedBy = "game",cascade = CascadeType.REMOVE)
//    private Set<Team> teams;


    public void  setId(long id){
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setLocation(String location){
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

//    public void setTeam1(long team1){
//        this.team1 = team1;
//    }
//
//    public long getTeam1() {
//        return team1;
//    }
//
//    public void setTeam2(long team2){
//        this.team2 = team2;
//    }
//
//    public long getTeam2() {
//        return team2;
//    }
}
