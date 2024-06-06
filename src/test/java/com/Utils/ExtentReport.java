package com.Utils;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
    private WebDriver driver;
    private ExtentReports extent;
    private ExtentTest test;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        // Setup ExtentReports and attach the reporter
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extent-report.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        // Optional: Additional configurations
        htmlReporter.config().setReportName("Facebook Login Test Report");
        htmlReporter.config().setDocumentTitle("Test Report");
    }

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][] {
            { "shwetal@gmailcom", "shwetal" },
            { "user2@example.com", "password2" }
        };
    }

    @Test(dataProvider = "loginData")
    public void facebookLoginTest(String email, String password) {
        test = extent.createTest("Facebook Login Test", "Test to validate Facebook login functionality with different credentials");

        try {
            driver.get("https://www.facebook.com/");
            test.log(Status.INFO, "Navigated to Facebook");

            WebElement emailInput = driver.findElement(By.id("email"));
            emailInput.sendKeys(email);
            test.log(Status.INFO, "Entered email: " + email);

            WebElement passwordInput = driver.findElement(By.id("pass"));
            passwordInput.sendKeys(password);
            test.log(Status.INFO, "Entered password");

            WebElement loginButton = driver.findElement(By.name("login"));
            loginButton.click();
            test.log(Status.INFO, "Clicked login button");

            String title = driver.getTitle();
            if (title.equals("Facebook")) {
                test.log(Status.PASS, "Login successful");
            } else {
                test.log(Status.FAIL, "Login failed");
            }
        } catch (Exception e) {
            test.log(Status.FAIL, "Test failed due to exception: " + e.getMessage());
        }
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        
        if (extent != null) {
            extent.flush();
        }
    }
}
