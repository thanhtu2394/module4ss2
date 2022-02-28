package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.ProductServiceImp;
import com.codegym.service.ProductServiceInterface;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {
    ProductServiceInterface productServiceInterface=new ProductServiceImp();
    @GetMapping("/view")
    public String view(Model model){
        List<Product> productList=productServiceInterface.findall();
        model.addAttribute("productList",productList);
        return "view";
    }
    @GetMapping("/create")
    public String create(Model model){
        Product product=new Product();
        model.addAttribute("product",product);
        return "create";
    }
    @PostMapping("/create")
    public String create1(Model model, Product product, RedirectAttributes redirectAttributes){
        productServiceInterface.save(product);
        redirectAttributes.addFlashAttribute("success","create ok");
        return "redirect:/view";
    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") int id,RedirectAttributes redirectAttributes){
        productServiceInterface.remove(id);
        redirectAttributes.addFlashAttribute("success","delete ok");
        return "redirect:/view";
    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id,Model model){
        Product product=productServiceInterface.findId(id);
        model.addAttribute("product",product);
        return "edit";
    }
    @PostMapping("/edit")
    public String edit( RedirectAttributes redirectAttributes,Product product){
        productServiceInterface.edit(product.getId(), product);
        redirectAttributes.addFlashAttribute("success","edit ok");
        return "redirect:/view";
    }
}
