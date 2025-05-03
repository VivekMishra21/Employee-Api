#Employee Management System - Spring Boot API
This project is an Employee Management System API built using Spring Boot and connected to a MySQL database. It allows you to perform CRUD (Create, Read, Update, Delete) operations on employee records, making it ideal for managing employee information in an organization.

Features
Create: Add new employee records.

Read: Retrieve employee details.

Update: Edit employee information.

Delete: Remove employee records.

Technologies Used
Spring Boot: For building the RESTful API.

MySQL: For database management.

Docker: For containerizing the application and MySQL database.

Java: The programming language for the backend.

Requirements
Before running the project locally, make sure you have the following installed:

Java 17 or higher

MySQL (or Docker for containerized MySQL)

Maven or Gradle (for building the project)

Docker (optional, for containerized environment)

How to Set Up Locally
Clone the repository:

bash
Copy
Edit
git clone https://github.com/VivekMishra21/Employee-Api.git
cd employee-api
Set up MySQL:

If you're using Docker, run the following command to start MySQL:

bash
Copy
Edit
docker-compose up -d
If you're using a local MySQL installation, make sure you have a database named employeeapi.

Configure application properties:

Edit src/main/resources/application.properties and update the MySQL connection details:

properties
Copy
Edit
spring.datasource.url=jdbc:mysql://localhost:3306/employeeapi
spring.datasource.username=yourusername
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
Build and run the application:

Using Maven:

bash
Copy
Edit
mvn clean install
mvn spring-boot:run
Using Gradle:

bash
Copy
Edit
./gradlew build
./gradlew bootRun
The API will be available at http://localhost:8080.

Docker Setup
If you prefer to use Docker for the entire setup, you can use the included docker-compose.yml to start both the Spring Boot application and the MySQL database in containers.

To build and start the containers:

bash
Copy
Edit
docker-compose up --build
This will start the Spring Boot API and MySQL containers. The API will be available at http://localhost:8080.

API Endpoints
GET /api/get: Retrieve all employees.

GET /api/get/{id}: Retrieve an employee by ID.

POST /api/create: Create a new employee.

PUT /api/put/{id}: Update an existing employee.

DELETE /api/delete/{id}: Delete an employee by ID.

Contributing
Feel free to fork this repository and submit pull requests. Contributions are welcome to improve the project



