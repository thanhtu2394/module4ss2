package com.codegym.them_san_pham_vao_gio.model;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class Cart {
    private Map<Product,Integer> products = new HashMap<>();

    public Cart(Map<Product, Integer> products) {
        this.products = products;
    }

    public Cart() {
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }
    public Map.Entry<Product, Integer> checkProduct(Product product){
        for (Map.Entry<Product,Integer> index: products.entrySet()
             ) {
            if(index.getKey().getId().equals(product.getId())){
                return index;
            }
        }
        return null;
    }
    public void addProduct(Product product, Optional<String> name){

        if(checkProduct(product) != null){
            if(name.isPresent()){
                String name1=name.get();
                Map.Entry<Product,Integer> index1=checkProduct(product);
                Integer index = index1.getValue()-1;
                products.replace(index1.getKey(),index);
            }else {
            Map.Entry<Product,Integer> index1=checkProduct(product);
            Integer index = index1.getValue()+1;
            products.replace(index1.getKey(),index);
        }}else {
            products.put(product,1);
        }
    }
}
