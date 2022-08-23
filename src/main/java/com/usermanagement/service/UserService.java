package com.usermanagement.service;

import com.usermanagement.model.User;

import java.util.List;
import java.util.Optional;


public interface UserService {
    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(int id);

    Optional<User> getUser(int id);

    List<User> getAllUser();
}