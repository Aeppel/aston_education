package com.pervishkond.myrestapp.controller;

import com.pervishkond.myrestapp.entity.Customer;
import com.pervishkond.myrestapp.exception.NoPersonException;
import com.pervishkond.myrestapp.service.CustomerService;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
public class CustomerRestController {

    CustomerService service;

    public CustomerRestController(CustomerService service){
        this.service = service;
    }

    @GetMapping("/")
    public List<Customer> home() {
        List<Customer> customerList = service.listAll();
        return customerList;
    }

    @GetMapping("/new")
    public Customer newCustomer(@RequestBody Customer customer) {
        service.save(customer);
        return customer;

    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id") Integer id) {
        Customer customer = service.get(id);
        if (customer == null) throw new NoPersonException("No Person with id =  " + id);
        service.delete(id);
        return "Deleted Person with id = " + id;
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable( value = "id") Integer id) {
        Customer customer = service.get(id);
        if (customer == null) throw new NoPersonException("No Person with id =  " + id);
        service.delete(id);
        return "Edited Person with id = " + id;
    }

}
