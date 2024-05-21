package com.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UserRegistrationTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.icaionlineregistration.org/"); 
    }

    private void customExplicitWait(WebDriver driver, int seconds, By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            System.out.println("Exception occurred while waiting for element: " + e.getMessage());
        }
    }

    @Test(priority = 1)
    public void registerNewUser() {
        By registerLinkLocator = By.xpath("//a[contains(text(),'Click Here to Register')]");
        customExplicitWait(driver, 10, registerLinkLocator);
        WebElement registerLink = driver.findElement(registerLinkLocator);
        registerLink.click();

        By userNameLocator = By.id("txtMemberName");
        customExplicitWait(driver, 10, userNameLocator);
        WebElement userNameInput = driver.findElement(userNameLocator);
        userNameInput.sendKeys("John Doe");

        By emailLocator = By.id("txtEmail");
        customExplicitWait(driver, 10, emailLocator);
        WebElement emailInput = driver.findElement(emailLocator);
        emailInput.sendKeys("john.doe@example.com");

        By mobileLocator = By.id("txtMobile");
        customExplicitWait(driver, 10, mobileLocator);
        WebElement mobileInput = driver.findElement(mobileLocator);
        mobileInput.sendKeys("1234567890");

        // Similarly, fill in other fields and complete the registration process
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
