# Book Inventory Management

## Overview
The **Book Inventory Management System** is a Java-based project designed to manage a collection of books. It provides functionality to add, remove, search, and decrement book quantities efficiently. The project uses a `HashMap` to store the inventory, ensuring fast lookups and updates.

---

## Features

### Core Functionalities:
1. **Add Books**: Add books to the inventory with a specified quantity.
2. **Remove Books**: Remove books from the inventory entirely.
3. **Decrement Quantity**: Reduce the quantity of a specific book without removing it completely.
4. **Search Books**: Check if a specific book exists in the inventory.
5. **Inventory Size**: Retrieve the total number of distinct books in the inventory.

### Utility Functions:
- **Print Inventory**: Display all books in the inventory along with their quantities.

---

## Files in the Repository
- **`Book.java`**: Represents the `Book` class, which encapsulates attributes like title and author.
- **`BookInventory.java`**: Implements the inventory management system with features like adding, removing, searching, and decrementing book quantities.
- **`BookInventoryTest.java`**: Contains JUnit test cases to ensure the correctness of the `BookInventory` functionalities.
- **`README.md`**: Documentation for the project.

---

## How to Run

### Prerequisites:
- **Java Development Kit (JDK)** 8 or later
- **JUnit 5** for running test cases (optional)

### Steps:
1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/book-inventory-management.git
   cd book-inventory-management
