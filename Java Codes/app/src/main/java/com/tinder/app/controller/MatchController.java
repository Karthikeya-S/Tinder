package com.tinder.app.controller;
import java.util.List;

import com.tinder.app.dao.MatchDao;
import com.tinder.app.dao.MatchDaoImpl;
import com.tinder.app.dao.UserDao;
import com.tinder.app.dao.UserDaoImpl;
import com.tinder.app.model.Match;
import com.tinder.app.model.User;
import com.tinder.app.utils.InputUtil;

public class MatchController {
    private UserDaoImpl userDao = new UserDaoImpl();
    private MatchDaoImpl matchDao = new MatchDaoImpl();

    public MatchController() {
        this.userDao = userDao;
        this.matchDao = matchDao;
    }

    public void likeUser(int username) {
        int userId = username;
        int likedUserId = InputUtil.promptInt("Enter the ID of the user you want to like: ");

        User user = userDao.getUserById(userId);
        User likedUser = userDao.getUserById(likedUserId);

        if (user == null || likedUser == null) {
            System.out.println("Invalid user ID!");
            return;
        }

        Match match = new Match(userId, likedUserId, false);
        matchDao.addMatch(match);

        System.out.println("You liked the user!");
    }

    public void viewMatches(int username) {
        int userId = username;
        User user = userDao.getUserById(userId);

        if (user == null) {
            System.out.println("User not found!");
            return;
        }

        System.out.println("Your matches:");

        // Get the list of matched users from the matchDao
        List<User> matches = matchDao.getMatches(user);

        if (matches.isEmpty()) {
            System.out.println("No matches found!");
            return;
        }

        for (User match : matches) {
            System.out.println(match.getName() + " (" + match.getAge() + ", " + match.getCity() + ")");
        }
    }

    public void viewLikedUsers(int username) {
        int userId = username;
        User user = userDao.getUserById(userId);

        if (user == null) {
            System.out.println("User not found!");
            return;
        }

        System.out.println("Users you have liked:");

        // Get the list of liked users from the matchDao
        List<User> likedUsers = matchDao.getLikedUsers(user);

        if (likedUsers.isEmpty()) {
            System.out.println("No liked users found!");
            return;
        }

        for (User likedUser : likedUsers) {
            System.out.println(likedUser.getName() + " (" + likedUser.getAge() + ", " + likedUser.getCity() + ")");
        }
    }
}
