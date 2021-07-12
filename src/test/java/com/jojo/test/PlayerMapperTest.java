package com.jojo.test;

import com.jojo.dao.PlayerMapper;
import com.jojo.pojo.Player;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author JOJO
 * @create 2021-06-17-0:15
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class PlayerMapperTest {
    @Autowired
    private PlayerMapper playerMapper;

    @Test
    public void getLoginPlayerTest(){
        Player player = playerMapper.getLoginPlayer("Uzi", "111111");
        System.out.println(player);
    }

    @Test
    public void getPlayerByIdTest(){
        Player player = playerMapper.getPlayerById(1);
        System.out.println(player);
    }

    @Test
    public void insertPlayerTest(){
        Player player = new Player(47, "JOJO", 7, "male", 20, "SUP", "123456", 1);
        playerMapper.insertPlayer(player);
    }

    @Test
    public void deleteByIdTest(){
        playerMapper.deleteById(47);
    }

    @Test
    public void updatePlayerTest(){
        Player player = new Player(47, "White", 7, "male", 20, "SUP", "123456", 1);
        playerMapper.updatePlayer(player);
    }

    @Test
    public void getCountTest(){
        Long count = playerMapper.getCount();
        System.out.println(count);
    }

    @Test
    public void getAllTest(){
        List<Player> players = playerMapper.getAll();
        System.out.println(players);
    }

    @Test
    public void getPlayerCountTest(){
        Integer count = playerMapper.getPlayerCount("", 0);
        System.out.println(count);
    }

    @Test
    public void updatePwdTest(){
        boolean flag = playerMapper.updatePwd(1, "111111");
        System.out.println(flag);
    }

    @Test
    public void getPlayerListTest(){
        List<Player> playerList = playerMapper.getPlayerList("", 0);
        System.out.println(playerList);
    }

}
