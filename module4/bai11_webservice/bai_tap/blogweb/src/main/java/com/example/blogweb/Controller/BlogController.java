package com.example.blogweb.Controller;

import com.example.blogweb.Model.Blog;
import com.example.blogweb.Model.Category;
import com.example.blogweb.Service.BlogService;
import com.example.blogweb.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    BlogService blogService;
    @Autowired
    CategoryService categoryService;
    @GetMapping("/view")
    public String view(Model model, @PageableDefault(size=3)Pageable pageable){
        Page<Blog> blogList=blogService.findAll(pageable);
        model.addAttribute("blogList", blogList);
        List<Category> categoryList=categoryService.findAll();
        model.addAttribute("categoryList",categoryList);
        return "/blog/view";
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("blog",new Blog());
        List<Category> categoryList=categoryService.findAll();
        model.addAttribute("categoryList",categoryList);
        return "/blog/create";
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
        List<Category> categoryList=categoryService.findAll();
        model.addAttribute("categoryList",categoryList);
        return "/blog/edit";
    }
    @PostMapping("/edit")
    public String edit(Blog blog, RedirectAttributes redirectAttributes){
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("success","edit ok");
        return "redirect:/view";

    }
    @GetMapping("/findcategory")
    public String find(@PageableDefault(size=2) Pageable pageable, @RequestParam(name="id") Long id,Model model){
        Category category=categoryService.findId(id);
        Page<Blog> blogs=blogService.findCategory(pageable,category);
        model.addAttribute("blogList", blogs);
        List<Category> categoryList=categoryService.findAll();
        model.addAttribute("categoryList",categoryList);
        return "/blog/view";
    }



}
