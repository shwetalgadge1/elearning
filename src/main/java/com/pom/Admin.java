package com.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Admin {
    public static void main(String[] args) {
      
        WebDriverManager.chromedriver().setup();
        
        
        WebDriver driver = new ChromeDriver();
        
        try {
            
            driver.get("https://example.com/admin"); 
            
           
            WebElement usernameField = driver.findElement(By.id("username")); 
            usernameField.sendKeys("admin_username"); 
            
        
            WebElement passwordField = driver.findElement(By.id("password")); 
            passwordField.sendKeys("admin_password"); 
            
            // Locate the login button and click it
            WebElement loginButton = driver.findElement(By.id("//*[@id=\"log_btn\"]")); 
            loginButton.click();
            
            
            WebElement dashboardElement = driver.findElement(By.id("admin-dashboard")); 
            if (dashboardElement.isDisplayed()) {
                System.out.println("Login successful");
            } else {
                System.out.println("Login failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           
            driver.quit();
        }
    }
}
