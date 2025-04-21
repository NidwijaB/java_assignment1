
# Java Assignment 1

Assignement Task 1: UI automation and generate testreport
	This is a simple Java project that automates browser tasks using **Selenium WebDriver**. It also includes logging and easy driver setup.


---

## Features

- Automates browser actions with Selenium WebDriver
- Automatically manages drivers using WebDriverManager
- Logs useful information using SLF4J and Logback
- Assignment Notes

	- Using Java and Selenium, automate follwing steps
	- Open ChatGPT in Chrome browser (Copilot was used as chatgpt doesn't provide responses for automated input of prompts)
	- In the message box, write the prompt:

			Please provide a Python function that accepts parameters from the command line,
			performs addition on those parameters, and return the result.

	- Use the copy button to copy the code and save it as a Python file.
	- If needed, modify the Python function as required.
	- Generate a CSV file with test data to test the add function with parameters and expected results.
	- Open online code compiler - (https://www.codechef.com/ide)
	- Select Python compiler and paste python function from file
	- Run program by passing test parameters
	- Generate an HTML report containing output status, time, memory, output from the website, and test case status.
---

## Requirements

Make sure the following tools are installed:

- **Java 24**
- **Maven 3.6.3 or newer**
- **IntelliJ IDEA IDE** 

---

## How to Run

1. **Clone the repository**
   ```bash
   git clone https://github.com/your-repo/java-assignment1.git
   cd java-assignment1
   ```

2. **Install dependencies**
   ```bash
   mvn clean install
   ```

3. **Run the tests**
   ```bash
   mvn test
   ```

---

## Dependencies

The project uses the following dependencies. These are defined in the `pom.xml` file:

- **Selenium**: For browser automation
 

- **WebDriverManager**: To automatically manage browser drivers
 

- **SLF4J**: For logging framework
 

- **Logback**: For logging backend implementation
  

---

## Technologies Used

- Java  
- Selenium  
- WebDriverManager  
- SLF4J + Logback  
- Maven

---

## Project Structure

```
java-assignment1/
├── src/
│   └── test/java/org/example/AssignmentJava.java        # Test code
├── pom.xml                # Maven configuration
||TestReport_assignment1.html
└── README.md              # Project info
```
