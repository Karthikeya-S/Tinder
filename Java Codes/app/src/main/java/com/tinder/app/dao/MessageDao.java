package com.tinder.app.dao;

import com.tinder.app.model.Message;
import com.tinder.app.model.User;
import java.util.List;

public interface MessageDao {
    void addMessage(Message message);
    void deleteMessage(int messageId);
    void getMessagesByUser(User user);
}