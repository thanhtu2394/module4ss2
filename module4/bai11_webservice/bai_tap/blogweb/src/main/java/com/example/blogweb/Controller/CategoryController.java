package com.example.blogweb.Controller;

import com.example.blogweb.Model.Blog;
import com.example.blogweb.Model.Category;
import com.example.blogweb.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/viewcategory")
    public String view(Model model){
       List<Category> categoryList=categoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        return "/catolery/view";
    }
    @GetMapping("/createcategory")
    public String create(Model model){
        model.addAttribute("categoryList",new Category());
        return "/catolery/create";
    }
    @PostMapping("createcategory")
    public String create(Category category, RedirectAttributes redirectAttributes){
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("success","create ok");
        return "redirect:/viewcategory";
    }
    @GetMapping("/deletecategory/{id}")
    public String delete(@PathVariable(name="id") Long id){
        categoryService.remove(id);
        return "redirect:/viewcategory";
    }
    @GetMapping("/editcategory/{id}")
    public String edit(Model model,@PathVariable(name="id") Long id){
       Category category=categoryService.findId(id);
        model.addAttribute("category",category);
        return "/catolery/edit";
    }
    @PostMapping("/editcategory")
    public String edit(Category category, RedirectAttributes redirectAttributes){
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("success","edit ok");
        return "redirect:/viewcategory";

    }
}
