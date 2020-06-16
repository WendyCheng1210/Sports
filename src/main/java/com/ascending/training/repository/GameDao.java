package com.ascending.training.repository;

import com.ascending.training.model.Game;


import java.util.List;

public interface GameDao {
    Game save (Game game);
    List<Game> getGames();
    Game getBy(long id);
    boolean delete(Game dep);
    //Game getGameEagerBy(long id);

}
