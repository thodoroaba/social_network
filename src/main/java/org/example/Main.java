package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        String connectionUrl = "jdbc:mysql://localhost:3306/javadbschool1";
        String username = "root";
        String password = "pass";

        Connection connection = DriverManager.getConnection(connectionUrl,
                username, password);

//        Statement ps = connection.createStatement();
//        ResultSet rs = ps.executeQuery("SELECT * FROM customers");
//        while (rs.next()) {
//            System.out.println(rs.getString("country"));
//        }

        PreparedStatement ps = connection.prepareStatement("SELECT * FROM customers WHERE id = ?;");
        ps.setInt(1, 1);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            System.out.println(rs.getString("country"));
        }
    }
}