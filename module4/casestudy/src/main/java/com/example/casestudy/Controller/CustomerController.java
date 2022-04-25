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
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @Autowired
    CustomerTypeService customerTypeService;

    @GetMapping("")
    public String findAll(Model model, @PageableDefault(size = 3) Pageable pageable, HttpServletRequest request, HttpServletResponse response) {
        Object principal= SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserDetails){
            String user=((UserDetails) principal).getUsername();

            Cookie cookie=new Cookie("user",user);
            Cookie cookie1=new Cookie("pass","12345");
            cookie.setMaxAge(30);
            cookie1.setMaxAge(30);
            response.addCookie(cookie);
            response.addCookie(cookie1);
        }

        Page<Customer> customerPage = customerService.findAll(pageable);
        model.addAttribute("list", customerPage);
        List<CustomerType> customerTypeList = customerTypeService.findAllList();
        model.addAttribute("listtype", customerTypeList);
        return "/Customer/view";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("customer", new Customer());
        List<CustomerType> customerTypeList = customerTypeService.findAllList();
        model.addAttribute("customerType", customerTypeList);
        return "/Customer/create";
    }

    @PostMapping("/create")
    public String create1(@Validated @ModelAttribute("customer") Customer customer, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new Customer().validate(customer, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "/Customer/create";
        }
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "create oK");
        return "redirect:/customer";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable(name = "id") Long id) {
        Customer customer = customerService.findById(id);
        model.addAttribute("customer", customer);
        List<CustomerType> customerTypeList = customerTypeService.findAllList();
        model.addAttribute("customerType", customerTypeList);
        return "/Customer/edit";
    }

    @PostMapping("/edit")
    public String edit1(@Validated @ModelAttribute("customer") Customer customer, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
//        customerService.save(customer);
//        redirectAttributes.addFlashAttribute("message","edit oK");
//        return "redirect:/customer";
        new Customer().validate(customer, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "/Customer/create";
        }
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "edit oK");
        return "redirect:/customer";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable(name = "id") Long id) {
        Customer customer = customerService.findById(id);
        model.addAttribute("customer", customer);
        List<CustomerType> customerTypeList = customerTypeService.findAllList();
        model.addAttribute("customerType", customerTypeList);
        return "/Customer/delete";
    }

    @PostMapping("/delete")
    public String delete(Customer customer, RedirectAttributes redirectAttributes) {
        customerService.remove(customer.getIdCustomer());
        redirectAttributes.addFlashAttribute("message", "delete oK");
        return "redirect:/customer";
    }

    //    @GetMapping("/delete/{id}")
//    public String delete(Model model, @PathVariable(name="id") Long id){
//        customerService.remove(id);
//        return "redirect:/customer";
//    }
    @PostMapping("search")
    public String search(@RequestParam(name = "search") String name, Model model, Pageable pageable) {
        Page<Customer> customerPage = customerService.findAllbyname(pageable, name);
        model.addAttribute("list", customerPage);
        return "/Customer/view";

    }

    @GetMapping("/403")
    public String error() {
        return "/Customer/403";
    }


}
