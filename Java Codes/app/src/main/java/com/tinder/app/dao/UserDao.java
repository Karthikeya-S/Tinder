package com.tinder.app.dao;
import com.tinder.app.model.User;
import java.util.List;
import com.tinder.app.model.User;
import java.util.List;

public interface UserDao {
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(int userId);
    User getUserById(int userId);
    List<User> getAllUsers();
}
