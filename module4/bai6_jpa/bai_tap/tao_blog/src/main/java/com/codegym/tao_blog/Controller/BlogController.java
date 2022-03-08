package com.codegym.tao_blog.Controller;

import com.codegym.tao_blog.model.Blog;
import com.codegym.tao_blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    BlogService blogService;
    @GetMapping("/view")
    public String view(Model model){
        List<Blog> blogList=blogService.findAll();
        model.addAttribute("blogList", blogList);
        return "/view";
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("blog",new Blog());
        return "/create";
    }
    @PostMapping("create")
    public String create(Blog blog, RedirectAttributes redirectAttributes){
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("success","create ok");
        return "redirect:/view";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(name="id") Long id){
        blogService.remove(id);
        return "redirect:/view";
    }
    @GetMapping("/edit/{id}")
    public String edit(Model model,@PathVariable(name="id") Long id){
        Blog blog=blogService.findId(id);
        model.addAttribute("blog",blog);
        return "/edit";
    }
    @PostMapping("/edit")
    public String edit(Blog blog, RedirectAttributes redirectAttributes){
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("success","edit ok");
        return "redirect:/view";

    }



}
