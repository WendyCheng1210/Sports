package com.ascending.training.repository;


import com.ascending.training.model.Player;
import java.util.List;

public interface PlayerDao {
        Player save (Player player);
        List<Player> getPlayers();
        Player getBy(long id);
        boolean delete(Player player);
        //Player getPlayerEagerBy(long id);
}
