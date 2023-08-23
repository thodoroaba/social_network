package org.example;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        String connectionUrl = "jdbc:mysql://localhost:3306/social_network";
        String dbUser = "root";
        String dbPass = "0745201259";

        Connection connection = DriverManager.getConnection(connectionUrl,
                dbUser, dbPass);

        Scanner input = new Scanner(System.in);
        System.out.println("Insert username");
        String username = input.nextLine();
        System.out.println("Insert password");
        String password = input.nextLine();
        String qu = String.format("select username from user where username = '%s' and password = '%s';" , username , password);

        PreparedStatement ps = connection.prepareStatement("SELECT * FROM user WHERE username = ? AND password = ? ;");
        ps.setString(1, username);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();

            if(rs.next()){
                System.out.println("Welcome " + username);
            }else{
                System.out.println("Authentication failed");
            }
    }
}