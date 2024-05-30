package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminDashboard {

    @FindBy(id = "username")
    WebElement usernameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "loginButton")
    WebElement loginButton;

    @FindBy(id = "users")
    WebElement usersOption;

    @FindBy(id = "professors")
    WebElement professorsOption;

    @FindBy(id = "courses")
    WebElement coursesOption;

    @FindBy(id = "learners")
    WebElement learnersOption;

    @FindBy(id = "addProfessor")
    WebElement addProfessorOption;

    @FindBy(id = "addCourses")
    WebElement addCoursesOption;

    @FindBy(id = "addChapters")
    WebElement addChaptersOption;

    @FindBy(id = "approveProfessorCourseList")
    WebElement approveProfessorCourseListOption;

    @FindBy(id = "courseList")
    WebElement courseListOption;

    public AdminDashboard(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public void clickUsers() {
        usersOption.click();
    }

    public void clickProfessors() {
        professorsOption.click();
    }

    public void clickCourses() {
        coursesOption.click();
    }

    public void clickLearners() {
        learnersOption.click();
    }

    public void clickAddProfessor() {
        addProfessorOption.click();
    }

    public void clickAddCourses() {
        addCoursesOption.click();
    }

    public void clickAddChapters() {
        addChaptersOption.click();
    }

    public void clickApproveProfessorCourseList() {
        approveProfessorCourseListOption.click();
    }

    public void clickCourseList() {
        courseListOption.click();
    }
}
