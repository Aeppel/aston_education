package com.pervishkond.myrestapp.service;

import com.pervishkond.myrestapp.DAO.CustomerDAOImpl;
import com.pervishkond.myrestapp.entity.Customer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerService {

    private final CustomerDAOImpl customerDAO;

    public CustomerService(CustomerDAOImpl repository) {
        this.customerDAO = repository;
    }

    public void save(Customer customer) {
        customerDAO.save(customer);
    }

    public List<Customer> listAll() {
        return customerDAO.listAll();
    }

    public Customer get(Integer id) {
        return customerDAO.get(id);
    }

    @Transactional
    public void delete(Integer id) {
        customerDAO.delete(id);
    }

}
