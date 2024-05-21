package com.Utils;
import org.testng.ITestContext;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.File;
import java.io.IOException;

@Listeners(Listener.TestListener.class)

public class Listener {

    private static WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
    }

    @Test
    public void loginTest() {
        WebElement emailInput = driver.findElement(By.id("email"));
        emailInput.sendKeys("shwetal@gmail.com");

        WebElement passwordInput = driver.findElement(By.id("pass"));
        passwordInput.sendKeys("shwetal");

        WebElement loginButton = driver.findElement(By.name("login"));
        loginButton.click();
    }

    @Test
    public void loginFailureTest() {
    	WebElement emailInput = driver.findElement(By.id("email"));
    	emailInput.sendKeys("shwetal@gmail.com");

    	WebElement passwordInput = driver.findElement(By.id("pass"));
    	passwordInput.sendKeys("shwetal");

    	WebElement loginButton = driver.findElement(By.name("login"));
    	loginButton.click();

    }

    public static class TestListener implements ITestListener {
        @Override
        public void onTestStart(ITestResult result) {
            System.out.println("Test Started: " + result.getName());
        }

        @Override
        public void onTestSuccess(ITestResult result) {
            System.out.println("Test Passed: " + result.getName());
        }

        @Override
        public void onTestFailure(ITestResult result) {
            System.out.println("Test Failed: " + result.getName());

            // Take screenshot on test failure
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String screenshotPath = "C:\\eclipse-workspace\\quantumsoft_1\\resources\\testdata\\failedtestcase1.bmp" + result.getName() + ".bmp";

            try {
                FileHandler.copy(screenshotFile, new File(screenshotPath));
                System.out.println("Screenshot saved successfully at: " + screenshotPath);
            } catch (IOException e) {
                System.out.println("Failed to save screenshot: " + e.getMessage());
            }
        }

        @Override
        public void onTestSkipped(ITestResult result) {
            System.out.println("Test Skipped: " + result.getName());
        }

        @Override
        public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
            // 
        }

        @Override
        public void onStart(ITestContext context) {
            // 
        }

        @Override
        public void onFinish(ITestContext context) {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
