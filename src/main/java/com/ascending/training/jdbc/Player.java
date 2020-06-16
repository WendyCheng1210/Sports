package com.ascending.training.jdbc;

import java.math.BigDecimal;
import java.util.Date;

public class Player {

    public Player(){}
    public Player(String name, String role_type, BigDecimal salary, Integer hired_year, long team_id) {
        this.name = name;
        this.role_type = role_type;
        this.salary = salary;
        this.hired_year = hired_year;
        this.team_id = team_id;
    }

    private long id;
    private String name;
    private String role_type;
    private BigDecimal salary;
    private Integer hired_year;
    private long team_id;

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole_type(String role_type) {
        this.role_type = role_type;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public void setTeam_id(long team_id) {
        this.team_id = team_id;
    }

    public Integer getHired_year() {
        return hired_year;
    }

    public void setHired_year(Integer hired_year) {
        this.hired_year = hired_year;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRole_type() {
        return role_type;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public long getTeam_id() {
        return team_id;
    }

}
