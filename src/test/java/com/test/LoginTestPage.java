package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pom.LoginPage;
import com.Base.TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;

import static org.testng.Assert.assertTrue;

public class LoginTestPage extends TestBase {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        initializeDriver(driver);
        loginPage = new LoginPage(driver);
        driver.get("http://example.com/login");
    }

    private void initializeDriver(WebDriver driver) {
        // Initialization code here
    }

    @AfterClass
    public void tearDown() {
        quitDriver(driver);
    }

    private void quitDriver(WebDriver driver) {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testUserLogin() {
        loginPage.performLogin("userOption", "user@example.com", "password123");
        assertTrue(driver.findElement(By.id("logoutButton")).isDisplayed(), "Login failed for User");
    }

    @Test
    public void testProfessorLogin() {
        loginPage.performLogin("professorOption", "professor@example.com", "password123");
        assertTrue(driver.findElement(By.id("logoutButton")).isDisplayed(), "Login failed for Professor");
    }

    @Test
    public void testAdminLogin() {
        loginPage.performLogin("adminOption", "admin@example.com", "password123");
        assertTrue(driver.findElement(By.id("logoutButton")).isDisplayed(), "Login failed for Admin");
    }

    @Test
    public void testCrossButtonFunctionality() {
        loginPage.performLogin("userOption", "user@example.com", "password123");
        assertTrue(driver.findElement(By.id("logoutButton")).isDisplayed(), "Login failed for User");
        loginPage.clickCrossButton();
        assertTrue(driver.findElement(By.id("welcomePageElement")).isDisplayed(), "Failed to navigate back to the welcome page");
    }
}
