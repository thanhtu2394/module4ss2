package com.example.casestudy.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TrangChuController {
    @GetMapping("/trangchu")
    public String trangchu(){
        return "trangchu";
    }
}
