package com.ascending.training.repository;


import com.ascending.training.model.Player;


import java.util.List;

public interface PlayerDao {
        Player save (Player player);
        List<Player> getPlayers();
        Player getBy(long id);
        Player getPlayerEagerBy(long id);
        Player update(Player player);
        boolean delete(Player player);
}
