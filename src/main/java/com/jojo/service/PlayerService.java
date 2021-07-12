package com.jojo.service;

import com.jojo.pojo.Player;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author JOJO
 * @create 2021-06-13-20:47
 */
public interface PlayerService {
    /**
     *获取登录玩家
     * @param userName
     * @param password
     * @return Player
     */
    Player getLoginPlayer(String userName, String password);

    /**
     *根据玩家ID获取玩家
     * @param id
     * @return
     */
    Player getPlayerById(Integer id);

    /**
     *向表中插入一条数据
     * @param p
     */
    void insertPlayer(Player p);

    /**
     *删除表中指定id的记录
     * @param id
     */
    void deleteById(int id);

    /**
     *将表中与p相同ID的记录替换为p
     * @param p
     */
    void updatePlayer(Player p);

    /**
     *返回表中数据的数量
     * @return
     */
    Long getCount();

    /**
     *将表中所有记录添加到集合中并返回
     * @return
     */
    List<Player> getAll();

    /**
     *根据用户需要返回表中数据数量
     * @param userName
     * @param rankId
     * @return
     */
    Integer getPlayerCount(String userName, int rankId);

    /**
     *修改当前用户密码
     * @param playerId
     * @param password
     * @return
     */
    Boolean updatePwd(Integer playerId, String password);

    /**
     * 通过条件查询-userList
     * @param userName
     * @param rankId
     * @return
     */
    List<Player> getPlayerList(String userName, int rankId);
}
