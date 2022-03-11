package com.example.form_dk.repository;

import com.example.form_dk.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserReporsitory extends JpaRepository<User,Long> {
}
