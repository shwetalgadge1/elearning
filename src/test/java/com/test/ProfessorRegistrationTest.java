package com.test;




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



import io.github.bonigarcia.wdm.WebDriverManager;

public class ProfessorRegistrationTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://example.com/registration"); 
    }

    @Test(priority = 1)
    public void createNewAccountTest() {
        WebElement professorNameInput = driver.findElement(By.name("professorName"));
        Custom_Explicitwait(driver, 10, professorNameInput);
        professorNameInput.sendKeys("John Doe");

        WebElement genderSelect = driver.findElement(By.name("gender"));
        Custom_Explicitwait(driver, 10, genderSelect);
        genderSelect.sendKeys("Male");

        WebElement emailInput = driver.findElement(By.name("email"));
        Custom_Explicitwait(driver, 10, emailInput);
        emailInput.sendKeys("john.doe@example.com");

        WebElement mobileInput = driver.findElement(By.name("mobile"));
        Custom_Explicitwait(driver, 10, mobileInput);
        mobileInput.sendKeys("1234567890");

        WebElement addressInput = driver.findElement(By.name("address"));
        Custom_Explicitwait(driver, 10, addressInput);
        addressInput.sendKeys("123 Main Street, City, Country");

        WebElement departmentSelect = driver.findElement(By.name("department"));
        Custom_Explicitwait(driver, 10, departmentSelect);
        departmentSelect.sendKeys("Computer Science");

        WebElement experienceInput = driver.findElement(By.name("experience"));
        Custom_Explicitwait(driver, 10, experienceInput);
        experienceInput.sendKeys("5");

        WebElement passwordInput = driver.findElement(By.name("password"));
        Custom_Explicitwait(driver, 10, passwordInput);
        passwordInput.sendKeys("Password123!");

        WebElement confirmPasswordInput = driver.findElement(By.name("confirmPassword"));
        Custom_Explicitwait(driver, 10, confirmPasswordInput);
        confirmPasswordInput.sendKeys("Password123!");
 
        WebElement eyeButton = driver.findElement(By.id("eyeButton"));
        Custom_Explicitwait(driver, 10, eyeButton);
        eyeButton.click();

        WebElement agreeCheckbox = driver.findElement(By.name("agree"));
        Custom_Explicitwait(driver, 10, agreeCheckbox);
        agreeCheckbox.click();

        WebElement registerButton = driver.findElement(By.name("register"));
        Custom_Explicitwait(driver, 10, registerButton);
        registerButton.click();
    }

    private void Custom_Explicitwait(WebDriver driver2, int i, WebElement professorNameInput) {
		
		
	}

	@Test(priority = 2)
    public void alreadyHaveAccountTest() {
        WebElement alreadyHaveAccountLink = driver.findElement(By.linkText("Already have an account?"));
        Custom_Explicitwait(driver, 10, alreadyHaveAccountLink);
        alreadyHaveAccountLink.click();
        
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
