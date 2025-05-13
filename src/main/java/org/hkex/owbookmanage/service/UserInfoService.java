package org.hkex.owbookmanage.service;

import jakarta.servlet.http.HttpSession;
import org.hkex.owbookmanage.entity.UserInfo;

public interface UserInfoService {
    UserInfo getUserInfo( HttpSession session);
    boolean gacha(HttpSession session);
}
