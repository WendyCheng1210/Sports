package com.ascending.training.model;
import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "players")
public class Player {

    public Player(){}
    public Player(String name, String role_type, BigDecimal salary, Integer hired_year) {
        this.name = name;
        this.role_type = role_type;
        this.salary = salary;
        this.hired_year = hired_year;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "role_type")
    private String role_type;

    @Column(name = "salary")
    private BigDecimal salary;

    @Column(name = "hired_year")
    private Integer hired_year;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;


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

    public void  setRole_type(String role_type){
        this.role_type = role_type;
    }

    public String getRole_type() {
        return role_type;
    }

    public void setSalary(BigDecimal salary){
        this.salary = salary;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setHired_year(Integer hired_year){ this.hired_year = hired_year; }

    public Integer getHired_year() {
        return hired_year;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}

