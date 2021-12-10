package com.company.dealerstat.database.repository.user;

import com.company.dealerstat.entity.user.User;

import java.util.List;

public interface UserRepository {

    List<User> getAllUsers();

    User getUser(int userId);

    User getUser(String email);

    void addUser(User user);

    void deleteUser(int userId);

    void editUser(User user);
}