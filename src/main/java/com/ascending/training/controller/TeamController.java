package com.ascending.training.controller;

import com.ascending.training.model.Team;
import com.ascending.training.service.TeamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeamController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private TeamService teamService;

    @RequestMapping(value = "/team", method = RequestMethod.GET)
    public void getTeams() {
        logger.debug("i am in the team controller");
    }

    @RequestMapping(value = "/team/{Id}", method = RequestMethod.GET)
    public Team getTeamById(@PathVariable(name = "Id")long id){
        logger.debug("i am in the team controllor get by " + id);
        return teamService.getBy(id);
    }

    @RequestMapping(value = "/team/{id}", method = RequestMethod.PATCH, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Team updateTeam(@PathVariable("id") long Id,@RequestParam("name") String name){
        logger.debug("pass in vairable id: " + Id + "name: " + name);
        Team t = teamService.getBy(Id);
        t.setName(name);
        t = teamService.update(t);
        return t;
    }

    @RequestMapping(value = "/team",method = RequestMethod.POST)
    public void create(@RequestBody Team newObject){
        logger.debug(newObject.toString());
    }

}

