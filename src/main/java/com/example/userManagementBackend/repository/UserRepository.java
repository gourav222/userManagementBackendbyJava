package com.example.userManagementBackend.repository;

import com.example.userManagementBackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}