package com.example.userManagementBackend.service.Impl;
import com.example.userManagementBackend.entity.User;
import com.example.userManagementBackend.repository.UserRepository;
import com.example.userManagementBackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }


    @Override
    public User getUser(Integer id) {
        User user = userRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user Id:" + id));

        return user;
    }

    @Override
    public void deleteUser(Integer id) {
        User user = userRepository
                .findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user Id:" + id));
        userRepository.delete(user);
    }

    @Override
    public void updateUser(Integer id, User user) {
        userRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user Id:" + id));
        user.setId(id);
        userRepository.save(user);
    }

//    @Override
//    public void updateName(Integer id, UserDTO userDTO) {
////        check weather the user is in database or not
//        User user = userRepository
//                .findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user Id:" + id));
//
//        user.setName(userDTO.getName());
//
//        userRepository.save(user);
//
//    }
}
