**Fitnesso Backend **

This repository contains the backend code for a Fitnesso Management System. The system allows for managing fitness classes, reservations, users, and employees.

**Technologies Used**

* Java
* Spring Boot
* Spring Security
* Lombok
* Hibernate
* PostgreSQL

**Structure**
The backend is structured into several components:

* Controllers: Handle incoming HTTP requests and delegate to services.
* Services: Implement business logic and interact with repositories.
* Repositories: Communicate with the database using Spring Data JPA.
* Models: Define entities that represent database tables.
* DTOs (Data Transfer Objects): Used for transferring data between frontend and backend.
Features

**User Management**

* Register new users (customers and employees).
* Authenticate users with login credentials.
* Update user details.
* Delete users (with constraints).

**Fitness Class Management**

* Add new fitness classes.
* Update existing fitness classes.
* Delete fitness classes (with cascading deletion of related reservations).

**Reservation Management**

* Make reservations for fitness classes.
* Accept or reject reservations.
* List reservations by status (accepted or not accepted) and user.

**Employee Management**

* View all employees.
* Add new employees.
