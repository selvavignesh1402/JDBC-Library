# Library Management System  
### Java • JDBC • Maven • MySQL

A console-based Library Management System that manages books, members, and book rentals using Java, JDBC, and MySQL.  
This project follows the DAO pattern and demonstrates CRUD operations, SQL joins, and database connectivity using JDBC.


##  1. Features

###  Book Management
- Add a new book  
- View all books  
- Auto-update copies on issue/return  

###  Member Management
- Add a new member  
- View members  

###  Rental Management
- Issue a book  
- Return a book  
- View issued books (joined data)


##  2. Technologies Used

| Component    | Technology                   |
| ------------ | ---------------------------- |
| Language     | Java SE 8                    |
| Build Tool   | Maven                        |
| Database     | MySQL                        |
| JDBC Driver  | mysql-connector-java         |
| Architecture | DAO Pattern                  |
| IDE          | Eclipse / IntelliJ / VS Code |


##  3. Project Structure

<img width="474" height="517" alt="image" src="https://github.com/user-attachments/assets/51759d34-a1a7-4c07-a746-75e6bea6fd3b" />


##  4. Database Setup (MySQL)

Run the following commands:

```sql
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
```


##  5. JDBC Configuration  
In `DBConnection.java`:

```java
private static final String URL = "jdbc:mysql://localhost:3306/librarydb";
private static final String USER = "root";
private static final String PASSWORD = "root";
```

Update username/password if necessary.


##  6. How to Run

1. Install MySQL and create the database  
2. Open the project in Eclipse / IntelliJ  
3. Maven will download dependencies automatically  
4. Run `Main.java`  
5. Use the menu in the console  


##  7. Application Menu

```
==== LIBRARY SYSTEM ====
1. Add Book
2. View Books
3. Add Member
4. View Members
5. Issue Book
6. Return Book
7. View Issued Books
0. Exit
```


##  8. Sample Output


Title: Harry Potter
Author: J.K. Rowling
Genre: Fantasy
Copies: 5
Book added successfully!



