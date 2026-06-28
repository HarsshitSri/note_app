# Student Management System REST API

A RESTful backend application built with **Java**, **Spring Boot**, **Spring Data JPA**, and **PostgreSQL** for managing student records. The project demonstrates CRUD operations, layered architecture, and database persistence using Hibernate.

## Features

- Create a new student record
- Retrieve all students
- Retrieve a student by ID
- Update existing student information
- Delete a student record
- RESTful API following HTTP standards
- PostgreSQL database integration using Spring Data JPA
- Layered architecture (Controller, Service, Repository)

- ## Tech Stack

- **Language:** Java
- **Framework:** Spring Boot
- **Database:** PostgreSQL
- **ORM:** Spring Data JPA (Hibernate)
- **Build Tool:** Maven
- **Testing:** JUnit

- ## Project Structure

```
src
├── main
│   ├── java
│   │   └── com.harshit.student_management_system
│   │       ├── controller
│   │       ├── model
│   │       ├── repository
│   │       ├── service
│   │       └── StudentManagementSystemApplication.java
│   └── resources
│       └── application.properties
└── test
```

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/students` | Create a new student |
| GET | `/students` | Retrieve all students |
| GET | `/students/{id}` | Retrieve a student by ID |
| PUT | `/students/{id}` | Update student details |
| DELETE | `/students/{id}` | Delete a student |
