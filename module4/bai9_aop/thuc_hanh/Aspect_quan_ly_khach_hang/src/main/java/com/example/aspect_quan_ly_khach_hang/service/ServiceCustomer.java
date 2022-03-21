package com.example.aspect_quan_ly_khach_hang.service;

import com.example.aspect_quan_ly_khach_hang.model.Customer;

import java.util.List;

public interface ServiceCustomer {
    List<Customer> findAll();
    void delete(Long id);
    Customer find(Long id);
    void save(Customer customer);
    void saveProcedue(String firts,String last) throws Exception;
}
