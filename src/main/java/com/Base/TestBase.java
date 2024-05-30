package com.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

public class TestBase {
    public static WebDriver driver;

    public TestBase(WebDriver driver2) {
		// TODO Auto-generated constructor stub
	}
	public TestBase() {
		// TODO Auto-generated constructor stub
	}
	public static void setupDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    public void navigateToHomePage(String url) {
        driver.get(url);
    }
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
	public void setUp() {
		// TODO Auto-generated method stub
		
	}
}
