package com.example.casestudy.Controller;

import com.example.casestudy.Model.Customer;
import com.example.casestudy.Model.CustomerType;
import com.example.casestudy.Service.CustomerService;
import com.example.casestudy.Service.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@Controller
public class logincontroller {
    @Autowired
    CustomerService customerService;
    @Autowired
    CustomerTypeService customerTypeService;
    @GetMapping("/login")
    public String login(@CookieValue(name = "user",defaultValue = "") String user1,@CookieValue(name = "pass",defaultValue = "") String pass,Model model) {

            Cookie cookie= new Cookie("user",user1);
            Cookie cookie1= new Cookie("pass",pass);
            model.addAttribute("cookievalue",cookie);
            model.addAttribute("password",cookie1);

        return "/Customer/login";
    }

//    @PostMapping("/login")
//    public String login1(HttpServletResponse response, @RequestParam(name = "remember") Optional<String> remember, @RequestParam(name = "user") Optional<String> user, @RequestParam(name = "password") Optional<String> password) {
//        if(remember.isPresent()&&user.isPresent()&&password.isPresent()){
//            String remember1=remember.get();
//            String user1=user.get();
//            String password1=password.get();
//            if (remember1.equals("check")) {
//                Cookie cookie1 = new Cookie(user1,password1);
//                cookie1.setMaxAge(30);
//                response.addCookie(cookie1);
//            }
//        }
//        return "/Customer/view";
//    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "/trangchu";
    }
}
