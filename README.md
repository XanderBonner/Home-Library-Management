# Home-Library-Management
A Library Management System built using Spring Boot, MySQL, and Hibernate

Overview
The Library Management System is a RESTful web application developed using Spring Boot and Hibernate ORM. It provides an interface for managing books, authors, publishers, and members in a library. The application uses MySQL as the database to store information and offers a set of APIs to perform CRUD (Create, Read, Update, Delete) operations on library data.

Features
User Management: Handle library members with authentication and role-based access.
Book Management: Add, update, delete, and retrieve information about books, including author and publisher details.
Author Management: Manage author details, including the books they have written.
Publisher Management: Store and manage publisher information.
Security: Basic user authentication with role-based authorization.
Logging: Detailed logging for SQL statements and database transactions for easy debugging.
Technologies Used
Java
Spring Boot
Hibernate ORM
MySQL
Maven (for dependency management)
RESTful API
Postman (for API testing)
Database Schema
The database consists of the following tables:

author: Stores author details.
publisher: Stores publisher information.
book: Stores book information, including foreign keys to author and publisher.
member: Manages library members, including login credentials.
authorities: Stores user roles and permissions, linked to the member table.
Installation
Prerequisites
Java 11+
MySQL Server
Maven
Steps
Clone the Repository:

bash
Copy code
git clone https://github.com/XanderBonner/Library-Management-System.git
cd Library-Management-System
Configure MySQL Database:

Create a MySQL database named library_directory.
Update the application.properties file with your MySQL username and password.
properties
Copy code
spring.datasource.url=jdbc:mysql://localhost:3306/library_directory
spring.datasource.username=your_username
spring.datasource.password=your_password
Run the Application:

bash
Copy code
mvn clean install
mvn spring-boot:run
Access the API:

The application will run on http://localhost:8080. You can test the API using tools like Postman.

Usage
Example API Endpoints
Get all books:

bash
Copy code
GET /api/books
Add a new book:

bash
Copy code
POST /api/books
Get a book by ID:

bash
Copy code
GET /api/books/{id}
Update a book:

bash
Copy code
PUT /api/books/{id}
Delete a book:

bash
Copy code
DELETE /api/books/{id}
Authentication
The application uses basic authentication. Example credentials:

Username: xanderB
Password: test123
Sample Requests
You can use Postman or curl to make requests to the API. Example curl request to get all books:

bash
Copy code
curl -u xanderB:test123 http://localhost:8080/api/books
