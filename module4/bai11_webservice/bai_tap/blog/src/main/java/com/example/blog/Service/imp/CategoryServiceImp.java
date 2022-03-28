package com.example.blog.Service.imp;

import com.example.blog.Model.Category;
import com.example.blog.Repositoty.CategoryReposity;
import com.example.blog.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImp implements CategoryService {
    @Autowired
    CategoryReposity categoryReposity;
    @Override
    public List<Category> findAll() {
        return categoryReposity.findAll();
    }

    @Override
    public void remove(Long id) {
categoryReposity.deleteById(id);    }

    @Override
    public Category findId(Long id) {
        return categoryReposity.findById(id).orElse(null);
    }

    @Override
    public void save(Category category) {
categoryReposity.save(category);
    }
}
