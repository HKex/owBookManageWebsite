package org.hkex.owbookmanage.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.hkex.owbookmanage.entity.User;

import java.io.IOException;


public class MainFilter extends HttpFilter {

    //非登录状态时只允许获取static & login页面
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String url = req.getRequestURI().toString();
        //if 访问非login和静态页面，且session得到 user = null, 重定向到login页面
        if(!url.endsWith("login") && !url.contains("/static/") && !url.endsWith("register")){
            HttpSession session = req.getSession();
            User user = (User)session.getAttribute("user");
            if(user == null){
                res.sendRedirect("/login");
                return;
            }
        }
        chain.doFilter(req, res);
    }
}
