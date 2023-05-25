package com.tinder.app.model;

public class Match {
    private int id;
    private int userId;
    private int matchedUserId;
    public Match(int userId, int matchedUserId) {
        this.userId = userId;
        this.matchedUserId = matchedUserId;
    }

    // Getters and setters for the attributes

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMatchedUserId() {
        return matchedUserId;
    }

    public void setMatchedUserId(int matchedUserId) {
        this.matchedUserId = matchedUserId;
    }
}