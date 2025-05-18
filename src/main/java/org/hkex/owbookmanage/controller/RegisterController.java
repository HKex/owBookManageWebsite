package org.hkex.owbookmanage.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import jakarta.annotation.Resource;
import org.hkex.owbookmanage.entity.User;
import org.hkex.owbookmanage.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.http.HttpRequest;

@Controller
public class RegisterController {

    @Resource
    private UserService userService;

    @Resource
    private PasswordEncoder encoder;

    @GetMapping("/register")
    public String registerPage(Model model)
    {
        model.addAttribute("login_url", "/login");
        return "register";
    }

    @PostMapping("/register")
    public String doRegister(User user, Model model){
        String RegName = user.getUsername();

        User userExist = userService.getOne(Wrappers.<User>query().eq("username",RegName));

        if(userExist != null){
            model.addAttribute("userExist",true);
            return "register";
        }

        String safe_pass = encoder.encode(user.getPassword());
        user.setPassword(safe_pass);

        userService.save(user);

        return "redirect:/login";
    }
}
