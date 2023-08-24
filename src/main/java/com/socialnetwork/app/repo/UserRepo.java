package com.socialnetwork.app.repo;

import com.socialnetwork.app.model.User;
import com.socialnetwork.app.utils.PropertiesReader;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserRepo {
    private static UserRepo instance;
    private static Connection connection;

    public static final String USER_USERNAME = "username";
    public static final String USER_ID = "id";
    public static final String USER_EMAIL = "email_address";
    public static final String USER_PIC = "profile_pic";
    public static final String USER_REG_DATE = "registered_on";
    public static final String USER_PASSWORD = "password";
    public static final String TABLE_USER = "user";
    private UserRepo(){
    }

    public static UserRepo getInstance() throws SQLException {
        if(instance == null){
            instance= new UserRepo();
            connection = DriverManager.getConnection(
                    PropertiesReader.getInstance().getDbURL(),
                    PropertiesReader.getInstance().getDbName(),
                    PropertiesReader.getInstance().getDbPass());
        }

        return instance;
    }

    public boolean checkAuth(String username, String password) throws SQLException {
        boolean result = false;
        String query = String.format("SELECT * FROM user WHERE %s = '%s' AND %s = '%s';" ,
                USER_USERNAME,
                username,
                USER_PASSWORD,
                password);

        PreparedStatement ps = connection.prepareStatement(query);

        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            result = true;
        }
        return result;
    }

    public List<User> getAllUsers() throws SQLException {

        List<User> userList = new ArrayList<>();
        String query = String.format("SELECT * FROM %s;", TABLE_USER);
        PreparedStatement ps = connection.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            userList.add(new User.UserBuilder()
                    .setUsername(rs.getString(USER_USERNAME))
                    .setId(rs.getString(USER_ID))
                    .setEmailAddress(rs.getString(USER_EMAIL))
                    .setProfilePic(rs.getString(USER_PIC))
                    .setRegisteredOn(new Date(rs.getLong(USER_REG_DATE)))
                    .build()
            );

        }
        return userList;
    }
}
