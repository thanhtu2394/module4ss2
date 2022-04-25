package com.example.casestudy.Service;

import com.example.casestudy.Model.Customer;
import com.example.casestudy.Model.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerTypeService {
    Page<CustomerType> findAll(Pageable pageable);
    List<CustomerType> findAllList();
    void save(CustomerType customerType);
    CustomerType findById(Long id);
    void remove(Long id);
}
