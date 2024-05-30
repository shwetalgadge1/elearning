package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    private void initializeDriver(WebDriver driver2) {
		// TODO Auto-generated method stub
		
	}

	@AfterClass
    public void tearDown() {
        quitDriver(driver);
    }

    private void quitDriver(WebDriver driver2) {
		// TODO Auto-generated method stub
		
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
}
