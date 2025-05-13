package org.hkex.owbookmanage.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.hkex.owbookmanage.dao.UserMapper;
import org.hkex.owbookmanage.entity.User;
import org.hkex.owbookmanage.service.RegisterService;
import org.hkex.owbookmanage.util.MybatisUtil;

public class RegisterServiceImpl implements RegisterService {

    public boolean auth(String username) {
        try(SqlSession sqlSession = MybatisUtil.getSession()){
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = mapper.getUserByName(username);
            return !(user == null);
        }
    }

    public boolean register(String username, String nickname, String password) {
        try(SqlSession sqlSession = MybatisUtil.getSession()){
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            return mapper.insertUser(username, nickname, password);
        }
    }
}
