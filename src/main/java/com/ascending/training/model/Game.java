package com.ascending.training.model;

public class Game {
    private long id;
    private String name;
    private String location;
    private long team1;
    private long team2;

    public void  setId(long id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setLocation(String location){
        this.location = location;
    }

    public void setTeam1(long team1){
        this.team1 = team1;
    }

    public void setTeam2(long team2){
        this.team2 = team2;
    }
}
