package com.example.blogweb.Repositoty;

import com.example.blogweb.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryReposity extends JpaRepository<Category,Long> {
}
