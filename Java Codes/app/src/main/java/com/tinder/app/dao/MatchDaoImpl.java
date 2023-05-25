package com.tinder.app.dao;
import com.tinder.app.model.Match;
import com.tinder.app.model.User;
import com.tinder.app.utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MatchDaoImpl implements MatchDao {
    private static final String ADD_MATCH_QUERY = "INSERT INTO matches(user_id, matched_user_id) VALUES (?, ?)";
    private static final String DELETE_MATCH_QUERY = "DELETE FROM matches WHERE id = ?";
    private static final String GET_MATCHES_QUERY = "SELECT u.* FROM users u INNER JOIN matches m ON u.id = m.matched_user_id WHERE m.user_id = ?";
    private static final String GET_LIKED_USERS_QUERY = "SELECT u.* FROM users u INNER JOIN matches m ON u.id = m.matched_user_id WHERE m.user_id = ?";

    public void addMatch(Match match) {
        try  {
        	Connection connection = DBConnection.createDBConnection();
            PreparedStatement statement = connection.prepareStatement(ADD_MATCH_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, match.getUserId());
            statement.setInt(2, match.getMatchedUserId());

            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Failed to add match, no rows affected.");
            }

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                match.setId(generatedKeys.getInt(1));
            } else {
                throw new SQLException("Failed to add match, no ID obtained.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteMatch(int matchId) {
        try {
        	Connection connection = DBConnection.createDBConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_MATCH_QUERY);
            statement.setInt(1, matchId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<User> getMatches(User user) {
        List<User> matches = new ArrayList<User>();

        try {
        	Connection connection = DBConnection.createDBConnection();
            PreparedStatement statement = connection.prepareStatement(GET_MATCHES_QUERY);
            statement.setInt(1, user.getId());
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                User matchedUser = extractUserFromResultSet(resultSet);
                matches.add(matchedUser);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return matches;
    }
    public List<User> getLikedUsers(User user) {
        List<User> likedUsers = new ArrayList<User>();

        try {
        	Connection connection = DBConnection.createDBConnection();
            PreparedStatement statement = connection.prepareStatement(GET_LIKED_USERS_QUERY);
            statement.setInt(1, user.getId());
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                User likedUser = extractUserFromResultSet(resultSet);
                likedUsers.add(likedUser);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return likedUsers;
    }

    private User extractUserFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String city = resultSet.getString("city");
        int age = resultSet.getInt("age");
        String gender = resultSet.getString("gender");
        int minAge = resultSet.getInt("min_age");
        int maxAge = resultSet.getInt("max_age");
        String bio = resultSet.getString("bio");
        String interests = resultSet.getString("interests");
        int numLikes = resultSet.getInt("num_likes");
        String password = resultSet.getString("password");

        return new User(id, name, city, age, gender, minAge, maxAge, bio, interests, numLikes, password);
    }
}