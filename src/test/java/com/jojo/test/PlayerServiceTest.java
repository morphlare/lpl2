package com.jojo.test;

import com.jojo.dao.PlayerMapper;
import com.jojo.pojo.Player;
import com.jojo.service.PlayerServiceImpl;
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
public class PlayerServiceTest {
    @Autowired
    private PlayerServiceImpl playerService;

    @Test
    public void updatePwdTest(){
        Boolean flag = playerService.updatePwd(1, "111111");
        System.out.println(flag);
    }

}
