package com.ascending.training.service;

import com.ascending.training.repository.TeamDao;
import com.ascending.training.repository.TeamDaoImpl;
import com.ascending.training.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    private TeamDao teamDao;
    @Autowired
    public Team save(Team team){ return teamDao.save(team);}
    public List<Team> getTeams(Team team){return teamDao.getTeams();}
    public Team update(Team team){return teamDao.update(team);}
    public Team getBy(long Id){return teamDao.getBy(Id);}
}
