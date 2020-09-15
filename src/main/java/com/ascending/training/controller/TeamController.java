package com.ascending.training.controller;

import com.ascending.training.model.Team;
import com.ascending.training.service.TeamService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/team")
public class TeamController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private TeamService teamService;

    // http://localhost:8080/team
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Team> getTeams(){
        List<Team> teams = teamService.getTeams();
        logger.debug("i am in the team controller");
        return teams;
    }

    // http://localhost:8080/team/1
    @RequestMapping(value = "/{Id}", method = RequestMethod.GET)
    public Team getTeamById(@PathVariable(name = "Id")long id){
        logger.debug("i am in the team controllor get by " + id);
        return teamService.getBy(id);
    }

    //http://localhost:8080/team?abbreviation = GSW
    @RequestMapping(value = "/{abbreviation}", method = RequestMethod.GET,params = {"abbreviation"})
    public Team getTeamByAbbre(@RequestParam("abbreviation") String abbreviation){
        logger.info("pass in vairable abbreviation: " + abbreviation);
        return null;
    }

    //http://localhost:8080/team/1?name=Golden State Warriors
    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Team updateTeam(@PathVariable("id") long Id,@RequestParam("name") String name){
        logger.debug("pass in vairable id: " + Id + "name: " + name);
        Team t = teamService.getBy(Id);
        t.setName(name);
        t = teamService.update(t);
        return t;
    }

    //http://localhost:8080/team
    @RequestMapping(value = "",method = RequestMethod.POST)
    public void create(@RequestBody Team newObject){
        logger.debug(newObject.toString());
    }

}

