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
  - `201 Created` for successful creations
  - `404 Not Found` for missing resources
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
	mvn spring-boot:run

3. Test endpoints via Postman or curl:

	POST /register                        → Create user
	POST /login                           → User login
	POST /messages                        → Create message login
	GET /messages                         → Fetch all messages
	DELETE /messages/{messageId}          → Delete message
	PATCH /messages/{messageId}           → Update message text
	GET /accounts/{accountId}/messages    → Fetch user's messages
	
---

## Project Structure

This project was initialized and scaffolded using the VS Code spring boot extension

src/
├── controller/  → Request handlers
├── service/     → Business logic & validation
├── repository/  → JPA-based database access
├── model/       → Entity definitions (Account, Message)
└── exception/   → Custom exceptions & error handlers

