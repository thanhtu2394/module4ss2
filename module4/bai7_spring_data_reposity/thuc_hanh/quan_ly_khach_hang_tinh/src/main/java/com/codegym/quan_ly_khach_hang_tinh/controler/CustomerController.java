package com.codegym.quan_ly_khach_hang_tinh.controler;

import com.codegym.quan_ly_khach_hang_tinh.model.Customer;
import com.codegym.quan_ly_khach_hang_tinh.model.Province;
import com.codegym.quan_ly_khach_hang_tinh.service.ProvinceService;
import com.codegym.quan_ly_khach_hang_tinh.service.ServiceCustomer;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @GetMapping("/customers")
    public ModelAndView listCustomers(Model model) {
        List<Customer> customers = serviceCustomer.findAll();
        ModelAndView modelAndView = new ModelAndView("/customer/view");
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }
    @GetMapping("/viewpage")
    public String viewpage(Model model,@PageableDefault(size = 4) Pageable pageable){
        Page<Customer> customerPage=serviceCustomer.findAllPage(pageable);
        model.addAttribute("customerpage",customerPage);
        return "/customer/viewpage";
    }
    @GetMapping("/search")
    public String search(@PageableDefault(size = 4) Pageable pageable,Model model,@RequestParam(name="name") String name){
        String name1=name;
        Page<Customer> customerPage=serviceCustomer.findallbyname(pageable, name1);
        model.addAttribute("customerpage",customerPage);
        return "/customer/viewpage";
    }

    @Autowired
    private ServiceCustomer serviceCustomer;
    @Autowired
    private ProvinceService provinceService;

    @GetMapping("/create")
    public ModelAndView showCreateForm(Model model) {
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customer", new Customer());
        List<Province> provinces=provinceService.findAll();
        model.addAttribute("provinces",provinces);
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView saveCustomer(@ModelAttribute("customer") Customer customer,Model model) {
        serviceCustomer.save(customer);
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customer", new Customer());
        List<Province> provinces=provinceService.findAll();
        model.addAttribute("provinces",provinces);
        modelAndView.addObject("message", "New customer created successfully");
        return modelAndView;
    }
    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id,Model model) {
        Customer customer = serviceCustomer.find(id);
        if (customer != null) {
            ModelAndView modelAndView = new ModelAndView("/customer/edit");
            modelAndView.addObject("customer", customer);
            List<Province> provinces=provinceService.findAll();
            model.addAttribute("provinces",provinces);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/customer/error");
            return modelAndView;
        }
    }

    @PostMapping("/edit")
    public ModelAndView updateCustomer(@ModelAttribute("customer") Customer customer) {
        serviceCustomer.save(customer);
        ModelAndView modelAndView = new ModelAndView("/customer/edit");
        modelAndView.addObject("customer", customer);
        modelAndView.addObject("message", "Customer updated successfully");
        return modelAndView;
    }
    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Customer customer = serviceCustomer.find(id);
        if (customer != null) {
            ModelAndView modelAndView = new ModelAndView("/customer/delete");
            modelAndView.addObject("customer", customer);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/customer/error");
            return modelAndView;
        }
    }

    @PostMapping("/delete")
    public String deleteCustomer(@ModelAttribute("customer") Customer customer) {
        serviceCustomer.delete(customer.getId());
        return "redirect:customers";
    }

}