package com.tinder.app.controller;
import com.tinder.app.utils.InputUtil;
import com.tinder.app.dao.UserDaoImpl;
import com.tinder.app.dao.MatchDaoImpl;

import java.util.List;

import com.tinder.app.App;
import com.tinder.app.dao.MatchDao;
import com.tinder.app.model.User;

public class UserController {
    private UserDaoImpl userDao = new UserDaoImpl();
    private MatchDaoImpl matchDao = new MatchDaoImpl();

    public UserController() {
        this.userDao = userDao;
        this.matchDao = matchDao;
    }

    public void registerUser() {
        String name = InputUtil.promptString("Enter your name: ");
        String city = InputUtil.promptString("Enter your city: ");
        int age = InputUtil.promptInt("Enter your age: ");
        String gender = InputUtil.promptString("Enter your gender: ");
        int minAge = InputUtil.promptInt("Enter the minimum age preference: ");
        int maxAge = InputUtil.promptInt("Enter the maximum age preference: ");
        String bio = InputUtil.promptString("Enter your bio: ");
        String password = InputUtil.promptString("Enter your password: ");

        User user = new User(name, city, age, gender, minAge, maxAge, bio, password);
        userDao.addUser(user);
        System.out.println("User registered successfully!");
    }

    public void viewMatches(int username) {
        int userId = username;
        User user = userDao.getUserById(userId);

        if (user == null) {
            System.out.println("User not found!");
            return;
        }

        System.out.println("Your matches:");

        // Get the list of matched users from the matchDao based on user's preferences
        List<User> matches = matchDao.getMatches(user);

        if (matches.isEmpty()) {
            System.out.println("No matches found!");
            return;
        }

        for (User match : matches) {
            System.out.println(match.getName() + " (" + match.getAge() + ", " + match.getCity() + ")");
        }
    }
    public boolean login(int username, String password) {
        User user = userDao.getUserById(username);
        if (user != null && user.getPassword().equals(password)) {
            System.out.println("Welcome Back user: "+username);
            return true;
        }
//        else if(user==null && user.getPassword().equals(password)) {
////        	System.out.println("User not found. Please register");
//        }
//        else if(user!=null && !user.getPassword().equals(password)) {
////        	System.out.println("User not found. Please register");
//        }
//        System.out.println("Please check your credentials.");
        return false;
    }
    public void logout() {
    	System.out.println("Thank you! You're logged out successfully");
//    	System.exit(0);
    	System.out.print("\033[H\033[2J");  
    	System.out.flush();  
    	App.loginOrRegister();
    }
}