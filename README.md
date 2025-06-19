
# House Market – JavaFX Property Management System

## Overview

**House Market** is a JavaFX-based property management application created as a team project for the Advanced Programming in Java course at Guilford College. The project was designed and implemented without the use of AI tools, focusing on mastering Java fundamentals, GUI development, and collaborative software engineering.

## Features

- **User Authentication**
  - Owner and customer login with hardcoded credentials for demonstration:
    - Owner 1: `owner` / `owner1`
    - Owner 2: `owner2` / `owner2`
    - Customer: `custo` / `custo1`
- **Role-Based Dashboards**
  - Owners can view and manage their property listings.
  - Customers can view available properties.
- **Add Property Dialog**
  - Owners can add new property listings via a dialog interface.
  - Input validation and exception handling for property details.
- **GUI Design**
  - Built using JavaFX with custom styling and background imagery.
  - Responsive layouts for a polished user experience.
- **Learning-Focused**
  - Exception handling with user feedback (e.g., red text fields for invalid input).
  - Extensive use of JavaFX controls and layouts.
  - Well-documented code for maintainability and learning.

## How to Run

1. **Clone or Download** this repository.
2. **Compile the Java files** (ensure you have JavaFX set up):
   ```bash
   javac -cp .;path/to/javafx-sdk/lib/* edu/guilford/*.java
   ```
3. **Run the application:**
   ```bash
   java -cp .;path/to/javafx-sdk/lib/* edu.guilford.PropertyDriver
   ```
   *(Replace `path/to/javafx-sdk` with the actual path to your JavaFX SDK.)*

## Login Information

- **Owner 1:**  
  Username: `owner`  
  Password: `owner1`
- **Owner 2:**  
  Username: `owner2`  
  Password: `owner2`
- **Customer:**  
  Username: `custo`  
  Password: `custo1`

## What We Learned

- **JavaFX GUI Programming:** Building real-world interfaces using JavaFX components and layouts.
- **Event Handling & Dialogs:** Implementing interactive features and custom dialogs.
- **Exception Handling:** Providing user feedback for invalid input.
- **Team Collaboration:** Working together on design, implementation, and debugging.
- **Iterative Problem Solving:** Attempted advanced features (like property filtering) and learned from the process, even when not fully successful.

## Known Limitations & Future Improvements

- The property filter/search feature was attempted but not fully implemented. We learned a lot about Java logic and GUI event handling in the process.
- The UI could be further enhanced for visual appeal and usability.
- More robust data management and persistent storage could be added.

## Credits

Developed by:
- Axel Sandoval
- Rogelio Perez Montero
- Kevin Buikpor

For: Advanced Programming in Java, Guilford College

---

**Note:**  
This project was completed as part of our learning journey in Java, and we are proud of the progress and teamwork demonstrated. Thank you for reviewing our work!

