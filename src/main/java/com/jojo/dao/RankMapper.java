package com.jojo.dao;

import com.jojo.pojo.Rank;

import java.sql.Connection;
import java.util.List;

/**
 * @author JOJO
 * @create 2021-06-13-18:43
 */
public interface RankMapper {
    /**
     *获取战队列表
     * @return
     */
    List<Rank> getRankList();

    /**
     * 根据战队名称获取战队
     * @param rankName
     * @return
     */
    Rank getRankByName(String rankName);
}
