# **Desktop Quiz Application - Java**

## **Overview**
This project is a desktop quiz application developed using Java. It leverages **Swing** and **AWT** for the graphical user interface (GUI) and incorporates asynchronous programming techniques (`async` and `await`) to ensure a smooth and responsive user experience.

The application features a robust backend for generating, managing, and evaluating quiz questions, making it a versatile tool for educational and testing purposes.

---

## **Features**
- **GUI Development:** Interactive user interface built with Swing and AWT.
- **Asynchronous Programming:** Ensures responsiveness even during heavy operations like file handling or internet connectivity checks.
- **Quiz Management:** 
  - Supports theory and practical quizzes.
  - Dynamically generates quizzes with randomized, non-repeating questions.
- **File Operations:** Automated creation and management of quiz-related documents in various formats (DOCX, XLSX, PPTX).
- **Internet Connectivity:** Detects internet availability to fetch or validate real-time data.
- **Time and Date Handling:** Supports both offline and online synchronization of date and time.
- **Error Handling:** Ensures smooth operation with exception management for file operations and network tasks.

---

## **Technology Stack**
- **Programming Language:** Java
- **UI Frameworks:** Swing, AWT
- **File Handling Libraries:** Apache POI (for DOCX, XLSX, and PPTX creation)
- **Tools:** Multithreading and concurrency utilities

---

## **How to Run**
1. **Prerequisites:**
   - Java Development Kit (JDK) installed.
   - Apache POI library included in the project dependencies.

2. **Setup:**
   - Clone the repository:  
     ```bash
     git clone <repository-link>
     ```
   - Open the project in your preferred IDE (e.g., IntelliJ IDEA, Eclipse).
   - Ensure all required dependencies are added to the project classpath.

3. **Run:**
   - Compile and run the main class (e.g., `ControllerClass.java` or `testerclass.java`).

---

## **Project Structure**
- **ControllerClass.java**  
  - Handles core functionalities such as quiz generation, file operations, and user actions.
- **FileCreator.java**  
  - Automates the creation of documents in various formats (DOCX, XLSX, PPTX).
- **testerclass.java**  
  - Provides additional testing and helper functions for the application.

