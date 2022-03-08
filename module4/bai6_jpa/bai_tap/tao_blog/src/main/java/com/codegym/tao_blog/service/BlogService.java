package com.codegym.tao_blog.service;

import com.codegym.tao_blog.model.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();
    void remove(Long id);
    Blog findId(Long id);
    void save(Blog blog);
}
