# Zoo Management System

## 🐾 Introduction

The **Zoo Management System** is a Java-based application designed to efficiently manage a zoo's operations, including animal care, visitor tracking, and staff management. This project was developed as part of an Object-Oriented Programming (OOP) course, implementing best practices in Java design.

## ✨ Features

- Manage animal records (species, feeding schedule, habitat details)
- Track visitor information and entry dates
- Maintain a staff database
- Generate reports on zoo activities

## 🛠️ Installation

1. Clone this repository:
   ```sh
   git clone https://github.com/yourusername/zoo-management.git
   ```
2. Open the project in **IntelliJ IDEA**.
3. Ensure you have JDK 17 or later installed.
4. Compile and run the project from the `Main` class.

## 📁 Project Structure

```
ZooManagement/
│── src/
│   ├── Main.java
│   ├── zoo/
│   │   ├── Animal.java
│   │   ├── Visitor.java
│   │   ├── Staff.java
│   ├── utils/
│   │   ├── Methods.java
│── README.md
```

## 🚀 Usage Example

```java
Animal lion = new Animal("Lion", "Carnivore", "Savannah");
Visitor visitor = new Visitor("John Doe", new Date());
System.out.println(visitor.getVisitDate());
```

## 📌 Contribution

Feel free to fork this repository and submit pull requests for improvements!

## 👤 Author

Developed by NaveSadan as part of the 1st year Information Systems B.Sc. program.


