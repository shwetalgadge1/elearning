package com.test;

import com.Base.TestBase;
import com.pom.UserRegistration;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class UserServiceTest extends TestBase {

    private UserRegistration.UserService userService;
    private UserRegistration userRegistration;
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        super.setUp();
        driver.get("https://example.com/registration");
        userRegistration = new UserRegistration(driver);
        userService = userRegistration.new UserService();
    }

    @Test
    public void testValidUserRegistration() {
        UserRegistration.User user = userRegistration.new User();
        user.setName("John Doe");
        user.setMobileNumber("1234567890");
        user.setGender("Male");
        user.setDepartment("IT");
        user.setCity("New York");
        user.setEmail("john.doe@example.com");
        user.setExperience("5 years");
        user.setPassword("Password1!");
        user.setConfirmPassword("Password1!");

        assertTrue(userService.registerUser(user));
        userRegistration.fillRegistrationForm(user);
    }

    @Test
    public void testCloseRegistrationPage() {
        userRegistration.closeRegistrationPage();
        // Verify that the page is closed
    }
}
