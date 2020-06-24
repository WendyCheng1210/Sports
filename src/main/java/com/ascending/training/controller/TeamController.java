package com.ascending.training.controller;

import com.ascending.training.model.Team;
import com.ascending.training.service.TeamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class TeamController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/team", method = RequestMethod.GET)
    public void getTeams() {
        logger.debug("i am in the team controller");
    }

    @RequestMapping(value = "/team/{Id}", method = RequestMethod.GET)
    public void getTeamById(@PathVariable(name = "Id")long id){
        logger.debug("i am in the team controllor get by " + id);
    }


}

