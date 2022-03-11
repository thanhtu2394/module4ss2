package com.example.form_dk.service;

import com.example.form_dk.model.User;

import java.util.List;

public interface UserService {
    List<User> findall();
    void create(User user);
}
