package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Base.TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

public class AdminRegistrationTestPage extends TestBase {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://example.com/admin/registration");
    }

    @Test(priority = 1)
    public void createNewAdminAccountTest() {
        WebElement adminNameInput = driver.findElement(By.id("name"));
        adminNameInput.sendKeys("Admin User");

        WebElement genderDropdown = driver.findElement(By.id("gender"));
        Select genderSelect = new Select(genderDropdown);
        genderSelect.selectByVisibleText("Male");  // or "Female"

        WebElement emailInput = driver.findElement(By.id("email"));
        emailInput.sendKeys("admin@example.com");

        WebElement mobileInput = driver.findElement(By.id("mobileNumber"));
        mobileInput.sendKeys("1234567890");

        WebElement departmentInput = driver.findElement(By.id("department"));
        departmentInput.sendKeys("Administration");

        WebElement designationInput = driver.findElement(By.id("designation"));
        designationInput.sendKeys("Admin"); // Entering designation for admin

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("AdminPassword123!");

        WebElement confirmPasswordInput = driver.findElement(By.id("confirmPassword"));
        confirmPasswordInput.sendKeys("AdminPassword123!");

        WebElement agreeCheckbox = driver.findElement(By.id("terms"));
        agreeCheckbox.click();

        WebElement registerButton = driver.findElement(By.id("register"));
        registerButton.click();
    }

    @Test(priority = 2)
    public void alreadyHaveAccountTest() {
        WebElement alreadyHaveAccountLink = driver.findElement(By.linkText("Already have an account?"));
        alreadyHaveAccountLink.click();
    }

    @Test(priority = 3)
    public void closePageTest() {
        WebElement closeButton = driver.findElement(By.id("closePage"));
        closeButton.click();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
