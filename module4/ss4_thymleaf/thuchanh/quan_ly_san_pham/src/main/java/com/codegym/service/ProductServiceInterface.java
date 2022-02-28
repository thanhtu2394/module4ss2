package com.codegym.service;

import com.codegym.model.Product;

import java.util.List;

public interface ProductServiceInterface {
    public List<Product> findall();
    public void save(Product product);
    public void edit(int id,Product product);
    public void remove(int id);
    public Product findId(int id);
}
