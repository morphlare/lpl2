package com.jojo.service;

import com.jojo.dao.PlayerMapper;
import com.jojo.pojo.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author JOJO
 * @create 2021-06-13-20:50
 */
@Service
@Transactional
public class PlayerServiceImpl implements PlayerService{

    @Autowired
    private PlayerMapper playerMapper;

    public void setPlayerMapper(PlayerMapper playerMapper) {
        this.playerMapper = playerMapper;
    }

    @Override
    public Player getLoginPlayer(String userName, String password) {
        return playerMapper.getLoginPlayer(userName, password);
    }

    @Override
    public Player getPlayerById(Integer id) {
        return playerMapper.getPlayerById(id);
    }

    @Override
    public void insertPlayer(Player p) {
        playerMapper.insertPlayer(p);
    }

    @Override
    public void deleteById(int id) {
        playerMapper.deleteById(id);
    }

    @Override
    public void updatePlayer(Player p) {
        playerMapper.updatePlayer(p);
    }

    @Override
    public Long getCount() {
        return playerMapper.getCount();
    }

    @Override
    public List<Player> getAll() {
        return playerMapper.getAll();
    }

    @Override
    public Integer getPlayerCount(String userName, int rankId) {
        return playerMapper.getPlayerCount(userName, rankId);
    }

    @Override
    public Boolean updatePwd(Integer playerId, String password) {
        return playerMapper.updatePwd(playerId, password);
    }

    @Override
    public List<Player> getPlayerList(String userName, int rankId) {
        return playerMapper.getPlayerList(userName, rankId);
    }
}
