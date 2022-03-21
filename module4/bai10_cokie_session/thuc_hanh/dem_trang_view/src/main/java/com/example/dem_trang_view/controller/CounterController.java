package com.example.dem_trang_view.controller;

import com.example.dem_trang_view.model.Counter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("dem")
public class CounterController {
    @ModelAttribute("dem")
    public Counter ses(){
        return new Counter();
    }

    @GetMapping("/")
    public String sesconuter(@ModelAttribute(name="dem") Counter counter1,Model model){
        counter1.increment();
        model.addAttribute("dem",counter1);
        return "view";
    }
}
