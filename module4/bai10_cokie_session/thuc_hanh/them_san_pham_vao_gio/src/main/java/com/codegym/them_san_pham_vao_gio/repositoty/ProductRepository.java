package com.codegym.them_san_pham_vao_gio.repositoty;

import com.codegym.them_san_pham_vao_gio.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

}
