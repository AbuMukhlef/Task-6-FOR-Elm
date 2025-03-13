# Employee Management System V6

## Project Description
The Employee Management System is a REST API application built with Spring Boot and JPA/Hibernate for managing employee data. This system allows users to perform CRUD operations (Create, Read, Update, Delete) on employee records.

## Version 6 Updates
In this sixth version of the Employee Management System, the following enhancements have been implemented:

- **OpenAPI Specification & Swagger UI**: Added comprehensive API documentation with Swagger UI for better developer experience
- **JSON Schema Validation**: Added JSON schema validation using the NetworkNT library to ensure data integrity and consistency
- **Logging Concept**: Implemented comprehensive logging throughout the application for better troubleshooting and monitoring
- **ORM Integration**: Replaced direct database operations with JPA/Hibernate ORM for more efficient data management
- **Spring Boot Framework**: Upgraded to use Spring Boot 3.4.3 for improved performance and security
- **EntityManager**: Implemented EntityManager for database operations instead of direct JDBC
- **Repository Pattern**: Enhanced the repository layer with proper separation of concerns
- **PostgreSQL Support**: Added PostgreSQL database support for robust data storage
- **RESTful API Design**: Improved API design with proper HTTP status codes and response handling
- **Transaction Management**: Added transaction support for database operations

## Technical Stack
- Java 23
- Spring Boot 3.4.3
- Spring Data JPA
- Hibernate ORM
- PostgreSQL Database
- NetworkNT JSON Schema Validator
- Logging Framework
- SpringDoc OpenAPI UI (Swagger)
- RESTful API


## OpenAPI Specification & Swagger UI
The application now includes comprehensive API documentation:

- **Swagger UI**: Interactive API documentation available at http://localhost:8080/swagger-ui.html
- **API Details**: Complete documentation of all endpoints, request/response models, and status codes
- **Try It Out**: Test API endpoints directly from the Swagger UI

Configuration in `application.properties`:
```properties
springdoc.swagger-ui.url=/employee.yaml
```

## JSON Schema Validation
The application validates all incoming employee data against a predefined JSON schema located at `/schemas/employees-schema.json`. This ensures that:

- All required fields are present
- Data types are correct
- Field constraints are enforced
- Invalid data is rejected before processing

The JsonSchemaValidator component:
- Loads the schema at application startup
- Validates employee objects against the schema
- Returns validation messages for any data inconsistencies

## Logging Implementation
The application includes comprehensive logging:

- **Request/Response Logging**: All API requests and responses are logged
- **Error Logging**: Detailed error information is captured for troubleshooting
- **Performance Logging**: Key operations are timed and logged for performance monitoring
- **Audit Logging**: Important data changes are logged for audit purposes
- **Configurable Log Levels**: Different log levels can be set for different environments

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET    | /absher/api/v6/employees | Get all employees |
| GET    | /absher/api/v6/employees/{id} | Get employee by ID |
| POST   | /absher/api/v6/employees | Create new employee |
| PUT    | /absher/api/v6/employees/{id} | Update employee by ID |
| DELETE | /absher/api/v6/employees/{id} | Delete employee by ID |

## Testing with Postman

### Setup
1. Ensure PostgreSQL is running and properly configured in your application.properties
2. Start the Spring Boot application
3. Open Postman

### Get All Employees
- Method: GET
- URL: http://localhost:8080/absher/api/v6/employees

### Get Employee by ID
- Method: GET
- URL: http://localhost:8080/absher/api/v6/employees/1

### Create New Employee
- Method: POST
- URL: http://localhost:8080/absher/api/v6/employees
- Headers: Content-Type: application/json
- Body:
```json
{
  "name": "John Doe",
  "gender": "Male",
  "dob": "1990-01-01",
  "phoneNumber": "1234567890",
  "hobbies": ["Reading", "Hiking", "Coding"]
}
```

### Update Employee
- Method: PUT
- URL: http://localhost:8080/absher/api/v6/employees/1
- Headers: Content-Type: application/json
- Body:
```json
{
  "name": "John Doe Updated",
  "gender": "Male",
  "dob": "1990-01-01",
  "phoneNumber": "9876543210",
  "hobbies": ["Reading", "Swimming", "Coding"]
}
```

### Delete Employee
- Method: DELETE
- URL: http://localhost:8080/absher/api/v6/employees/1

## Using Swagger UI
1. Start the application
2. Navigate to http://localhost:8080/swagger-ui.html in your browser
3. You'll see all available endpoints with documentation
4. Expand any endpoint to see details and test functionality:
   - Click on an endpoint
   - Click "Try it out"
   - Fill in required parameters
   - Click "Execute"
   - View the response

## Data Model
The Employee entity includes the following fields:
- id (int): Unique identifier
- name (String): Employee name
- gender (String): Employee gender
- dob (String): Date of birth
- phoneNumber (String): Contact number
- hobbies (List<String>): Employee hobbies

## JSON Schema Example
```json
{
  "$schema": "http://json-schema.org/draft-07/schema#",
  "type": "object",
  "properties": {
    "name": {
      "type": "string",
      "minLength": 2,
      "maxLength": 100
    },
    "gender": {
      "type": "string",
      "enum": ["Male", "Female", "Other"]
    },
    "dob": {
      "type": "string",
      "format": "date"
    },
    "phoneNumber": {
      "type": "string",
      "pattern": "^[0-9]{10}$"
    },
    "hobbies": {
      "type": "array",
      "items": {
        "type": "string"
      }
    }
  },
  "required": ["name", "gender", "dob"]
}
```

## OpenAPI Configuration
This project uses the SpringDoc OpenAPI UI dependency:
```xml
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>2.8.5</version>
</dependency>
```

## Notes
- Make sure to configure your PostgreSQL connection in the application.properties file
- The API returns appropriate HTTP status codes: 200 OK, 201 Created, 204 No Content, 404 Not Found
- Error handling is implemented to provide meaningful error messages
- Invalid data will be rejected with appropriate validation messages
- Check application logs for detailed information about requests, responses, and errors
- API documentation is available through Swagger UI for easy testing and integration