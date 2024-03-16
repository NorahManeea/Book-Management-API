# Book Management API

## Overview
The Book Management API is a RESTful web service built using Spring Boot to manage a collection of books. It provides endpoints for performing CRUD (Create, Read, Update, Delete) operations on books.

## Features
- **Library Management**: Add, update, delete, and view book records.
- Borrowing Management: Borrow and return books, view borrowing records.
- **RESTful API**: Exposes REST endpoints for interacting with the system programmatically.
- **Data Persistence**: Stores book data in a relational database (PostgreSQL).
- **Error Handling**: Custom error handling for handling exceptions gracefully.

## Technologies Used
- Java
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven

## Endpoints
``` 
GET /api/book
POST /api/book
GET /api/book/{bookId}
PUT /api/book/{bookId}
DELETE /api/book/{bookId}


GET /api/borrowings
POST /api/borrowings
GET /api/borrowings/{borrowingId}
```
