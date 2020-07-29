package com.ascending.training.model;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "teams")
public class Team {
//1. create view class
//    public static class ExtendedView extends BasicView {}
//    public static class BasicView {}
//2. tag model property with view class
//    @JsonView(BasicView.class)
//    private long id;
//    @JsonInclude(JsonInclude.Include.NON_NULL)
//    @OneToMany(mappedBy = "department", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
//    @JsonView(ExtendedView.class)
//    private Set<Employee> employees;
//3. select view in the controller
//    @JsonView(Department.ExtendedView.class)
//    @RequestMapping(value = "/with-children", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
//    public List<Department> getDepartmentsWithChildren() {
//        List<Department> departments = departmentService.getDepartmentsEager();
//        return departments;
//    }

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
    @JsonIgnore
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

    public int hashCode(){
        /*生成hashcode
        final int prime = 31;
        int result = 1;
        result = prime * result + (int)id;
        result = prime * result + name.hashCode();
        result = prime * result + abbreviation.hashCode();
        result = prime * result + formed_year.hashCode();
        result = prime * result + players.hashCode();
        Objects.hash(id,name);
        return result;
         */

        return Objects.hash(id,name,abbreviation,formed_year,players);
    }

    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team)o;
        return id == team.id &&
                Objects.equals(name, team.name) &&
                Objects.equals(abbreviation, team.abbreviation) &&
                Objects.equals(formed_year, team.formed_year) &&
                Objects.equals(players, team.players);
    }
}
