package com.tinder.app.dao;
import com.tinder.app.model.User;
import com.tinder.app.utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private static final String INSERT_USER_QUERY = "INSERT INTO users(name, city, age, gender, minAge, maxAge, bio, interests, likes, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_USER_QUERY = "UPDATE users SET name = ?, city = ?, age = ?, gender = ?, minAge = ?, maxAge = ?, bio = ?, interests = ?, no_of_likes = ?, password = ? WHERE user_id = ?";
    private static final String DELETE_USER_QUERY = "DELETE FROM users WHERE user_id = ?";
    private static final String GET_USER_BY_ID_QUERY = "SELECT * FROM users WHERE user_id = ?";
    private static final String GET_ALL_USERS_QUERY = "SELECT * FROM users";

    public void addUser(User user) {
        try {
        	Connection connection = DBConnection.createDBConnection();
            PreparedStatement statement = connection.prepareStatement(INSERT_USER_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getName());
            statement.setString(2, user.getCity());
            statement.setInt(3, user.getAge());
            statement.setString(4, user.getGender());
            statement.setInt(5, user.getMinAge());
            statement.setInt(6, user.getMaxAge());
            statement.setString(7, user.getBio());
            statement.setString(8, user.getInterests());
            statement.setInt(9, user.getNumOfLikes());
            statement.setString(10, user.getPassword());

            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Failed to add user, no rows affected.");
            }

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                user.setId(generatedKeys.getInt(1));
            } else {
                throw new SQLException("Failed to add user, no ID obtained.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateUser(User user) {
        try {
        	Connection connection = DBConnection.createDBConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_USER_QUERY);
            statement.setString(1, user.getName());
            statement.setString(2, user.getCity());
            statement.setInt(3, user.getAge());
            statement.setString(4, user.getGender());
            statement.setInt(5, user.getMinAge());
            statement.setInt(6, user.getMaxAge());
            statement.setString(7, user.getBio());
            statement.setString(8, user.getInterests());
            statement.setInt(9, user.getNumOfLikes());
            statement.setString(10, user.getPassword());
            statement.setInt(11, user.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteUser(int userId) {
        try {
        	Connection connection = DBConnection.createDBConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_USER_QUERY);
            statement.setInt(1, userId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public User getUserById(int userId) {
        User user = null;

        try {
        	Connection connection = DBConnection.createDBConnection();
            PreparedStatement statement = connection.prepareStatement(GET_USER_BY_ID_QUERY);
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user = extractUserFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();

        try {
        	Connection connection = DBConnection.createDBConnection();
            PreparedStatement statement = connection.prepareStatement(GET_ALL_USERS_QUERY);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user = extractUserFromResultSet(resultSet);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    private User extractUserFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("user_id");
        String name = resultSet.getString("name");
        String city = resultSet.getString("city");
        int age = resultSet.getInt("age");
        String gender = resultSet.getString("gender");
        int minAge = resultSet.getInt("minAge");
        int maxAge = resultSet.getInt("maxAge");
        String bio = resultSet.getString("bio");
        String interests = resultSet.getString("interests");
        int numLikes = resultSet.getInt("likes");
        String password = resultSet.getString("password");

        return new User(id, name, city, age, gender, minAge, maxAge, bio, interests, numLikes, password);
    }
}
