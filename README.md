# Library Management System (Java)

A console-based Library Management System developed using Java.
This project demonstrates core Object-Oriented Programming (OOP) concepts such as inheritance, abstraction, and polymorphism through a practical library simulation.

---

## Features

### Book Management

* Add new books
* Remove existing books
* View all available books
* Search books by title

### Member Management

* Register new members
* Supports multiple member types:

  * Student
  * Faculty
  * External Member
* View all registered members

### Borrowing System

* Borrow books with limit control
* Return books with validation
* Track borrowed books
* Prevent invalid or duplicate transactions

### Staff Management

* Add staff members:

  * Librarian
  * Assistant
* Staff can assist members
* Librarian can manage books

---

## Technologies Used

* Java
* Object-Oriented Programming (OOP)

  * Encapsulation
  * Inheritance
  * Polymorphism
  * Abstraction
* Java Collections (ArrayList)
* Java Time API (LocalDateTime)

---

## Project Structure

```
Library-Management-System/
│── LibrarySystem.java     # Main entry point (menu-driven system)
│── library.java           # Core library operations
│── Book.java              # Book entity and transaction logic
│── Member.java            # Abstract member class
│── Student.java           # Student member type
│── Faculty.java           # Faculty member type
│── externalMember.java    # External member type
│── Staff.java             # Abstract staff class
│── Librarian.java         # Librarian role (manages books)
│── assistant.java         # Assistant role (helps members)
```

---

## Getting Started

### Requirements

* Java JDK 8 or higher

### Compile and Run

```bash
javac *.java
java LibrarySystem
```

---

## How It Works

The system is menu-driven and runs in the console.

Main modules include:

* Administration (manage staff)
* Book Management (add, remove, search books)
* Member Management (register and manage members)

---

## Key Concepts Demonstrated

* Encapsulation: Data handling within classes such as `Book` and `Member`
* Inheritance:

  * `Student`, `Faculty`, `externalMember` extend `Member`
  * `Librarian`, `assistant` extend `Staff`
* Polymorphism: Method overriding (e.g., `role()`, `assistMember()`)
* Abstraction: Use of abstract classes `Member` and `Staff`

---

## Limitations

* Console-based (no graphical interface)
* Data is not persistent (resets after program ends)
* No database integration

---

## Future Improvements

* Add graphical interface (Java Swing or JavaFX)
* Integrate database (MySQL or SQLite)
* Add authentication system
* Improve search and filtering

---

## Project Status

Completed (Academic Project)
Open for improvements and enhancements

---

## Author

Muhammad Jaffer
Java Project – Library Management System

---

## License

This project is open-source and available for educational use.

---
