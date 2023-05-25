package com.tinder.app.model;

public class User {
    private int id;
    private String name;
    private String city;
    private int age;
    private String gender;
    private int minAge;
    private int maxAge;
    private String bio;
    private String interests;
    private int numOfLikes;
    private String password;

    public User(String name, String city, int age, String gender, int minAge, int maxAge, String bio, String password) {
        this.name = name;
        this.city = city;
        this.age = age;
        this.gender = gender;
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.bio = bio;
//        this.interests = interests;
        this.numOfLikes = 0;
        this.password = password;
    }

    // Getters and setters for the attributes

    public User(int id, String name, String city, int age, String gender, int minAge, int maxAge, String bio,
			String interests, int numLikes, String password) {
    	this.id = id;
    	this.name = name;
        this.city = city;
        this.age = age;
        this.gender = gender;
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.bio = bio;
        this.interests = interests;
        this.numOfLikes = 0;
        this.password = password;
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public int getNumOfLikes() {
        return numOfLikes;
    }

    public void setNumOfLikes(int numOfLikes) {
        this.numOfLikes = numOfLikes;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    // Additional methods for managing interests

    public void setInterest(String interest) {
        this.interests = interest;
    }
}