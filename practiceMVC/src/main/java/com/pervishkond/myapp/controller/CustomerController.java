package com.pervishkond.myapp.controller;

import com.pervishkond.myapp.entity.Customer;
import com.pervishkond.myapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class CustomerController {

    CustomerService service;

    public CustomerController(CustomerService service){
        this.service = service;
    }

    @GetMapping("/")
    public ModelAndView home() {
        List<Customer> customerList = service.listAll();
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("customerList", customerList);
        return mav;
    }

    @GetMapping("/new")
    public String newCustomer(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "new_customer";

    }

    @PostMapping(value = "/save")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        service.save(customer);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable (value = "id") Integer id) {
        service.delete(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable( value = "id") Integer id, Model model) {
        Customer customer = service.get(id);
        model.addAttribute("customer", customer);
        return "edit";
    }

}
