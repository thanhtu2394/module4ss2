package com.codegym.service;

import com.codegym.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductServiceImp implements  ProductServiceInterface{
    public static List<Product> productList;
    static {
        productList=new ArrayList<>();
        productList.add(new Product(1,"a",12,"like","pvd"));
        productList.add(new Product(2,"b",12,"like1","pvd"));
        productList.add(new Product(3,"c",12,"like2","pvd"));
        productList.add(new Product(4,"d",12,"like3","pvd"));
    }
    @Override
    public List<Product> findall() {
        return productList;
    }

    @Override
    public void save(Product product) {
        productList.add(product);
    }

    @Override
    public void edit(int id, Product product) {
        for (Product i:productList
             ) {
            if (i.getId()==id){
                i.setName(product.getName());
                i.setPrice(product.getPrice());
                i.setDescription(product.getDescription());
                i.setProducer(product.getProducer());
            }
        }
    }


    @Override
    public void remove(int id) {
        for (int i = 0; i <productList.size() ; i++) {
            if(productList.get(i).getId()==id){
                productList.remove(i);
                break;
            }
        }
    }

    @Override
    public Product findId(int id) {
        int j=0;
        for (int i = 0; i <productList.size() ; i++) {
            if(productList.get(i).getId()==id){
              j=i;
                break;
            }
        }
        return productList.get(j);
    }
}
