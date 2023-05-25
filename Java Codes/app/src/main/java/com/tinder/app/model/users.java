package com.tinder.app.model;

public class users {
	private int user_id;
	private String name;
	private String gender;
	private int age;
	private int minAge;
	private int maxAge;
	private String bio;
	private String city;
	private String interests;
	private int no_of_likes;
	private String password;
	public users(String name, String gender, int age, int minAge, int maxAge, String bio, String city,
			String interests,String password) {
		super();
//		this.user_id = user_id;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.minAge = minAge;
		this.maxAge = maxAge;
		this.bio = bio;
		this.city = city;
		this.interests = interests;
//		this.no_of_likes = no_of_likes;
		this.password = password;
	}
//	public int getUser_id() {
//		return user_id;
//	}
//	public void setUser_id(int user_id) {
//		this.user_id = user_id;
//	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getInterests() {
		return interests;
	}
	public void setInterests(String interests) {
		this.interests = interests;
	}
//	public int getNo_of_likes() {
//		return no_of_likes;
//	}
//	public void setNo_of_likes(int no_of_likes) {
//		this.no_of_likes = no_of_likes;
//	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
