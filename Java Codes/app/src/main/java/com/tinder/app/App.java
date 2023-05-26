package com.tinder.app;
import com.tinder.app.controller.UserController;

import java.io.IOException;

import com.tinder.app.controller.MatchController;
import com.tinder.app.controller.MessageController;
import com.tinder.app.utils.InputUtil;
import com.tinder.app.dao.MatchDao;
import com.tinder.app.dao.UserDao;

public class App {
    private static final UserController userController = new UserController();
    private static final MessageController messageController = new MessageController();
    private static final MatchController matchController = new MatchController();

    public static void main(String[] args) throws InterruptedException, IOException {
        System.out.println("Welcome to Command Line Tinder!");

        // Prompt the user to login or register
        loginOrRegister();

        // Display main menu
//        showMainMenu();
    }

    public static void loginOrRegister() throws InterruptedException, IOException {
        boolean loggedIn = false;

        while (!loggedIn) {
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");

            int choice = InputUtil.promptInt("Enter your choice");
            boolean flag = false;
            
            switch (choice) {
                case 1:
                    int username = InputUtil.promptInt("Enter your username");
                    String password = InputUtil.promptString("Enter your password");
                    loggedIn = userController.login(username, password);
                    if (loggedIn) {
                        showMainMenu(username);
                    }
                    else {
                    	System.out.println("Invalid Password");
                    }
                    break;
                case 2:
//                    String newUser = InputUtil.promptString("Enter a new username");
//                    String newPassword = InputUtil.promptString("Enter a new password");
                    userController.registerUser();
                    System.out.println("Registration successful! Please login.");
                    break;
                case 3:
                    System.out.println("Thank you for using Command Line Tinder. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void showMainMenu(int username) throws InterruptedException, IOException {
        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. View Matches");
            System.out.println("2. View Liked Users");
            System.out.println("3. View Messages");
            System.out.println("4. Like User");
            System.out.println("5. Send Message");
            System.out.println("6. Logout");

            int choice = InputUtil.promptInt("Enter your choice");

            switch (choice) {
                case 1:
                    userController.viewMatches(username);
                    break;
                case 2:
                    matchController.viewLikedUsers(username);
                    break;
                case 3:
                	messageController.viewMessages(username);
                    break;
                case 4:
                    matchController.likeUser(username);
                    break;
                case 5:
                    messageController.sendMessage(username);
                    break;
                case 6:
                    userController.logout();
                    loginOrRegister();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}