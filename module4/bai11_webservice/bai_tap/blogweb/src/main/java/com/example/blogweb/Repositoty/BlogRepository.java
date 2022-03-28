package com.example.blogweb.Repositoty;

import com.example.blogweb.Model.Blog;
import com.example.blogweb.Model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Long> {
    public Page<Blog> findAllByCategory(Pageable pageable, Category category);
    public List<Blog> findAllByCategory(Category category);
}
