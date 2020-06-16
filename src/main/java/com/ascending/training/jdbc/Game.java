package com.ascending.training.jdbc;

public class Game {
    public Game(){}
    public Game(String name, String location, long team1, long team2){
        this.name = name;
        this.location = location;
        this.team1 = team1;
        this.team2 = team2;
    }


    private long id;
    private String name;
    private long team1;
    private long team2;
    private String location;

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTeam1(long team1) {
        this.team1 = team1;
    }

    public void setTeam2(long team2) {
        this.team2 = team2;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public long getId() {
        return id + super.hashCode();
    }

    public String getName() {
        return name;
    }

    public long getTeam1() {
        return team1;
    }

    public long getTeam2() {
        return team2;
    }

    public String getLocation() {
        return location;
    }
}
