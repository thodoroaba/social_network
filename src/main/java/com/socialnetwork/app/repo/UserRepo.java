package com.socialnetwork.app.repo;

import com.socialnetwork.app.model.User;
import com.socialnetwork.app.utils.PropertiesReader;

import java.sql.*;

public class UserRepo {
    private static UserRepo instance;
    private static Connection connection;

    public static final String USER_USERNAME = "username";
    public static final String USER_PASSWORD = "password";
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
}
