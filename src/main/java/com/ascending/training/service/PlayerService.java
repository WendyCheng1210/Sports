package com.ascending.training.service;

import com.ascending.training.model.Player;
import com.ascending.training.model.Team;
import com.ascending.training.repository.PlayerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private PlayerDao playerDao;

    public Player save(Player player){return playerDao.save(player);}
    public List<Player> getPlayers(){return playerDao.getPlayers();}
    public Player update(Player player){return playerDao.update(player);}
    public Player getBy(long Id){return playerDao.getBy(Id);}
}
