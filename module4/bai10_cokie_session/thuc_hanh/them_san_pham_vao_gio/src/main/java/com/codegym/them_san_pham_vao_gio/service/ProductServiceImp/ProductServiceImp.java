package com.codegym.them_san_pham_vao_gio.service.ProductServiceImp;

import com.codegym.them_san_pham_vao_gio.model.Product;
import com.codegym.them_san_pham_vao_gio.repositoty.ProductRepository;
import com.codegym.them_san_pham_vao_gio.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}
