package com.jojo.controller;

import com.jojo.pojo.Rank;
import com.jojo.service.RankServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author JOJO
 * @create 2021-06-20-18:52
 */
@Controller
@RequestMapping("/rank")
public class RankController {

    @Autowired
    private RankServiceImpl rankService;

    @RequestMapping("/list")
    public String list(HttpServletRequest req){
        List<Rank> ranks = rankService.getRankList();
        req.setAttribute("rankList", ranks);
        return "rankList";
    }
}
