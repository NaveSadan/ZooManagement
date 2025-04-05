# Zoo Management System

## 🐾 Introduction

The **Zoo Management System** is a Java-based application designed to efficiently manage a zoo's operations, including animal care, visitor tracking, and staff management. This project was developed as part of an Object-Oriented Programming (OOP) course, implementing best practices in Java design.

## ✨ Features

- Manage animal records (species, feeding schedule, habitat details)
- Track visitor information and entry dates
- Maintain a staff database (ZooKeepers and ZooManagers)
- Match animals with compatible zookeepers
- Generate reports on zoo activities (e.g., food expertise gaps)

## 🛠️ Installation

1. Clone this repository:
   ```sh
   git clone https://github.com/yourusername/zoo-management.git
2. Open the project in **IntelliJ IDEA**.
3. Ensure you have JDK 17 or later installed.
4. Compile and run the project from the `Main` class.

## 📁 Project Structure

```
ZooManagement/
│── src/
│   ├── Main.java              # Entry point of the application
│   ├── Creature.java          # Abstract base class for all entities (Animal, ZooKeeper, Visitor, ZooManager)
│   ├── Animal.java            # Extends Creature, implements Matchable
│   ├── ZooKeeper.java         # Extends Creature, implements Matchable
│   ├── Visitor.java           # Extends Creature
│   ├── ZooManager.java        # Extends Creature
│   ├── ZooManagement.java     # Manages collections of Animals, Visitors, ZooKeepers, and ZooManagers
│   ├── FoodType.java          # Represents food details for animals
│   ├── Matchable.java         # Interface for matching Animals with ZooKeepers
│── README.md
```

## 📁 Class Hirarchy

    Creature (Abstract)
        Animal (Implements Matchable)
        ZooKeeper (Implements Matchable)
        Visitor
        ZooManager
    FoodType (Standalone class used by Animal)
    ZooManagement (Manages the zoo's operations)
    Matchable (Interface for compatibility matching)


## 🚀 Usage Example

```java
FoodType carnivoreFood = new FoodType("Carnivore", 6, 3, new Date());
Animal lion = new Animal("Lion", "L1231", "Male", true, carnivoreFood, new Date(), "Lions' cage", "Jery Smith");
ZooKeeper keeper = new ZooKeeper("Jery Smith", "645612455", 9000, "Night", "Zoo456", "Carnivore", "Lion");
System.out.println("Lion matches keeper: " + lion.match(keeper));
```

## 📌 Contribution

Feel free to fork this repository and submit pull requests for improvements!

## 👤 Author

Developed by NaveSadan as part of the 1st year Information Systems B.Sc. program during OOP course.


