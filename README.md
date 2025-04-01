# User Management System

This project is a simple User Management System built with Spring Boot. It provides RESTful APIs to manage user data, including retrieving and creating users.

## Features

- Retrieve a list of all users.
- Create a new user with validation.
- Handle validation exceptions with detailed error messages.

## Technologies Used

- Java
- Spring Boot
- Spring MVC
- Spring JDBC
- H2 Database (or any other database configured)
- Maven

## Getting Started

### Prerequisites

- Java 17 or later
- Maven 3.6+
- An IDE like IntelliJ IDEA or Eclipse

### Installation

1. **Clone the repository:**

   ```bash
   git clone https://github.com/SohaibKhan007/user-management.git
   cd user-management
   ```

2. **Build the project:**

   ```bash
   mvn clean install
   ```

3. **Run the application:**

   ```bash
   mvn spring-boot:run
   ```

4. **Access the application:**

   The application will be running at `http://localhost:8080`.

## API Endpoints

- **GET /users**: Retrieve all users.
- **POST /users**: Create a new user.

### Request Body for Creating a User

```json
{
  "id": 1,
  "name": "John Doe",
  "email": "john.doe@example.com"
}
```

### Validation Rules

- **ID**: Must be zero or a positive integer.
- **Name**: Must not be blank and should be between 2 and 255 characters.
- **Email**: Must be a valid email format and not empty.

## Error Handling

Validation errors will return a `400 Bad Request` with a JSON response containing field-specific error messages.

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request for any improvements.
