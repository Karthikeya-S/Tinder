-- Active: 1684438679718@@127.0.0.1@3306@wileyclassic
CREATE DATABASE IF NOT EXISTS tinder;
DROP TABLE users;
USE tinder;
CREATE TABLE users(
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    gender CHAR NOT NULL,
    Age INT NOT NULL,
    minAge INT,
    maxAge INT,
    bio VARCHAR(1000) NOT NULL,
    city VARCHAR(500) NOT NULL,
    interests VARCHAR(100),
    no_of_likes INT,
    password VARCHAR(15) CHECK (length(password) >= 8)
);
DROP Table likes;
CREATE TABLE likes(
    likesID INT,
    user1 INT, 
    FOREIGN KEY (user1) REFERENCES users(user_id),
    user2 INT,
    FOREIGN KEY (user2) REFERENCES users(user_id),
    isLike BOOLEAN
);
select database();