package com.jojo.test;

import com.jojo.dao.RankMapper;
import com.jojo.pojo.Rank;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author JOJO
 * @create 2021-06-19-23:28
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class RankMapperTest {

    @Autowired
    private RankMapper rankMapper;

    @Test
    public void getRankListTest(){
        List<Rank> rankList = rankMapper.getRankList();
        System.out.println(rankList);
    }

}
