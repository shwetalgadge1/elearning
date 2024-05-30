package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Base.TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

public class ProfessorRegistrationTest extends TestBase {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://example.com/registration"); 
    }

    @Test(priority = 1)
    public void createNewAccountTest() {
        WebElement professorNameInput = driver.findElement(By.name("professorName"));
        professorNameInput.sendKeys("John Doe");

        WebElement genderSelect = driver.findElement(By.name("gender"));
        genderSelect.sendKeys("Male");

        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("john.doe@example.com");

        WebElement mobileInput = driver.findElement(By.name("mobile"));
        mobileInput.sendKeys("1234567890");

        WebElement addressInput = driver.findElement(By.name("address"));
        addressInput.sendKeys("123 Main Street, City, Country");

        WebElement departmentSelect = driver.findElement(By.name("department"));
        departmentSelect.sendKeys("Computer Science");

        WebElement experienceInput = driver.findElement(By.name("experience"));
        experienceInput.sendKeys("5");

        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("Password123!");

        WebElement confirmPasswordInput = driver.findElement(By.name("confirmPassword"));
        confirmPasswordInput.sendKeys("Password123!");

        WebElement eyeButton = driver.findElement(By.id("eyeButton"));
        eyeButton.click();

        WebElement agreeCheckbox = driver.findElement(By.name("agree"));
        agreeCheckbox.click();

        WebElement registerButton = driver.findElement(By.name("register"));
        registerButton.click();
    }

    @Test(priority = 2)
    public void alreadyHaveAccountTest() {
        WebElement alreadyHaveAccountLink = driver.findElement(By.linkText("Already have an account?"));
        alreadyHaveAccountLink.click();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
