package com.warehouse.service;


import com.warehouse.model.User;

public interface UserService {

    void save(User user);

    User findById(long id);

    User findByLogin(String login);

}