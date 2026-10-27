# College Library Management System
A beginner-friendly Java console microproject demonstrating Object-Oriented Programming (OOPS) fundamentals, specifically **Encapsulation**, **Classes & Objects**, and **Arrays of Objects**.

---

## 📌 Project Overview
The **College Library Management System** is a lightweight, menu-driven console application designed for college libraries to manage book inventories, perform keyword title searches, and execute stock-checked book issuing and returning.

### Core OOPS Concepts Demonstrated
1. **Encapsulation & Data Hiding:** All state attributes of a book (`bookId`, `title`, `author`, `totalCopies`, `availableCopies`) are declared `private`. Access and modifications are restricted to public getters and validated business methods (`issueCopy()`, `returnCopy()`).
2. **Classes & Objects:** Real-world entities are modeled as software classes (`Book`, `Library`, `Main`).
3. **Constructors:** Parameterized constructors initialize object states reliably with clean defaults.
4. **Arrays of Objects:** Fixed-size memory storage (`Book[]`) maintains the collection without reliance on external collections/frameworks.
5. **Input Validation & Exception Prevention:** Protects against negative copies, duplicate IDs, array overflows, and non-numeric scanner crashes.

---

## 📂 Project Structure
```
CollegeLibraryManagement/
│
├── src/
│   ├── Book.java               # Book entity with encapsulated state & stock logic
│   ├── Library.java            # Library manager with Book[] array and operations
│   ├── Main.java               # Console menu interface and user input handling
│   └── AutomatedTestSuite.java # Automated verification test runner
│
├── README.md                   # Setup and usage guide
└── PROJECT_REPORT.md           # Full academic microproject submission report
```

---

## 🚀 How to Compile and Run

### Prerequisites
- Java Development Kit (JDK 8 or higher). Verified on JDK 24.

### 1. Using the Terminal / Command Prompt
Open your terminal and navigate to the project directory:

```bash
cd CollegeLibraryManagement/src
```

#### Compile the Java files:
```bash
javac *.java
```

#### Run the main application:
```bash
java Main
```

#### Run the automated test suite:
```bash
java AutomatedTestSuite
```

---

## 💻 Sample Console Walkthrough
```
==========================================================
       WELCOME TO COLLEGE LIBRARY MANAGEMENT SYSTEM       
==========================================================

----------------- LIBRARY MENU -----------------
1. Add New Book
2. Display All Books
3. Search Book by Title
4. Issue Book
5. Return Book
6. Exit
------------------------------------------------
Enter your choice (1-6): 1

--- Add New Book ---
Enter Book ID (positive integer): 101
Enter Book Title: Object-Oriented Programming in Java
Enter Author Name: E Balagurusamy
Enter Total Copies: 3
[Success] Book added successfully!

Enter your choice (1-6): 2

======================================= REGISTERED BOOKS =======================================
| Book ID  | Title                        | Author               | Total Copies | Available Copies |
------------------------------------------------------------------------------------------------
| 101      | Object-Oriented Programming  | E Balagurusamy       | 3            | 3                |
================================================================================================

Enter your choice (1-6): 4

--- Issue Book ---
Enter Book ID to issue: 101
[Success] Book "Object-Oriented Programming in Java" issued successfully!
[Status] Remaining Available Copies: 2 / 3
```

---

## ⚠️ Scope & Limitations
- **In-Memory Storage:** Book data is maintained in RAM during execution. When the program terminates, data is reset.
- **No Individual Student Accounts:** Stock numbers are tracked globally; student borrowing histories and due dates are omitted to keep the project strictly focused on core OOPS concepts without unnecessary complexity.
