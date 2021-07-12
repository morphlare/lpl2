package com.jojo.resolver;

import com.jojo.exception.MyException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

/**
 * @author JOJO
 * @create 2021-06-23-13:42
 */
public class MyHandlerExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        String msg;
        if(e instanceof MyException){
            msg = e.getMessage();
        }else {
            Writer out = new StringWriter();
            PrintWriter s = new PrintWriter(out);
            e.printStackTrace(s);
            msg = out.toString();
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", msg);
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
