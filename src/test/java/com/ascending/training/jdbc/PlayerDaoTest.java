package com.ascending.training.jdbc;
import com.ascending.training.jdbc.PlayerDao;
import com.ascending.training.jdbc.Player;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PlayerDaoTest {

    private PlayerDao playerJDBCDao;

    @Before
    public void setUp(){
        playerJDBCDao = new PlayerDao();
    }

    @After
    public void tearDown(){
        playerJDBCDao = null;
    }

    @Test
    public void getPlayerTest(){
        //PlayerDao playerJDBCDao = new PlayerDao();
        List<Player> playerList = playerJDBCDao.getPlayers();
        assertEquals(0, playerList.size());
    }
}
