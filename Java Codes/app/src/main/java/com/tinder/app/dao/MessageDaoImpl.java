package com.tinder.app.dao;

import com.tinder.app.model.Message;
import com.tinder.app.model.User;
import com.tinder.app.utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MessageDaoImpl implements MessageDao {
    private static final String ADD_MESSAGE_QUERY = "INSERT INTO messages(sender_id, receiver_id, content) VALUES (?, ?, ?)";
    private static final String DELETE_MESSAGE_QUERY = "DELETE FROM messages WHERE id = ?";
    private static final String GET_MESSAGES_BY_USER_QUERY = "SELECT * FROM messages WHERE (sender_id = ? AND receiver_id = ?) OR (sender_id = ? AND receiver_id = ?) ORDER BY timestamp";

    public void addMessage(Message message) {
        try  {
        	Connection connection = DBConnection.createDBConnection();
            PreparedStatement statement = connection.prepareStatement(ADD_MESSAGE_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, message.getSenderId());
            statement.setInt(2, message.getReceiverId());
            statement.setString(3, message.getContent());

            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Failed to add message, no rows affected.");
            }

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                message.setId(generatedKeys.getInt(1));
            } else {
                throw new SQLException("Failed to add message, no ID obtained.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteMessage(int messageId) {
        try {
        	Connection connection = DBConnection.createDBConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_MESSAGE_QUERY);
            statement.setInt(1, messageId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getMessagesByUser(User user) {
        List<Message> messages = new ArrayList<Message>();

        try {
        	Connection connection = DBConnection.createDBConnection();
            PreparedStatement statement = connection.prepareStatement(GET_MESSAGES_BY_USER_QUERY);
            statement.setInt(1, user.getId());
            statement.setInt(2, user.getId());
            statement.setInt(3, user.getId());
            statement.setInt(4, user.getId());

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
//                Message message = extractMessageFromResultSet(resultSet);
//                messages.add(message);
            	System.out.println(resultSet.getString("content"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Message extractMessageFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        int senderId = resultSet.getInt("sender_id");
        int receiverId = resultSet.getInt("receiver_id");
        String messageText = resultSet.getString("content");
        Timestamp createdAt = resultSet.getTimestamp("timestamp");

        return new Message(id, senderId, receiverId, messageText, createdAt);
    }
}