package org.hkex.owbookmanage.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.hkex.owbookmanage.service.RegisterService;
import org.hkex.owbookmanage.service.impl.RegisterServiceImpl;
import org.hkex.owbookmanage.util.ThymeleafUtil;
import org.thymeleaf.context.Context;

import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet{
    RegisterService service;

    @Override
    public void init() throws ServletException {
        service = new RegisterServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if(service.auth(req.getParameter("username"))){
            session.setAttribute("UserAlreadyExist",true);
            doGet(req, resp);
        }else{
            service.register(req.getParameter("username"),req.getParameter("nickname"),
                            req.getParameter("password"));
            resp.sendRedirect("login");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Context context = new Context();
        context.setVariable("login_url", "/ow/login");
        HttpSession session = req.getSession();
        if(session.getAttribute("UserAlreadyExist") != null){
            context.setVariable("userExist",true);
        }
        else{
            session.removeAttribute("UserAlreadyExist");
        }
        ThymeleafUtil.getEngine().process("register.html", context ,resp.getWriter());
    }
}
