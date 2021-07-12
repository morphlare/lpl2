package com.jojo.interceptor;

import com.jojo.pojo.Player;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author JOJO
 * @create 2021-06-23-13:00
 */
public class PlayerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Player player = (Player) request.getSession().getAttribute("user_session");
        if(player == null){
            request.getRequestDispatcher("login").forward(request, response);
            return false;
        }
        return true;
    }
}
