package com.test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Base.TestBase;
import com.pom.UserDashboardPage;

import io.github.bonigarcia.wdm.WebDriverManager;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class UserDashboardTest extends TestBase{
    private WebDriver driver;
    private UserDashboardPage userDashboard;

    @BeforeTest
    public void setUp() {
    	   WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        userDashboard = new UserDashboardPage(driver);
        driver.get("url_of_your_application");
        // Perform login here
        // Example:
        // userDashboard.login("username", "password");
    }

    @Test
    public void testCoursesOption() {
        userDashboard.openCourses();
        // Assert that the courses list is displayed
        WebElement coursesList = driver.findElement(By.id("coursesList"));
        assertEquals(coursesList.isDisplayed(), true);
    }

    @Test(dependsOnMethods = {"testCoursesOption"})
    public void testCourseDetailAndEnrollment() {
        userDashboard.openCourseDetails();
        // Assert that course details are displayed
        WebElement courseDetails = driver.findElement(By.id("courseDetails"));
        assertEquals(courseDetails.isDisplayed(), true);

        // Perform enrollment
        userDashboard.enrollCourse();
        // Assert that payment gateway options are displayed
        WebElement paymentGateway = driver.findElement(By.id("paymentGateway"));
        assertEquals(paymentGateway.isDisplayed(), true);
    }

    @Test
    public void testLearnersOption() {
        userDashboard.openLearners();
        // Assert that the number of learners is displayed
        WebElement learnersCount = driver.findElement(By.id("learnersCount"));
        assertEquals(learnersCount.isDisplayed(), true);
    }

    @Test
    public void testChaptersOption() {
        userDashboard.openChapters();
        // Assert that the chapters list is displayed
        WebElement chaptersList = driver.findElement(By.id("chaptersList"));
        assertEquals(chaptersList.isDisplayed(), true);
    }

    @Test
    public void testFavouritesOption() {
        userDashboard.openFavourites();
        // Assert that the favourites courses list is displayed
        WebElement favouritesList = driver.findElement(By.id("favouritesList"));
        assertEquals(favouritesList.isDisplayed(), true);
    }

    @Test
    public void testMyLearningOption() {
        userDashboard.openMyLearning();
        // Assert that the enrolled courses list is displayed
        WebElement enrolledCoursesList = driver.findElement(By.id("enrolledCoursesList"));
        assertEquals(enrolledCoursesList.isDisplayed(), true);
    }

    @Test
    public void testMyWishlistOption() {
        userDashboard.openMyWishlist();
        // Assert that the wishlist courses list is displayed
        WebElement wishlistCoursesList = driver.findElement(By.id("wishlistCoursesList"));
        assertEquals(wishlistCoursesList.isDisplayed(), true);
    }

    @Test
    public void testProfessorsOption() {
        userDashboard.openProfessors();
        // Assert that the professors list is displayed
        WebElement professorsList = driver.findElement(By.id("professorsList"));
        assertEquals(professorsList.isDisplayed(), true);
    }

    @Test
    public void testUserDetailsOption() {
        userDashboard.openUsers();
        // Assert that the user details are displayed
        WebElement userDetails = driver.findElement(By.id("userDetails"));
        assertEquals(userDetails.isDisplayed(), true);
    }
    @Test
    public void testReviewButtonFunctionality() {
        WebElement reviewButton = driver.findElement(By.id("reviewButton"));
        reviewButton.click();

        WebElement reviewTextArea = driver.findElement(By.id("reviewTextArea"));
        reviewTextArea.sendKeys("This course is excellent!");

        WebElement submitReviewButton = driver.findElement(By.id("submitReviewButton"));
        submitReviewButton.click();

        // Wait for the review to be saved (you might need to implement waits)
        // Assert that the review is saved in the database
        // Example: Assert that the review is displayed on the main page
        WebElement mainPage = driver.findElement(By.id("mainPage"));
        String reviewTextOnMainPage = mainPage.getText();
        assertTrue(reviewTextOnMainPage.contains("This course is excellent!"));
    }
    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
