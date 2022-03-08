package com.codegym.quan_ly_khach_hang_tinh.controler;

import com.codegym.quan_ly_khach_hang_tinh.model.Customer;
import com.codegym.quan_ly_khach_hang_tinh.model.Province;
import com.codegym.quan_ly_khach_hang_tinh.service.ProvinceService;
import com.codegym.quan_ly_khach_hang_tinh.service.ServiceCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/province")
public class ProvinceController {

    @GetMapping("/view")
    public ModelAndView listProvince() {
        List<Province> provinces = provinceService.findAll();
        ModelAndView modelAndView = new ModelAndView("/province/view");
        modelAndView.addObject("provinces", provinces);
        return modelAndView;
    }

    @Autowired
    private ProvinceService provinceService;
    @Autowired
    private ServiceCustomer serviceCustomer;

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/province/create");
        modelAndView.addObject("province", new Province());
        return modelAndView;
    }
//
    @PostMapping("/create")
    public ModelAndView saveProvince(Province province) {
        provinceService.save(province);
        ModelAndView modelAndView = new ModelAndView("/province/create");
        modelAndView.addObject("province", new Province());
        modelAndView.addObject("message", "New customer created successfully");
        return modelAndView;
    }
    @GetMapping("/xem/{id}")
    public String lokkAll(Model model,@PathVariable(name="id") Long id){
Province province=provinceService.find(id);
List<Customer> customerList=serviceCustomer.findProcide(province);
model.addAttribute("customer",customerList);
model.addAttribute("province1",province);
return "/province/view-pro";

    }
//    @GetMapping("/edit/{id}")
//    public ModelAndView showEditForm(@PathVariable Long id) {
//        Customer customer = serviceCustomer.find(id);
//        if (customer != null) {
//            ModelAndView modelAndView = new ModelAndView("/customer/edit");
//            modelAndView.addObject("customer", customer);
//            return modelAndView;
//
//        } else {
//            ModelAndView modelAndView = new ModelAndView("/customer/error");
//            return modelAndView;
//        }
//    }
//
//    @PostMapping("/edit")
//    public ModelAndView updateCustomer(@ModelAttribute("customer") Customer customer) {
//        serviceCustomer.save(customer);
//        ModelAndView modelAndView = new ModelAndView("/customer/edit");
//        modelAndView.addObject("customer", customer);
//        modelAndView.addObject("message", "Customer updated successfully");
//        return modelAndView;
//    }
//    @GetMapping("/delete/{id}")
//    public ModelAndView showDeleteForm(@PathVariable Long id) {
//        Customer customer = serviceCustomer.find(id);
//        if (customer != null) {
//            ModelAndView modelAndView = new ModelAndView("/customer/delete");
//            modelAndView.addObject("customer", customer);
//            return modelAndView;
//
//        } else {
//            ModelAndView modelAndView = new ModelAndView("/customer/error");
//            return modelAndView;
//        }
//    }
//
//    @PostMapping("/delete")
//    public String deleteCustomer(@ModelAttribute("customer") Customer customer) {
//        serviceCustomer.delete(customer.getId());
//        return "redirect:customers";
//    }
}
