package com.tinder.app.controller;
import com.tinder.app.utils.InputUtil;
import com.tinder.app.model.*;
import com.tinder.app.dao.UserDao;

public class UserController {
    private final UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    public void registerUser() {
        System.out.println("===== User Registration =====");
        String password = InputUtil.promptString("Enter the password (Min: 8 Max: 15): ");
        String name = InputUtil.promptString("Enter your name: ");
        String gender = InputUtil.promptString("Enter your gender (M/F): ");
        int age = InputUtil.promptInt("Enter your age: ");
        String city = InputUtil.promptString("Enter your location: ");
        int minAge = InputUtil.promptInt("Enter minimum age: ");
        int maxAge = InputUtil.promptInt("Enter maximum age: ");
        
        String bio = InputUtil.promptString("About you? ");
        
        String interests = InputUtil.promptString("Enter your interests: ");
        
        users newUser = new users(name,gender, age, minAge, maxAge, bio, city, interests, password);
        userDao.registerUser(newUser);
        System.out.println("Registration successful!");
    }

    public void loginUser() {
        System.out.println("===== User Login =====");
        String name = InputUtil.promptString("Enter your name: ");
        // You can add additional authentication steps like password input

        users user = userDao.getUserByName(name);
        if (user != null) {
            System.out.println("Welcome back, " + user.getName() + "!");
            // Proceed with application flow for logged-in user
        } else {
            System.out.println("User not found. Please register first.");
        }
    }

    // You can add more methods for user management, such as updating user profile, deleting user account, etc.
}