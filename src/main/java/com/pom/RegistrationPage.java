package com.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RegistrationPage {
    public static void main(String[] args) {
        
        WebDriverManager.chromedriver().setup();
        
       
        WebDriver driver = new ChromeDriver();
        
        try {
            
            driver.get("https://www.facebook.com");
            
           
            WebElement createAccountButton = driver.findElement(By.xpath("//a[text()='Create new account']"));
            createAccountButton.click();
            
            
        } finally {
        	try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
          
            
    }}}

