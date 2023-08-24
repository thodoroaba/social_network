package com.socialnetwork.app;

import com.socialnetwork.app.service.AuthService;
import com.socialnetwork.app.utils.PropertiesReader;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        System.out.println("Welcome to social network!");
        PropertiesReader.getInstance().loadProps();
        System.out.println("Enter 1 for getting all users");
        System.out.println("Enter 2 for getting a user by id");
        System.out.println("Enter 3 for deleting a user by id");
        System.out.println("Enter 4 for updating a user");
        System.out.println("Enter 5 for testing auth");
        Scanner input = new Scanner(System.in);
        int option = input.nextInt();
        switch (option){
            case 1:

                break;
            case 2:
                //TODO
                break;
            case 3:
                //TODO
                break;
            case 4:
                //TODO
                break;
            case 5:
                System.out.println("Introdu username:");
                String username = input.next();
                System.out.println("Introdu password:");
                String pass = input.next();
                boolean isOk = AuthService.getInstance().checkAuth(username, pass);
                System.out.println("Auth result: " + isOk);
                break;
            default:
                System.out.println("This option is wrong!");
                break;
        }

    }
}
