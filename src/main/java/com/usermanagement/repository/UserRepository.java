package com.usermanagement.repository;

import com.usermanagement.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    void save(User user);

    void deleteById(int id);

    List<User> findAll();

    Optional<User> findById(int id);
}
