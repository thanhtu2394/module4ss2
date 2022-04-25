package com.example.casestudy.Repository;

import com.example.casestudy.Model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepositopry extends JpaRepository<Customer,Long> {
    public Page<Customer> findAllByNameCustomerContains(Pageable pageable,String name);
}
