package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        String connectionUrl = "jdbc:mysql://localhost:3306/social_network";
        String username = "root";
        String password = "password";

        Connection connection = DriverManager.getConnection(connectionUrl,
                username, password);

//        Statement ps = connection.createStatement();
//        ResultSet rs = ps.executeQuery("SELECT * FROM customers");
//        while (rs.next()) {
//            System.out.println(rs.getString("country"));
//        }

        PreparedStatement ps = connection.prepareStatement("SELECT * FROM user");
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            System.out.println(rs.getString("username"));
        }
    }
}