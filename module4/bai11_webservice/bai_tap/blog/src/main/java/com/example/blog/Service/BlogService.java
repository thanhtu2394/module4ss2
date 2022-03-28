package com.example.blog.Service;

import com.example.blog.Model.Blog;
import com.example.blog.Model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {
    Page<Blog> findAll(Pageable pageable);
    void remove(Long id);
    Blog findId(Long id);
    void save(Blog blog);
    Page<Blog> findCategory(Pageable pageable, Category category);
}
