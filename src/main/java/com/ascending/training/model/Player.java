package com.ascending.training.model;
import javax.print.DocFlavor;
import java.util.Date;

public class Player {

    public Player(){}

    private long id;
    private String name;
    private String role_type;
    private long salary;
    private Date hired_date;
    private long team_id;

    public void  setId(long id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void  setRole_type(String role_type){
        this.role_type = role_type;
    }

    public void setSalary(long salary){
        this.salary = salary;
    }

    public void setHired_date(Date hired_date){
        this.hired_date = hired_date;
    }

    public void setTeam_id(long team_id){
        this.team_id = team_id;
    }
}
