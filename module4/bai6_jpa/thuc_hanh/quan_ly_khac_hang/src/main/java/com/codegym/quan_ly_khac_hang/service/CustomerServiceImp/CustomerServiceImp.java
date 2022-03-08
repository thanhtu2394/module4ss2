package com.codegym.quan_ly_khac_hang.service.CustomerServiceImp;

import com.codegym.quan_ly_khac_hang.model.Customer;
import com.codegym.quan_ly_khac_hang.repository.CustomerRepository;
import com.codegym.quan_ly_khac_hang.service.ServiceCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImp implements ServiceCustomer {
    @Autowired
    CustomerRepository customerRepository;
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void delete(Long id) {
customerRepository.deleteById(id);
    }

    @Override
    public Customer find(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Customer customer) {
customerRepository.save(customer);
    }

    @Override
    public void saveProcedue(String firts, String last) {
        customerRepository.createProcedue(firts,last);
    }
}
