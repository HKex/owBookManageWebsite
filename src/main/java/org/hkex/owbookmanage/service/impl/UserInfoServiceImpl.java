package org.hkex.owbookmanage.service.impl;

import jakarta.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSession;
import org.hkex.owbookmanage.dao.UserInfoMapper;
import org.hkex.owbookmanage.entity.User;
import org.hkex.owbookmanage.entity.UserInfo;
import org.hkex.owbookmanage.service.UserInfoService;
import org.hkex.owbookmanage.util.MybatisUtil;


public class UserInfoServiceImpl implements UserInfoService {
    UserInfoMapper mapper;
    @Override
    public UserInfo getUserInfo(HttpSession session) {
        try(SqlSession sqlsession = MybatisUtil.getSession()){
            mapper = sqlsession.getMapper(UserInfoMapper.class);
            User user = (User)session.getAttribute("user");
            UserInfo userInfo = mapper.getUserInfo(user.getId());
            if(userInfo == null){
                userInfo = new UserInfo(user.getId(),114514);
                mapper.insertUserInfo(user.getId(), 114514);
            }
            session.setAttribute("info", userInfo);
            return userInfo;
        }
    }

    @Override
    public boolean gacha(HttpSession session){
        try(SqlSession sqlsession = MybatisUtil.getSession()){
            mapper = sqlsession.getMapper(UserInfoMapper.class);
            UserInfo userInfo = (UserInfo)session.getAttribute("info");
            if(!mapper.updateUserInfo(userInfo.getId(), userInfo.getCoinBalance() - 400))return false;
            userInfo.setCoinBalance(userInfo.getCoinBalance() - 400);
            session.setAttribute("info", userInfo);
            return true;
        }
    }
}
