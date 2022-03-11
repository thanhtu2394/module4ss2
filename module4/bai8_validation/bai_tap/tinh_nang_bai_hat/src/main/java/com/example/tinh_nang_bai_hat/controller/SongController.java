package com.example.tinh_nang_bai_hat.controller;

import com.example.tinh_nang_bai_hat.model.Song;
import com.example.tinh_nang_bai_hat.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class SongController {
    @Autowired
    SongService songService;
    @GetMapping("/view")
    public String view(Model model){
List<Song> songList=songService.findAll();
model.addAttribute("song",songList);
return "view";
    }
    @GetMapping("/create1")
    public String create(Model model){
        model.addAttribute("song", new Song());
        return "create";
    }
    @PostMapping("/create")
    public String create(@Validated Song song, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            return "create";
        }else{
            songService.create(song);
            return "redirect:/view";
        }
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable(name="id") Long id,Model model){
        Song song=songService.findbyid(id);
        model.addAttribute("song",song);
        return "edit";
    }
    @PostMapping("/edit")
    public String edit(@Validated Song song, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            return "edit";
        }else{
            songService.create(song);
            return "redirect:/view";
        }
    }

}
