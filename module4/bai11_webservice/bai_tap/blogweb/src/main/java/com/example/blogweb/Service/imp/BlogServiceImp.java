package com.example.blogweb.Service.imp;


import com.example.blogweb.Model.Blog;
import com.example.blogweb.Model.Category;
import com.example.blogweb.Repositoty.BlogRepository;
import com.example.blogweb.Service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogServiceImp implements BlogService {
   @Autowired
   BlogRepository blogRepository;
    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Page<Blog> findCategory(Pageable pageable, Category category) {
        return blogRepository.findAllByCategory(pageable,category);
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public List<Blog> findall23() {
        return blogRepository.findAll();
    }

    @Override
    public List<Blog> findbycategory(Category category) {
        return blogRepository.findAllByCategory(category);
    }

    @Override
    public void remove(Long id) {
blogRepository.deleteById(id);
    }

    @Override
    public Blog findId(Long id) {
        return blogRepository.findById(id).orElse(null);
    }
}
