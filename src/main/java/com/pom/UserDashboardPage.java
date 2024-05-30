package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Base.TestBase;

public class UserDashboardPage extends TestBase {
    private WebDriver driver;

    public UserDashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    // Find elements by annotations
    @FindBy(id = "courses")
    private WebElement courses;

    @FindBy(id = "learners")
    private WebElement learners;

    @FindBy(id = "chapters")
    private WebElement chapters;

    @FindBy(id = "favourites")
    private WebElement favourites;

    @FindBy(id = "myLearning")
    private WebElement myLearning;

    @FindBy(id = "myWishlist")
    private WebElement myWishlist;

    @FindBy(id = "professors")
    private WebElement professors;

    @FindBy(id = "users")
    private WebElement users;

    public void login(String username, String password) {
        // Write login logic here
    }

    public void openCourses() {
        courses.click();
    }

    public void openLearners() {
        learners.click();
    }

    public void openChapters() {
        chapters.click();
    }

    public void openFavourites() {
        favourites.click();
    }

    public void openMyLearning() {
        myLearning.click();
    }

    public void openMyWishlist() {
        myWishlist.click();
    }

    public void openProfessors() {
        professors.click();
    }

    public void openUsers() {
        users.click();
    }

    public void openCourseDetails() {
        // Write logic to open course details page
    }

    public void enrollCourse() {
        // Write logic to enroll in a course
    }

	public boolean isWelcomeMessageDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
}
