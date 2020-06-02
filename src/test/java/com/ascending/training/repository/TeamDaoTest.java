package com.ascending.training.repository;
import com.ascending.training.model.Team;
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
            assertEquals(8, teamList.size());
        }


    }
