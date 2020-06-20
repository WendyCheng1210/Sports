package com.ascending.training.repository;

import com.ascending.training.model.Team;

import java.util.List;

public interface TeamDao {
    Team save(Team team);
    List<Team> getTeams();
    Team getBy(long id);
    Team getTeamEagerBy(long id);
    Team update(Team team);
    boolean delete(Team team);
}
