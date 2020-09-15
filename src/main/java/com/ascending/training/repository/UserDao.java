package com.ascending.training.repository;

import com.ascending.training.model.User;

import java.util.List;

public interface UserDao {

    User save(User user);
    User findByID(Long Id);
    User getUserByEmail(String email);
    User getUserByCredentials(String email, String password);
    void delete(User u);
    List<User> findAllUsers();
}
