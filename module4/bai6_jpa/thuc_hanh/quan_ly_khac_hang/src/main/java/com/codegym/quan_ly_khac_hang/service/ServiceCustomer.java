package com.codegym.quan_ly_khac_hang.service;

import com.codegym.quan_ly_khac_hang.model.Customer;

import java.util.List;

public interface ServiceCustomer {
    List<Customer> findAll();
    void delete(Long id);
    Customer find(Long id);
    void save(Customer customer);
    void saveProcedue(String firts,String last);
}
