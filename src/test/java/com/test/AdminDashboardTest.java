package com.test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Base.TestBase;
import com.pom.AdminDashboard;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AdminDashboardTest extends TestBase {
    public AdminDashboardTest(WebDriver driver2) {
		super(driver2);
		// TODO Auto-generated constructor stub
	}

	WebDriver driver;
    AdminDashboard adminDashboard;

    @BeforeClass
    public void setup() {
       WebDriverManager.chromedriver().setup();
        driver = getDriver(); // Initialize driver from TestBase
        adminDashboard = new AdminDashboard(driver); // Pass driver to AdminDashboard
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Implicit wait
        driver.get("http://your-admin-dashboard-url");
        adminDashboard.login("admin_username", "admin_password");
    }

    private WebDriver getDriver() {
        // Assuming this method is implemented in TestBase
        return new ChromeDriver();
    }

    @Test
    public void testUsersSection() {
        adminDashboard.clickUsers();
        WebElement userList = driver.findElement(By.id("userList")); // Implicit wait used here

        List<WebElement> users = driver.findElements(By.cssSelector("#userList .user"));
        Assert.assertTrue(users.size() > 0, "No users found.");
    }

    @Test
    public void testCoursesSection() {
        adminDashboard.clickCourses();
        WebElement courseList = driver.findElement(By.id("courseList")); // Implicit wait used here

        List<WebElement> courses = driver.findElements(By.cssSelector("#courseList .course"));
        Assert.assertTrue(courses.size() > 0, "No courses found.");
    }

    @Test
    public void testProfessorsSection() {
        adminDashboard.clickProfessors();
        WebElement professorList = driver.findElement(By.id("professorList")); // Implicit wait used here

        List<WebElement> professors = driver.findElements(By.cssSelector("#professorList .professor"));
        Assert.assertTrue(professors.size() > 0, "No professors found.");
    }

    @Test
    public void testLearnersSection() {
        adminDashboard.clickLearners();
        WebElement learnerList = driver.findElement(By.id("learnerList")); // Implicit wait used here

        List<WebElement> learners = driver.findElements(By.cssSelector("#learnerList .learner"));
        Assert.assertTrue(learners.size() > 0, "No learners found.");
    }

    @Test
    public void testAddProfessor() {
        adminDashboard.clickAddProfessor();
        WebElement addProfessorForm = driver.findElement(By.id("addProfessorForm")); // Implicit wait used here

        WebElement nameField = driver.findElement(By.id("professorName"));
        WebElement emailField = driver.findElement(By.id("professorEmail"));
        WebElement submitButton = driver.findElement(By.id("submitProfessor"));

        nameField.sendKeys("New Professor");
        emailField.sendKeys("professor@example.com");
        submitButton.click();

        // Verification logic after adding the professor
        WebElement successMessage = driver.findElement(By.id("successMessage")); // Implicit wait used here
        Assert.assertTrue(successMessage.isDisplayed(), "Professor not added successfully.");
    }

    @Test
    public void testAddCourse() {
        adminDashboard.clickAddCourses();
        WebElement addCourseForm = driver.findElement(By.id("addCourseForm")); // Implicit wait used here

        WebElement titleField = driver.findElement(By.id("courseTitle"));
        WebElement descriptionField = driver.findElement(By.id("courseDescription"));
        WebElement submitButton = driver.findElement(By.id("submitCourse"));

        titleField.sendKeys("New Course");
        descriptionField.sendKeys("Course Description");
        submitButton.click();

        // Verification logic after adding the course
        WebElement successMessage = driver.findElement(By.id("successMessage")); // Implicit wait used here
        Assert.assertTrue(successMessage.isDisplayed(), "Course not added successfully.");
    }

    @Test
    public void testAddChapter() {
        adminDashboard.clickAddChapters();
        WebElement addChapterForm = driver.findElement(By.id("addChapterForm")); // Implicit wait used here

        WebElement titleField = driver.findElement(By.id("chapterTitle"));
        WebElement contentField = driver.findElement(By.id("chapterContent"));
        WebElement submitButton = driver.findElement(By.id("submitChapter"));

        titleField.sendKeys("New Chapter");
        contentField.sendKeys("Chapter Content");
        submitButton.click();

        // Verification logic after adding the chapter
        WebElement successMessage = driver.findElement(By.id("successMessage")); // Implicit wait used here
        Assert.assertTrue(successMessage.isDisplayed(), "Chapter not added successfully.");
    }

    @Test
    public void testApproveProfessor() {
        adminDashboard.clickApproveProfessorCourseList();
        WebElement approvalList = driver.findElement(By.id("approvalList")); // Implicit wait used here

        WebElement approveButton = driver.findElement(By.cssSelector(".approveButton"));
        approveButton.click();

        // Verification logic after approving the professor
        WebElement successMessage = driver.findElement(By.id("successMessage")); // Implicit wait used here
        Assert.assertTrue(successMessage.isDisplayed(), "Professor not approved successfully.");
    }

    @Test
    public void testCourseList() {
        adminDashboard.clickCourseList();
        WebElement courseList = driver.findElement(By.id("courseList")); // Implicit wait used here

        List<WebElement> courses = driver.findElements(By.cssSelector("#courseList .course"));
        Assert.assertTrue(courses.size() > 0, "No courses found.");
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
