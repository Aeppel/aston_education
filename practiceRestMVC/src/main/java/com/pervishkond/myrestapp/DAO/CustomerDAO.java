package com.pervishkond.myrestapp.DAO;

import com.pervishkond.myrestapp.entity.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDAO {
    public void save(Customer customer);

    public List<Customer> listAll();

    public Customer get(Integer id);

    public void delete(Integer id);
}
