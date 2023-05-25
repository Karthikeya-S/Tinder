package com.tinder.app.model;

public class Match {
    private int id;
    private int userId;
    private int matchedUserId;
    private boolean isMutual;

    public Match(int userId, int matchedUserId, boolean isMutual) {
        this.userId = userId;
        this.matchedUserId = matchedUserId;
        this.isMutual = isMutual;
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

    public boolean isMutual() {
        return isMutual;
    }

    public void setMutual(boolean mutual) {
        isMutual = mutual;
    }
}