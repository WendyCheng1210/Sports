package com.ascending.training.jdbc;
import com.ascending.training.jdbc.Team;
import com.ascending.training.jdbc.TeamDao;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TeamDaoTest {

        private TeamDao teamJDBCDao;

        @Before
        public void setUp(){
            teamJDBCDao = new TeamDao();
        }

        @After
        public void tearDown(){
            teamJDBCDao = null;
        }

        @Test
        public void getTameTest(){
            List<Team> teamList = teamJDBCDao.getTeams();
            assertEquals(0, teamList.size());
        }


    }
