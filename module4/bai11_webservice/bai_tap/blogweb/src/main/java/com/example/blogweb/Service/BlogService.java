package com.example.blogweb.Service;

import com.example.blogweb.Model.Blog;
import com.example.blogweb.Model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {
    Page<Blog> findAll(Pageable pageable);
    List<Blog> findall23();
    List<Blog> findbycategory(Category category);
    void remove(Long id);
    Blog findId(Long id);
    void save(Blog blog);
    Page<Blog> findCategory(Pageable pageable, Category category);
}
