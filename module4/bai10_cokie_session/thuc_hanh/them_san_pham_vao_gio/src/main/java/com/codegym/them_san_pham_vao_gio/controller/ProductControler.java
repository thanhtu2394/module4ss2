package com.codegym.them_san_pham_vao_gio.controller;

import com.codegym.them_san_pham_vao_gio.model.Cart;
import com.codegym.them_san_pham_vao_gio.model.Product;
import com.codegym.them_san_pham_vao_gio.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@SessionAttributes("car")
public class ProductControler {
    @Autowired
    ProductService productService;
    @ModelAttribute("car")
    public Cart carsession(){
        return new Cart();
    }

    @GetMapping("/shop")
    public String showShop(Model model){
        List<Product> productList=productService.findAll();
        model.addAttribute("products",productList);
        return "shop";

    }
    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @ModelAttribute(name="car") Cart cart,@RequestParam(name="alo") Optional<String> giam1) {

        Product product=productService.findById(id);
            cart.addProduct(product,giam1);
            return "redirect:/shopping-cart";
    }
    @GetMapping("/buy")
    public String buy(Model model,@ModelAttribute(name="car") Cart cart){
        int sl=cart.getProducts().size();
        float total=0;
        for (Map.Entry<Product,Integer> index:cart.getProducts().entrySet()
             ) {float price= (float) (index.getValue()*index.getKey().getPrice());
            total += price;
        }
        model.addAttribute("ssp",sl);
        model.addAttribute("price",total);
        return "ok";
    }
    @PostMapping("/buy1")
    public String buy1(RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("message","mua thanh cong");
        return "redirect:/shop";
    }

}
