package com.example.userManagementBackend.service;

import com.example.userManagementBackend.dto.UserDTO;
import com.example.userManagementBackend.entity.User;
import java.util.List;

public interface UserService {
    void addUser(User user);
    List<User> getUsers();

    User getUser(Integer id);

    void deleteUser(Integer id);

    void updateUser(Integer id, User user);

//    void updateName(Integer id, UserDTO userDTO);
}
