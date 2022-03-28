package com.example.quan_ly_khach_hang.controler;

import com.example.quan_ly_khach_hang.model.Customer;
import com.example.quan_ly_khach_hang.service.ServiceCustomer;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("cuswebservice")
public class CustomerControllerService {
    @Autowired
    ServiceCustomer serviceCustomer;
    @GetMapping
    public ResponseEntity<List<Customer>> getCustomer(){
        List<Customer> customers=serviceCustomer.findAll();
        return new ResponseEntity<>(customers,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable(name="id") Long id){
        Optional<Customer> customer= Optional.ofNullable(serviceCustomer.find(id));
        if(customer.isPresent()){
            return new ResponseEntity<>(customer.get(),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Customer customer){
        serviceCustomer.save(customer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        Optional<Customer> customerOptional = Optional.ofNullable(serviceCustomer.find(id));
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customer.setId(customerOptional.get().getId());
        serviceCustomer.save(customer);
        return new ResponseEntity<>(customerOptional.get(),HttpStatus.OK);
    }
    @PutMapping()
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
        serviceCustomer.save(customer);
        return new ResponseEntity<>(customer,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable Long id) {
        Optional<Customer> customerOptional = Optional.ofNullable(serviceCustomer.find(id));
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        serviceCustomer.delete(id);
        return new ResponseEntity<>(customerOptional.get(),HttpStatus.OK);
    }


}
