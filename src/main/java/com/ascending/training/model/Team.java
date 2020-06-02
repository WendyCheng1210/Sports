package com.ascending.training.model;
import java.util.Date;

public class Team {
    public Team(){}

    private long id;
    private String name;
    private String abbreviation;
    private Integer formed_year;



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


}
