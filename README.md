# Social Media API

A hands-on Java Spring Boot project that implements a simple, RESTful backend API for managing users and posts. Built to demonstrate proficiency in API-driven services, layered architecture, problem-solving, and backend fundamentals.

---

## ​ Project Highlights & Purpose

- **RESTful API Design**  
  Implements clean REST endpoints (`GET`, `POST`, `PUT`, `DELETE`) for `Account` and `Message` entities, with proper HTTP status codes and resource-level routing.

- **Java & Spring Boot Stack**  
  Leverages **Java** (current LTS version) and **Spring Boot**—a framework widely used in enterprise environments—for rapid development and strong industry relevance.

- **Layered Architecture (Controller → Service → Repository → Database)**  
  - **Controllers** manage HTTP requests and JSON responses  
  - **Services** encapsulate business logic and validation  
  - **Repositories** utilize Spring Data JPA for ORM-based data access  
  - **Persistence** with H2 (in-memory for testing) and easily extendable to MySQL/PostgreSQL

- **Database Integration & JPA**  
  Demonstrates proficiency with **Spring Data JPA** and relational databases.

- **Error Handling & Validation**  
  Includes resource validation and clean error responses—for example:
  - `401 Unauthorized` for incorrect username and password
  - `409 Conflict` for duplicate username on registration
  - Custom exceptions and global exception handling to improve API reliability

- **Testing & Local Development**  
  Utilizes H2 for in-memory testing, enabling quick, isolated test runs—aligns with lean development and testable design practices.

---

##  Getting Started (For Reviewers)

1. Clone repo:
	```bash
	git clone https://github.com/jefische/social-media-api.git
	cd social-media-api

2. Build and run:
	```bash
	mvn spring-boot:run

3. Test endpoints via Postman or curl:

	**Endpoints:**

	| Method  | Endpoint                            | Description              |
	|---------|-------------------------------------|--------------------------|
	| POST    | `/register`                         | Create new user account  |
	| POST    | `/login`                            | User login               |
	| POST    | `/messages`                         | Create new message       |
	| GET     | `/messages`                         | Fetch all messages       |
	| DELETE  | `/messages/{messageId}`             | Delete a message         |
	| PATCH   | `/messages/{messageId}`             | Update a message         |
	| GET     | `/accounts/{accountId}/messages`    | Fetch user messages      |

**Example curl request:**
```bash
	curl -X POST http://localhost:8080/register \
	-H "Content-Type: application/json" \
	-d '{"username": "JohnDoe", "password": "johnTheGiant"}'
```
---

## Project Structure

This project was initialized and scaffolded using the VS Code spring boot extension
```
src/
├── main/
│ ├── java/
│ │ └── com.example.socialmedia/
│ │ ├── controller/   → Request handlers
│ │ ├── service/      → Business logic & validation
│ │ ├── repository/   → JPA-based database access
│ │ ├── model/        → Entity definitions (Account, Message)
│ │ └── exception/    → Custom exceptions & error handlers
│ └── resources/
│ └── application.yml
└── test/
```
---