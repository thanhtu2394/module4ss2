package com.codegym.quan_ly_khach_hang_tinh.service.CustomerServiceImp;

import com.codegym.quan_ly_khach_hang_tinh.model.Customer;
import com.codegym.quan_ly_khach_hang_tinh.model.Province;
import com.codegym.quan_ly_khach_hang_tinh.repository.CustomerRepository;
import com.codegym.quan_ly_khach_hang_tinh.service.ServiceCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public List<Customer> findProcide(Province province) {
        return customerRepository.findAllByProvince(province);
    }

    @Override
    public Page<Customer> findAllPage(Pageable pageable) {
        return customerRepository.findAll(pageable);

    }

    @Override
    public Page<Customer> findallbyname(Pageable pageable, String name) {
        return customerRepository.findAllByFirstNameContaining(name,pageable);
    }


}
