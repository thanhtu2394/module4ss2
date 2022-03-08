package com.example.blog.Service;

import com.example.blog.Model.Blog;
import com.example.blog.Model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    void remove(Long id);
    Category findId(Long id);
    void save(Category category);
}
