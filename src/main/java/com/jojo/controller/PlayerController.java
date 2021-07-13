package com.jojo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jojo.pojo.Player;
import com.jojo.pojo.Rank;
import com.jojo.service.PlayerService;
import com.jojo.service.PlayerServiceImpl;
import com.jojo.service.RankServiceImpl;
import com.mysql.cj.util.StringUtils;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.JSONArray;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author JOJO
 * @create 2021-06-14-15:24
 */
@Controller
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    private PlayerServiceImpl playerService;

    @Autowired
    private RankServiceImpl rankService;

    @RequestMapping("/login")
    public String login(HttpServletRequest req) {
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        Player player = playerService.getLoginPlayer(userName, password);
        if(player != null){
            if (req.getAttribute("error") != null){
                req.removeAttribute("error");
            }
            req.getSession().setAttribute("user_session", player);
            return "frame";
        }else {
            req.setAttribute("error", "用户名或密码错误");
            return "forward:/login.jsp";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest req){
        req.getSession().removeAttribute("user_session");
        return "forward:/login.jsp";
    }

    @RequestMapping("/pwdModify")
    public void pwdModify(HttpServletRequest req, HttpServletResponse resp){
        Object o = req.getSession().getAttribute("user_session");
        String oldPassword = req.getParameter("oldPassword");

        Map<String, String> resultMap = new HashMap<>();

        if (o == null) { //Session失效了，session过期
            resultMap.put("result", "sessionerror");
        } else if (StringUtils.isNullOrEmpty(oldPassword)) { //输入的密码为空
            resultMap.put("result", "error");
        } else {
            String userPassword = ((Player) o).getPassword(); //Session中用户的密码
            if (oldPassword.equals(userPassword)) {
                resultMap.put("result", "true");
            } else {
                resultMap.put("result", "false");
            }
        }
        try {
            resp.setContentType("text/json;charset=utf-8");
            PrintWriter writer = resp.getWriter();
            writer.write(JSONArray.toJSONString(resultMap));
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/pwdUpdate")
    public String pwdUpdate(HttpServletRequest req, Model model){
        Object o = req.getSession().getAttribute("user_session");
        String newPassword = req.getParameter("newPassword");
        boolean flag = false;
        if (o != null && newPassword != null) {
            flag = playerService.updatePwd(((Player) o).getPlayerId(), newPassword);
            if (flag) {
                req.setAttribute("message", "修改密码成功，请使用新密码登录");
                //密码修改成功，移除当前Session
                req.getSession().removeAttribute("user_session");
            } else {
                req.setAttribute("message", "密码修改失败，请重新修改");
                //密码修改失败
            }
        } else {
            req.setAttribute("message", "新密码有问题，请重新修改");
        }
        return "pwd_update";
    }

    @RequestMapping("/query")
    public String query(HttpServletRequest req){
        String queryName = req.getParameter("queryName");
        String temp = req.getParameter("queryPlayerRank");
        String pageIndex = req.getParameter("pageIndex");
        int queryPlayerRank = 0;
        int pageSize = 6;
        int currentPageNo = 1;

        if(queryName == null){
            queryName = "";
        }

        if(temp!=null && !temp.equals("")){
            queryPlayerRank = Integer.parseInt(temp);
        }

        if(pageIndex != null){
            currentPageNo = Integer.parseInt(pageIndex);
        }

        PageHelper.startPage(currentPageNo, pageSize);
        List<Player> players = playerService.getPlayerList(queryName, queryPlayerRank);
        PageInfo<Player> pageInfo = new PageInfo<>(players);
        List<Player> playerList = pageInfo.getList();
        req.getSession().setAttribute("playerList", playerList);

        List<Rank> rankList = rankService.getRankList();
        req.getSession().setAttribute("rankList", rankList);

        Integer playerCount = playerService.getPlayerCount(queryName, queryPlayerRank);
        int totalPageCount = (playerCount + pageSize - 1) / pageSize;

        req.setAttribute("playerCount", playerCount);
        req.setAttribute("currentPageNo",currentPageNo);
        req.setAttribute("totalPageCount",totalPageCount);
        req.setAttribute("queryName",queryName);
        req.setAttribute("queryPlayerRank",queryPlayerRank);

        return "playerList";
    }

    @RequestMapping("/edit/{id}")
    public String edit(HttpServletRequest req, @PathVariable("id") Integer id, Model model){
        String playerName = req.getParameter("playerName");
        String rankName = req.getParameter("rankName");
        String role = req.getParameter("role");

        Player player = playerService.getPlayerById(id);

        if(StringUtils.isNullOrEmpty(playerName)){
            playerName = player.getPlayerName();
        }
        if(StringUtils.isNullOrEmpty(rankName)){
            rankName = player.getRankName();
        }
        if(StringUtils.isNullOrEmpty(role)){
            role = player.getRole();
        }

        Rank rank = rankService.getRankByName(rankName);
        player.setPlayerName(playerName);
        player.setRankName(rankName);
        player.setRankId(rank.getRankId());
        player.setRole(role);

        playerService.updatePlayer(player);
        setAttr(model);
        return "playerList";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id, Model model){
        playerService.deleteById(id);
        setAttr(model);
        return "playerList";
    }


    public void setAttr(Model model){
        int playerCount = playerService.getPlayerCount("",0);
        int currentPageNo = 1;
        int pageSize = 6;
        int totalPageCount = (playerCount + pageSize - 1) / pageSize;
        PageHelper.startPage(currentPageNo, pageSize);
        List<Player> playerList = playerService.getAll();
        PageInfo<Player> pageInfo = new PageInfo<>(playerList);
        playerList = pageInfo.getList();

        model.addAttribute("playerCount", playerCount);
        model.addAttribute("currentPageNo",currentPageNo);
        model.addAttribute("totalPageCount",totalPageCount);
        model.addAttribute("playerList", playerList);
    }

    @RequestMapping(value = "/insert/{id}", method = RequestMethod.POST)
    public String insert(@PathVariable("id") Integer id, HttpServletRequest req, Model model, @RequestParam("pic")MultipartFile uploadImg) throws IOException {
        String playerName = req.getParameter("playerName");
        String role = req.getParameter("role");
        String temp = req.getParameter("age");
        String rankName = req.getParameter("rankName");
        String sex = req.getParameter("sex");
        String password = req.getParameter("password");
        setAttr(model);

        if(StringUtils.isNullOrEmpty(playerName)){
            return "playerList";
        }
        if(StringUtils.isNullOrEmpty(temp)){
            return "playerList";
        }
        if(StringUtils.isNullOrEmpty(sex)){
            return "playerList";
        }
        if(StringUtils.isNullOrEmpty(password)){
            return "playerList";
        }
        
        Integer age = Integer.parseInt(temp);
        Rank rank = rankService.getRankByName(rankName);
        
        String oldImgName = uploadImg.getOriginalFilename();
        String suffixName = oldImgName.substring(oldImgName.lastIndexOf("."));
        String newImgName = UUID.randomUUID().toString()+suffixName;

        String uploadOir = req.getServletContext().getRealPath("/img");
        File file = new File(uploadOir);
        if(!file.exists()){
            file.mkdir();
        }

        uploadImg.transferTo(new File(uploadOir, newImgName));
        String pic = "img/" + newImgName;
        System.out.println(pic);

        String pic1 = uploadOir + "\\" + newImgName;
        String pic2 = "D:\\workspace_idea\\lpl2\\src\\main\\webapp\\img\\" + newImgName;
        fileCopy(pic1, pic2);

        Player player = new Player(id, playerName, rank.getRankId(), sex, age, role, password, pic);
        playerService.insertPlayer(player);
        setAttr(model);
        return "playerList";
    }

    public void fileCopy(String src, String out){
        FileWriter fileWriter = null;
        FileReader fileReader = null;
        try {
            fileWriter = new FileWriter(out);
            fileReader = new FileReader(src);
            char[] chars = new char[100000];
            int num = 0;
            while((num = fileReader.read(chars)) != -1){
                fileWriter.write(chars, 0, num);
                fileWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileWriter.close();
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
