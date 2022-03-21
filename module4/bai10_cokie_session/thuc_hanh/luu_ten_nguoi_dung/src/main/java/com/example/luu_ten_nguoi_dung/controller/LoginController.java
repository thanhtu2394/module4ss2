package com.example.luu_ten_nguoi_dung.controller;

import com.example.luu_ten_nguoi_dung.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String login(HttpServletResponse response, @CookieValue(value = "name", defaultValue = "") String name, Model model) {
        System.out.println(name);
        Cookie cookie = new Cookie("name", name);
        User user = new User(cookie.getValue(),"");
        model.addAttribute("namecokie", cookie);
        model.addAttribute("user", user);
        return "login";
    }

    @PostMapping("/dologin")
    public String dologin(@ModelAttribute(name = "user") User user, HttpServletResponse response, Model model) {
        Cookie cookie = new Cookie("name", user.getEmail());
        cookie.setMaxAge(120);
        response.addCookie(cookie);
        model.addAttribute("namecokie", cookie);
        return "login";
    }
}
