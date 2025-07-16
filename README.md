# Simple Java Web CRUD Application using Servlet, JSP, and JDBC

## Overview

This is a basic Java EE web application implementing CRUD (Create, Read, Update, Delete) operations on user data stored in a MySQL database. The project demonstrates the use of core Java EE technologies including Servlets, JSP, and JDBC.

Users can:

- Add a new user (Name, Email, Country)
- View the list of all users
- Edit existing user details
- Delete users

## Project Structure

Project/
├─ WebContent/
│ ├─ user-list.jsp # Displays the list of users
│ ├─ user-form.jsp # Form for adding/editing a user
├─ src/
│ ├─ com.example.controller/
│ │ └─ UserServlet.java # Servlet controller handling requests
│ ├─ com.example.dao/
│ │ └─ UserDAO.java # DAO handling DB operations via JDBC
│ └─ com.example.model/
│ └─ User.java # User model class (POJO)
└─ WEB-INF/
└─ lib/
└─ mysql-connector-java.jar # MySQL JDBC driver


## How to Run

1. Import the project into an IDE like Eclipse or IntelliJ IDEA with Java EE support.
2. Add the MySQL JDBC driver (`mysql-connector-java.jar`) to the project’s `WEB-INF/lib` folder or build path.
3. Configure and start Apache Tomcat server (or any Java EE compatible server).
4. Build and deploy the project to the server.
5. Start your MySQL server.
6. Access the application at:  
   `http://localhost:8080/YourAppContext/`

## Features Demonstrated

- Servlet lifecycle and request handling
- JSP pages with JSTL to display dynamic content
- JDBC database connectivity and prepared statements
- MVC design pattern implementation
- Form handling and URL routing
- Basic validation and user-friendly UI

## Additional Notes

- The application can be extended with features such as input validation, pagination, authentication, or CSS styling.
- Proper exception handling and logging can be implemented for production-readiness.
- This project is a solid foundation for learning Java EE web applications.

## Author

DIBBBO DUTTA

---

*This project is created as a sample for reviewing Java EE concepts (JSP, Servlets, JDBC).*
