package com.codegym.quan_ly_khac_hang.controler;

import com.codegym.quan_ly_khac_hang.model.Customer;
import com.codegym.quan_ly_khac_hang.service.ServiceCustomer;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
        import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CustomerController {
    @GetMapping("/customers")
    public ModelAndView listCustomers() {
        List<Customer> customers = serviceCustomer.findAll();
        ModelAndView modelAndView = new ModelAndView("view");
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @Autowired
    private ServiceCustomer serviceCustomer;

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView saveCustomer(@ModelAttribute("customer") Customer customer) {
        serviceCustomer.save(customer);
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("message", "New customer created successfully");
        return modelAndView;
    }
    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Customer customer = serviceCustomer.find(id);
        if (customer != null) {
            ModelAndView modelAndView = new ModelAndView("edit");
            modelAndView.addObject("customer", customer);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error");
            return modelAndView;
        }
    }

    @PostMapping("/edit")
    public ModelAndView updateCustomer(@ModelAttribute("customer") Customer customer) {
        serviceCustomer.save(customer);
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("customer", customer);
        modelAndView.addObject("message", "Customer updated successfully");
        return modelAndView;
    }
    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Customer customer = serviceCustomer.find(id);
        if (customer != null) {
            ModelAndView modelAndView = new ModelAndView("delete");
            modelAndView.addObject("customer", customer);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("error");
            return modelAndView;
        }
    }

    @PostMapping("/delete")
    public String deleteCustomer(@ModelAttribute("customer") Customer customer) {
        serviceCustomer.delete(customer.getId());
        return "redirect:customers";
    }
    @GetMapping("/createProce")
    public ModelAndView showCreateForm1() {
        ModelAndView modelAndView = new ModelAndView("createProce");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/createProce")
    public ModelAndView saveCustomer1(@ModelAttribute("customer") Customer customer) {
        serviceCustomer.saveProcedue(customer.getFirstName(),customer.getLastName());
        ModelAndView modelAndView = new ModelAndView("createProce");
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("message", "New customer created successfully");
        return modelAndView;
    }
}