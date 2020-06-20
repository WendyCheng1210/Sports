package com.ascending.training.repository;

import com.ascending.training.model.Game;


import java.util.List;

public interface GameDao {
    Game save (Game game);
    List<Game> getGames();
    Game getBy(long id);
    Game update(Game game);
    boolean delete(Game game);
    //Game getGameEagerBy(long id);

}
