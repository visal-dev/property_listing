# Property Management API

This project is a Property Management API built with Spring Boot 3. It follows the principles of clean architecture to ensure a maintainable and scalable codebase. The API allows for managing properties, property types, locations, and amenities.

## Table of Contents

- [Getting Started](#getting-started)
- [Project Structure](#project-structure)
- [API Endpoints](#api-endpoints)
    - [Amenity Endpoints](#amenity-endpoints)
    - [Location Endpoints](#location-endpoints)
    - [PropertyType Endpoints](#propertytype-endpoints)
    - [Property Endpoints](#property-endpoints)
- [Example JSON Requests](#example-json-requests)
- [Dependencies](#dependencies)
- [Authors](#authors)

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6 or higher

### Installing

1. Clone the repository
   ```bash
   git clone https://github.com/yourusername/property-management-api.git
2. Navigate to the project directory
    ```bash
    cd property-management-api

3. Build the project
    ```bash
    mvn clean install
4. Run the project
    ```bash
    mvn spring-boot:run

### Testing
You can use tools like Postman or curl to test the endpoints.

## Project Structure
```css
    src/
    └── main/
    ├── java/
    │   └── com/example/mypropertyapp/
    │       ├── controller/
    │       ├── domain/
    │       ├── repository/
    │       ├── service/
    │       └── MyPropertyAppApplication.java
    └── resources/
    ├── application.properties
    └── data.sql
```
    
- controller: Contains the REST controllers for handling HTTP requests.
- domain: Contains the entity classes representing the database tables.
- repository: Contains the repository interfaces for database operations.
- application: Contains the service classes implementing business logic.
- MyPropertyAppApplication.java: The main class to run the Spring Boot application.
application.properties: Configuration file for the Spring Boot application.
data.sql: Initial data setup script.


## API Endpoints
Amenity Endpoints
Create an Amenity

- URL: /api/amenities
- Method: POST
- Request Body:
```
{
    "name": "Swimming Pool"
}
```
Get All Amenities

- URL: /api/amenities
- Method: GET
- Response Body:
```
[
    {
    "id": 1,
    "name": "Swimming Pool"
    },
    {
    "id": 2,
    "name": "Gym"
    }
]
```
Get an Amenity by ID

- URL: /api/amenities/{id}
- Method: GET
- Response Body:
```
{
    "id": 1,
    "name": "Swimming Pool"
}
```
Update an Amenity

- URL: /api/amenities/{id}
- Method: PUT
- Request Body:
```
{
    "name": "Updated Swimming Pool"
}
```
Delete an Amenity

- URL: /api/amenities/{id}
- Method: DELETE

### Location Endpoints
Create a Location

- URL: /api/locations
- Method: POST
- Request Body:
```
{
    "name": "Phnom Penh",
    "isActive": true
}
```

Get All Locations

- URL: /api/locations
- Method: GET
- Response Body:
```agsl

[
    {
        "id": 1,
        "name": "Phnom Penh",
        "isActive": true
        },
        {
        "id": 2,
        "name": "Siem Reap",
        "isActive": false
    }
]
```

Get a Location by ID

- URL: /api/locations/{id}
- Method: GET
- Response Body:
```agsl

{
    "id": 1,
    "name": "Phnom Penh",
    "isActive": true
}
```

Update a Location

- URL: /api/locations/{id}
- Method: PUT
- Request Body:
```agsl
{
    "name": "Updated Phnom Penh",
    "isActive": false
}
```

Delete a Location

- URL: /api/locations/{id}
- Method: DELETE 

### PropertyType Endpoints
Create a PropertyType

- URL: /api/property-types
- Method: POST
- Request Body:
```agsl
{
    "name": "Apartment",
    "description": "A small residential unit in a building"
}
```

Get All PropertyTypes

- URL: /api/property-types
- Method: GET
- Response Body:
```agsl
[
    {
        "id": 1,
        "name": "Apartment",
        "description": "A small residential unit in a building"
    },
    {
        "id": 2,
        "name": "House",
        "description": "A standalone residential unit"
    }
]
```

Get a PropertyType by ID

- URL: /api/property-types/{id}
- Method: GET
- Response Body:
```agsl
{
    "id": 1,
    "name": "Apartment",
    "description": "A small residential unit in a building"
}
```

Update a PropertyType

- URL: /api/property-types/{id}
- Method: PUT
- Request Body:
```agsl
{
    "name": "Updated Apartment",
    "description": "A residential unit in a building"
}
```

Delete a PropertyType

- URL: /api/property-types/{id}
- Method: DELETE
- Property Endpoints

### Property Endpoint

- URL: /api/properties
- Method: POST
- Request Body:
```agsl
{
    "name": "Luxury Apartment",
    "description": "A luxury apartment with sea view",
    "propertyType": {
        "id": 1
    },
    "location": {
        "id": 1
    },
    "amenities": [
        {
            "id": 1
        },
        {
            "id": 2
        }
    ]
}
```

Get All Properties

- URL: /api/properties
- Method: GET
- Response Body:
```agsl
[
    {
        "id": 1,
        "name": "Luxury Apartment",
        "description": "A luxury apartment with sea view",
        "propertyType": {
            "id": 1,
            "name": "Apartment",
            "description": "A small residential unit in a building"
        },
        "location": {
            "id": 1,
            "name": "Phnom Penh",
            "isActive": true
        },
        "amenities": [
            {
                "id": 1,
                "name": "Swimming Pool"
            },
            {
                "id": 2,
                "name": "Gym"
            }
        ]
    }
]
```

Get a Property by ID

- URL: /api/properties/{id}
- Method: GET
- Response Body:
```agsl
{
    "id": 1,
    "name": "Luxury Apartment",
    "description": "A luxury apartment with sea view",
    "propertyType": {
        "id": 1,
        "name": "Apartment",
        "description": "A small residential unit in a building"
    },
    "location": {
        "id": 1,
        "name": "Phnom Penh",
        "isActive": true
    },
    "amenities": [
        {
            "id": 1,
            "name": "Swimming Pool"
        },
        {
            "id": 2,
            "name": "Gym"
        }
    ]
}
```

Update a Property

- URL: /api/properties/{id}
- Method: PUT
- Request Body:
```agsl

{
    "name": "Updated Luxury Apartment",
    "description": "An updated description for the luxury apartment",
    "propertyType": {
        "id": 1
    },
    "location": {
        "id": 1
    },
    "amenities": [
        {
            "id": 1
        }
    ]
}
```

Delete a Property

- URL: /api/properties/{id}
- Method: DELETE 

### Dependencies
- Spring Boot Starter Data JPA
- Spring Boot Starter Web
- Spring Boot Starter Validation
- H2 Database (for development and testing purposes)
- Lombok (for reducing boilerplate code)

### Authors
Group 2 of RUPP - Java
Feel free to contribute to this project by opening issues or submitting pull requests.


### This README file includes:

1. **Getting Started**: Instructions for setting up the project.
2. **Project Structure**: Description of the project's directory structure.
3. **API Endpoints**: List of all API endpoints with example requests and responses.
4. **Dependencies**: List of project dependencies.
5. **Authors**: Information about the author(s) of the project.
