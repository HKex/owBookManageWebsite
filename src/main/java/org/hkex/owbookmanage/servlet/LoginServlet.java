package org.hkex.owbookmanage.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hkex.owbookmanage.service.UserService;
import org.hkex.owbookmanage.service.impl.UserServiceImpl;
import org.hkex.owbookmanage.util.ThymeleafUtil;
import org.thymeleaf.context.Context;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    UserService service;

    @Override
    public void init() throws ServletException {
        service = new UserServiceImpl();
    }

    //登录成功跳转到index
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Context context = new Context();
        if(req.getSession().getAttribute("login-failure") != null){
            context.setVariable("failure",true);
            req.getSession().removeAttribute("login-failure");
        }
        if(req.getSession().getAttribute("user") != null){
            resp.sendRedirect("index");
            return;
        }
        context.setVariable("register_url", "/ow/register");
        ThymeleafUtil.getEngine().process("login.html", context ,resp.getWriter());
    }

    //处理登录请求
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if(service.auth(username, password, req.getSession())){
            resp.sendRedirect("index");
        }else{
            req.getSession().setAttribute("login-failure", "用户名或密码错误！");
            this.doGet(req, resp);
        }
    }
}
