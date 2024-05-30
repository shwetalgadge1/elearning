
package com.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Base.TestBase;

public class LoginPage extends TestBase {
    private WebDriver driver;

    @FindBy(id = "loginButton")
    private WebElement loginButton;

    @FindBy(id = "userOption")
    private WebElement userOption;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "rememberMe")
    private WebElement rememberMeCheckbox;

    @FindBy(id = "submitLogin")
    private WebElement submitButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void selectUserOption(String userTypeOptionId) {
        driver.findElement(By.id(userTypeOptionId)).click();
    }

    public void setEmail(String email) {
        emailField.sendKeys(email);
    }

    public void setPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickRememberMeCheckbox() {
        rememberMeCheckbox.click();
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public void performLogin(String userTypeOptionId, String email, String password) {
        clickLoginButton();
        selectUserOption(userTypeOptionId);
        setEmail(email);
        setPassword(password);
        clickRememberMeCheckbox();
        clickSubmitButton();
    }

	public void loginAsUser(String string, String string2) {
		// TODO Auto-generated method stub
		
	}
}
