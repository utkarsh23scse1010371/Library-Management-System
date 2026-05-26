# 📚 Library Management System — Java OOP Project

## Project Structure

live link--https://onlinegdb.com/v75T6APVh

```
LibraryManagementSystem/
│
├── src/
│   ├── LibraryException.java   ← Custom Exception (Exception Handling)
│   ├── LibraryOperations.java  ← Interface (Abstraction)
│   ├── Person.java             ← Abstract Parent Class (Abstraction + Inheritance base)
│   ├── Book.java               ← Book entity (Encapsulation)
│   ├── Student.java            ← Student extends Person (Inheritance + Polymorphism)
│   ├── Librarian.java          ← Librarian extends Person, implements LibraryOperations
│   ├── Library.java            ← Library data store and search
│   └── Main.java               ← Entry point with menu-driven UI
│
└── README.md
```

---

## 🚀 How to Compile and Run

### Step 1: Compile
```bash
cd LibraryManagementSystem
mkdir out
javac -d out src/*.java
```

### Step 2: Run
```bash
java -cp out Main
```

---

## ✅ OOP Concepts Covered

| Concept         | Implementation |
|----------------|----------------|
| **Class & Object** | Book, Student, Librarian, Library classes with objects |
| **Encapsulation** | All fields `private`; accessed via getters/setters |
| **Inheritance** | `Student` and `Librarian` both extend `Person` |
| **Polymorphism** | `displayDetails()` overridden in Student and Librarian |
| **Abstraction** | `Person` (abstract class) + `LibraryOperations` (interface) |
| **Constructor** | All classes use parameterized constructors |
| **Exception Handling** | Custom `LibraryException` for all error cases |

---

## 📋 Menu Options

```
1. Add Book          → Librarian adds a new book
2. View All Books    → Table view of all books with status
3. Add Student       → Register a new student
4. Issue Book        → Issue a book to a student (with validations)
5. Return Book       → Student returns a borrowed book
6. View Student      → Display student info + borrowed books
7. Search by Author  → Find books by author name (optional feature)
8. Exit
```

---

## 📐 Class Diagram

```
         ┌──────────────┐
         │   Person     │  ← Abstract Class
         │  - id        │
         │  - name      │
         │  + displayDetails() [abstract]
         └──────┬───────┘
                │ extends
       ┌────────┴────────┐
       ▼                 ▼
  ┌─────────┐      ┌───────────┐
  │ Student │      │ Librarian │──implements──► LibraryOperations
  │- dept   │      │- empCode  │                (issueBook, returnBook,
  │- books[]│      └───────────┘                 addBook, viewAllBooks)
  └─────────┘

  ┌────────┐     ┌─────────────────┐
  │  Book  │     │    Library      │
  │- bookId│     │ - books[]       │
  │- name  │◄────│ - students[]    │
  │- author│     │ + findBookById()|
  │- status│     │ + findStudentById()
  └────────┘     └─────────────────┘
```

---

## ⚙️ Business Rules Enforced

- A student can borrow **maximum 3 books**
- Cannot issue an **already issued** book
- Student can return **only books they borrowed**
- Invalid IDs throw `LibraryException`

---

## 💡 Optional Features Included

- ✔ **Search by Author** (Menu option 7)
- ✔ **Pre-loaded sample data** (5 books, 3 students)
- ✔ Pretty console table formatting
