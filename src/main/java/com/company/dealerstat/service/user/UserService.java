package com.company.dealerstat.service.user;

import com.company.dealerstat.entity.user.User;

import java.util.List;

public interface UserService {

    List<User> findAllUsers();

    User findUser(int userId);

    User findUser(String email);

    void addUser(User user);

    void removeUser(int userId);

    void editUser(User user);
}