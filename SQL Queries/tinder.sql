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
DROP TABLE matches;
CREATE TABLE matches (
  id INT AUTO_INCREMENT PRIMARY KEY,
  user_id1 INT NOT NULL,
  user_id2 INT NOT NULL,
  FOREIGN KEY (user_id1) REFERENCES users(user_id),
  FOREIGN KEY (user_id2) REFERENCES users(user_id)
);
select * from users where user_id = 10000;
select database();
show tables;

CREATE TABLE users (
  user_id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  city VARCHAR(255) NOT NULL,
  age INT NOT NULL,
  gender VARCHAR(6) NOT NULL,
  minAge INT NOT NULL,
  maxAge INT NOT NULL,
  bio TEXT,
  interests TEXT,
  likes INT DEFAULT 0,
  password VARCHAR(255) NOT NULL
);


SELECT * from users;



CREATE TABLE matches (
  id INT AUTO_INCREMENT PRIMARY KEY,
  user_id1 INT NOT NULL,
  user_id2 INT NOT NULL,
  FOREIGN KEY (user_id1) REFERENCES users(user_id),
  FOREIGN KEY (user_id2) REFERENCES users(user_id)
);

CREATE TABLE messages (
  id INT AUTO_INCREMENT PRIMARY KEY,
  sender_id INT NOT NULL,
  receiver_id INT NOT NULL,
  content TEXT NOT NULL,
  timestamp DATETIME DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (sender_id) REFERENCES users(user_id),
  FOREIGN KEY (receiver_id) REFERENCES users(user_id)
);

drop table messages;
drop table matches;
show tables;
select * from users;
select * from matches;
select * from likes;
select * from messages;