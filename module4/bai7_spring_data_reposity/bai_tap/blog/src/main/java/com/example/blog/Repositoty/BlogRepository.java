package com.example.blog.Repositoty;

import com.example.blog.Model.Blog;
import com.example.blog.Model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Long> {
    public Page<Blog> findAllByCategory(Pageable pageable, Category category);
}
