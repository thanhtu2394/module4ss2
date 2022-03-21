package com.codegym.them_san_pham_vao_gio.service;

import com.codegym.them_san_pham_vao_gio.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(Long id);
}
