package com.aoher.services;

import com.aoher.entity.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);
    List<User> getUsers();
    User getUserById(int userId);
    void deleteUserById(int userId);
    User updateUser(User user);
}
