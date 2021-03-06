package com.ascending.training.repository;

import com.ascending.training.ApplicationBootstrap;
import com.ascending.training.model.Player;
import com.ascending.training.model.Team;
//import com.ascending.training.service.TeamService;
import org.hibernate.HibernateException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= ApplicationBootstrap.class)

public class TeamDaoTest {
    @Autowired
    private TeamDao teamDao;
    @Autowired
    private PlayerDao playerDao;

    private Team t1;
    private Player p1;
    private Player p2;
    private String teamString = "Team Golden State Warriors";

    @Before
    public void setUp() {
        t1 = new Team();
       // t1.setId(1000);
        t1.setName("Golden State Warriors");
        t1.setAbbreviation("GSW");
        t1.setFormed_year(1946);
        t1 = teamDao.save(t1);

        p1 = new Player();
        p1.setName("Stephen Curry");
        //p1.setId(30);
        p1.setHired_year(2009);
        p1.setRole_type("Point Guard");
        p1.setSalary(BigDecimal.valueOf(37460000.00));
        p1.setTeam(t1);
        playerDao.save(p1);

        p2 = new Player();
        p2.setName("Klay Thompson");
        //p2.setId(11);
        p2.setHired_year(2011);
        p2.setRole_type("Small forward");
        p2.setSalary(BigDecimal.valueOf(32740000.00));
        p2.setTeam(t1);
        playerDao.save(p2);
    }

    @After
    public void tearDown() {
        playerDao.delete(p1);
        playerDao.delete(p2);
        teamDao.delete(t1);
    }

    @Test
    public void getTeamsTest() {
        List<Team> teams = teamDao.getTeams();
        int expectedNumOfTeam = 1;
        Assert.assertEquals(expectedNumOfTeam, teams.size());

        List<Player> players = playerDao.getPlayers();
        int expectedNumOfPlayer = 2;
        Assert.assertEquals(expectedNumOfPlayer,players.size());
    }

//    @Test
//    public void getTeamsServiceTest() {
//        List<Team> teams = teamService.getTeams();
//        int expectedNumOfTeam = 1;
//        Assert.assertEquals(expectedNumOfTeam, teams.size());
//    }

    @Test
    public void getTeamEagerByTest(){
        Team team = teamDao.getTeamEagerBy(t1.getId());
        assertNotNull(team);
        assertEquals(team.getName(),t1.getName());
        assertTrue(team.getPlayers().size()>0);
    }

    @Test(expected = HibernateException.class)
    public void getTeamByTest(){
        Team team = teamDao.getBy(t1.getId());
        assertNotNull(team);
        assertEquals(team.getName(),t1.getName());
        System.out.println(team.getPlayers());
    }
}

