package org.hkex.owbookmanage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.hkex.owbookmanage.entity.User;

public interface UserService extends IService<User>{
    User getUserWithoutPassword(String username);
}
