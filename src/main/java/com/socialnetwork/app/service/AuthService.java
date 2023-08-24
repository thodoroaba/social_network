package com.socialnetwork.app.service;

public class AuthService {
    private static AuthService instance;

    private AuthService() {

    }

    public static AuthService getInstance() {
        if (instance == null) {
            instance = new AuthService();
        }
        return instance;
    }

    public boolean checkAuth(String username, String password) {
        boolean result = false;
        // TODO
        return result;
    }
}
