package com.example.casestudy.Service;

import com.example.casestudy.Model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {
    Page<Customer> findAll(Pageable pageable);
    Page<Customer> findAllbyname(Pageable pageable,String name);
    void save(Customer customer);
    Customer findById(Long id);
    void remove(Long id);
}
