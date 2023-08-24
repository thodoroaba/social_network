package com.socialnetwork.app.controller;

import com.socialnetwork.app.model.User;
import com.socialnetwork.app.service.UserService;

import java.sql.SQLException;
import java.util.List;

public class UserController {

    private static UserController instance;

    private UserController() { }

    public static UserController getInstance() {
        if(instance == null) {
            instance = new UserController();
        }
        return instance;
    }

    public List<User> getAllUsers() throws SQLException {
        return UserService.getInstance().getAllUsers();
    }

}
