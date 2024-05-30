package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfessorRegistrationPage {
    private WebDriver driver;

    @FindBy(id = "name")
    private WebElement nameInput;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "confirmPassword")
    private WebElement confirmPasswordInput;

    @FindBy(id = "gender")
    private WebElement genderDropdown;

    @FindBy(id = "mobileNumber")
    private WebElement mobileNumberInput;

    @FindBy(id = "department")
    private WebElement departmentInput;

    @FindBy(id = "experience")
    private WebElement experienceInput;

    @FindBy(id = "terms")
    private WebElement termsCheckbox;

    @FindBy(id = "register")
    private WebElement registerButton;

    @FindBy(linkText = "Already have an account?")
    private WebElement loginLink;

    public ProfessorRegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterName(String name) {
        nameInput.sendKeys(name);
    }

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void confirmPassword(String password) {
        confirmPasswordInput.sendKeys(password);
    }

    public void selectGender(String gender) {
        genderDropdown.sendKeys(gender);
    }

    public void enterMobileNumber(String mobileNumber) {
        mobileNumberInput.sendKeys(mobileNumber);
    }

    public void enterDepartment(String department) {
        departmentInput.sendKeys(department);
    }

    public void enterExperience(String experience) {
        experienceInput.sendKeys(experience);
    }

    public void checkTermsAndConditions() {
        termsCheckbox.click();
    }

    public void clickRegister() {
        registerButton.click();
    }

    public void clickLoginLink() {
        loginLink.click();
    }
}