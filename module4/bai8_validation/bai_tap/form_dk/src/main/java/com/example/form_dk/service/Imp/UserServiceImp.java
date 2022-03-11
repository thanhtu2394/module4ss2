package com.example.form_dk.service.Imp;

import com.example.form_dk.model.User;
import com.example.form_dk.repository.UserReporsitory;
import com.example.form_dk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserReporsitory userReporsitory;
    @Override
    public List<User> findall() {
        return userReporsitory.findAll();
    }

    @Override
    public void create(User user) {
userReporsitory.save(user);
    }
}
