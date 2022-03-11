package com.example.form_dk.controller;

import com.example.form_dk.model.User;
import com.example.form_dk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/")
    public String create(Model model){
       User use=new User();
        model.addAttribute("model",use);
        return "view";
    }
    @PostMapping("/")
    public String create(@Valid @ModelAttribute(name="model") User user, BindingResult bindingResult){
        new User().validate(user,bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "view";
        }else{
            userService.create(user);
            return "create";
        }
    }
}
