package org.hkex.owbookmanage.controller;

import jakarta.annotation.Resource;
import org.hkex.owbookmanage.entity.Borrow;
import org.hkex.owbookmanage.entity.User;
import org.hkex.owbookmanage.service.BookService;
import org.hkex.owbookmanage.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;

@Controller
public class IndexController {

    @Resource
    private UserService userService;

    @Resource
    private BookService bookService;

    @GetMapping("/index")
    public String index(Model model,Authentication authentication) {

        Object principalObj = authentication.getPrincipal();
        org.springframework.security.core.userdetails.User principal =
                (org.springframework.security.core.userdetails.User)principalObj;
        String current_username = principal.getUsername();
        //可以封装起来

        User user_without_password = userService.getUserWithoutPassword(current_username);
        model.addAttribute("nickname", user_without_password.getNickname());

        List<Borrow> borrows= bookService.getBorrow();

        model.addAttribute("borrows",borrows);

        return "index";
    }
}
