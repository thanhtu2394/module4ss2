package com.example.blogweb.Service;

import com.example.blogweb.Model.Blog;
import com.example.blogweb.Model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    void remove(Long id);
    Category findId(Long id);
    void save(Category category);
}
