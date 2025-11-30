Library Management System
Java + Maven + JDBC + MySQL

Project Overview

The Library Management System is a console-based application built using Java, JDBC, Maven, and MySQL.

It allows librarians to manage:

Books

Members

Book Issue & Return

Rental History

This project demonstrates:

RDBMS concepts

JDBC connectivity

DAO pattern

Multi-table operations

CRUD operations

Maven-based project structure

Technologies Used
Component	Technology
Language	Java
Build Tool	Maven
Database	MySQL
JDBC Driver	mysql-connector-java
Architecture	DAO Pattern
IDE	Eclipse
📁 Project Structure
LibrarySystem/
 ├── src/main/java/com/library/
 │      ├── Book.java
 │      ├── BookDAO.java
 │      ├── Member.java
 │      ├── Rental.java
 │      ├── DBConnection.java
 │      └── Main.java
 ├── src/main/resources/
 ├── pom.xml
 └── README.md

Database Schema (MySQL)

Run these queries:

CREATE DATABASE librarydb;
USE librarydb;

CREATE TABLE book (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100),
    author VARCHAR(100),
    genre VARCHAR(50),
    copies INT
);

CREATE TABLE member (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    phone VARCHAR(20)
);

CREATE TABLE rental (
    rental_id INT PRIMARY KEY AUTO_INCREMENT,
    member_id INT,
    book_id INT,
    issue_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    return_date TIMESTAMP NULL,
    FOREIGN KEY(member_id) REFERENCES member(id),
    FOREIGN KEY(book_id) REFERENCES book(id)
);

JDBC Database Configuration

DBConnection.java
private static final String URL = "jdbc:mysql://localhost:3306/librarydb";
private static final String USER = "";
private static final String PASSWORD = "";

How to Run the Project

1️⃣ Clone or Download the project
git clone https://github.com/selvavignesh1402/LibrarySystem.git

2️⃣ Install MySQL

Create the DB using the SQL above.

3️⃣ Open Project in Eclipse

Maven will automatically download dependencies.

4️⃣ Run the project

Execute the Main.java file.

Application Menu

Your program displays:

==== LIBRARY SYSTEM ====
1. Add Book
2. View Books
3. Add Member
4. View Members
5. Issue Book
6. Return Book
7. View Issued Books
0. Exit

Add Book

Enter Title, Author, Genre, Copies → saved into DB.

Add Member

Enter Name & Phone → saved into DB.

Issue a Book

Decreases book copies by 1

Adds entry into rental table

Return Book

Updates return_date

Increases book copies

View Issued Books

Shows joined data from rental + member + book.

DAO Classes
BookDAO

addBook()

viewBooks()

updateCopies()

Member

addMember()

viewMembers()

Rental

issueBook()

returnBook()

viewIssuedBooks()

Sample Output
==== LIBRARY SYSTEM ====
1. Add Book
2. View Books
3. Add Member
4. View Members
5. Issue Book
6. Return Book
7. View Issued Books
0. Exit
Enter choice: 1

Title: Harry Potter
Author: J.K. Rowling
Genre: Fantasy
Copies: 5
Book added successfully!
