package com.example.casestudy.Service.imp;

import com.example.casestudy.Model.Customer;
import com.example.casestudy.Repository.CustomerRepositopry;
import com.example.casestudy.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImp implements CustomerService {
    @Autowired
    CustomerRepositopry customerRepositopry;
    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepositopry.findAll(pageable);
    }

    @Override
    public Page<Customer> findAllbyname(Pageable pageable, String name) {
        return customerRepositopry.findAllByNameCustomerContains(pageable,name);
    }

    @Override
    public void save(Customer customer) {
customerRepositopry.save(customer);
    }

    @Override
    public Customer findById(Long id) {
        return customerRepositopry.findById(id).orElse(null);
    }

    @Override
    public void remove(Long id) {
customerRepositopry.deleteById(id);
    }
}
