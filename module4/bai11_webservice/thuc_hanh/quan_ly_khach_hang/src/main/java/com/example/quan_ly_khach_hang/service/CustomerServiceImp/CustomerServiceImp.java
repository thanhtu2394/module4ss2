package com.example.quan_ly_khach_hang.service.CustomerServiceImp;

import com.example.quan_ly_khach_hang.model.Customer;
import com.example.quan_ly_khach_hang.repository.CustomerRepository;
import com.example.quan_ly_khach_hang.service.ServiceCustomer;
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
