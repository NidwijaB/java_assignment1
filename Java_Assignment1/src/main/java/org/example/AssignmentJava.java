
package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;



import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
        import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.awt.*;
        import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.*;
        import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Date;
import java.util.logging.Logger;

public class AssignmentJava {
    private static final Logger logger = Logger.getLogger(AssignmentJava.class.getName());

    public static void main(String[] args) throws IOException, InterruptedException, UnsupportedFlavorException {
//        webdriver setup with new selenium
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

//        to track the runtime starting time
        long startTime = System.currentTimeMillis();

        driver.manage().window().maximize();
        driver.get("https://copilot.microsoft.com/chat");
        logger.info("Opened Copilot.");

        WebElement messageBox = wait.until(ExpectedConditions.elementToBeClickable(By.tagName("textarea")));
        messageBox.sendKeys("Please provide a Python function that accepts space-separated numbers from the user input (stdin), performs addition on those numbers, and returns the result. Do not include any comments.");
        messageBox.sendKeys(Keys.RETURN);
        logger.info("Query sent to Copilot.");

        Thread.sleep(5000);
        WebElement copyButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Copy code']")));
        copyButton.click();
        logger.info("Code copied from Copilot.");

        // Retrieve copied code from clipboard and save to file
        String code = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        Files.write(Paths.get("AddFunction_assignment1.py"), code.getBytes());
        logger.info("Code saved to AddFunction.py.");

        driver.get("https://www.codechef.com/ide");
        Thread.sleep(8000); // Let the editor load

        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("language-select")));
        dropdown.click();
        WebElement pythonOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='Python3']")));
        pythonOption.click();
        logger.info("Language set to Python3.");

        // Wait for the editor to load and inject the Python code
        Thread.sleep(3000);
        String pythonCode = Files.readString(Paths.get("AddFunction_assignment1.py"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        String escapedCode = pythonCode.replace("\\", "\\\\")
                .replace("\n", "\\n")
                .replace("\"", "\\\"")
                .replace("\r", "");
        js.executeScript(
                "document.getElementsByClassName('ace_text-input')[0].value = \"\";" +
                        "ace.edit(document.getElementsByClassName('ace_editor')[0]).setValue(\"" + escapedCode + "\");"
        );
        logger.info("Code injected into the CodeChef editor.");

        WebElement inputBox = driver.findElement(By.xpath("//div[contains(@class, '_tcContainer_1mvh4_454')]"));
        WebElement stdinBox = inputBox.findElement(By.tagName("textarea"));
        stdinBox.sendKeys("40 20"); // Example input for addition

        WebElement runBtn = driver.findElement(By.xpath("//div[@class='_execute-btn-container_1mvh4_215']"));
        WebElement mainButton = runBtn.findElement(By.tagName("button"));
        mainButton.click();
        logger.info("Run button clicked to execute the code.");

        Thread.sleep(5000); // Wait for the code to execute

        WebElement outputBox = driver.findElement(By.xpath("//div[contains(@class, '_dark_58rxo_263')]"));
        String rawOutput = outputBox.getText();

        String status = rawOutput.substring(rawOutput.indexOf("Status :") + "Status :".length(), rawOutput.indexOf("Time:")).trim();
        String time = rawOutput.substring(rawOutput.indexOf("Time:") + "Time:".length(), rawOutput.indexOf("Memory:")).trim();
        String memory = rawOutput.substring(rawOutput.indexOf("Memory:") + "Memory:".length(), rawOutput.indexOf("Sample Input")).trim();
        String sampleInput = rawOutput.substring(rawOutput.indexOf("Sample Input") + "Sample Input".length(), rawOutput.indexOf("Your Output")).trim();
        String yourOutput = rawOutput.substring(rawOutput.indexOf("Your Output") + "Your Output".length()).trim();

        // Capture memory usage and time taken
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        long memoryUsed = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        String htmlReport = "<html><head><title>Test Execution Report</title></head><body>" +
                "<h1>Test Execution Report</h1>" +
                "<table border='1' cellpadding='10' style='border-collapse: collapse; font-family: Arial, sans-serif;'>" +
                "<tr><th>Test Case</th><td>Addition Function Test</td></tr>" +
                "<tr><th>Status</th><td>" + status + "</td></tr>" +
                "<tr><th>Execution Time (ms)</th><td>" + duration + "</td></tr>" +
                "<tr><th>Time (Output)</th><td>" + time + "</td></tr>" +
                "<tr><th>Memory Used (Runtime)</th><td>" + memoryUsed + " bytes</td></tr>" +
                "<tr><th>Memory (Output)</th><td>" + memory + "</td></tr>" +
                "<tr><th>Sample Input</th><td>" + sampleInput + "</td></tr>" +
                "<tr><th>Your Output</th><td>" + yourOutput + "</td></tr>" +
                "</table></body></html>";

        Files.write(Paths.get("TestReport_assignment1.html"), htmlReport.getBytes());
        logger.info("HTML report generated.");

        driver.close();
    }
}
