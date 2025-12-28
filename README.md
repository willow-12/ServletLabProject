# Servlet Lab Project

## Overview
This project is a simple Java Web Application using Servlets, JSP, Tomcat 9, Maven, and MySQL.

It allows:
- Registering a student
- Saving the student into MySQL database
- Viewing all registered students



## Tools / Technologies Used
- Java (JDK 8+)
- Apache Tomcat 9
- Maven
- MySQL 8
- JSP & Servlets (`javax.servlet`)
- NetBeans / VS Code (any IDE)


## Database Setup

Run the following SQL in MySQL:

sql
CREATE DATABASE IF NOT EXISTS studentdb;
USE studentdb;

CREATE TABLE IF NOT EXISTS students (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100),
  email VARCHAR(100),
  year INT
);
