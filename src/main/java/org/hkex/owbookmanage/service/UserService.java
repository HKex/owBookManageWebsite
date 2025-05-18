package org.hkex.owbookmanage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import jakarta.servlet.http.HttpSession;
import org.hkex.owbookmanage.entity.User;
import org.springframework.stereotype.Service;

public interface UserService extends IService<User>{
    User getUserWithoutPassword(String username);
}
