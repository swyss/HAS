package com.has.adminhub.backend.services;

import com.has.adminhub.backend.entities.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User updateUser(Long id, User user);
    void deleteUser(Long id);
    List<User> getAllUsers();
}

