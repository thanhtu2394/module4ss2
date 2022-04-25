package com.example.test.service;

import com.example.test.model.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface QuestionService {
    Page<Question> findAll(Pageable pageable);
//    Page<Question> findAll1(Pageable pageable,String name);
    void save(Question question);
    void delete(Long id);
    Question findbyid(Long id);


}
