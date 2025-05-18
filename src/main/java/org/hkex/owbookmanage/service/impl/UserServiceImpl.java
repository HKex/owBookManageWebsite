package org.hkex.owbookmanage.service.impl;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.hkex.owbookmanage.dao.UserMapper;
import org.hkex.owbookmanage.entity.User;
import org.hkex.owbookmanage.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private UserMapper mapper;

    @Override
    public User getUserWithoutPassword(String username) {
        return mapper.selectOne(Wrappers.<User>query().select("id", "username", "nickname").eq("username", username));
    }
}
