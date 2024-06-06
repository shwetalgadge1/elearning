package com.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

public class TestBase {
    public static WebDriver driver;

    public TestBase(WebDriver driver2) {
        // Constructor
    }

    public TestBase() {
        // Constructor
    }

    public static void setupDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://example.com/registration");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void navigateToUrl(String url) {
        driver.get(url);
    }

    public void setUp() {
        setupDriver();
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
