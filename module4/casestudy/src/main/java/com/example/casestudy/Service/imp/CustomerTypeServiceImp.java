package com.example.casestudy.Service.imp;

import com.example.casestudy.Model.CustomerType;
import com.example.casestudy.Repository.CustomerTypeRepository;
import com.example.casestudy.Service.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeServiceImp implements CustomerTypeService {
    @Autowired
    CustomerTypeRepository customerTypeRepository;
    @Override
    public Page<CustomerType> findAll(Pageable pageable) {
        return customerTypeRepository.findAll(pageable);
    }

    @Override
    public List<CustomerType> findAllList() {
        return customerTypeRepository.findAll();
    }

    @Override
    public void save(CustomerType customerType) {
        customerTypeRepository.save(customerType);

    }

    @Override
    public CustomerType findById(Long id) {
        return customerTypeRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(Long id) {
customerTypeRepository.deleteById(id);
    }
}
