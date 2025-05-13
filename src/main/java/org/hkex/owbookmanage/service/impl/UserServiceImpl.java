package org.hkex.owbookmanage.service.impl;

import jakarta.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSession;
import org.hkex.owbookmanage.dao.UserMapper;
import org.hkex.owbookmanage.entity.User;
import org.hkex.owbookmanage.service.UserService;
import org.hkex.owbookmanage.util.MybatisUtil;

public class UserServiceImpl implements UserService {
    @Override
    public boolean auth(String username, String password, HttpSession session) {
        try(SqlSession sqlSession = MybatisUtil.getSession()){
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = mapper.getUser(username, password);
            User admin = mapper.getAdmin(username, password);
            if(user == null && admin == null)return false;
            if(admin != null)session.setAttribute("user", admin);
            else session.setAttribute("user", user);
            return true;
        }
    }
}
