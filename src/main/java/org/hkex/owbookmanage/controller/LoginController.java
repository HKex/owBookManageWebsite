package org.hkex.owbookmanage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    //登录成功跳转到index
    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false, defaultValue = "false")String error
            , Model model) {
        model.addAttribute("register_url", "/register");
        if(error.equals("true"))model.addAttribute("failure",true);
        return "login";
    }
}
