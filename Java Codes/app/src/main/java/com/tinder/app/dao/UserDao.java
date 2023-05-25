package com.tinder.app.dao;
import com.tinder.app.model.users;
import java.util.List;

public interface UserDao {
    void registerUser(users user);
    
    void updateUser(users user);
    
    void deleteUser(int user_id);
    
    users getUserById(int user_id);
    
    users getUserByName(String name);
    
    List<users> getAllUsers();
}