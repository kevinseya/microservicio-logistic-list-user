# GRAPHQL in Java with Spring Boot

This project is a simple GRAPHQL created with Spring Boot that allows managing the USER domain, specifically for the LIST microservice. The API offers the basic operation such as list users, displaying the GRAPHI technology screen as the main page.
## Project Structure

- **`ListUserApplication.java`**: The main class that runs the Spring Boot application and defines the GRAPHI tecnology.

- `POST /graphql`: Allows you to list the users, under the required query.

## Requirements

- **JDK 17** o superior.
- **Maven** (for dependency management and project construction).

## Installation

1. **Clone the repository**

    ```bash
    git clone <https://github.com/kevinseya/microservicio-logistic-list-user.git>
    ```

2. **Build and run the application** with Maven:

    ```bash
    mvn spring-boot:run
    ```

3. The application run on: `http://localhost:8080`.

## Use of GraphQL

### 1. POST /graphql

List users. The request body must contain the user details in JSON format with query
POST request example:
```bash
POST /graphql Content-Type: application/json
    
    {
    "query": "query { users { id name lastname email phone rol } }"
    }
```
**Response:**
```json
    {
  "data": {
    "users": [
      {
        "id": "0f855de5-8768-4fc5-ad2d-0c304aab7a81",
        "name": "John",
        "lastname": "Doe",
        "email": "john.doe3@example.com",
        "phone": "1234567890",
        "rol": "ADMIN"
      }
    ]
  }
}
```
**Response code:**
- **`200 OK:`** List users.
- **`400 Bad Request:`** Bad Request.
- **`500 Internal Server Error:`** Server error.
