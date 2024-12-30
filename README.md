# Palindrome Validator Web Application
 This is a simple web application built using Java Servlets and JSP to validate if a string entered by the user is a palindrome. The app also allows users to display the table of inputs and their corresponding validation results (whether the input is a palindrome or not) and delete an input from the table.

## Features
- Palindrome Validation: Users can input a string to check if it's a palindrome.
- Display Table: Displays a table with all the inputs, indicating whether each is a palindrome.
- Delete Input: Allows users to delete an input from the table.
- Database Integration: Data is stored in a PostgreSQL database.

## Technologies Stack
- **Java**: Backend logic and servlet handling.
- **Servlets**: For handling HTTP requests and responses.
- **JSP**: To render dynamic HTML pages.
- **PostgreSQL**: Used for storing input values and validation results.
- **HTML/CSS**: For front-end design.
- **Java JDBC**: For database connectivity.

## Prerequisites
To run this project locally, you need:
- Java 8 or higher
- Apache Tomcat server (or any Java servlet container)
- PostgreSQL database
- An IDE (e.g., IntelliJ IDEA, Eclipse)

## Setup Instructions
1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/palindrome-validator.git
2. Set Up Database
    1. Create a PostgreSQL database called palindromeInput:
       ```bash
       CREATE DATABASE palindromeInput;
    2. Create a table to store input values and their palindrome check results:
       ```bash
        CREATE TABLE palindrometable (
            id INTEGER PRIMARY KEY,
            input VARCHAR(255),
            yes VARCHAR(3),
            no VARCHAR(3)
        );
3. Configure Database Connection
    In the InputServices.java class, make sure the following database details are correct:
    - url = "jdbc:postgresql://localhost:4321/palindromeInput"
    - username = "postgres"
    - password = "tiger"

    Update them if your PostgreSQL credentials or database setup are different.
4. Deploy to Tomcat
    1. Build the project using your IDE.
    2. Deploy the project to your Apache Tomcat server.
    3. Access the application via the Tomcat server URL, usually http://localhost:8080/.

## File Structure
- **index.html**: The main page for palindrome input.
- **style.css**: Custom styles for the UI.
- **InputClass.java**: Java class for input data.
- **PalindromeServlet.java**: Servlet for handling palindrome validation logic.
- **InputServices.java**: Handles database interactions.
- **deleteForm.html**: Form to delete an input.
- **DisplayServlet.java**: Servlet to display the table of inputs.
- **DeleteInput.java**: Servlet to delete an input from the database.

## How to Use
1. **Input**: Go to the home page (index.html), enter an id and a string, and click "Submit" to check if it's a palindrome.
2. **Display Table**: Click the "Display Table" button to see all inputs and their palindrome results.
3. **Delete Input**: Use the "Delete an Input" button to delete an entry from the database.

## Example
1. **Input**: "101", "madam"
2. **Result**: The system will display "Yes" if it's a palindrome, or "No" if it's not.

## Contributing
1. Fork the repository.
2. Create a new branch (git checkout -b feature-name).
3. Make your changes and commit them (git commit -m 'Add new feature').
4. Push to the branch (git push origin feature-name).
5. Open a pull request.

## Demo
![Palindrome Validator Demo](./assets/plaindrome-validator.gif)

## Acknowledgements
- **PostgreSQL** for the database.
- **Java Servlets** for handling HTTP requests.
- **Apache Tomcat** for the servlet container.

## Contact
Created by [Yogesh](https://github.com/Yoki-28) - feel free to reach out!