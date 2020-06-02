package com.ascending.training.repository;
import com.ascending.training.model.Game;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class GameDaoTest {

    private GameDao gameJDBCDao;

    @Before
    public void setUp(){
        gameJDBCDao = new GameDao();
    }

    @After
    public void tearDown(){
        gameJDBCDao = null;
    }

    @Test
    public void getGameTest(){
        //GameDao gameJDBCDao = new GameDao();
        List<Game> gameList = gameJDBCDao.getGames();
        assertEquals(4, gameList.size());
    }
}

