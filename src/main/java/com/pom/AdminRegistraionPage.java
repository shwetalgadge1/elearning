package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.Base.TestBase;

public class AdminRegistraionPage extends TestBase {
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

    @FindBy(id = "designation")
    private WebElement designationInput; // New input field for admin registration

    @FindBy(id = "register")
    private WebElement registerButton;

    @FindBy(linkText = "Already have an account?")
    private WebElement loginLink;

    @FindBy(id = "closePage")
    private WebElement closePageButton; // Add the cross button element

    public AdminRegistraionPage(WebDriver driver) {
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
        Select genderSelect = new Select(genderDropdown);
        genderSelect.selectByVisibleText(gender);
    }

    public void enterMobileNumber(String mobileNumber) {
        mobileNumberInput.sendKeys(mobileNumber);
    }

    public void enterDepartment(String department) {
        departmentInput.sendKeys(department);
    }

    public void enterDesignation(String designation) {
        designationInput.sendKeys(designation); // Method to enter designation for admin
    }

    public void clickRegister() {
        registerButton.click();
    }

    public void clickLoginLink() {
        loginLink.click();
    }

    public void clickClosePage() {
        closePageButton.click(); // Method to click the cross button
    }
}
