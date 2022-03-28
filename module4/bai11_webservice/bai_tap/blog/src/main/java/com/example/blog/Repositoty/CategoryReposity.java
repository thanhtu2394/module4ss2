package com.example.blog.Repositoty;

import com.example.blog.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryReposity extends JpaRepository<Category,Long> {
}
