# Property Management App

## Overview
The Property Management App is a web application built with **Java Spring Boot** for the backend and **JavaScript** for the frontend. It allows users to manage properties, including adding, updating, deleting, and viewing property details. The application uses **JPA** to interact with a remote **MySQL** database, and it's deployed on two **EC2 instances**—one for the app and another for the database.

## Features
- **Add New Property**: Allows users to add properties with address, price, size, and description.
- **View Properties**: Lists all properties with details.
- **Edit Property**: Enables updating the details of a property.
- **Delete Property**: Allows the removal of a property from the list.

## How to Access
The application was live and could be accessed directly via the following URL:

[http://ec2-3-88-150-145.compute-1.amazonaws.com:8080/](http://ec2-3-88-150-145.compute-1.amazonaws.com:8080/)

**Note**: The EC2 instances are currently turned off to conserve credits. However, you can view a demonstration of the application's usage in the video below.

## Demo Video
To see the Property Management App in action, watch the following demonstration video:

[Demo video](https://github.com/user-attachments/assets/7d5e24b8-c285-41d6-9a72-313e9d4b1add)

## Deployment Video

For a detailed walkthrough of the deployment process, check out the deployment video below:

[Despliege](https://github.com/user-attachments/assets/296fb95a-61c9-4693-8da9-25641d2e2df3)


## Architecture
The architecture of the Property Management App follows a layered approach, separating concerns for maintainability and scalability. Here’s a breakdown of the key components:

1. **Presentation Layer**:
   - **Frontend**: The user interface is built with HTML, CSS, and JavaScript, providing a dynamic and responsive experience. The frontend communicates with the backend via RESTful APIs to perform CRUD operations on properties.

2. **Business Logic Layer**:
   - **Spring Boot**: The application is built using Spring Boot, which simplifies the development of Java applications by providing built-in features such as dependency injection, transaction management, and security. The business logic for managing properties is encapsulated in controllers.

3. **Data Access Layer**:
   - **JPA & Hibernate**: This layer handles database interactions through JPA and Hibernate. It abstracts the database operations and provides a repository pattern for accessing and manipulating property data. The `PropertyRepository` interface extends `CrudRepository` to facilitate standard CRUD operations.

4. **Database**:
   - The application uses a **MySQL** database hosted on a separate EC2 instance. The database schema includes tables for storing property information, ensuring data persistence and integrity.

5. **Deployment**:
   - The application is deployed on Amazon EC2, leveraging the cloud infrastructure for scalability and availability. The backend runs on one instance, while the MySQL database runs on another, ensuring separation of concerns and enhanced security.
  
### Diagram
   ![image](https://github.com/user-attachments/assets/97fc77ac-535e-4ce2-9477-146e1d9e32bb)


## Technologies Used
- **Backend**: Java Spring Boot, JPA, Hibernate
- **Frontend**: HTML, CSS, JavaScript
- **Database**: MySQL, managed remotely on a separate EC2 instance
- **Deployment**: Amazon EC2
