package com.jojo.service;

import com.jojo.pojo.Rank;

import java.util.List;

/**
 * @author JOJO
 * @create 2021-06-13-22:02
 */
public interface RankService {
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
