package com.ascending.training.jdbc;

public class Team {

    public Team(){}

    public Team(String name, String abbreviation, Integer formed_year){
        this.name = name;
        this.abbreviation = abbreviation;
        this.formed_year = formed_year;
    }

    private long id;
    private  String name;
    private  String abbreviation;
    private  int formed_year;

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public void setFormed_year(int formed_year) {
        this.formed_year = formed_year;
    }

    public long getId() {
        return id + super.hashCode();
    }

    public String getName() {
        return name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public int getFormed_year() {
        return formed_year;
    }
}
