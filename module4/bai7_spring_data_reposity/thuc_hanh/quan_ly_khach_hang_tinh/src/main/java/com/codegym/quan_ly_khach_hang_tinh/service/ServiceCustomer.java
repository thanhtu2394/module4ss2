package com.codegym.quan_ly_khach_hang_tinh.service;

import com.codegym.quan_ly_khach_hang_tinh.model.Customer;
import com.codegym.quan_ly_khach_hang_tinh.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ServiceCustomer {
    List<Customer> findAll();
    void delete(Long id);
    Customer find(Long id);
    void save(Customer customer);
    List<Customer> findProcide(Province province);
    Page<Customer> findAllPage(Pageable pageable);
    Page<Customer> findallbyname(Pageable pageable,String name);
}
