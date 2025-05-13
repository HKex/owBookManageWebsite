package org.hkex.owbookmanage.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.hkex.owbookmanage.entity.User;
import org.hkex.owbookmanage.entity.UserInfo;
import org.hkex.owbookmanage.service.UserInfoService;
import org.hkex.owbookmanage.service.impl.UserInfoServiceImpl;
import org.hkex.owbookmanage.util.ThymeleafUtil;
import org.thymeleaf.context.Context;

import java.io.IOException;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    private UserInfoService service;

    @Override
    public void init() throws ServletException {
        service = new UserInfoServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //处理抽卡请求并刷新
        UserInfo info = (UserInfo)req.getSession().getAttribute("info");
        HttpSession session = req.getSession();
        if(!service.gacha(session)){
            throw new ServletException("抽卡失败！");
        }
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Context context = new Context();
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");
        context.setVariable("nickname",user.getNickname());
        UserInfo info = (UserInfo)session.getAttribute("info");//返回UserInfo
        if(info == null){
            info = service.getUserInfo(session);//UserInfoServiceImpl 返回info对象，若无，则插入数据库，若有，则赋值,且之后都写入session
        }
        context.setVariable("balance",info.getCoinBalance());
        ThymeleafUtil.getEngine().process("index.html", context ,resp.getWriter());
    }
}
