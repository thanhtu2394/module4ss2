package com.codegym.tao_blog.service.imp;

import com.codegym.tao_blog.Repository.BlogRepository;
import com.codegym.tao_blog.model.Blog;
import com.codegym.tao_blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Blog> findAll() {
        return blogRepository.findAll();
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
