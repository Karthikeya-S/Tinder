package com.tinder.app.controller;
import java.time.LocalDateTime;
import java.util.List;

import com.tinder.app.dao.MessageDao;
import com.tinder.app.dao.MessageDaoImpl;
import com.tinder.app.dao.UserDao;
import com.tinder.app.dao.UserDaoImpl;
import com.tinder.app.model.Message;
import com.tinder.app.model.User;
import com.tinder.app.utils.InputUtil;

public class MessageController {
    private UserDaoImpl userDao = new UserDaoImpl();
    private MessageDaoImpl messageDao = new MessageDaoImpl();

    public MessageController() {
        this.userDao = userDao;
        this.messageDao = messageDao;
    }

    public void sendMessage(int username) {
        int senderId = username;
        int receiverId = InputUtil.promptInt("Enter the ID of the user you want to send a message to: ");
        String content = InputUtil.promptString("Enter your message: ");

        User sender = userDao.getUserById(senderId);
        User receiver = userDao.getUserById(receiverId);

        if (sender == null || receiver == null) {
            System.out.println("Invalid user ID!");
            return;
        }
        Message message = new Message(senderId, receiverId, content,LocalDateTime.now());
        messageDao.addMessage(message);

        System.out.println("Message sent successfully!");
    }

    public void viewMessages(int username) {
        int userId = username;
        User user = userDao.getUserById(userId);

        if (user == null) {
            System.out.println("User not found!");
            return;
        }

        System.out.println("Your messages:");

        // Get the list of messages for the user from the messageDao
//        String messages = messageDao.getMessagesByUser(user);
//
//        if (messages.isEmpty()) {
//            System.out.println("No messages found!");
//            return;
//        }
//
//        for (Message message : messages) {
//            User sender = userDao.getUserById(message.getSenderId());
//            System.out.println("From: " + sender.getName() + " (" + sender.getCity() + ")");
//            System.out.println("Message: " + message.getContent());
//            System.out.println("Sent at: " + message.getTimestamp());
//            System.out.println();
//        }
        messageDao.getMessagesByUser(user);
    }
}

