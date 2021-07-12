package com.jojo.service;

import com.jojo.dao.RankMapper;
import com.jojo.pojo.Rank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author JOJO
 * @create 2021-06-13-22:03
 */
@Service
@Transactional
public class RankServiceImpl implements RankService{

    @Autowired
    private RankMapper rankMapper;

    @Override
    public List<Rank> getRankList() {
        return rankMapper.getRankList();
    }

    @Override
    public Rank getRankByName(String rankName) {
        return rankMapper.getRankByName(rankName);
    }
}
