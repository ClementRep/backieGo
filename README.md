# backieGo

## Description
Backie Go App is a Spring Boot application that allows truck owners to register their trucks and users who wants to use those trucks for moving/other services to search and make it easy to find.

## Features
- RESTful API endpoints for [entities, users, bookings]
- Data persistence using [PostgreSQL/H2]
- Exception handling and validation
- Unit and integration testing

## Technologies
- Java 17+
- Spring Boot 3+
- Spring Data JPA
- Spring Security (if applicable)
- Maven/Gradle
- PostgreSQL/MySQL/H2
- Lombok

## Installation

### Prerequisites
- Java JDK 17+
- Maven or Gradle
- PostgreSQL/H2 database

### Steps
```bash
# Clone the repo
git clone https://github.com/yourusername/backieGo.git

# Navigate to project folder
cd backieGo

# Build the project
mvn clean install   # or ./mvnw clean install if using wrapper

# Run the project
mvn spring-boot:run   # or ./mvnw spring-boot:run
