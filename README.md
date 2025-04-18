
# Java Assignment 1

This is a simple Java project that automates browser tasks using **Selenium WebDriver**. It also includes logging and easy driver setup.

---

## Features

- Automates browser actions with Selenium WebDriver
- Automatically manages drivers using WebDriverManager
- Logs useful information using SLF4J and Logback

---

## Requirements

Make sure the following tools are installed:

- **Java 24**
- **Maven 3.6.3 or newer**
- **Any IDE** (IntelliJ IDEA recommended)

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
  ```xml
  <dependency>
      <groupId>org.seleniumhq.selenium</groupId>
      <artifactId>selenium-java</artifactId>
      <version>4.19.1</version>
  </dependency>
  ```

- **WebDriverManager**: To automatically manage browser drivers
  ```xml
  <dependency>
      <groupId>io.github.bonigarcia</groupId>
      <artifactId>webdrivermanager</artifactId>
      <version>5.8.0</version>
  </dependency>
  ```

- **SLF4J**: For logging framework
  ```xml
  <dependency>
      <groupId>org.slf4j</groupId>
      <artifactId>slf4j-api</artifactId>
      <version>2.0.9</version>
  </dependency>
  ```

- **Logback**: For logging backend implementation
  ```xml
  <dependency>
      <groupId>ch.qos.logback</groupId>
      <artifactId>logback-classic</artifactId>
      <version>1.4.11</version>
  </dependency>
  ```

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
│   └── test/java/         # Test code
├── pom.xml                # Maven configuration
└── README.md              # Project info
```

---

## License

This project is for educational purposes.
